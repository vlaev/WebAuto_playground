package com.selenium.vlay.home;

/**
 * Created by Vlay on 01.10.2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
    private final WebDriver driver;
    public static By flash_text = By.cssSelector("div.flash");
    public static By welcome_message = By.xpath("//section[@id='main']/div[4]");
    public static By login_button = By.linkText("Login");
    public static By close_flash = By.id("closeflash");
    public static By header_text = By.cssSelector("h1");
    public static By strong_text = By.cssSelector("strong");
    public static By paragraph = By.cssSelector("p");
    public static By register_button = By.id("button");

    public Home_Page(WebDriver driver){
        this.driver = driver;
    }

    public void Login(){
        WebElement login = driver.findElement(login_button);
        login.click();
    }
}
