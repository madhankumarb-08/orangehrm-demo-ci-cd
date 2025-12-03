package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageobjectmodel.LandingPage;
import org.pageobjectmodel.LoginPage;
import org.pageobjectmodel.PimPage;
import org.testng.Assert;
import utilities.random.Randomnumber;
import java.time.Duration;
public class StandaloneTest
{
    static String e_username ="maddy12";
    static String e_password = "maddy@123";
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(driver);
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        loginPage.load_url(url);
        String username = "Admin";
        String passowrd = "admin123";
        loginPage.login(username,passowrd);
        loginPage.setClicklogin();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickPim();
        PimPage pimPage = new PimPage(driver);
        pimPage.addEmployeeBtn();
        String f_name ="Madhan";
        String m_name ="kumar";
        String l_name= "B";
        String employeeId = Randomnumber.getEmployeeId();
        pimPage.entername(f_name,m_name,l_name,employeeId);
        pimPage.enterEmpUsername(e_username);
        WebElement loginAccess =pimPage.getLoginAccess();
        Assert.assertTrue(loginAccess.isDisplayed(),"Enable is not enabled");
        pimPage.enterEmpPassword(e_password,e_password);
        WebElement successMsg = pimPage.getSuccessStatus();
        Assert.assertTrue(successMsg.isDisplayed(),"Success message NOT displayed!");
        pimPage.clickAccount();
    }
}
