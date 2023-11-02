package org.muir.bbc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SignedOutPage extends BasePage {

    private static final By CONTINUE_LOCATOR = By.xpath( "//a[text()='Continue']" );

    public SignedOutPage( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "SIGNED OUT PAGE IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> elements = driver.findElements( CONTINUE_LOCATOR );
        return !elements.isEmpty();
    }

    public HomePage clickContinueButton() {
        WebElement continueElement = driver.findElement( CONTINUE_LOCATOR );
        continueElement.click();
        return new HomePage( driver );
    }
}
