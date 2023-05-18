package us.piit;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;


public class LoginTest extends CommonAPI {
     Logger log = LogManager.getLogger(LoginTest.class.getName());
     String validusername = "standard_user";
     String validpassword = "secret_sauce";

     LoginPage loginPage = new LoginPage();
     HomePage homePage = new HomePage();
    @Test
    public void validCredential()  {
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter username, password and click on the login button
        loginPage.enterUsername(validusername);
        loginPage.enterPassword(validpassword);
        loginPage.clickOnLoginBtn();

        String expectedHomePageHeader = "Products";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);



    }

    //negative test
    @Test
    public void invalidUsername() {
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter username, password and click on the login button
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword(validpassword);
        loginPage.clickOnLoginBtn();

        //validate the error message
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);




    }

    @Test
    public void missingUsername() {
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter username, password and click on the login button
        loginPage.enterUsername("");
        loginPage.enterPassword(validpassword);
        loginPage.clickOnLoginBtn();

        //validate the error message
        String expectedError = "Epic sadface: Username is required";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");


    }

    @Test
    public void missingPasswrod() {
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter username, password and click on the login button
        loginPage.enterUsername(validusername);
        loginPage.enterPassword("");
        loginPage.clickOnLoginBtn();

        //validate the error message
        String expectedError = "Epic sadface: Username is required";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");

    }
}