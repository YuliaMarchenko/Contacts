package com.telrun.contacts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    @Test
    public void testOpenHomePage() {
        System.out.println(isComponentFormPresent());
        System.out.println(isElementPresent(By.cssSelector("div:nth-child(2) div div")));
        System.out.println(isElement2(By.cssSelector("div:nth-child(2) div div")));
    }
}
