package cn.okay.page.okaymall.partsmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


/**
 * Created by yutz on 2018/3/2.
 */
public class HeadsetPage extends AbstractPage {

    @FindBy(css = ".menu h2")
    WebElement headset;

    @FindBy(css = ".crumbs a[href='/index.php?m=OkayMall&c=Goods&a=accessoriescate&c1Id=336']")
    WebElement partsClassPageBtn;

    @FindBy(css = ".prompt .okay-a")
    WebElement seeMoudleLink;

    @FindBy(css = ".dialog-context .selectgoodsmodel")
    WebElement moudleAlert;

    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=getNewOkayGoodDetail&goodId=180&c1Id=336&c2Id=339']")
    WebElement partsListFirst;

    @FindBy(css = ".okay-dialog-section .okay-close")
    WebElement closeMoudleBtn;

    public HeadsetPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,headset);
    }

    public PartsClassificationPage clickBarPartsBtn() throws Exception {
        return click(partsClassPageBtn,PartsClassificationPage.class);
    }

    public void clickSeeMoudleBtn(){
        click(seeMoudleLink,moudleAlert);
        pageWait(2000);
        Assert.assertTrue(moudleAlert.isDisplayed(),"点击查看型号按钮后，没有出现查看型号弹窗");
    }

    public PartsDetailPage clickFirstParts() throws Exception {
        return click(partsListFirst,PartsDetailPage.class);
    }

    public void clickCloseMoudle(){
        click(seeMoudleLink,moudleAlert);
        pageWait(2000);
        click(closeMoudleBtn,partsListFirst);
        pageWait(1000);
    }
}
