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
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
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
