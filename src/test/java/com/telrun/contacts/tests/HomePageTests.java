package com.telrun.contacts.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    @Test
    public void testOpenHomePage() {
        app.getContact().isComponentFormPresent();
    }

    @Test
    public void checkHeaderWithoutLogin(){
        Assert.assertTrue(app.getHeader().isHomePresent());
        Assert.assertTrue(app.getHeader().isAboutPresent());
        Assert.assertTrue(app.getHeader().isLoginLinkPresent());
    }

    @Test
    public void checkHeaderWithLogin(){
        app.getUser().login();
        Assert.assertTrue(app.getHeader().isHomePresent());
        Assert.assertTrue(app.getHeader().isAboutPresent());
        Assert.assertTrue(app.getHeader().isContactPresent());
        Assert.assertTrue(app.getHeader().isAddPresent());
    }
}
