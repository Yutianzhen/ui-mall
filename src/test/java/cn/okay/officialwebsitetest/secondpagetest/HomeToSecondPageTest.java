package cn.okay.officialwebsitetest.secondpagetest;

import cn.okay.page.officialwebsite.fourthpage.FourthPage;
import cn.okay.page.officialwebsite.fourthpage.NewestNewDetailedPage;
import cn.okay.page.officialwebsite.thirdpage.ThirdPage;
import cn.okay.page.okaymall.loginbefore.AppDowloadPage;
import cn.okay.testbase.MallAbstractTestCase;
import cn.okay.testbase.OffcialAbstracTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.officialwebsite.secondpage.*;

import java.util.concurrent.ForkJoinPool;

import static cn.okay.testbase.AbstracTestCase.driver;

/**
 * Created by yutz on 2018/1/24.
 * 这是官网首页进行一系列操作的用例
 */
public class HomeToSecondPageTest extends OffcialAbstracTestCase {

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

    @Test(testName = "homePage4",description = "首页进入中小学校长页",groups = "offcial2")
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

    @Test(testName = "homePage12",description = "鼠标停留在网站地图时，唤起网站地图的角色入口选择框",groups = "offcial")
    public void mouseWebMapTest(){
        OffciaHomePage offciaHomePage=new OffciaHomePage(driver);
        offciaHomePage.mouseWebMap();
    }
    @Test(testName = "homePage13",description = "首页点击OKAY动态，进入OKAY智慧教育高峰论坛三级页",groups = "offcial")
    public void homePageToOkayEduPageTest(){
        OffciaHomePage offciaHomePage=new OffciaHomePage(driver);
        ThirdPage thirdPage=offciaHomePage.clickToOkayEeuPage();
        Assert.assertTrue(driver.getTitle().contains("OKAY智慧教育高峰论坛"));
    }

    @Test(testName = "homePage14",description = "首页点击下载专区，进入APP下载页",groups = "offcial")
    public void homePageToAppDowloadPageTest(){
        OffciaHomePage offciaHomePage=new OffciaHomePage(driver);
        AppDowloadPage appDowloadPage= offciaHomePage.clickToAppDowloadPage();
    }

    @Test(testName = "homePage15",description = "点击新闻资讯中第一条新闻，进入文章详情页",groups = "offcial")
    public void clickFirstNewToFourthPageTest(){
        OffciaHomePage offciaHomePage=new OffciaHomePage(driver);
        NewestNewDetailedPage fourthPage=offciaHomePage.clickToNewestNewDFourthPage();
    }

    @Test(testName = "homePage16",description = "点击当前正在轮播的banner图，进入四级页",groups = "offcial")
    public void ckickBannerLinkTest(){
        OffciaHomePage offciaHomePage=new OffciaHomePage(driver);
        FourthPage fourthPage=offciaHomePage.clickBannerToFourthPage();
    }
}
