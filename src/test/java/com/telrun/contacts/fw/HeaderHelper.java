package com.telrun.contacts.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isHomePresent() {
        return isElementPresent(By.xpath("//a[contains(.,'HOME')]"));
    }

    public boolean isAboutPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'ABOUT')]"));
    }

    public boolean isContactPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'CONTACT')]"));
    }

    public boolean isAddPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'ADD')]"));
    }

}
