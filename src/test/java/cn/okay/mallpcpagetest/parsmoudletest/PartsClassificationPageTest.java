package cn.okay.mallpcpagetest.parsmoudletest;

import cn.okay.page.okaymall.loginbefore.MallHomePage;
import cn.okay.page.okaymall.partsmoudle.*;
import cn.okay.testbase.AbstractTestCase;
import org.testng.annotations.Test;
/**
 * Created by yutz on 2018/3/6.
 */
public class PartsClassificationPageTest extends AbstractTestCase {

    @Test(testName = "PartsClass1",description = "进入手写笔系列页面",groups = "mall")
    public void goHandwritingPenPage() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HandwritingPenPage handwritingPenPage=pcp.clickToHandwritingPenPage();
    }

    @Test(testName = "PartsClass2",description = "进入充电器系列页面",groups = "mall")
    public void goChargerPageTest() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        ChargerPage chargerPage=pcp.clickToChargerPage();
    }

    @Test(testName = "PartsClass3",description = "进入耳机系列页面",groups = "mall")
    public void goHeadsetPageTest() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
    }

    @Test(testName = "PartsClass4",description = "进入笔芯系列页面",groups = "mall")
    public void goRefillPage() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        RefillPage refillPage=pcp.clickToRefillPage();
    }

    @Test(testName = "PartsClass5",description = "进入售后维修包系列页面",groups = "mall")
    public void goRepairPage() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        RepairPage repairPage=pcp.clickToRepairPage();
    }

    @Test(testName = "PartsClass6",description = "进入保护套系列页面",groups = "mall")
    public void goSmartCoverPage() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        SmartCoverPage smartCoverPage=pcp.clickToSmartCoverPage();
    }

    @Test(testName = "PartsClass7",description = "滑动页面到底部然后点击回到顶部按钮",groups = "mall")
    public void clickGoPageTop() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        pcp.clickToTopBtn();
    }

}
