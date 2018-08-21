package cn.okay.testbase;

import cn.okay.tools.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by yutz on 2018/8/21.
 */
public class OffcialAbstracTestCase extends AbstracTestCase{

    private static int defaultTimeOut=30;
    private String offcialUrl;

    @BeforeMethod(alwaysRun = true)
    public void initDriver() throws Exception {
        System.out.println("-------------------------Start Test--------------------------");
        offcialUrl= ConfigUtil.getConfigUtil().getConfigFileContent("offcialUrl");
        System.out.println("Current Driver is null : " + (driver == null));
        driver = creatNewDriver();
        driver.manage().timeouts().implicitlyWait(defaultTimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(offcialUrl);
    }



}
