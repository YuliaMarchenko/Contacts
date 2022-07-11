package com.telrun.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{

    WebDriver wd;

    UserHelper user;
    ContactHelper contact;
    HeaderHelper header;

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(wd);
        contact = new ContactHelper(wd);
        header = new HeaderHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

}
