package cn.okay.tools;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Created by yutz on 2018/9/14.
 * 设置testng实现用例失败重跑用类
 */
public class Retry implements IRetryAnalyzer{

    public int retryCount=0;
    private static int maxRetryCount ;
    static {
        //外围文件配置最大运行次数，失败后重跑maxRetryCount+1次
        maxRetryCount = 0;//也就是失败后重跑1次
        Reporter.log("maxRunCount=" + (maxRetryCount));
    }


    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount <= maxRetryCount){String message = "running retry for '" + iTestResult.getName() + "' on class " +
                this.getClass().getName() + " Retrying " + retryCount + " times";
            Reporter.log(message);
            Reporter.setCurrentTestResult(iTestResult);
            Reporter.log("RunCount=" + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }
}
