package org.example;
import Testcomponents.BaseTest;
import Testcomponents.Rtry;
import org.openqa.selenium.WebElement;
import org.pageobjectmodel.LandingPage;
import org.pageobjectmodel.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.random.Randomnumber;
public class StandaloneTest extends BaseTest
{
    static String e_username ="maddy13";
    static String e_password = "maddy@123";

    @Test(retryAnalyzer = Rtry.class)
    public void login() throws InterruptedException
    {
        String username = "Admin";
        String passowrd = "admin123";
        loginPage.login(username,passowrd);
        LandingPage landingPage = loginPage.setClicklogin();
        PimPage pimPage = landingPage.clickPim();
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
