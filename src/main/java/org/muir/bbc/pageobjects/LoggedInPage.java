package org.muir.bbc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LoggedInPage extends BasePage {

    private static final By idctaLinkLocator = By.id( "idcta-link" );

    public LoggedInPage( WebDriver driver ) {
        this.driver = driver;
        Assert.assertTrue( isOpen(), "LOGGED IN PAGE IS NOT OPEN" );
    }

    @Override
    public boolean isOpen() {
        List<WebElement> elements = driver.findElements( idctaLinkLocator );
        return !elements.isEmpty();
    }

    public boolean idctaLinkHasInitial( String expectedInitial ) {
        WebElement idctaLinkElement = driver.findElement( idctaLinkLocator );
        var actualInitial = idctaLinkElement.getAttribute("userinitial" );
        return expectedInitial.equals( actualInitial );
    }
}
