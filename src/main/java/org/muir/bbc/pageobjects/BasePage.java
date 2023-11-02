package org.muir.bbc.pageobjects;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    public abstract boolean isOpen();
}
