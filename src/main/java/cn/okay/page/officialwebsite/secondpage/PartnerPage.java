package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by yutz on 2018/2/1.
 */
public class PartnerPage extends AbstractPage {

    @FindBy(css="#talkbox")
    WebElement partnerPageElement;

    public PartnerPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,partnerPageElement);
        pageWait(4000);
    }
}
