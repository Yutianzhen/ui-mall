package cn.okay.page.officialwebsite.secondpage;

import cn.okay.page.officialwebsite.OffciaHomePage;
import cn.okay.page.officialwebsite.thirdpage.ThirdPage;
import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/2/1.
 * 家长的二级页
 */
public class ParentPage extends AbstractPage {

    @FindBy(css="#talkbox")
    WebElement parentElement;

    //家长页面的第一个关注模块
    @FindBy(css="a[href='70.html']")
    WebElement firstModular;

    @FindBy(linkText = "首页")
    WebElement toHomePageBtn;

    public ParentPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,parentElement);
        pageWait(4000);
    }

    public ThirdPage clickToThirdPage(){
        clickAndSwitchWindow(firstModular);
        return new ThirdPage(driver);
    }

    public OffciaHomePage clickToHomePage() throws Exception {
        return click(toHomePageBtn,OffciaHomePage.class);
    }

}
