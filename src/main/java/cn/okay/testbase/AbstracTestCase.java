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

//在@Test注解中加入了group属性时,@BeforeMethod修饰的方法会无法执行,原因是@Beforeclass不是@Test的那个组，如果使用alwaysRun=true方式，让其一定会运行
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
