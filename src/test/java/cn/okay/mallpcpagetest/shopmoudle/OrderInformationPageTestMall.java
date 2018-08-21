package cn.okay.mallpcpagetest.shopmoudle;

import cn.okay.page.okaymall.loginbefore.LoginToolMallPage;
import cn.okay.page.okaymall.loginbefore.MallHomePage;
import cn.okay.page.okaymall.partsmoudle.HeadsetPage;
import cn.okay.page.okaymall.partsmoudle.PartsClassificationPage;
import cn.okay.page.okaymall.partsmoudle.PartsDetailPage;
import cn.okay.page.okaymall.shopmoudle.OrderInformationPage;
import cn.okay.page.okaymall.shopmoudle.ShopCarPage;
import cn.okay.testbase.MallAbstractTestCase;
import org.testng.annotations.Test;

/**
 * Created by yutz on 2018/3/19.
 */
public class OrderInformationPageTestMall extends MallAbstractTestCase {

    @Test(testName = "OrderInformationPageTest1", description = "订单信息页删除一个收获地址", groups = "mall")
    public void deleteAddress() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.clickJionShopCar();
        OrderInformationPage orderInformationPage=shopCarPage.goOrderInformationPage();
        orderInformationPage.delteteAddress();
    }

    @Test(testName = "OrderInformationPageTest2", description = "成功新增地址", groups = "mall")
    public void addAddress() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.clickJionShopCar();
        OrderInformationPage orderInformationPage=shopCarPage.goOrderInformationPage();
        orderInformationPage.addAddress();
    }

    @Test(testName = "OrderInformationPageTest3", description = "增加备注并提交订单", groups = "mall")
    public void placeOrder() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.clickJionShopCar();
        OrderInformationPage orderInformationPage=shopCarPage.goOrderInformationPage();
    }

}
