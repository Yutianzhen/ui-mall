package cn.okay.page.okaymall.loginbefore;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.ConfigUtil;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by yutz on 2018/2/27.
 * 登录的弹框页
 */
public class LoginToolMallPage extends AbstractPage{

    @FindBy(css=".index-banner")
    WebElement homeBanner;

    @FindBy(css=".user-icon")
    WebElement userBtn;

    @FindBy(css=".okay-login-btn")
    WebElement loginBtn;

    @FindBy(linkText = "注册")
    WebElement registerBtn;

    @FindBy(css=".login-title")
    WebElement loginAlertTitle;

    @FindBy(css="input[class='okay-input login-tel']")
    WebElement userNameInput;

    @FindBy(css="input[class='okay-input login-pas']")
    WebElement passwordInput;

    @FindBy(css=".btn")
    WebElement submit;

    @FindBy(css = ".parts-icon")
    WebElement shopIcon;

    @FindBy(css = ".go-regist")
    WebElement goRegistBtn;

    @FindBy(linkText = "忘记密码")
    WebElement resetPasswordLink;

    @FindBy(css = ".login-err")
    WebElement passwordErr;

    @FindBy(css = ".login-err .okay-a")
    WebElement usernameErr;

    public LoginToolMallPage(WebDriver driver) throws Exception {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,homeBanner);
    }

    public MallHomePage login() throws Exception {
        String userName=ConfigUtil.getConfigUtil().getConfigFileContent("username");
        String password= ConfigUtil.getConfigUtil().getConfigFileContent("password");
        moveToElement(driver,userBtn);
        click(loginBtn,loginAlertTitle);
        sendkeysInput(userNameInput,userName);
        sendkeysInput(passwordInput,password);
        log.info("username:"+userName+";password:"+password);
        return click(submit,MallHomePage.class);
    }

    public RegisterPage loginToRegisterPage() throws Exception {
        moveToElement(driver,userBtn);
        click(loginBtn,loginAlertTitle);
        return click(goRegistBtn,RegisterPage.class);
    }

    public ResetPasswordPage loginToResetPassword() throws Exception {
        moveToElement(driver,userBtn);
        click(loginBtn,loginAlertTitle);
        clickAndSwitchWindow(resetPasswordLink);
        return new ResetPasswordPage(driver);
    }

    public void passwordErr(){
        moveToElement(driver,userBtn);
        click(loginBtn,loginAlertTitle);
        sendkeysInput(userNameInput,"18915262525");
        sendkeysInput(passwordInput,"123321");
        click(submit,passwordErr);
        pageWait(2000);
        log.error("错误提示是："+passwordErr.getText());
        Assert.assertEquals(passwordErr.getText(),"手机号密码不匹配");
    }

    public RegisterPage usernameErr() throws Exception {
        moveToElement(driver,userBtn);
        click(loginBtn,loginAlertTitle);
        sendkeysInput(userNameInput,"18915262501");
        click(submit,usernameErr);
        pageWait(2000);
        Assert.assertEquals(usernameErr.getText(),"去注册");
        return click(usernameErr,RegisterPage.class);
    }

    public RegisterPage menuGoRegisterPage() throws Exception {
        moveToElement(driver,userBtn);
        return click(registerBtn,RegisterPage.class);
    }

}
