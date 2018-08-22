package cn.okay.page.officialwebsite.secondpage;

import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by yutz on 2018/1/24.
 * 教师的二级页
 */
public class TeacherPage extends AbstractPage {

    @FindBy(id="talkbox")
    public WebElement xiaoYun;

    public TeacherPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,xiaoYun);
        pageWait(4000);
    }
}
