package cn.okay.page.okaymall.shopmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by yutz on 2018/3/30.
 */
public class MyOrderPage extends AbstractPage{

    @FindBy(css = ".member-sectitle")
    WebElement orderPage;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/div[5]/div/a[2]")
    WebElement firstOrderDetailLink;

    @FindBy(xpath = "html/body/div[3]/div[2]/div[1]/div/div[5]/div/div")
    WebElement firstOrderDetali;

    public MyOrderPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,orderPage);
    }

    public void MoveToDetaliLink(){
        moveToElement(driver,firstOrderDetailLink);
        pageWait(2000);
        Assert.assertEquals(firstOrderDetali.isDisplayed(),true);
    }

}
