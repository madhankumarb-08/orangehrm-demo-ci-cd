package org.pageobjectmodel;
import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PimPage extends AbstractComponents
{
    WebDriver driver;
    public PimPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

 //  driver.findElement(By.xpath("//button[contains(@class,'oxd-button--secondary')]")).click();

    @FindBy(xpath = "//button[contains(@class,'oxd-button--secondary')]")
    WebElement save;



    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement emp_password;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement emp_con_passowrd;

    @FindBy(xpath = "(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")
    WebElement loginAccess;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    WebElement emp_username;

    @FindBy(xpath = "//div[@class='oxd-form-row user-form-header']//following::div[@class='oxd-switch-wrapper'][1]")
    WebElement createEntry;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstname;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middlename;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastname;

    @FindBy(xpath = "//label[.='Employee Id']/following::input[1]")
    WebElement EmployeeId;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement getEmployeeIdSearch;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement searchButton;

    @FindBy(xpath = "//h6[.='Personal Details']")
    WebElement text_personalDetails;

    @FindBy(xpath = "(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")
    WebElement male_gender;
    @FindBy(xpath = "(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]")
    WebElement female_gender;

    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
    WebElement saveEditDetails1;

    private final By dob = By.xpath("//label[.='Date of Birth']/../following-sibling::div//input");


    private final By marital_status_options = By.xpath("//div[@role='listbox']//span");
    private final By marital_status_dropdown = By.xpath("//label[text()='Marital Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");

    private final By nationalityDropdown = By.xpath("//label[text()='Nationality']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");

    private final By nationallityOptions = By.xpath("//div[@role='listbox']//span");

    private final By editButton= By.xpath("//div[@class='oxd-table-body']//button[contains(@class,'oxd-icon-button')]");

    private final By deleteButton= By.xpath("(//div[@class='oxd-table-body']//button[contains(@class,'oxd-icon-button')])[2]");

    private final By yesDelete = By.xpath("//div[@class='oxd-dialog-container-default--inner']//button[contains(@class,'oxd-button--label-danger')]");

    private final By addBtn = By.cssSelector("button[class$='oxd-button--secondary']");

    private final By scsmsg = By.xpath("//p[contains(@class,'oxd-text--toast-message')]");

    public void addEmployeeBtn()
    {
        waitForElementBY(addBtn);
        driver.findElement(addBtn).click();
    }
    public void entername(String f_name,String m_name,String l_name,String e_id)
    {
        firstname.sendKeys(f_name);
        middlename.sendKeys(m_name);
        lastname.sendKeys(l_name);
        EmployeeId.sendKeys(Keys.CONTROL+"a");
        EmployeeId.sendKeys(Keys.DELETE);
        EmployeeId.sendKeys(e_id);
        createEntry.click();
    }

    public void enterEmpUsername(String name)
    {
        emp_username.sendKeys(name);
    }

    public WebElement getLoginAccess()
    {
        return loginAccess;
    }

    public void enterEmpPassword(String pass,String Cpass)
    {
        emp_password.sendKeys(pass);
        emp_con_passowrd.sendKeys(Cpass);
    }
    public WebElement successMsgEditDetails()
    {
        presenceofWaitBY(scsmsg);
        return driver.findElement(scsmsg);
    }
    public WebElement getSuccessStatus() throws InterruptedException
    {
        save.click();
        presenceofWaitBY(scsmsg);
        return driver.findElement(scsmsg);
    }

    public void setGetEmployeeIdSearch(String id)
    {
        getEmployeeIdSearch.sendKeys(id);
    }
    public void setSearchButton()
    {
        searchButton.click();
    }

    public void clickEditButton()
    {
        waitForElementtoBeClickable(editButton);
    }

    public String verifycurrentpage()
    {
        waitForWebElement(text_personalDetails);
        return text_personalDetails.getText();
    }

    public void fillEditDetailsofEmployee(String nationality,String gender,String marital,String birth)
    {
        setNationality(nationality);
        setgender(gender);
        setMarital_status(marital);
        setDob(birth);
    }
    public void setNationality(String nationality)
    {
        driver.findElement(nationalityDropdown).click();
        waitForElementBY(nationallityOptions);
        List<WebElement> list = driver.findElements(nationallityOptions);
        for(WebElement li : list)
        {
            if(li.getText().equalsIgnoreCase(nationality))
            {
                li.click();
                break;
            }
        }
    }
    public void setgender(String gender)
    {
        if(gender.equalsIgnoreCase("male"))
        {
            moveMouse(male_gender);
            male_gender.click();
        }
        else
        {
            moveMouse(female_gender);
            female_gender.click();
        }
    }

    public void setMarital_status(String status)
    {
        driver.findElement(marital_status_dropdown).click();
        waitForElementBY(marital_status_options);
        List<WebElement> list1 = driver.findElements(marital_status_options);
        for(WebElement li : list1)
        {
            if(li.getText().equalsIgnoreCase(status))
            {
                li.click();
                break;
            }
        }
    }
    public void setDob(String birth)
    {
        WebElement dobField = driver.findElement(dob);
        dobField.click();
        dobField.sendKeys(Keys.CONTROL+"a");
        dobField.sendKeys(Keys.DELETE);
        dobField.sendKeys(birth);
    }
    public void setSaveEditDetails1()
    {
        saveEditDetails1.click();
    }
    public void setDeleteButton()
    {
        waitForElementtoBeClickable(deleteButton);
        waitForElementtoBeClickable(yesDelete);
    }
}
