package com.selenium.vlay.login;

/**
 * Created by Vlay on 01.10.2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
    private final WebDriver driver;
    By email_field = By.id("auth_user_email");
    By password_field = By.id("auth_user_password");
    By submit_button = By.cssSelector("input.btn");
    public static By header_login = By.cssSelector("h2");
    public static By flash_text = By.cssSelector("div.flash");
    public static By login_button = By.linkText("Login");

    public Login_Page(WebDriver driver){
        this.driver = driver;
    }

    public void type_email_pass(String userEmail, String userPass){
        WebElement user_email = driver.findElement(email_field);
        WebElement pass_field = driver.findElement(password_field);

        user_email.sendKeys(userEmail);
        pass_field.sendKeys(userPass);
    }
    public void submit (){
        WebElement login = driver.findElement(submit_button);
        login.click();
    }
}
