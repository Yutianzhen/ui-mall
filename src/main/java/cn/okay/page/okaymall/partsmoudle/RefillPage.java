package cn.okay.page.okaymall.partsmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/3/2.
 */
public class RefillPage extends AbstractPage {

    @FindBy(css = ".menu h2")
    WebElement refill;

    public RefillPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,refill);
    }
}
