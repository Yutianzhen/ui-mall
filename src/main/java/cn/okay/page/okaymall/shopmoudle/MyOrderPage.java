package cn.okay.page.okaymall.shopmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/3/30.
 */
public class MyOrderPage extends AbstractPage{

    @FindBy(css = ".member-sectitle")
    WebElement orderPage;

    public MyOrderPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,orderPage);
    }
}
