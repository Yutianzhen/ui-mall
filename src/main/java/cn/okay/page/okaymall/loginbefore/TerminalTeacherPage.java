package cn.okay.page.okaymall.loginbefore;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by yutz on 2018/2/28.
 */
public class TerminalTeacherPage extends AbstractPage {

    @FindBy(css = ".t1-1")
    WebElement terminalTeacherMoudle;

    public TerminalTeacherPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,terminalTeacherMoudle);
    }
}
