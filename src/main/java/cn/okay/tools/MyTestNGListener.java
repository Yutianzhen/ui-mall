package cn.okay.tools;

import cn.okay.testbase.DriverFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 * Created by yutz on 2018/4/9.
 */
public class MyTestNGListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr){
        try {
            super.onTestFailure(tr);
            ScreenshotUtil.getScreenshotUtil(DriverFactory.getInstance().getDriver()).setScreenshot();
            String imgName=ScreenshotUtil.getScreenshotUtil().getFileName();
            Reporter.log("<img src=./img/" + imgName + " /img>", true);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("截图失败");
        }
    }

}
