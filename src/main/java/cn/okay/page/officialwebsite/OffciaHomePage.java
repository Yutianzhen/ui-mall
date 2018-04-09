package cn.okay.page.officialwebsite;

import cn.okay.page.officialwebsite.secondpage.*;
import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/4/9.
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

    //老师
    @FindBy(css="a[href='/teacher/index.html']")
    WebElement teacherBtn;

    //学生
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

    //公司简介
    @FindBy(css="a[href='https://www.okayzhihui.com/introduction.html']")
    WebElement companyProfile;

    //产品介绍
    @FindBy(css="a[href='https://www.okayzhihui.com/partner/125/183.html']")
    WebElement productIntroductionBtn;

    @FindBy(css="#mall_top")
    WebElement OkayMallBtn;

    @FindBy(css="i[class='icon wechat']")
    WebElement wechatIcon;

    @FindBy(css="i[class='icon code']")
    WebElement wechatCode;

    public OffciaHomePage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,xiaoYun);
    }

    public HeadMasterPage clickToHeadmasterPage() throws Exception {
        return click(headMasterBtn,HeadMasterPage.class);
    }

    public TeacherPage clickToTeacherPage() throws Exception {
        return click(teacherBtn,TeacherPage.class);
    }

    public EducationDepartmentPage clickToEducationDepartmentPage() throws Exception {
        return click(educationDepartmentBtn,EducationDepartmentPage.class);
    }

    public StudentPage clickToStudentPage() throws Exception {
        return click(studentBtn,StudentPage.class);
    }

    public ParentPage clickToParentPage() throws Exception {
        return click(parentBtn,ParentPage.class);
    }

    public TrainingInstitutionPage clickToTrainingInstitutionPage() throws Exception {
        return click(trainingInstitutionBtn,TrainingInstitutionPage.class);
    }

    public PartnerPage clickToPartnerPage() throws Exception {
        return click(partnerBtn,PartnerPage.class);
    }

    public CompanyProfilePage clickToCompanyProfilePage () throws Exception {
        clickAndSwitchWindow(companyProfile);
        return new CompanyProfilePage(driver);
    }

    public ProductIntroductionPage clickToProductIntroductionPage() throws Exception {
        return click(productIntroductionBtn,ProductIntroductionPage.class);
    }

    public OkayMallPage clickToOkayMallPage(){
        clickAndSwitchWindow(OkayMallBtn);
        return new OkayMallPage(driver);
    }
    public void mouseHoverWechat(){
        slidingPageToElement(driver,wechatIcon);
        moveToElement(driver,wechatIcon);
        pageWait(3000);
        log.info("微信图标显示的效果是："+wechatCode.isDisplayed());
        assert wechatCode.isDisplayed();
    }

}
