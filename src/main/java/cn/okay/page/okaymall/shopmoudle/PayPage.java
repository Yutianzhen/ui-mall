package cn.okay.page.okaymall.shopmoudle;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by yutz on 2018/3/19.
 */
public class PayPage extends AbstractPage {

    @FindBy(css = ".payment")
    WebElement pay;

    @FindBy(css = "li[data-paymethod='Bank']")
    WebElement bankPay;

    @FindBy(css = ".dialog-context")
    WebElement selectBank;

    @FindBy(css = "li[data-paymethod='Weixin']")
    WebElement wechatPay;

    @FindBy(css = "a[class='dl-confirm btn fis-btn']")
    WebElement surePay;

    @FindBy(css = "li[data-paymethod='Alipay']")
    WebElement alipayPay;

    @FindBy(css = ".bk")
    WebElement bankRemittance;

    public PayPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,pay);
    }

    public WebElement selectBank(){
        return click(bankPay,selectBank);
    }

    public PayWaitPage selectWeiXin() throws Exception {
         click(wechatPay,surePay);
         return click(surePay,PayWaitPage.class);
    }

    public AlipaySurePage selectAlipay() throws Exception {
        return click(alipayPay,AlipaySurePage.class);
    }

    public PayWaitPage selectBankRemittance() throws Exception {
        return click(bankRemittance,PayWaitPage.class);
    }

}
