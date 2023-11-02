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

    private static final By USER_ID_LOCATOR = By.id( "user-identifier-input" );

    private static final By SUBMIT_LOCATOR = By.id( "submit-button" );

    public SignInPage1( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "SignInPage1 IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> userIdElements = driver.findElements( USER_ID_LOCATOR );
        List<WebElement> submitElements = driver.findElements( SUBMIT_LOCATOR );
        return !userIdElements.isEmpty() && !submitElements.isEmpty();
    }

    public SignInPage1 setEmailAddress( String emailAddress ) {
        WebElement emailAddressElement = driver.findElement( USER_ID_LOCATOR );
        emailAddressElement.sendKeys( emailAddress );
        return this;
    }

    public SignInPage2 clickSubmitButton() {
        WebElement submitElement = driver.findElement( SUBMIT_LOCATOR );
        submitElement.click();
        return new SignInPage2( driver );
    }
}
