package cn.okay.page.okaymall.shopmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by yutz on 2018/3/30.
 * 我的订单页面
 */
public class MyOrderPage extends AbstractPage{

    @FindBy(css = ".member-sectitle")
    WebElement orderPage;

    @FindBy(css = ".order-dethover")
    WebElement firstOrderDetailLink;

    @FindBy(css = ".fis span")
    WebElement firstOrderDetali;

    @FindBy(css = "a[class='btn fis-btn cancle cancleorder']")
    WebElement cancelOrderBtn;

    @FindBy(css = "a[class='dl-confirm btn fis-btn']")
    WebElement sureDeleteOrderBtn;

    @FindBy(css = ".okay-prompt span")
    WebElement deleteOrderSuccess;

    @FindBy(css = "a[class='btn fis-btn cancle']")
    WebElement electronicReceiptBtn;

    @FindBy(css = "a[class='btn fis-btn go']")
    WebElement goPayBtn;

    @FindBy(css = "a[class='payloading bkhover']")
    WebElement waitRemittanceLink;

    @FindBy(css = ".list-item .th-state .custom-context")
    WebElement remittanceShow;

    public MyOrderPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,orderPage);
    }

    public void moveToDetaliLink(){
        moveToElement(driver,firstOrderDetailLink);
        Assert.assertEquals(firstOrderDetali.isDisplayed(),true);
    }

    public void cancelOrder(){
        click(cancelOrderBtn,sureDeleteOrderBtn);
        click(sureDeleteOrderBtn);
        Assert.assertEquals(deleteOrderSuccess.getText(),"取消成功");
    }

    public ElectronicReceiptPage clickToElectronicReceiptPage() throws Exception {
        return click(electronicReceiptBtn,ElectronicReceiptPage.class);
    }

    public PayPage goPay() throws Exception {
        return click(goPayBtn,PayPage.class);
    }

}
