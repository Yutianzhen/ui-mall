package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by yutz on 2018/2/1.
 * 产品介绍的四级页
 */
public class ProductIntroductionPage extends AbstractPage {

    @FindBy (css="#nav")
    WebElement productIntroductionElement;

    public ProductIntroductionPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,productIntroductionElement);
    }
}
