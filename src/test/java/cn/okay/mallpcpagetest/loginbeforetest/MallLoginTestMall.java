package cn.okay.mallpcpagetest.loginbeforetest;

import cn.okay.page.okaymall.loginbefore.LoginToolMallPage;
import cn.okay.page.okaymall.loginbefore.MallHomePage;
import cn.okay.page.okaymall.loginbefore.RegisterPage;
import cn.okay.page.okaymall.loginbefore.ResetPasswordPage;
import cn.okay.testbase.MallAbstractTestCase;
import org.testng.annotations.Test;



/**
 * Created by yutz on 2018/2/27.
 * 商城的登录模块测试
 */
public class MallLoginTestMall extends MallAbstractTestCase {

    @Test(testName = "testLogin1",description = "登录后进入商城首页",groups = "mall")
    public void loginTest() throws Exception {
        LoginToolMallPage loginToolMallPage =new LoginToolMallPage(driver);
        MallHomePage mallHomePage= loginToolMallPage.login();
    }

    @Test(testName = "testLogin2",description = "登录框中进入注册页",groups = "mall")
    public void loginGoRgisterPage() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        RegisterPage registerPage=loginToolMallPage.loginToRegisterPage();
    }

    @Test(testName = "testLogin3",description = "登录框进入忘记密码页",groups = "mall")
    public void loginGoResterPasswordPage() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        ResetPasswordPage resetPasswordPage=loginToolMallPage.loginToResetPassword();
    }

    @Test(testName = "testLogin4",description = "登录框填写错误的密码",groups = "mall")
    public void loginPasswordErr() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        loginToolMallPage.passwordErr();
    }

    /*
    经验证，此case已经没有了
    @Test(testName = "testLogin5",description = "登录框填写不存在的手机号,报错后进入注册页面",groups = "mall1")
    public void loginUsernameErr() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        RegisterPage registerPage=loginToolMallPage.usernameErr();
    }
*/
    @Test(testName = "testLogin6",description = "用户菜单处点击注册按钮",groups = "mall")
    public void menuToRegisterPageTest() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        RegisterPage registerPage=loginToolMallPage.menuGoRegisterPage();
    }

}
