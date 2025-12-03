package org.pageobjectmodel;
import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    By addBtn = By.cssSelector("button[class$='oxd-button--secondary']");

    By scsmsg = By.xpath("//p[contains(@class,'oxd-text--toast-message')]");

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
    public WebElement getSuccessStatus()
    {
        save.click();
        presenceofWaitBY(scsmsg);
        return driver.findElement(scsmsg);
    }

}
