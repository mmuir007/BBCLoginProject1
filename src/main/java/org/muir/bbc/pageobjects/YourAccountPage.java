package org.muir.bbc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * This Page Object class parses the Your Account page.
 */
public class YourAccountPage extends BasePage {

    private static final By SIGN_OUT_LOCATOR = By.xpath( "//span[text() = 'Sign out']" );

    public YourAccountPage( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "YOUR ACCOUNT PAGE IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> elements = driver.findElements( SIGN_OUT_LOCATOR );
        return !elements.isEmpty();
    }

    public void clickSignOut() {
        WebElement signOutElement = driver.findElement( SIGN_OUT_LOCATOR );
        signOutElement.click();
    }
}
