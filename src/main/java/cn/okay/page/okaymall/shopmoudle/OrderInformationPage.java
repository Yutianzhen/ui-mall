package cn.okay.page.okaymall.shopmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by yutz on 2018/3/14.
 */
public class OrderInformationPage extends AbstractPage {

    List<WebElement> addressList=driver.findElements(By.cssSelector(".adress-list li"));

    @FindBy(linkText = "提交订单")
    WebElement sublimitBtn;

    WebElement deleteSecondAddress=driver.findElements(By.cssSelector(".func .dele")).get(1);
    WebElement secondAddress=driver.findElements(By.cssSelector(".info")).get(1);

    @FindBy(css = "a[class='dl-confirm btn fis-btn']")
    WebElement deleteSureBtn;

    @FindBy(css = ".add-address-btn")
    WebElement addAddress;

    @FindBy(css = "div[class='fo-check select']")
    WebElement selectdDefaultAddress;

    @FindBy(css = "a[class='btn fis-btn save']")
    WebElement saveAddress;

    @FindBy(css = "textarea[class='okay-textarea remarks']")
    WebElement remarksText;

    //省
    @FindBy(css = ".okay-select[data-index='1']")
    WebElement selectProvince;

    @FindBy(css = "li[data-value='340000']")
    WebElement province;

    //市
    @FindBy(css = ".okay-select[data-index='2']")
    WebElement selectCity;

    @FindBy(css = "li[data-value='340500']")
    WebElement city;

    //区域
    @FindBy(css = ".okay-select[data-index='3']")
    WebElement selectArea;

    @FindBy(css = "li[data-value='340503']")
    WebElement area;

    @FindBy(css = "input[class='okay-input user-address']")
    WebElement inputAddress;

    @FindBy(css = "input[class='okay-input user-name']")
    WebElement inputUserName;

    @FindBy(css = "input[class='okay-input user-phone']")
    WebElement inputPhone;

    @FindBy(css="div[class='fo-check select']")
    WebElement selectDefaultAddress;

    @FindBy(css = "input[class='okay-input user-email']")
    WebElement inputEmail;

    @FindBy(css = "a[class='btn fis-btn save']")
    WebElement savaAddress;

    @FindBy(css = ".okay-prompt span")
    WebElement modificationHints;

    public OrderInformationPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,sublimitBtn);
    }

    public void delteteAddress(){
        moveToElement(driver,secondAddress);
        click(deleteSecondAddress,deleteSureBtn);
        click(deleteSureBtn);
        Assert.assertEquals(modificationHints.getText(),"删除成功");
        pageWait(2000);
    }

    public void addAddress(){
        click(addAddress,selectProvince);
        click(selectProvince,province);
        click(province,selectCity);
        click(selectCity,city);
        click(city,selectArea);
        click(selectArea,area);
        click(area,inputAddress);
        sendkeysInput(inputAddress,"这是自动化测试自动添加的详细地址");
        sendkeysInput(inputUserName,"自动化名");
        sendkeysInput(inputPhone,"18945347894");
        sendkeysInput(inputEmail,"ceshidizhi@163.com");
        click(selectDefaultAddress,savaAddress);
        click(savaAddress);
        Assert.assertEquals(modificationHints.getText(),"保存成功");
        pageWait(2000);
    }

    public PayPage clickToPayPage() throws Exception {
        sendkeysInput(remarksText,"这里是自动化测试做的备注信息，请注意查收");
        return click(sublimitBtn,PayPage.class);
    }

}
