package cn.okay.officialwebsitetest.secondpagetest;

import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.officialwebsite.secondpage.TrainingInstitutionDetailPage;
import cn.okay.page.officialwebsite.secondpage.TrainingInstitutionPage;
import cn.okay.testbase.MallAbstractTestCase;
import cn.okay.testbase.OffcialAbstracTestCase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static cn.okay.testbase.AbstracTestCase.driver;

/**
 * Created by yutz on 2018/2/2.
 */
public class TrainingInstitutionPageTest extends OffcialAbstracTestCase {

    @Test(testName = "TrainingInstitutionPage1",description = "机构页点击OKAY优势按钮",groups = "offcial")
    public void clickoOkayAdvantageBtn() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        TrainingInstitutionPage trainingInstitutionPage= offciaHomePage.clickToTrainingInstitutionPage();
        WebElement element=trainingInstitutionPage.clickokayAdvantage();
    }

    @Test(testName = "TrainingInstitutionPage2",description = "机构页点击合作机构按钮",groups = "offcial")
    public void clickTrainingInstitutionBtn() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        TrainingInstitutionPage trainingInstitutionPage= offciaHomePage.clickToTrainingInstitutionPage();
        WebElement expectElement=trainingInstitutionPage.clickPartner();
    }

    @Test(testName = "TrainingInstitutionPage3",description = "鼠标悬停在OKAY优势模块的第一个模块上",groups = "offcial")
    public void mouseHoverAdvantage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        TrainingInstitutionPage trainingInstitutionPage= offciaHomePage.clickToTrainingInstitutionPage();
        trainingInstitutionPage.hoverFirstAdvantage();
    }

    @Test(testName = "TrainingInstitutionPage4",description = "鼠标悬停在朗文教育上并进入对应详情页",groups = "offcial")
    public void clickToTrainingInstitutionDetailPage() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        TrainingInstitutionPage tip= offciaHomePage.clickToTrainingInstitutionPage();
        TrainingInstitutionDetailPage tidp=tip.clickToTrainingInstitutionDetailPage();
    }

    @Test(testName = "TrainingInstitutionPage5",description = "详情页点击学校的机构展示图片",groups = "offcial")
    public void clickShowImg() throws Exception {
        OffciaHomePage offciaHomePage =new OffciaHomePage(driver);
        TrainingInstitutionPage tip= offciaHomePage.clickToTrainingInstitutionPage();
        TrainingInstitutionDetailPage tidp=tip.clickToTrainingInstitutionDetailPage();
        tidp.clickSchoolImg();
    }

}
