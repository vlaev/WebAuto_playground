package com.selenuim.vlay;
/**
 * Created by Vlay
 */

import com.selenium.vlay.account.Web_Account;
import com.selenium.vlay.home.Home_Page;
import com.selenium.vlay.home.Home_page_logged;
import com.selenium.vlay.login.Login_Page;
import com.selenium.vlay.profile.Profile_Page;
import com.selenium.vlay.register.Register_Page;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Web_Test {
    public WebDriver driver;
    private Web_Account site;
    private boolean acceptNextAlert = true;
    //private StringBuffer verificationErrors = new StringBuffer();
    //private int i = 1; //Verify counter of errors

    @BeforeClass
    public void setUp() throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "no,en-us,en");
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        site = new Web_Account();
        driver.get(site.site_url);
        deleteScreenShots("./src/test/screenShots/");
    }

    @Test
    public void testCreateUser() throws Exception {

        driver.findElement(Home_Page.register_button).click();
        Assert.assertEquals(driver.getTitle(), "Registration");

        Register_Page register_page = new Register_Page(driver);
        register_page.type_credentials(site.first_name, site.last_name, site.user_email, site.password, site.password, site.nickname);
        register_page.submit();

        Assert.assertEquals(driver.getTitle(), "Selenium Testing");
        Assert.assertEquals(driver.findElement(Home_page_logged.flash_text).getText(), "Welcome to Selenium course, " + site.nickname + "!\n×");
        Assert.assertTrue(isElementPresent(Home_page_logged.logout_button));

        driver.findElement(Home_page_logged.logout_button).click();

        Assert.assertEquals(driver.findElement(Home_page_logged.flash_text).getText(), "Welcome to Selenium course!\n×");
        Assert.assertEquals(driver.findElement(Home_Page.welcome_message).getText(), "Hello Anonymous!");

        Assert.assertTrue(isElementPresent(Home_Page.login_button));
    }

    @Test
    public void testDeleteUser() throws Exception {
        driver.findElement(Home_Page.login_button).click();

        Login_Page login_page = new Login_Page(driver);
        Assert.assertEquals(driver.findElement(login_page.header_login).getText(), "Login");

        login_page.type_email_pass(site.user_email, site.password);
        login_page.submit();

        Home_page_logged home_page_logged = new Home_page_logged(driver);
        Assert.assertEquals(driver.findElement(home_page_logged.flash_text).getText(), "Welcome to Selenium course, " + site.nickname + "!\n×");
        Assert.assertEquals(driver.findElement(home_page_logged.strong_text).getText(), "Цели и задачи курса");
        Assert.assertEquals(driver.findElement(home_page_logged.profile_button).getText(), "Profile");
        Assert.assertTrue(isElementPresent(home_page_logged.logout_button));

        home_page_logged.Profile();
        Profile_Page profile_page = new Profile_Page(driver);
        Assert.assertEquals(driver.findElement(profile_page.header_text).getText(), "Profile");
        Assert.assertEquals(driver.findElement(profile_page.delete_word).getText(), "Check to delete:");
        profile_page.Check_For_Delete();
        Assert.assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to delete this object[\\s\\S]$"));
        profile_page.Submit_changes();

        Assert.assertEquals(driver.findElement(Home_Page.flash_text).getText(), "User DELETED! ×");
        driver.findElement(By.id("button")).click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE){
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./src/test/screenShots/" + testResult.getName() + "_ScreenShot.jpg"));
        }
    }

    public void deleteScreenShots(String screenShotFolderPath) {
        File file = new File(screenShotFolderPath);
        File[] files = file.listFiles();
        for (File f:files){
            if (f.isFile() && f.exists()){
                f.delete();
            }
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
