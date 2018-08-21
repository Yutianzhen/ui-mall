package cn.okay.mallpcpagetest.shopmoudle;

import cn.okay.page.okaymall.loginbefore.LoginToolMallPage;
import cn.okay.page.okaymall.loginbefore.MallHomePage;
import cn.okay.page.okaymall.partsmoudle.HeadsetPage;
import cn.okay.page.okaymall.partsmoudle.PartsClassificationPage;
import cn.okay.page.okaymall.partsmoudle.PartsDetailPage;
import cn.okay.page.okaymall.shopmoudle.*;
import cn.okay.testbase.MallAbstractTestCase;
import org.testng.annotations.Test;

/**
 * Created by yutz on 2018/3/30.
 */
public class PayPageTestMall extends MallAbstractTestCase {

    @Test(testName = "PayPageTest1", description = "选择支付宝支付", groups = "mall")
    public void seletAplipayTest() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.clickJionShopCar();
        OrderInformationPage orderInformationPage=shopCarPage.goOrderInformationPage();
        PayPage payPage=orderInformationPage.clickToPayPage();
        AlipaySurePage alipaySurePage=payPage.selectAlipay();
    }

    @Test(testName = "PayPageTest2", description = "选择微信支付但是未付款", groups = "mall")
    public void seletWechatPayTest() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.clickJionShopCar();
        OrderInformationPage orderInformationPage=shopCarPage.goOrderInformationPage();
        PayPage payPage=orderInformationPage.clickToPayPage();
        PayWaitPage payWaitPage=payPage.selectWeiXin();
        MyOrderPage myOrderPage=payWaitPage.clickSeeMyOrder();
    }

    @Test(testName = "PayPageTest3", description = "选择银行汇款支付", groups = "mall")
    public void seletBankRemittanceyTest() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.clickJionShopCar();
        OrderInformationPage orderInformationPage=shopCarPage.goOrderInformationPage();
        PayPage payPage=orderInformationPage.clickToPayPage();
        PayWaitPage payWaitPage=payPage.selectBankRemittance();
        MyOrderPage myOrderPage=payWaitPage.clickSeeMyOrder();
    }

}
