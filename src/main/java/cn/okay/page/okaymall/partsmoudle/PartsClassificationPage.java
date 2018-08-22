package cn.okay.page.okaymall.partsmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


/**
 * Created by yutz on 2018/2/28.
 * 配件类别页
 */
public class PartsClassificationPage extends AbstractPage {

    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=accessories&c1Id=336&c2Id=340']")
    WebElement stylusSeriesBtn;

    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=accessories&c1Id=336&c2Id=340']")
    WebElement handwritingPenLink;

    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=accessories&c1Id=336&c2Id=347']")
    WebElement chargerLink;

    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=accessories&c1Id=336&c2Id=339']")
    WebElement headsetLink;

    //笔芯
    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=accessories&c1Id=336&c2Id=348']")
    WebElement refillLink;

    //保护套
    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=accessories&c1Id=336&c2Id=346']")
    WebElement smartCoverLink;

    //维修包
    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=accessories&c1Id=336&c2Id=345']")
    WebElement repairLink;

    @FindBy(css = ".okay-footer")
    WebElement fotterDiv;

    @FindBy(css="a[class='function-goTop show']")
    WebElement toTopBtn;

    public PartsClassificationPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,stylusSeriesBtn);
    }

    public HandwritingPenPage clickToHandwritingPenPage() throws Exception {
        return click(handwritingPenLink,HandwritingPenPage.class);
    }

    public ChargerPage clickToChargerPage() throws Exception {
        return click(chargerLink,ChargerPage.class);
    }

    public HeadsetPage clickToHeadsetPage() throws Exception {
        return click(headsetLink,HeadsetPage.class);
    }

    public RefillPage clickToRefillPage() throws Exception {
        return click(refillLink,RefillPage.class);
    }

    public RepairPage clickToRepairPage() throws Exception {
        return click(repairLink,RepairPage.class);
    }

    public SmartCoverPage clickToSmartCoverPage() throws Exception {
        return click(smartCoverLink,SmartCoverPage.class);
    }

    public void clickToTopBtn(){
        slidingPageToElement(driver,fotterDiv);
        pageWait(2000);
        Assert.assertEquals(toTopBtn.isDisplayed(),true);
        click(toTopBtn);
        pageWait(2000);
    }

}
