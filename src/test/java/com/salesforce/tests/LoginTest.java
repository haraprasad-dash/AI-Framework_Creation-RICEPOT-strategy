package com.salesforce.tests;

import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Valid login with correct credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not displayed");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not displayed");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");
        loginPage.enterUsername("valid_user@example.com");
        loginPage.enterPassword("ValidPassword123");
        loginPage.clickLoginButton();
    }

    @Test(priority = 2, description = "Invalid login with blank username")
    public void testInvalidLoginBlankUsername() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        loginPage.enterUsername("");
        loginPage.enterPassword("SomePassword123");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for blank username");
    }

    @Test(priority = 3, description = "Invalid login with blank password")
    public void testInvalidLoginBlankPassword() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        loginPage.enterUsername("test_user@example.com");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for blank password");
    }

    @Test(priority = 4, description = "Invalid login with blank username and password")
    public void testInvalidLoginBlankCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for blank credentials");
    }

    @Test(priority = 5, description = "Invalid login with incorrect password")
    public void testInvalidLoginWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        loginPage.enterUsername("valid_user@example.com");
        loginPage.enterPassword("WrongPassword123");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for incorrect password");
    }

    @Test(priority = 6, description = "Invalid login with non-existent user")
    public void testInvalidLoginNonExistentUser() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        loginPage.enterUsername("nonexistent_user_xyz@example.com");
        loginPage.enterPassword("SomePassword123");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for non-existent user");
    }

    @Test(priority = 7, description = "Invalid login with invalid email format")
    public void testInvalidLoginInvalidEmailFormat() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        loginPage.enterUsername("invalid-email-format");
        loginPage.enterPassword("SomePassword123");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid email format");
    }

    @Test(priority = 8, description = "Invalid login with SQL injection attempt")
    public void testInvalidLoginSQLInjection() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        loginPage.enterUsername("' OR '1'='1");
        loginPage.enterPassword("' OR '1'='1");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed() || loginPage.isLoginPageDisplayed(), "Error message should be displayed or login page should remain");
    }

    @Test(priority = 9, description = "Verify Remember Me checkbox is displayed")
    public void testRememberMeCheckboxDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        Assert.assertTrue(loginPage.isRememberMeCheckboxDisplayed(), "Remember Me checkbox should be displayed");
    }

    @Test(priority = 10, description = "Verify login with Remember Me selected")
    public void testLoginWithRememberMe() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        loginPage.enterUsername("valid_user@example.com");
        loginPage.enterPassword("ValidPassword123");
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
    }
}
