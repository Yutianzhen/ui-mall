package cn.okay.officialwebsitetest.otherlevelpagetest;

import cn.okay.testbase.AbstractTestCase;
import org.testng.annotations.Test;
import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.officialwebsite.fourthpage.FourthPage;
import cn.okay.page.officialwebsite.secondpage.ParentPage;
import cn.okay.page.officialwebsite.thirdpage.ParentThirdPage;

/**
 * Created by yutz on 2018/2/5.
 */
public class ThirdPageTest extends AbstractTestCase {

    @Test(testName = "ThirdPageTest1",description = "二级页面进入三级页",groups = "offcia")
    public void jionThirdPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
    }

    @Test(testName = "ThirdPageTest2",description = "点击bar上的家长回到二级页1",groups = "offcia")
    public void clickBarToSecondPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
        parentPage=parentThirdPage.clickBarParentBtn();
    }

    @Test(testName = "ThirdPageTest3",description = "点击banner主题进入四级页",groups = "offcia")
    public void clickBannerImgToFourthPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
        FourthPage fourthPage=parentThirdPage.clickBannerImgToFourthPage();
    }

    @Test(testName = "ThirdPageTest4",description = "点击推荐的其他主题模块进入另外主题三级页",groups = "offcia")
    public void clickOtherRecommendMoudle() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
        parentThirdPage=parentThirdPage.clickOtherRecommendThemeMoudle();
    }

    @Test(testName = "ThirdPageTest5",description = "hover后点击文章列表第一篇文章进入四级页",groups = "offcia")
    public void clickListFirstArticle() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
        FourthPage fourthPage=parentThirdPage.clickArticleListFirst();
    }

}
