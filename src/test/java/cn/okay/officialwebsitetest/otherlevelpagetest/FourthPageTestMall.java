package cn.okay.officialwebsitetest.otherlevelpagetest;

import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.officialwebsite.fourthpage.FourthPage;
import cn.okay.page.officialwebsite.secondpage.ParentPage;
import cn.okay.page.officialwebsite.thirdpage.ParentThirdPage;
import cn.okay.testbase.MallAbstractTestCase;
import cn.okay.testbase.OffcialAbstracTestCase;
import org.testng.annotations.Test;

/**
 * Created by yutz on 2018/2/5.
 */
public class FourthPageTestMall extends OffcialAbstracTestCase {

    @Test(testName = "FourthPageTest1",description = "点击推荐文章的第一篇文章",groups = "offcial")
    public void clickFirstRecommendMoudleToOtherRecommend() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
        FourthPage fourthPage=parentThirdPage.clickArticleListFirst();
        fourthPage=fourthPage.clickFirstRecommendMoudle();
    }

    @Test(testName = "FourthPageTest2",description = "点击导航链接进入首页",groups = "offcial")
    public void clickFirstBarToHomePage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
        FourthPage fourthPage=parentThirdPage.clickBannerImgToFourthPage();
        offciaHomePage =fourthPage.clickFirstBarBtnToHomePage();
    }

    @Test(testName = "FourthPageTest3",description = "页面滑动到底部后点击回到顶部按钮",groups = "offcial")
    public void clickToPageTop() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
        FourthPage fourthPage=parentThirdPage.clickBannerImgToFourthPage();
        fourthPage.clickToPageTop();
    }

}
