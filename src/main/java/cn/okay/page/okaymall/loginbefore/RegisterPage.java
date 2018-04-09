package cn.okay.page.okaymall.loginbefore;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/3/2.
 */
public class RegisterPage extends AbstractPage {

    @FindBy(css = ".okay-a-register")
    WebElement register;

    public RegisterPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,register);
    }
}
