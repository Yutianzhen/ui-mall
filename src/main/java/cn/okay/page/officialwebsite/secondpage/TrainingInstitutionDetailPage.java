package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/2/5.
 */
public class TrainingInstitutionDetailPage extends AbstractPage {

    @FindBy(css="div[class='desc clearfix auto-h']")
    WebElement aboutUsElement;

    @FindBy(xpath = "html/body/div[1]/div[4]/div/div/ul/li[2]/img")
    WebElement showSchoolImg;

    public TrainingInstitutionDetailPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,aboutUsElement);
    }

    public void clickSchoolImg(){
        moveToElement(driver,showSchoolImg);
        pageWait(2000);
        click(showSchoolImg);
        pageWait(3000);
    }
}
