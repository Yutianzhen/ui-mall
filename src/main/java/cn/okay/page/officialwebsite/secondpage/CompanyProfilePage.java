package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2017/10/17.
 * 公司简介页
 */
public class CompanyProfilePage extends AbstractPage {

    @FindBy(id="nav")
    public WebElement pageContent;

    public CompanyProfilePage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,DefaultWaitElementTime4Page,pageContent);
    }
}
