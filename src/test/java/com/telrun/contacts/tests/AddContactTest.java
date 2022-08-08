package com.telrun.contacts.tests;

import com.telrun.contacts.models.Contact;
import com.telrun.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getHeader().isLoginLinkPresent()) {
            app.getUser().login();
        }
    }

   /* @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Ivan", "Sidorov", "232776568668", "testIvan@test.com", "Berlin", "description1"});
        list.add(new Object[]{"Sofia", "Sidorova", "45334433", "testSofia@test.com", "Dublin", "description2"});
        list.add(new Object[]{"Daria", "Petrova", "232776568668", "testDaria@test.com", "Paris", "description3"});
        list.add(new Object[]{"Elena", "Kostuk", "232776568668", "testElena@test.com", "Berlin", "description4"});
        return list.iterator();

        @Test(dataProvider = "addNewContact")
        public void addContactPositiveTestFromDataProvider (String name, String lastName, String phone,
                String email, String address, String description){
            app.getContact().click(By.cssSelector("[href=\"/add\"]"));
            app.getContact().fillContactForm(new Contact()
                    .setName(name)
                    .setLastName(lastName)
                    .setPhone(phone)
                    .setEmail(email)
                    .setAddress(address)
                    .setDescription(description));
            app.getContact().click(By.cssSelector(".add_form__2rsm2 button"));
        }
    }*/

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().click(By.cssSelector("[href=\"/add\"]"));
        app.getContact().fillContactForm(contact);
        app.getContact().click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
        app.getContact().pause(2000);
    }
}
