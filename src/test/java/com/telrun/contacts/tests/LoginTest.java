package com.telrun.contacts.tests;

import com.telrun.contacts.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test
    public void loginUserPositiveTest() {
        app.getUser().login();
        Assert.assertTrue(app.getHeader().isSignOutPresent());
    }

    @Test
    public void loginUserNegativeTest(){
        app.getUser().clickLoginHeader();
        app.getUser().fillLoginRegistrationForm(new User().setEmail("test102@test.com").setPassword(" "));
        app.getUser().clickLogin();
        Assert.assertTrue(app.getUser().isAlertPresent());
        Assert.assertTrue(app.getUser().isErrorPresent());
    }
}
