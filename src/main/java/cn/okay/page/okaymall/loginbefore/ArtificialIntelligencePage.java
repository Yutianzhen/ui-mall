package cn.okay.page.okaymall.loginbefore;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/2/28.
 *人工智能实时指导也页
 */
public class ArtificialIntelligencePage extends AbstractPage {

    @FindBy(css = ".intelligence")
    WebElement intelligentImg;

    public ArtificialIntelligencePage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,intelligentImg);
    }
}
