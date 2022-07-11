package com.telrun.contacts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getHeader().isLoginLinkPresent()) {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }
}
