package com.telrun.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else {
            login();
            addContact();
        }
    }

    @Test
    public void removeContactTest() {
        pause(2000);
        int sizeBefore = sizeOfContacts();
        removeContact();
        pause(2000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}
