package org.muir.bbc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * This page object will parse the Home Page when the user is logged in.
 * When the user is logged in, the first character of the email address
 * is displayed (capitalized).
 */
public class LoggedInPage extends BasePage {

    private static final By IDCTA_LINK_LOCATOR = By.id( "idcta-link" );

    public LoggedInPage( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "LOGGED IN PAGE IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> elements = driver.findElements( IDCTA_LINK_LOCATOR );
        return !elements.isEmpty();
    }

    public boolean idctaLinkHasInitial( String expectedInitial ) {
        WebElement idctaLinkElement = driver.findElement( IDCTA_LINK_LOCATOR );
        var actualInitial = idctaLinkElement.getAttribute("userinitial" );
        return expectedInitial.equals( actualInitial );
    }

    public YourAccountPage clickIDCTALink() {
        WebElement idctaLinkElement = driver.findElement( IDCTA_LINK_LOCATOR );
        idctaLinkElement.click();
        return new YourAccountPage( driver );
    }
}
