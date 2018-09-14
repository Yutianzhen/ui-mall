package cn.okay.tools;

import cn.okay.testbase.DriverFactory;
import org.testng.*;

import java.util.Iterator;

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

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = (ITestResult) listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (testContext.getFailedTests().getResults(method).size() > 1) {
                listOfFailedTests.remove();
            }
            else {
                if (testContext.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }

            }
        }
    }

}
