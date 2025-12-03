package org.pageobjectmodel;
import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class LandingPage extends AbstractComponents
{
    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    By pim = By.xpath("//a[contains(@class,'oxd-main-menu-item')]/span[.='PIM']");

    public void clickPim()
    {
        waitForElementBY(pim);
        driver.findElement(pim).click();
    }

}
