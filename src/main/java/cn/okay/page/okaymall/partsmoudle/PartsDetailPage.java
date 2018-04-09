package cn.okay.page.okaymall.partsmoudle;

import cn.okay.page.okaymall.shopmoudle.ShopCarPage;
import cn.okay.testbase.AbstractPage;
import cn.okay.tools.ConfigUtil;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


/**
 * Created by yutz on 2018/3/8.
 */
public class PartsDetailPage extends AbstractPage {

    @FindBy(css = ".top")
    WebElement detailDiv;

    @FindBy(css = "a[href='/index.php?m=OkayMall&c=Goods&a=accessories&c1Id=336&c2Id=339']")
    WebElement clickBarToPartsHeadset;

    @FindBy(css = ".prompt .okay-a")
    WebElement seeMoudleAlert;

    @FindBy(css = ".dialog-context .selectgoodsmodel")
    WebElement partsMoudleAlert;

    @FindBy(css = ".okay-count")
    WebElement inputCount;

    @FindBy(css = ".okay-add")
    WebElement addBtn;

    //当数量超过1使减少按钮可点击时才会出现此定位元素
    @FindBy(css = ".okay-reduce")
    WebElement reduceBtn;

    @FindBy(css = "div[class='okay-reduce disreduce']")
    WebElement reduceBtnNoClick;

    @FindBy(css = "a[class='btn add']")
    WebElement addShopBtn;

    @FindBy(css="input[class='okay-input login-tel']")
    WebElement userNameInput;

    @FindBy(css="input[class='okay-input login-pas']")
    WebElement passwordInput;

    @FindBy(css=".login-btn .btn")
    WebElement submit;

    public PartsDetailPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,detailDiv);
    }

    public HeadsetPage clickBarToHeadsetPage() throws Exception {
        return click(clickBarToPartsHeadset,HeadsetPage.class);
    }

    public void clickToSeeMoudleAlert(){
        click(seeMoudleAlert,partsMoudleAlert);
        pageWait(2000);
        Assert.assertTrue(partsMoudleAlert.isDisplayed());
    }

    public void addCount(){
        click(addBtn,reduceBtn);
        Assert.assertEquals(inputCount.getAttribute("value").toString(),"2");
    }

    public void reduceCount(){
        inputCount.clear();
        inputCount.sendKeys("2");
        pageWait(1000);
        Assert.assertEquals(inputCount.getAttribute("value").toString(),"2");
        click(reduceBtn,reduceBtnNoClick);
        Assert.assertEquals(inputCount.getAttribute("value").toString(),"1");

    }
    public ShopCarPage clickJionShopCar() throws Exception {
        return click(addShopBtn,ShopCarPage.class);
    }

    public ShopCarPage loginAndJoinShopCar() throws Exception{
        String userName= ConfigUtil.getConfigUtil().getConfigFileContent("username");
        String password=ConfigUtil.getConfigUtil().getConfigFileContent("password");
        click(addShopBtn,userNameInput);
        sendkeysInput(userNameInput,userName);
        sendkeysInput(passwordInput,password);
        return click(submit,ShopCarPage.class);
    }
}
