package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by yutz on 2018/2/1.
 * 培训机构的机构二级页
 */
public class TrainingInstitutionPage extends AbstractPage {

    @FindBy(css="#p-header")
    WebElement trainingInstitutionBar;

    @FindBy(css="#toAdvantage")
    WebElement okayAdvantageBtn;

    @FindBy(css="#toPartner")
    WebElement TrainingInstitutionBtn;

    @FindBy(css="#advantage")
    WebElement advantageDiv;

    @FindBy(css="#partner")
    WebElement partnerDiv;

    //OKAY优势未hover时的的第一个模块
    WebElement firstAdvantageElemen=driver.findElements(By.cssSelector("div[class='show']")).get(0);

    //OKAY优势的第一个模块hover状态后显示区域
    WebElement firstAdvantagesHover=driver.findElements(By.cssSelector(".h-show")).get(0);

    //合作机构里的第二个模块
    @FindBy(css="li img[src='/data/upload/portal/20171026/59f1ae9950507.png']")
    WebElement secondPartnerImg;

    //合作机构第二个模块的访问网站按钮
    @FindBy(css="a[href='/trains/info/2.html']")
    WebElement secondPartnerWebBtn;

    public TrainingInstitutionPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,trainingInstitutionBar);
    }

    public WebElement clickokayAdvantage(){
        return click(okayAdvantageBtn,advantageDiv);
    }

    public WebElement clickPartner(){
        return click(TrainingInstitutionBtn,partnerDiv);
    }

    public void hoverFirstAdvantage(){
        slidingPageToElement(driver,firstAdvantageElemen);
        moveToElement(driver,firstAdvantageElemen);
        log.info("OKAY优势模块第一个模块的hover状态是："+firstAdvantagesHover.isDisplayed());
        assert firstAdvantagesHover.isDisplayed();
    }

    public TrainingInstitutionDetailPage clickToTrainingInstitutionDetailPage(){
        moveToElement(driver,secondPartnerImg);
        assert secondPartnerWebBtn.isDisplayed();
        pageWait(2000);
        clickAndSwitchWindow(secondPartnerWebBtn);
        return new TrainingInstitutionDetailPage(driver);
    }

}
