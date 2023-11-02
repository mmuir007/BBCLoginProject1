package org.muir.bbc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * This page object parses the second Sign In page, i.e.,
 * the one that accepts the user's password.
 */
public class SignInPage2 extends BasePage {

    private static final By passwordLocator = By.id( "password-input" );

    private static final By submitLocator = By.id( "submit-button" );

    public SignInPage2( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "SignInPage2 IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> userIdElements = driver.findElements( passwordLocator );
        List<WebElement> submitElements = driver.findElements( submitLocator );
        return !userIdElements.isEmpty() && !submitElements.isEmpty();
    }

    public SignInPage2 setPassword( String password ) {
        WebElement userIdElements = driver.findElement( passwordLocator );
        userIdElements.sendKeys( password );
        return this;
    }

    public LoggedInPage clickSubmitButton() {
        WebElement submitElement = driver.findElement( submitLocator );
        submitElement.click();
        return new LoggedInPage( driver );
    }
}
