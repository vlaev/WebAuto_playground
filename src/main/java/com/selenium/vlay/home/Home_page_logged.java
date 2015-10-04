package com.selenium.vlay.home;

/**
 * Created by Vlay on 01.10.2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page_logged {
    private final WebDriver driver;
    public static By flash_text = By.cssSelector("div.flash");
    public static By profile_button = By.id("button");
    public static By strong_text = By.cssSelector("strong");
    public static By logout_button = By.linkText("Logout");
    public static By post_counter = By.cssSelector("div.web2py_counter");
    public static By post_counter_table = By.cssSelector("div.web2py_table > div");
    public static By post_message_button = By.linkText("Post Message");
    public static By post_body = By.cssSelector("td");
    public static By post_user = By.xpath("//tr[@id]/td[2]");
    public static By view_button = By.cssSelector("span.buttontext.button");
    public static By delete_button = By.xpath("//tr[@id]/td[3]/a[2]/span[2]");

    public Home_page_logged(WebDriver driver){
        this.driver = driver;
        WebElement flash_text_el = driver.findElement(flash_text);
        WebElement profile_button_el = driver.findElement(profile_button);
        WebElement strong_text_el = driver.findElement(strong_text);
        WebElement logout_button_el = driver.findElement(logout_button);
    }

    public void Post_Message(){
        WebElement post_button = driver.findElement(post_message_button);
        post_button.click();
    }

    public void Delete_Post(){
        WebElement delete_post = driver.findElement(delete_button);
        delete_post.click();
    }

    public void Logout(){
        WebElement logout = driver.findElement(logout_button);
        logout.click();
    }

    public void Profile(){
        WebElement profile = driver.findElement(profile_button);
        profile.click();
    }
}