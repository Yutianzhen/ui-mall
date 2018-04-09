package cn.okay.page.officialwebsite.thirdpage;

import cn.okay.page.officialwebsite.fourthpage.FourthPage;
import cn.okay.page.officialwebsite.secondpage.ParentPage;
import cn.okay.testbase.AbstractPage;
import cn.okay.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yutz on 2018/4/9.
 */
public class ParentThirdPage extends AbstractPage {

    @FindBy(css="#nav")
    WebElement barBtn;

    @FindBy(css = "a[href='/parent/index.html']")
    WebElement parentBtn;

    @FindBy(css=".full-pic a")
    WebElement  bannerImg;

    @FindBy(css = "li[class='rect fl '] a")
    WebElement recommendThemeMoudle;

    //文章列表里的第一个文章
    WebElement articleList=driver.findElements(By.cssSelector(".pic-list li a")).get(0);

    public ParentThirdPage(WebDriver driver) {
        super(driver);
        WaitTool.waitFor(driver,WaitTool.DEFAULT_WAIT_4_ELEMENT,barBtn);
    }

    public ParentPage clickBarParentBtn() throws Exception {
        return click(parentBtn,ParentPage.class);
    }

    public FourthPage clickBannerImgToFourthPage(){
        clickAndSwitchWindow(bannerImg);
        return new FourthPage(driver);
    }

    public ParentThirdPage clickOtherRecommendThemeMoudle() throws Exception {
        return click(recommendThemeMoudle,ParentThirdPage.class);
    }

    //点击文章列表里第一篇文章,鼠标悬停文章出现
    public FourthPage clickArticleListFirst(){
        moveToElement(driver,articleList);
        clickAndSwitchWindow(articleList);
        return new FourthPage(driver);
    }
}

