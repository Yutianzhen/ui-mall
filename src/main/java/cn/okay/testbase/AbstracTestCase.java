package cn.okay.testbase;

import cn.okay.tools.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by yutz on 2018/8/21.
 */
public class AbstracTestCase {

    public static WebDriver driver=null;
    private static String broswerType;
    private static int defaultTimeOut=30;


    @BeforeMethod(alwaysRun = true)
    public void initDriver()throws Exception{}
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
        System.out.println("-------------------------End  Test---------------------------");
    }

}
