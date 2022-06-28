package com.telrun.contacts;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    
    // precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))){
            wd.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }

    @Test
    public void testRegistrationPositive(){
        // click on the link LOGIN
        wd.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        // fill registration form
        wd.findElement(By.cssSelector("[placeholder=\"Email\"]")).click();
        wd.findElement(By.cssSelector("[placeholder=\"Email\"]")).clear();
        wd.findElement(By.cssSelector("[placeholder=\"Email\"]")).sendKeys("test100@test.com");
        wd.findElement(By.cssSelector("[placeholder=\"Password\"]")).click();
        wd.findElement(By.cssSelector("[placeholder=\"Password\"]")).clear();
        wd.findElement(By.cssSelector("[placeholder=\"Password\"]")).sendKeys("test12_TEST");
        // click on the button Registration
        wd.findElement(By.xpath("//button[contains(.,' Registration')]")).click();
        // assert the button Sing out displayed
        System.out.println(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }
}
