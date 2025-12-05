package Testcomponents;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshoot
{
    public String takeScreenshoot(String testcaseName,WebDriver driver) throws IOException
    {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/reports/screenshots/";
        File directory = new File(path);
        if(!directory.exists())
        {
            directory.mkdir();
        }
        String filename = testcaseName+"_"+System.currentTimeMillis()+".png";
        File finalpath = new File(path+filename);

        FileUtils.copyFile(src,finalpath);
        return "screenshots/" + filename;
    }
}
