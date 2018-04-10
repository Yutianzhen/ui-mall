package cn.okay.officialwebsitetest.secondpagetest;

import cn.okay.testbase.AbstractTestCase;
import org.testng.annotations.Test;
import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.officialwebsite.secondpage.*;

/**
 * Created by yutz on 2018/1/24.
 */
public class HomeToSecondPageTest extends AbstractTestCase {

    @Test(testName = "homePage1",description = "首页进入公司简介页",groups = "offcial")
    public void homePageToProfilePage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        CompanyProfilePage companyProfilePage= offciaHomePage.clickToCompanyProfilePage();
    }

    @Test(testName = "homePage2",description = "官网首页进入商城首页",groups = "offcial")
    public void homePageToOkayMallPage(){
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        OkayMallPage mallPage= offciaHomePage.clickToOkayMallPage();
    }

    @Test(testName = "homePage3",description = "首页进入产品介绍页",groups = "offcial")
    public void homePageToProductIntroductionPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ProductIntroductionPage productIntroductionPage= offciaHomePage.clickToProductIntroductionPage();
    }

    @Test(testName = "homePage4",description = "首页进入中小学校长页",groups = "offcial")
    public void homePageToHeadmasterPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        HeadMasterPage headMasterPage= offciaHomePage.clickToHeadmasterPage();
    }

    @Test(testName = "homePage5",description = "首页进入培训机构校长页",groups = "offcial")
    public void homePageToTrainingInstitutionPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        TrainingInstitutionPage trainingInstitutionPage= offciaHomePage.clickToTrainingInstitutionPage();
    }

    @Test(testName = "homePage6",description = "首页进入老师页",groups = "offcial")
    public void homePageToTeacherPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        TeacherPage teacherPage= offciaHomePage.clickToTeacherPage();
    }

    @Test(testName = "homePage7",description = "首页进入教育部门领导页",groups = "offcial")
    public void homePageToEducationDepartmentPage() throws Exception {
        OffciaHomePage offciaHomePage = new OffciaHomePage(driver);
        EducationDepartmentPage educationDepartmentPage= offciaHomePage.clickToEducationDepartmentPage();
    }

    @Test(testName = "homePage8",description = "首页进入学生页",groups = "offcial")
    public void  homePageToStudentPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        StudentPage studentPage= offciaHomePage.clickToStudentPage();
    }

    @Test(testName = "homePage9",description = "首页进入家长页",groups = "offcial")
    public void homePageToParentPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        ParentPage parentPage= offciaHomePage.clickToParentPage();
    }

    @Test(testName = "homePage10",description = "首页进入合作伙伴页",groups = "offcial")
    public void homeToPartnerPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        PartnerPage partnerPage= offciaHomePage.clickToPartnerPage();
    }

    @Test(testName = "homePage11",description = "鼠标悬停在微信公众号",groups = "offcial")
    public void homePageMouseHoverWechatTest(){
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        offciaHomePage.mouseHoverWechat();
    }
}
