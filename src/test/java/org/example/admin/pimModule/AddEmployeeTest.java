package org.example.admin.pimModule;
import org.openqa.selenium.WebElement;
import org.pageobjectmodel.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CredentialsReader;
import utilities.Reuseclass;
import utilities.TestdataTravel;
import utilities.random.Randomnumber;
public class AddEmployeeTest extends  Reuseclass
{
    String e_username;
    String e_password = "Maddy@123";
    PimPage pimPage;

    @Test
    public void adminCreatesEmployee() throws InterruptedException
    {
        loginAsAdmin(CredentialsReader.get("admin.username"), CredentialsReader.get("admin.password"));
        pimPage = landingPage.clickPim();
        pimPage.addEmployeeBtn();
        e_username = Randomnumber.getEmployeeId();
        String employeeId = Randomnumber.getEmployeeId();
        System.out.println("Employee id : "+employeeId);
        TestdataTravel.set("Employee_ID",employeeId);
        String f_name = "Madhan";
        String m_name = "Kumar";
        String l_name = "B";
        pimPage.entername(f_name, m_name,l_name, employeeId);

        pimPage.enterEmpUsername(e_username);
        Assert.assertTrue(
                pimPage.getLoginAccess().isDisplayed(),
                "Login access checkbox not enabled"
        );
        pimPage.enterEmpPassword(e_password, e_password);
        WebElement toster_message = pimPage.getSuccessStatus();
        Assert.assertEquals(toster_message.getText(), "Successfully Saved");
        landingPage.setLogout_btn();
        loginAsAdmin(e_username,e_password);
    }

    @Test(dependsOnMethods = "adminCreatesEmployee")
    public void checkTheCreatedEmployeeCanLogin() throws InterruptedException
    {
        loginAsEmployee(e_username,e_password);
        landingPage.setLogout_btn();
    }
}

