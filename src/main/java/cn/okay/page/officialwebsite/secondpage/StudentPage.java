package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/2/1.
 * 学生的二级页面
 */
public class StudentPage extends AbstractPage {

    @FindBy (css="#talkbox")
    WebElement xiaoYun;

    public StudentPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,xiaoYun);
        pageWait(4000);
    }
}
