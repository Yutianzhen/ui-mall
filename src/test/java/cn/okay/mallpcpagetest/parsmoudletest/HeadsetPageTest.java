package cn.okay.mallpcpagetest.parsmoudletest;

import cn.okay.testbase.AbstractTestCase;
import org.testng.annotations.Test;
import cn.okay.page.okaymall.loginbefore.MallHomePage;
import cn.okay.page.okaymall.partsmoudle.HeadsetPage;
import cn.okay.page.okaymall.partsmoudle.PartsClassificationPage;
import cn.okay.page.okaymall.partsmoudle.PartsDetailPage;


/**
 * Created by yutz on 2018/3/8.
 */
public class HeadsetPageTest extends AbstractTestCase {

    @Test(testName = "HeadsetPageTest1",description = "耳机详情页点击导航返回配件类别页",groups = "mall")
    public void clickGoPartsClassPage() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        pcp=headsetPage.clickBarPartsBtn();
    }

    @Test(testName = "HeadsetPageTest2",description = "进入耳机商品详情页",groups = "mall")
    public void goPartsDetailPage() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        PartsDetailPage partsDetailPage=headsetPage.clickFirstParts();
    }

    @Test(testName = "HeadsetPageTest3",description = "点击链接出现查看型号弹窗",groups = "mall")
    public void clickSeeMoudleAlert() throws Exception {
        MallHomePage mallHomePage=new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        headsetPage.clickSeeMoudleBtn();
    }

    @Test(testName = "HeadsetPageTest4",description = "点击关闭按钮关闭查看型号弹窗",groups = "mall")
    public void clickCloseSeeMoudleAlert() throws Exception {
        MallHomePage mallHomePage = new MallHomePage(driver);
        PartsClassificationPage pcp=mallHomePage.clickPartsLink();
        HeadsetPage headsetPage=pcp.clickToHeadsetPage();
        headsetPage.clickCloseMoudle();
    }
}
