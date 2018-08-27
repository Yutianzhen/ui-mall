package cn.okay.page.officialwebsite.fourthpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/8/24.
 * 首页点击最新资讯，进入的这个单独的四级页
 */
public class NewestNewDetailedPage extends AbstractPage {

    @FindBy(css=".title .clearfix")
    WebElement newInformationMoudle;

    public NewestNewDetailedPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,newInformationMoudle);
    }
}
