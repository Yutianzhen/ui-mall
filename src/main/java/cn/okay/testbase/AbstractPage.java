package cn.okay.testbase;

import cn.okay.tools.Log;
import cn.okay.tools.WaitTool;
import cn.okay.tools.WindowUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by yutz on 2018/4/8.
 */
public class AbstractPage {

    protected WebDriver driver;
    public static final int DefaultWaitElementTime4Page = 30;
    protected Log log=new Log(this.getClass());

    public AbstractPage(WebDriver driver){
        this.driver=driver;
        //page load end
        WaitTool.waitForLoad(driver);
        //Initialization page elements
        PageFactory.initElements(driver,this);
        pageWait(2000);
        log.info(driver.getTitle()+":page load end");
    }

    protected static boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    protected void clickAndSwitchWindow(WebElement element){
        log.info("Click element and switchWindow");
        isDisplayed(element);
        click(element);
        WindowUtil.getInstance(driver).switchToNewWindow();
    }

    //设置点击元素事件
    protected void click(WebElement element){
        isDisplayed(element);
        element.click();
    }

    //点击一个元素等待下一个元素出现
    protected WebElement click(WebElement element,WebElement expectedElement){
        log.info("Click element wait next element");
        click(element);
        pageWait(3000);
        return ((WebElement)WaitTool.waitFor(this.driver, ExpectedConditions.visibilityOf(expectedElement),WaitTool.getDefaultWait4Element()));
    }

    //点击一个元素并等待下一个页面出现
    protected <W extends AbstractPage> W click(WebElement element, Class<W> nextPageClass) throws Exception {
        log.info("Click element wait next page");
        click(element);
        return nextPageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
    }

    //鼠标悬停当前元素
    protected void moveToElement(WebDriver driver,WebElement element){
        isDisplayed(element);
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
        pageWait(2000);
    }

    protected void sendkeysInput(WebElement element,String s){
        element.clear();
        element.sendKeys(s);
        pageWait(2000);
    }
    //处理文件上传操作  http://blog.csdn.net/u011541946/article/details/74332938
    protected void uploadFile(String src){
        StringSelection sel=new StringSelection(src);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
        try {
            Robot robot=new Robot();
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (Exception e){
            e.printStackTrace();
            log.error("上传文件失败");
        }
    }

    //通过JS方式滑动页面到指定元素附近
    protected void slidingPageToElement(WebDriver driver,WebElement element){
        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    //设置线程休眠
    protected void pageWait(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("Thread sleep fail");
        }
    }

}
