package cn.okay.mallpcpagetest.shopmoudle;

import cn.okay.page.okaymall.loginbefore.LoginToolMallPage;
import cn.okay.page.okaymall.loginbefore.MallHomePage;
import cn.okay.page.okaymall.partsmoudle.HeadsetPage;
import cn.okay.page.okaymall.partsmoudle.PartsClassificationPage;
import cn.okay.page.okaymall.partsmoudle.PartsDetailPage;
import cn.okay.page.okaymall.shopmoudle.*;
import cn.okay.testbase.AbstractTestCase;
import org.testng.annotations.Test;

/**
 * Created by yutz on 2018/3/14.
 */
public class ShopCarPageTest extends AbstractTestCase{

    @Test(testName = "ShopCarPageTest1",description = "选择商品结算并进入订单信息页",groups = "mall")
    public void selectCommodity() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.loginAndJoinShopCar();
        OrderInformationPage orderInformationPage=shopCarPage.goOrderInformationPage();
    }

    @Test(testName = "ShopCarPageTest2",description = "删除第一个商品",groups = "mall")
    public void deleteFirstCommodity() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.clickJionShopCar();
        shopCarPage.deleteFirstCommodity();
    }

    @Test(testName = "ShopCarPageTest3",description = "设置第一个商品的商品数量为2",groups = "mall")
    public void inputFirstCommodityCount() throws Exception {
        LoginToolMallPage loginToolMallPage = new LoginToolMallPage(driver);
        MallHomePage mallHomePage = loginToolMallPage.login();
        PartsClassificationPage pcp = mallHomePage.clickPartsLink();
        HeadsetPage headsetPage = pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage = headsetPage.clickFirstParts();
        ShopCarPage shopCarPage = partsDetailPage.clickJionShopCar();
        shopCarPage.inputFirstCount();
    }

}
