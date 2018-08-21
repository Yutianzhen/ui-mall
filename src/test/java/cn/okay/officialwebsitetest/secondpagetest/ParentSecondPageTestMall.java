package cn.okay.officialwebsitetest.secondpagetest;

import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.officialwebsite.secondpage.ParentPage;
import cn.okay.page.officialwebsite.thirdpage.ParentThirdPage;
import cn.okay.testbase.MallAbstractTestCase;
import cn.okay.testbase.OffcialAbstracTestCase;
import org.testng.annotations.Test;

import static cn.okay.testbase.AbstracTestCase.driver;

/**
 * Created by yutz on 2018/2/5.
 */
public class ParentSecondPageTestMall extends OffcialAbstracTestCase {

    @Test(testName = "ParentSecondPage1",description = "家长二级页点击第一个关注模块进入三级页",groups = "offcial")
    public void clickFirstModdle() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        ParentThirdPage parentThirdPage=parentPage.clickToThirdPage();
    }

    @Test(testName = "ParentSecondPage2",description = "点击首页按钮回到首页",groups = "offcial")
    public void clickToHomePage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
        offciaHomePage =parentPage.clickToHomePage();
    }

}
