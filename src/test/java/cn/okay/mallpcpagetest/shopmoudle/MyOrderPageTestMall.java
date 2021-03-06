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
 * Created by yutz on 2018/4/10.
 * 我的订单页
 */
public class MyOrderPageTestMall extends MallAbstractTestCase {

    @Test(testName = "MyOrderPageTest1", description = "鼠标滑过第一个订单详情链接，出现订单详情介绍", groups = "mall")
    public void MoveToFirstDetaliLink() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        MyOrderPage myOrderPage=mallHomePage.homePageToMyOrderPage();
        myOrderPage.moveToDetaliLink();
    }

    @Test(testName = "MyOrderPageTest2", description = "取消订单", groups = "mall")
    public void cancelOrder() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        /**  此处是为了防止没有取消订单按钮 进行的进入首页后从下单到进入我的订单页的流程
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
        ShopCarPage shopCarPage=partsDetailPage.clickJionShopCar();
        OrderInformationPage orderInformationPage=shopCarPage.goOrderInformationPage();
        PayPage payPage=orderInformationPage.clickToPayPage();
        PayWaitPage payWaitPage=payPage.selectBankRemittance();
        MyOrderPage myOrderPage=payWaitPage.clickSeeMyOrder();
        myOrderPage.cancelOrder();
         */
        MyOrderPage myOrderPage=mallHomePage.homePageToMyOrderPage();
        myOrderPage.cancelOrder();
    }

    @Test(testName = "MyOrderPageTest3", description = "进入电子收据页面", groups = "mall")
    public void intoElectronicReceiptPage() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        MyOrderPage myOrderPage=mallHomePage.homePageToMyOrderPage();
        ElectronicReceiptPage electronicReceiptPage=myOrderPage.clickToElectronicReceiptPage();
    }

    @Test(testName = "MyOrderPageTest4", description = "点击去支付按钮，进入支付页", groups = "mall")
    public void clickGoPayBtn() throws Exception {
        LoginToolMallPage loginToolMallPage=new LoginToolMallPage(driver);
        MallHomePage mallHomePage=loginToolMallPage.login();
        MyOrderPage myOrderPage=mallHomePage.homePageToMyOrderPage();
        PayPage payPage=myOrderPage.goPay();
    }

}
