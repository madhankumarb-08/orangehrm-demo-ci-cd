package org.example.admin.pim;

import org.openqa.selenium.WebElement;
import org.pageobjectmodel.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CredentialsReader;
import utilities.Reuseclass;
import utilities.TestdataTravel;

public class DeleteEmployee extends Reuseclass
{
    PimPage pimPage;

    @Test
    public void deleteEmployeeAdmin() throws InterruptedException
    {
        loginAsAdmin(CredentialsReader.get("admin.username"), CredentialsReader.get("admin.password"));
        pimPage = landingPage.clickPim();
        pimPage.setGetEmployeeIdSearch(TestdataTravel.get("Employee_ID"));
        pimPage.setSearchButton();
        pimPage.setDeleteButton();
        WebElement toster_message = pimPage.successMsgEditDetails();
        Assert.assertEquals(toster_message.getText(), "Successfully Deleted");

    }
}
