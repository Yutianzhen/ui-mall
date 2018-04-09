package cn.okay.page.okaymall.shopmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by yutz on 2018/3/12.
 */
public class ShopCarPage extends AbstractPage {

    @FindBy(css = ".cart-box")
    WebElement shopCarDiv;

    //结算按钮
    @FindBy(css = ".go-statement")
    WebElement statementBtn;

    WebElement deleteBtn=driver.findElements(By.cssSelector(".item-close")).get(0);

    WebElement fristCount=driver.findElements(By.cssSelector("input[class='okay-count']")).get(0);

    //删除弹框的确定按钮
    @FindBy(css = "a[class='dl-confirm btn fis-btn']")
    WebElement determineBtn;

    public ShopCarPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,shopCarDiv);
    }

    public void deleteFirstCommodity(){
        click(deleteBtn,determineBtn);
        click(determineBtn,shopCarDiv);
    }

    public OrderInformationPage goOrderInformationPage() throws Exception {
        return click(statementBtn, OrderInformationPage.class);
    }

    public void inputFirstCount(){
        sendkeysInput(fristCount,"2");
        Assert.assertEquals(fristCount.getAttribute("value"),"2");
    }

}
