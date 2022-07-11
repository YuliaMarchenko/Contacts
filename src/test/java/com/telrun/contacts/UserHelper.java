package com.telrun.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void registration() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        fillLoginRegistrationForm(new User().setEmail("test102@test.com").setPassword("test12_TEST"));
        click(By.xpath("//button[contains(.,' Registration')]"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder=\"Email\"]"), user.getEmail());
        type(By.cssSelector("[placeholder=\"Password\"]"), user.getPassword());
    }

    public void login() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        fillLoginRegistrationForm(new User().setEmail("test102@test.com").setPassword("test12_TEST"));
        click(By.xpath("//button[contains(.,' Login')]"));
    }
}
