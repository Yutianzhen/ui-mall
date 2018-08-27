package cn.okay.officialwebsitetest.otherlevelpagetest;

import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.officialwebsite.fourthpage.FourthPage;
import cn.okay.page.officialwebsite.secondpage.ParentPage;
import cn.okay.page.officialwebsite.thirdpage.ThirdPage;
import cn.okay.testbase.OffcialAbstracTestCase;
import org.testng.annotations.Test;

/**
 * Created by yutz on 2018/2/5.
 */
public class FourthPageTest extends OffcialAbstracTestCase {

    @Test(testName = "FourthPageTest1",description = "点击推荐文章的第一篇文章",groups = "offcial")
    public void clickFirstRecommendMoudleToOtherRecommend() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ThirdPage thirdPage =parentPage.clickToThirdPage();
        FourthPage fourthPage= thirdPage.clickArticleListFirst();
        fourthPage=fourthPage.clickFirstRecommendMoudle();
    }

    @Test(testName = "FourthPageTest2",description = "点击导航链接进入首页",groups = "offcial")
    public void clickFirstBarToHomePage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ThirdPage thirdPage =parentPage.clickToThirdPage();
        FourthPage fourthPage= thirdPage.clickBannerImgToFourthPage();
        offciaHomePage =fourthPage.clickFirstBarBtnToHomePage();
    }

    @Test(testName = "FourthPageTest3",description = "页面滑动到底部后点击回到顶部按钮",groups = "offcial")
    public void clickToPageTop() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ThirdPage thirdPage =parentPage.clickToThirdPage();
        FourthPage fourthPage= thirdPage.clickBannerImgToFourthPage();
        fourthPage.clickToPageTop();
    }

}
