package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/2/1.
 */
public class OkayMallPage extends AbstractPage {

    @FindBy(css=".okay-header")
    WebElement mallHeader;

    public OkayMallPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,mallHeader);
    }
}
