package cn.okay.mallpcpagetest.parsmoudletest;

import cn.okay.page.okaymall.loginbefore.LoginToolMallPage;
import cn.okay.page.okaymall.loginbefore.MallHomePage;
import cn.okay.page.okaymall.partsmoudle.HeadsetPage;
import cn.okay.page.okaymall.partsmoudle.PartsClassificationPage;
import cn.okay.page.okaymall.partsmoudle.PartsDetailPage;
import cn.okay.page.okaymall.shopmoudle.ShopCarPage;
import cn.okay.testbase.MallAbstractTestCase;
import org.testng.annotations.Test;

/**
 * Created by yutz on 2018/3/12.
 */
public class PartsDetailPageTestMall extends MallAbstractTestCase {

    @Test(testName = "PartsDetailPage1", description = "登录前进入商品详情页商品加入购物车", groups = "mall")
    public void joinShopCar() throws Exception {
        MallHomePage mallHomePage = new MallHomePage(driver);
        PartsClassificationPage pcp = mallHomePage.clickPartsLink();
        HeadsetPage headsetPage = pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage = headsetPage.clickFirstParts();
        ShopCarPage shopCarPage = partsDetailPage.loginAndJoinShopCar();
    }

    @Test(testName = "PartsDetailPage2", description = "登录后进入商品详情页商品加入购物车", groups = "mall")
    public void loginAfterJoinShopCar() throws Exception {
        LoginToolMallPage loginToolMallPage = new LoginToolMallPage(driver);
        MallHomePage mallHomePage = loginToolMallPage.login();
        PartsClassificationPage pcp = mallHomePage.clickPartsLink();
        HeadsetPage headsetPage = pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage = headsetPage.clickFirstParts();
        ShopCarPage shopCarPage = partsDetailPage.clickJionShopCar();
    }

    @Test(testName = "PartsDetailPage3", description = "商品详情页点击增加数量按钮", groups = "mall")
    public void clickAddCountBtn() throws Exception {
        MallHomePage mallHomePage = new MallHomePage(driver);
        PartsClassificationPage pcp = mallHomePage.clickPartsLink();
        HeadsetPage headsetPage = pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage = headsetPage.clickFirstParts();
        partsDetailPage.addCount();
    }

    @Test(testName = "PartsDetailPage4", description = "商品详情页点击增加数量按钮", groups = "mall")
    public void clickerduceCountBtn() throws Exception {
        MallHomePage mallHomePage = new MallHomePage(driver);
        PartsClassificationPage pcp = mallHomePage.clickPartsLink();
        HeadsetPage headsetPage = pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage = headsetPage.clickFirstParts();
        partsDetailPage.reduceCount();
    }

    @Test(testName = "PartsDetailPage5", description = "商品详情页点击查看型号连接", groups = "mall")
    public void clickeSeeMoudle() throws Exception {
        MallHomePage mallHomePage = new MallHomePage(driver);
        PartsClassificationPage pcp = mallHomePage.clickPartsLink();
        HeadsetPage headsetPage = pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage = headsetPage.clickFirstParts();
        partsDetailPage.clickToSeeMoudleAlert();
    }

    @Test(testName = "PartsDetailPage6", description = "商品详情页点击导航回到耳机页", groups = "mall")
    public void clickBackHeaderMoudle() throws Exception {
        MallHomePage mallHomePage = new MallHomePage(driver);
        PartsClassificationPage pcp = mallHomePage.clickPartsLink();
        HeadsetPage headsetPage = pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage = headsetPage.clickFirstParts();
        headsetPage=partsDetailPage.clickBarToHeadsetPage();
    }
}