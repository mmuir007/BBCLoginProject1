package org.muir.bbc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.testng.Assert;

/**
 * This page object parses the BBC Home Page.
 */
public class HomePage extends BasePage {

    private static final By IDCTA_LINK_LOCATOR = By.id( "idcta-link" );

    public HomePage( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "HOME PAGE IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> elements = driver.findElements( IDCTA_LINK_LOCATOR );
        return !elements.isEmpty();
    }

    public SignInPage1 clickIDCTALink() {
        WebElement idctaLinkElement = driver.findElement( IDCTA_LINK_LOCATOR );
        idctaLinkElement.click();
        return new SignInPage1( driver );
    }
}
