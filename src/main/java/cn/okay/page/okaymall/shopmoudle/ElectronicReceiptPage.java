package cn.okay.page.okaymall.shopmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/4/10.
 */
public class ElectronicReceiptPage extends AbstractPage {

    @FindBy(css = ".orderinfo")
    WebElement orderInformation;

    public ElectronicReceiptPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,orderInformation);
    }

}
