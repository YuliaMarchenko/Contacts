package com.telrun.contacts.tests;

import com.telrun.contacts.models.User;
import com.telrun.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = true)
    public void testRegistrationPositive() throws InterruptedException {
        app.getUser().registration();
        Assert.assertTrue(app.getHeader().isSignOutPresent());
    }

    @Test(dataProvider = "registrationFromCsv", dataProviderClass = DataProviders.class)
    public void testRegistrationUserNegativeTest(User user) {
        app.getUser().click(By.xpath("//a[contains(.,'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(.,' Registration')]"));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
