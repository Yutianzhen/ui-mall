package cn.okay.testbase;

import cn.okay.tools.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by yutz on 2018/4/8.
 */
public class DriverFactory {

    private static WebDriver driver=null;
    private static String broswerType;
    private DriverFactory(){

    }

    public static synchronized DriverFactory getInstance(){
        return new DriverFactory();
    }

    public WebDriver getDriver() throws Exception {
        return driver;
    }

    public static WebDriver createBroswerDriver() throws Exception{
        broswerType= ConfigUtil.getConfigUtil().getConfigFileContent("broswerType");
        if(broswerType.equals("chrome")){
            //此处读取的是当前工作目录的路径，加上项目里的路径，但是在Jenkins中编译时会提示找不到该路径，故把driver设置成了读取固定C盘位置
     //     System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            //此处设置读取C盘位置的driver，是为了解决Jenkins中找不到driiver路径的问题
            System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("--test-type", "--ignore-certificate-errors");
            driver = new ChromeDriver(options);
        }
        else if(broswerType.equals("firefox")){
            driver=new FirefoxDriver();
        }
        else
            System.out.println("输入的浏览器类型不存在");
        return driver;
    }

}
