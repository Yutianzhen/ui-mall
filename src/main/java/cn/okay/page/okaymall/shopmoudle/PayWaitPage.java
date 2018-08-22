package cn.okay.page.okaymall.shopmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by yutz on 2018/3/30.
 * 支付订单页
 */
public class PayWaitPage extends AbstractPage {

    WebElement seeMyOrder=driver.findElements(By.cssSelector(".okay-a")).get(0);

    public PayWaitPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,seeMyOrder);
    }

    public MyOrderPage clickSeeMyOrder() throws Exception {
        return click(seeMyOrder,MyOrderPage.class);
    }

}
