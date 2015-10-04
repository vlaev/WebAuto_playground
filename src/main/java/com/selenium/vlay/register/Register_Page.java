package com.selenium.vlay.register;

/**
 * Created by Vlay on 01.10.2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register_Page {
    private final WebDriver driver;
    By first_name_field = By.id("auth_user_first_name");
    By last_name_field = By.id("auth_user_last_name");
    By email_field = By.id("auth_user_email");
    By password_field = By.id("auth_user_password");
    By password2_field = By.name("password_two");
    By nickname_field = By.id("auth_user_nickname");
    By submit_button = By.cssSelector("input.btn");

    public Register_Page(WebDriver driver){
        this.driver = driver;
    }
    public void type_credentials (String userFirstName, String userLastName, String userEmail, String userPass, String userPass2, String userNickname){
        WebElement user_first_name = driver.findElement(first_name_field);
        WebElement user_last_name = driver.findElement(last_name_field);
        WebElement user_email = driver.findElement(email_field);
        WebElement pass_field = driver.findElement(password_field);
        WebElement pass_field2 = driver.findElement(password2_field);
        WebElement user_nickname = driver.findElement(nickname_field);

        user_first_name.sendKeys(userFirstName);
        user_last_name.sendKeys(userLastName);
        user_email.sendKeys(userEmail);
        pass_field.sendKeys(userPass);
        pass_field2.sendKeys(userPass2);
        user_nickname.sendKeys(userNickname);
    }

    public void submit (){
        WebElement submit_registration = driver.findElement(submit_button);
        submit_registration.click();
    }
}
