package org.example.admin.pim;
import org.openqa.selenium.WebElement;
import org.pageobjectmodel.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CredentialsReader;
import utilities.Reuseclass;
import utilities.TestdataTravel;

public class EditEmployeeTest extends Reuseclass
{
    public PimPage pimPage;

    String nationality = "Indian";
    String gender = "male";
    String marital = "Single";
    String birth = "2003-07-04";

    @Test
    public void editEmployeeusingAdmin() throws InterruptedException
    {
        loginAsAdmin(CredentialsReader.get("admin.username"), CredentialsReader.get("admin.password"));
        pimPage = landingPage.clickPim();
        pimPage.setGetEmployeeIdSearch(TestdataTravel.get("Employee_ID"));
        pimPage.setSearchButton();
        pimPage.clickEditButton();
        String verifypage = pimPage.verifycurrentpage();
        Assert.assertEquals(verifypage,"Personal Details");
        pimPage.fillEditDetailsofEmployee(nationality,gender,marital,birth);
        pimPage.setSaveEditDetails1();
        WebElement toster_message = pimPage.successMsgEditDetails();
        Assert.assertEquals(toster_message.getText(), "Successfully Updated");
    }
}
