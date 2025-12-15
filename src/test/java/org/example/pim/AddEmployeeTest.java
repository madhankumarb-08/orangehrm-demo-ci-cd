package org.example.pim;
import Testcomponents.BaseTest;
import org.pageobjectmodel.LandingPage;
import org.pageobjectmodel.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.random.Randomnumber;
public class AddEmployeeTest extends BaseTest
{

    String e_username = "maddy113";
    String e_password = "Maddy@123";
    LandingPage landingPage;
    PimPage pimPage;

    @Test
    public void adminCreatesEmployee() throws InterruptedException
    {

        loginPage.login("Admin", "admin123");
        landingPage = loginPage.setClicklogin();

        pimPage = landingPage.clickPim();
        pimPage.addEmployeeBtn();

//        e_username = Randomnumber.getEmployeeId();
        String employeeId = Randomnumber.getEmployeeId();

        String f_name = "Maddy";
        String m_name = "Kumar";
        String l_name = "B";
        pimPage.entername(f_name, m_name,l_name, employeeId);
        pimPage.enterEmpUsername(e_username);

        Assert.assertTrue(
                pimPage.getLoginAccess().isDisplayed(),
                "Login access checkbox not enabled"
        );

        pimPage.enterEmpPassword(e_password, e_password);

        Assert.assertTrue(
                pimPage.getSuccessStatus().isDisplayed(),
                "Employee creation success message not shown"
        );

        landingPage.setLogout_btn();
    }

    @Test(dependsOnMethods = "adminCreatesEmployee")
    public void employeeCanLogin() throws InterruptedException
    {

        loginPage.login(e_username, e_password);
        landingPage = loginPage.setClicklogin();
        landingPage.setLogout_btn();
    }
}

