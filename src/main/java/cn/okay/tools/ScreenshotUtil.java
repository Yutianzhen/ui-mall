package cn.okay.tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yutz on 2018/4/8.
 */
public class ScreenshotUtil {

    private WebDriver driver;
    private final String PATH = System.getProperty("user.dir")+"\\test-output\\screenshotFile";
    private SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    private String date=df.format(new Date());
    private File fileName=new File(PATH+File.separator+date+".png");

    private ScreenshotUtil(WebDriver driver){
        this.driver=driver;
    }
    private ScreenshotUtil(){

    }

    public static synchronized ScreenshotUtil getScreenshotUtil(WebDriver driver){
        return  new ScreenshotUtil(driver);
    }
    public static synchronized ScreenshotUtil getScreenshotUtil(){
        return new ScreenshotUtil();
    }

    //Set screenshot
    public void setScreenshot(){

        File file=new File(PATH);
        if(!file.exists()||!file.isDirectory()){
            file.mkdir();
        }else {
            int i=1;
            while (fileName.exists()) {
                fileName = new File(PATH + File.separator + date +"_"+ i + ".png");
                i++;
            }
        }
        try {
            File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile,fileName);
        } catch (IOException e) {
            System.out.println("current page title"+driver.getTitle()+"，Can't save screenshot");
            e.printStackTrace();
        }

    }
    public String getFileName(){
        String fileNamePath=fileName.getPath();
        System.out.println("当前截图文件的路径是:"+fileNamePath);
        return fileNamePath;
    }

}
