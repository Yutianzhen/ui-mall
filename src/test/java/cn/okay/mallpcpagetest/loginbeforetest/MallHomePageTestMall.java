package cn.okay.mallpcpagetest.loginbeforetest;

import cn.okay.testbase.MallAbstractTestCase;
import org.testng.annotations.Test;
import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.okaymall.loginbefore.*;
import cn.okay.page.okaymall.partsmoudle.PartsClassificationPage;
import cn.okay.page.okaymall.shopmoudle.ShopCarPage;


/**
 * Created by yutz on 2018/2/28.
 */
public class MallHomePageTestMall extends MallAbstractTestCase {

    @Test(testName = "mallHomePageTest1",description = "商城首页进入配件页",groups = "mall")
    public void clickPartsLink() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pc=mallHomePage.clickPartsLink();
    }

    @Test(testName = "mallHomePageTest2",description = "商城首页点击首页按钮",groups = "mall")
    public void clickHomePageLink() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        mallHomePage=mallHomePage.clickHomePageLink();
    }

    @Test(testName = "mallHomePageTest3",description = "商城首页点击官网连接",groups = "mall")
    public void clickOfficaLink() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        OffciaHomePage offciaHomePage=mallHomePage.clickOfficaLink();
    }

    @Test(testName = "mallHomePageTest4",description = "商城首页点击第一张banner图片进入S4.0页面",groups = "mall")
    public void clickFirstBannerImg() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        TerminalStudentPage ts=mallHomePage.clickImg();
    }

    @Test(testName = "mallHomePageTest5",description = "首页点击运营位进入下载页",groups = "mall")
    public void clickDowloadAppMoudle() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        AppDowloadPage appDowloadPage=mallHomePage.clickDowloadMoudle();
    }

    @Test(testName = "mallHomePageTest6",description = "首页点击运营位的人工智能模块",groups = "mall")
    public void clickArtificialIntelligenceMoudle() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        ArtificialIntelligencePage atp=mallHomePage.clickIntelligentTerminalMoudle();
    }

    @Test(testName = "mallHomePageTest7",description = "首页点击运营位的远程智能教学",groups = "mall")
    public void clickDistanceTeacherMoudle() throws Exception {
        MallHomePage mallHomePage = new MallHomePage(driver);
        DistanceTeachingPage dtp=mallHomePage.clickDistanceTeachingMoudle();
    }

    @Test(testName = "mallHomePageTest8",description = "首页点击运营位的配件模块",groups = "mall")
    public void clickPartsMoudle() throws Exception {
        MallHomePage mallHomePage = new MallHomePage(driver);
        PartsClassificationPage pc=mallHomePage.clickPartsMoudle();
    }

    @Test(testName = "mallHomePageTest9",description = "首页滑动智能终端并点击进入S4.0",groups = "mall")
    public void clickTerminalStudentBtn() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        TerminalStudentPage ts=mallHomePage.clickStudentTerminal();
    }

    @Test(testName = "mallHomePageTest9",description = "首页滑动智能终端并点击进入T1.0",groups = "mall")
    public void clickTerminalTeacherBtn() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        TerminalTeacherPage ts=mallHomePage.clickTeacherTerminal();
    }

    @Test(testName = "mallHomePageTest10",description = "登录后首页进入购物车页",groups = "mall")
    public void homePageToShopCarPage() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        ShopCarPage shopCarPage=mallHomePage.homePageToShopPage();
    }

}
