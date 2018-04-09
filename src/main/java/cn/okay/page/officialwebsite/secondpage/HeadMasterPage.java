package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/1/24.
 */
public class HeadMasterPage extends AbstractPage {

    @FindBy(id="talkbox")
    public WebElement xiaoYun;

    public HeadMasterPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,xiaoYun);
        pageWait(4000);
    }

}
