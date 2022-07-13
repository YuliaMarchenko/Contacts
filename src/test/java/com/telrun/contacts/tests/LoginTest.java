package com.telrun.contacts.tests;

import com.telrun.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @DataProvider
    public Iterator<Object[]> loginFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/invalidEmail.csv"));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "loginFromCsv")
    public void loginUserNegativeTest(User user) {
        app.getUser().click(By.xpath("//a[contains(.,'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(.,' Login')]"));
    }
}
