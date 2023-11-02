package org.muir.bbc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * This page object parses the first Sign In page, i.e.,
 * the one that accepts the user's email address.
 */
public class SignInPage1 extends BasePage {

    private static final By userIdLocator = By.id( "user-identifier-input" );

    private static final By submitLocator = By.id( "submit-button" );

    public SignInPage1( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "SignInPage1 IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> userIdElements = driver.findElements( userIdLocator );
        List<WebElement> submitElements = driver.findElements( submitLocator );
        return !userIdElements.isEmpty() && !submitElements.isEmpty();
    }

    public SignInPage1 setEmailAddress( String emailAddress ) {
        WebElement emailAddressElement = driver.findElement( userIdLocator );
        emailAddressElement.sendKeys( emailAddress );
        return this;
    }

    public SignInPage2 clickSubmitButton() {
        WebElement submitElement = driver.findElement( submitLocator );
        submitElement.click();
        return new SignInPage2( driver );
    }
}
