package cn.okay.testbase;

import cn.okay.tools.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

/**
 * Created by yutz on 2018/4/8.
 */
public class AbstractTestCase {

    public static WebDriver driver=null;
    private static String broswerType;
    private static int defaultTimeOut=30;
    private String url;

//    @Parameters({"url"})
    @BeforeMethod(alwaysRun = true)
    public void initDriver() throws Exception {
        url= ConfigUtil.getConfigUtil().getConfigFileContent("url");
        System.out.println("Current Driver is null : " + (driver == null));
        driver = creatNewDriver();
        driver.manage().timeouts().implicitlyWait(defaultTimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("----------------Start Test-----------------");
    }

    public static WebDriver creatNewDriver() throws Exception {
        if (driver == null) {
            synchronized (WebDriver.class) {
                if (driver == null) {
                    driver=DriverFactory.getInstance().createBroswerDriver();
                }
            }
        }
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void destoryDriver(){
        System.out.println("End Test Page Title="+driver.getTitle());
        driver.close();
        driver.quit();
        driver=null;
        System.out.println("----------------End  Test------------------");
    }


}
