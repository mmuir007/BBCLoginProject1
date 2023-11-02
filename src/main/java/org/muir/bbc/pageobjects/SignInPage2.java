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

    private static final By PASSWORD_LOCATOR = By.id( "password-input" );

    private static final By SUBMIT_LOCATOR = By.id( "submit-button" );

    private static final By ERROR_LOCATOR =
            By.xpath( "//div[@id='form-message-general']/p/span/span" );

    public SignInPage2( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "SignInPage2 IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> userIdElements = driver.findElements( PASSWORD_LOCATOR );
        List<WebElement> submitElements = driver.findElements( SUBMIT_LOCATOR );
        return !userIdElements.isEmpty() && !submitElements.isEmpty();
    }

    public SignInPage2 setPassword( String password ) {
        WebElement userIdElements = driver.findElement( PASSWORD_LOCATOR );
        userIdElements.sendKeys( password );
        return this;
    }

    public void clickSubmitButton() {
        WebElement submitElement = driver.findElement( SUBMIT_LOCATOR );
        submitElement.click();
    }

    public boolean hasErrorMessage( String expectedErrorText ) {
        var errorElement = driver.findElement( ERROR_LOCATOR );
        var actualErrorText = errorElement.getText();
        return actualErrorText.contains( expectedErrorText );
    }
}
