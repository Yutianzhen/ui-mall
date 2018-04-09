package cn.okay.page.officialwebsite.fourthpage;

import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by yutz on 2018/4/9.
 */
public class FourthPage extends AbstractPage {

    @FindBy(css = "#recommend")
    WebElement recommendMoudle;

    @FindBy(css="#recommend a")
    WebElement firstRecommendMoudle;

    WebElement barFirstPage=driver.findElements(By.cssSelector("#nav a")).get(0);

    @FindBy(css="#to-top")
    WebElement toTopBtn;

    @FindBy(css="#socialmedia")
    WebElement pageBottomDiv;

    public FourthPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,recommendMoudle);
    }

    public FourthPage clickFirstRecommendMoudle() throws Exception {
        moveToElement(driver,firstRecommendMoudle);
        return click(recommendMoudle,FourthPage.class);
    }
    public OffciaHomePage clickFirstBarBtnToHomePage() throws Exception {
        return click(barFirstPage,OffciaHomePage.class);
    }

    public void clickToPageTop(){
        slidingPageToElement(driver,pageBottomDiv);
        pageWait(2000);
        click(toTopBtn);
        pageWait(2000);
        Assert.assertFalse(toTopBtn.isDisplayed(),"回到顶部按钮没有被隐藏");
        log.info("回到顶部按钮现在的显示状态为："+toTopBtn.isDisplayed());
    }

}
