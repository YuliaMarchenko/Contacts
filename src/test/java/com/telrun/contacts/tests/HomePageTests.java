package com.telrun.contacts.tests;

import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    @Test
    public void testOpenHomePage() {
        app.getContact().isComponentFormPresent();
    }
}
