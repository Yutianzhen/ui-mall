package cn.okay.tools;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by yutz on 2018/4/8.
 */
public class WaitTool {
    /**
     * Default wait time for an element. 60 seconds.
     * <p>
     * This value should be access through the getDefaultWait4Element static method, to ensure that any application
     * specific overrides are applied
     */
    public static final int DEFAULT_WAIT_4_ELEMENT = 30;
    private static int defaultWait4Element = DEFAULT_WAIT_4_ELEMENT;

    /**
     * Set the default value used by this tool for element timeout. If not set, the default is DEFAULT_WAIT_4_ELEMENT
     * timeout.
     *
     * @param timeoutInSeconds
     *            the new timeout value. If <code>null</code> the value reverts back to DEFAULT_WAIT_4_ELEMENT.
     */
    public static void setDefaultWait4Element(Integer timeoutInSeconds) {
        defaultWait4Element = timeoutInSeconds == null ? WaitTool.DEFAULT_WAIT_4_ELEMENT : timeoutInSeconds;
    }

    /**
     * Get the default value used by this tool for element timeout. If not set using the
     * <code>setDefaultWait4Element</code> method, the default is DEFAULT_WAIT_4_ELEMENT timeout.
     *
     * @return the timeout value.
     */
    public static int getDefaultWait4Element() {
        return defaultWait4Element;
    }

    /**
     * Default wait time for a page to be displayed. 12 seconds. The average web page load time is 6 seconds in 2012.
     * Based on your tests, please set this value. "0" will nullify implicitlyWait and speed up a test.
     * <p>
     * This value should be access through the getDefaultWait4Element static method, to ensure that any application
     * specific overrides are applied
     */
    public static final int DEFAULT_WAIT_4_PAGE = 30;
    private static int defaultWait4Page = DEFAULT_WAIT_4_PAGE;

    /**
     * Set the default value used by this tool for page load timeout. If not set, the default is DEFAULT_WAIT_4_ELEMENT
     * timeout. Note that this timeout may also be used for element arrive, after an AJAX call.
     *
     * @param timeoutInSeconds
     *            the new timeout value. If <code>null</code> the value reverts back to DEFAULT_WAIT_4_PAGE.
     */
    public static void setDefaultWait4Page(Integer timeoutInSeconds) {
        defaultWait4Page = timeoutInSeconds == null ? WaitTool.DEFAULT_WAIT_4_PAGE : timeoutInSeconds;
    }

    /**
     * Get the default value used by this tool for page load timeout. If not set using the
     * <code>setDefaultWait4Element</code> method, the default is DEFAULT_WAIT_4_ELEMENT timeout. Note that this timeout
     * may also be used for element arrive, after an AJAX call.
     *
     * @return the timeout value.
     */
    public static int getDefaultWait4Page() {
        return defaultWait4Page;
    }

    //判断整个页面加载完毕
    public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoad= new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoad);
    }

    /**
     * Wait for an expected an expectedCondition.
     *
     * @param driver
     *            The driver object to be used
     * @param expectedCondition
     *            The condition to wait for. See the <code>ExpectedConditions</code> class for the conditions one can
     *            wait for.
     * @param timeOutInSeconds
     *            The time in seconds to wait until returning a failure
     * @return the element returned by the condition provided
    // * @throws TimeoutException
    // *             if the timeout expires
     * @throws RuntimeException
     *             Wait will ignore instances of NotFoundException that are encountered (thrown) by default in the
     *             'until' condition, BUT immediately propagate all others.
     */

    public static <V> V  waitFor(WebDriver driver,ExpectedCondition<V> expectedCondition,int timeOutInSeconds){

        return new WebDriverWait(driver,timeOutInSeconds,defaultWait4Element).until(expectedCondition);

    }

    public static <V> Boolean waitFor(WebDriver driver, int timeOutSeconds, final WebElement element){

        return WaitTool.waitFor(driver, new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                try {
                    if(element.isDisplayed())
                        return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.getLogger(this.getClass()).error("Can't find that page webelement!!!");
                }
                return false;
            }
        },timeOutSeconds);
    }

}
