package cn.okay.tools;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Set;

/**
 * Created by yutz on 2018/4/8.
 */
public class WindowUtil {

    private WebDriver driver;
    private String currentWindow=null;
    private Boolean flag=false;

    private WindowUtil(WebDriver driver){

        this.driver=driver;
    }

    public static synchronized WindowUtil getInstance(WebDriver driver){

        return new WindowUtil(driver);
    }

    public String getCurrentWindow(){
        currentWindow=driver.getWindowHandle();
        return currentWindow;
    }
    //设置在多个窗口情况下，切换窗口时会关闭切换前的老窗口，始终保持只有两个窗口同时存在
    public String switchToNewWindow(){
        currentWindow=getCurrentWindow();
        WaitTool.waitFor(driver, new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver input) {
                Set<String> windows=driver.getWindowHandles();
                return windows.size()>1;
            }
        },WaitTool.getDefaultWait4Page());
        Set<String> windows=driver.getWindowHandles();
        for(String wh:windows){
            if(!wh.equals(currentWindow)) {
                driver.close();
                driver.switchTo().window(wh);
                break;
            }
        }
        return currentWindow;
    }
    //切换到最新打开的窗口
    public void switchWindow(){
        currentWindow=getCurrentWindow();
        WaitTool.waitFor(driver, new ExpectedCondition<Boolean>(){

            @Override
            public Boolean apply(WebDriver input) {
                Set<String> windows=driver.getWindowHandles();
                return windows.size()>1;
            }
        },WaitTool.getDefaultWait4Page());
        Set<String> windows=driver.getWindowHandles();
        for(String wh:windows){
            if(wh.equals(currentWindow))
                continue;
            driver.switchTo().window(wh);
            break;
        }
    }
    //切换到指定窗口
    public void switchToAppointWindow(String windowHandle){
        driver.switchTo().window(windowHandle);
    }
    //根据指定窗口title进行切换
    public Boolean switchToWindowForTitle(String windowsTitle){
        try {
            currentWindow=getCurrentWindow();
            Set<String> windows=driver.getWindowHandles();
            for(String wh:windows){
                if(wh.equals(currentWindow))
                    continue;
                else{
                    driver.switchTo().window(wh);
                    if (driver.getTitle().contains(windowsTitle)){
                        flag=true;
                        System.out.println("Switch to window: "
                                + windowsTitle + " successfully!");
                        break;
                    }
                    else
                        continue;
                }
            }
        }
        catch (NoSuchWindowException e){
            System.out.println("Window: " + windowsTitle + " cound not found!");
            flag = false;
        }
        return flag;
    }
    //获得当前窗口总数
    public int getCurrentWindowCount() throws Exception {

        try {
            WaitTool.waitFor(driver, new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver input) {
                    Set<String> windows = driver.getWindowHandles();
                    return windows.size() > 1;
                }

            }, 30);
        } catch (Exception e) {

        }
        return driver.getWindowHandles().size();
    }

    public static void snapshot(){

    }

}
