package com.telrun.contacts.fw;

import com.telrun.contacts.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public void addContact() {
        click(By.cssSelector("[href=\"/add\"]"));
        fillContactForm(new Contact().setName("Karl").setLastName("Sidorov").setAddress("Berlin").setEmail("sidorov@test.com").setDescription("something").setPhone("5754465446"));
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[contains(.,'Remove')]"));
        }
    }

    public boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public int sizeOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void fillContactForm(Contact contact) {
        int i = (int) System.currentTimeMillis() / 100000;
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone() + i);
        type(By.cssSelector("input:nth-child(4)"), i + contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
    }

    public boolean isComponentFormPresent() {
        return wd.findElements(By.cssSelector("div:nth-child(2) div div")).size() > 0;
    }
}
