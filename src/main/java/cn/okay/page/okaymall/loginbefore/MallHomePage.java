package cn.okay.page.okaymall.loginbefore;

import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.okaymall.partsmoudle.PartsClassificationPage;
import cn.okay.page.okaymall.shopmoudle.MyOrderPage;
import cn.okay.page.okaymall.shopmoudle.ShopCarPage;
import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by yutz on 2018/2/28.
 */
public class MallHomePage extends AbstractPage {

    @FindBy(css=".index-argument")
    WebElement recommendMoudle;

    @FindBy(linkText = "首页")
    WebElement homePageLink;

    @FindBy(linkText = "OKAY智能终端")
    WebElement OKAYIntelligentTerminalLink;

    @FindBy(linkText = "配件")
    WebElement partsLink;

    @FindBy(linkText = "官网")
    WebElement offciaLink;

    WebElement firstImgBanner=driver.findElements(By.cssSelector(".only a")).get(0);

    @FindBy(css = ".clearfix a[href='/index.php?m=OkayMall&c=index&a=downapp']")
    WebElement dowloadAppMoudle;

    @FindBy(css = ".clearfix a[href='/index.php?m=OkayMall&c=index&a=intelligence']")
    WebElement artificialIntelligenceMoudle;

    @FindBy(css = ".clearfix a[href='/index.php?m=OkayMall&c=index&a=coach']")
    WebElement distanceTeachingMoudle;

    @FindBy(css = ".clearfix a[href='/index.php?m=OkayMall&c=Goods&a=accessoriescate']")
    WebElement partsMoudle;

    @FindBy(css = ".clearfix a[href='/index.php?m=OkayMall&c=Goods&a=getMainOkaypad&goodId=207']")
    WebElement terminalStudentBtn;

    @FindBy(css = ".clearfix a[href='/index.php?m=OkayMall&c=Goods&a=getMainOkaypad&goodId=130']")
    WebElement terminalTeacherBtn;

    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Orders&a=okayMallOrders']")
    WebElement myOrder;

    @FindBy(css=".user-icon")
    WebElement userBtn;

    @FindBy(css = ".cartsicon")
    WebElement shopCarBtn;

    public MallHomePage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,recommendMoudle);
    }

    public MallHomePage clickHomePageLink() throws Exception {
        return click(homePageLink,MallHomePage.class);
    }

    public PartsClassificationPage clickPartsLink() throws Exception {
        return click(partsLink,PartsClassificationPage.class);
    }

    public OffciaHomePage clickOfficaLink() throws Exception {
        clickAndSwitchWindow(offciaLink);
        return new OffciaHomePage(driver);
    }

    public AppDowloadPage clickDowloadMoudle() throws Exception {
        return click(dowloadAppMoudle,AppDowloadPage.class);
    }

    public ArtificialIntelligencePage clickIntelligentTerminalMoudle() throws Exception {
        return click(artificialIntelligenceMoudle,ArtificialIntelligencePage.class);
    }

    public DistanceTeachingPage clickDistanceTeachingMoudle() throws Exception {
        return click(distanceTeachingMoudle,DistanceTeachingPage.class);
    }

    public PartsClassificationPage clickPartsMoudle() throws Exception {
        return click(partsMoudle,PartsClassificationPage.class);
    }

    public TerminalStudentPage clickImg() throws Exception {
        clickAndSwitchWindow(firstImgBanner);
        return new TerminalStudentPage(driver);
    }

    public TerminalStudentPage clickStudentTerminal() throws Exception {
        moveToElement(driver,OKAYIntelligentTerminalLink);
        log.info("智能终端S4.0的显示效果是:"+terminalStudentBtn.isDisplayed());
        Assert.assertTrue(terminalStudentBtn.isDisplayed());
        return click(terminalStudentBtn,TerminalStudentPage.class);
    }

    public TerminalTeacherPage clickTeacherTerminal() throws Exception {
        moveToElement(driver,OKAYIntelligentTerminalLink);
        log.info("智能终端T1.0的显示效果是:"+terminalTeacherBtn.isDisplayed());
        Assert.assertTrue(terminalTeacherBtn.isDisplayed());
        return click(terminalTeacherBtn,TerminalTeacherPage.class);
    }

    public ShopCarPage homePageToShopPage() throws Exception {
        return click(shopCarBtn,ShopCarPage.class);
    }

    public MyOrderPage homePageToMyOrderPage() throws Exception {
        moveToElement(driver,userBtn);
        return click(myOrder,MyOrderPage.class);
    }
}
