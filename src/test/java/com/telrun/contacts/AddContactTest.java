package com.telrun.contacts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (isLoginLinkPresent()) {
            login();
        }
    }

    @Test
    public void addContactPositiveTest(){
        addContact();
        Assert.assertTrue(isContactCreated("Karl"));
    }

    @AfterMethod
    public void postCondition(){
        removeContact();
    }
}
