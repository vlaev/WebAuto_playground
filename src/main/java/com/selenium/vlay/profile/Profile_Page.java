package com.selenium.vlay.profile;

/**
 * Created by Vlay on 01.10.2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Profile_Page {
    private final WebDriver driver;
    public static By header_text = By.cssSelector("h2");
    public static By delete_word = By.id("delete_record__label");
    public static By delete_checkbox = By.id("delete_record");
    public static By submit_button = By.cssSelector("input.btn");

    public Profile_Page (WebDriver driver){
        this.driver = driver;
    }

    public void Check_For_Delete (){
        WebElement checkbox = driver.findElement(delete_checkbox);
        checkbox.click();
    }

    public void Submit_changes (){
        WebElement submit = driver.findElement(submit_button);
        submit.click();
    }


}