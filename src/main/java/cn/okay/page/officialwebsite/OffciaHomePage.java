package cn.okay.page.officialwebsite;

import cn.okay.page.officialwebsite.fourthpage.FourthPage;
import cn.okay.page.officialwebsite.fourthpage.NewestNewDetailedPage;
import cn.okay.page.officialwebsite.secondpage.*;
import cn.okay.page.officialwebsite.thirdpage.ThirdPage;
import cn.okay.page.okaymall.loginbefore.AppDowloadPage;
import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.ws.WebEndpoint;

/**
 * Created by yutz on 2018/4/9.
 * 官网首页
 */
public class OffciaHomePage extends AbstractPage {

    @FindBy(id="talkbox")
    private WebElement xiaoYun;

    //精彩回放
    @FindBy(css="a[href='https://www.okayzhihui.com/index/videoLive']")
    WebElement playbackBtn;

    //中小学校长
    @FindBy(css="a[href='/headmaster/index.html']")
    WebElement headMasterBtn;

    //教育部门领导
    @FindBy(css="a[href='/edudep/index.html']")
    WebElement educationDepartmentBtn;

    @FindBy(css="a[href='/teacher/index.html']")
    WebElement teacherBtn;

    @FindBy(css="a[href='/student/index.html']")
    WebElement studentBtn;

    //家长
    @FindBy(css="a[href='/parent/index.html']")
    WebElement parentBtn;

    //培训机构校长
    @FindBy(css="a[href='/trains/index.html']")
    WebElement trainingInstitutionBtn;

    //合作伙伴
    @FindBy(css="a[href='/partner/index.html']")
    WebElement partnerBtn;

    //公司简介（即关于我们按钮）
    @FindBy(css="a[href='/introduction.html']")
    WebElement companyProfile;

    //产品介绍（OKAY产品链接）
    @FindBy(css="a[href='/partner/125/183.html']")
    WebElement productIntroductionBtn;

    @FindBy(linkText = "OKAY动态")
    WebElement OKAYDynamicBtn;

    @FindBy(linkText = "下载专区")
    WebElement downloadApp;

    @FindBy(css=".mall")
    WebElement OkayMallBtn;

    @FindBy(css="div[class='func wechat']")
    WebElement wechatIcon;

    @FindBy(css="i[class='icon code']")
    WebElement wechatCode;
    //网站地图按钮
    @FindBy(css=".entrance")
    WebElement webMapBtn;
    //一级地图的角色选择框
    @FindBy(css = ".role-list")
    WebElement firstLevelMap;
    //最新资讯
    @FindBy(css=".news li")
    WebElement newestNews;
    //首页banner当前正在轮播的轮播图
    @FindBy(css="div[class='swiper-slide swiper-slide-visible swiper-slide-active'] a")
    WebElement bannerLink;

    public OffciaHomePage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,xiaoYun);
    }
    //中小学校长
    public HeadMasterPage clickToHeadmasterPage() throws Exception {
        return click(headMasterBtn,HeadMasterPage.class);
    }
    //老师
    public TeacherPage clickToTeacherPage() throws Exception {
        return click(teacherBtn,TeacherPage.class);
    }
    //教育部门领导
    public EducationDepartmentPage clickToEducationDepartmentPage() throws Exception {
        return click(educationDepartmentBtn,EducationDepartmentPage.class);
    }
    //学生
    public StudentPage clickToStudentPage() throws Exception {
        return click(studentBtn,StudentPage.class);
    }
    //jiazhang
    public ParentPage clickToParentPage() throws Exception {
        return click(parentBtn,ParentPage.class);
    }
    //培训机构校长
    public TrainingInstitutionPage clickToTrainingInstitutionPage() throws Exception {
        return click(trainingInstitutionBtn,TrainingInstitutionPage.class);
    }
    //合作伙伴
    public PartnerPage clickToPartnerPage() throws Exception {
        return click(partnerBtn,PartnerPage.class);
    }
    //公司简介
    public CompanyProfilePage clickToCompanyProfilePage () throws Exception {
        clickAndSwitchWindow(companyProfile);
        return new CompanyProfilePage(driver);
    }
    //产品介绍
    public ProductIntroductionPage clickToProductIntroductionPage() throws Exception {
        clickAndSwitchWindow(productIntroductionBtn);
        return new ProductIntroductionPage(driver);
    }
    //商城首页
    public OkayMallPage clickToOkayMallPage(){
        clickAndSwitchWindow(OkayMallBtn);
        return new OkayMallPage(driver);
    }
    //进入下载专区的
    public AppDowloadPage clickToAppDowloadPage(){
        clickAndSwitchWindow(downloadApp);
        return new AppDowloadPage(driver);
    }
    //滑动到微信模块
    public void mouseHoverWechat(){
        slidingPageToElement(driver,wechatIcon);
        moveToElement(driver,wechatIcon);
        pageWait(3000);
        log.info("微信图标显示的效果是："+wechatCode.isDisplayed());
        assert wechatCode.isDisplayed();
    }
    //鼠标悬停网站地图时，出现一级角色选择框
    public void mouseWebMap(){
        slidingPageToElement(driver,webMapBtn);
        moveToElement(driver,webMapBtn);
        log.info("网站地图一级地图的显示效果是："+firstLevelMap.isDisplayed());
        assert firstLevelMap.isDisplayed();
    }
    //点击OKAY动态，进入OKAY智慧教育高峰论坛的三级页
    public ThirdPage clickToOkayEeuPage(){
        clickAndSwitchWindow(OKAYDynamicBtn);
        return new ThirdPage(driver);
    }

    //点击最新资讯中的第一条文章，进入文章详情页
    public NewestNewDetailedPage clickToNewestNewDFourthPage(){
        clickAndSwitchWindow(newestNews);
        return new NewestNewDetailedPage(driver);
    }

    //点击当前的banner轮播图，进入对应的四级文章详情页
    public FourthPage clickBannerToFourthPage(){
        clickAndSwitchWindow(bannerLink);
        return new FourthPage(driver);
    }
}
