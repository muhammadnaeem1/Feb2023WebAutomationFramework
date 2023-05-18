package us.piit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;


public class LogoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    String validUsername = "#user-name";
    String validPassword = "standard_user";

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @Test
    public void logout() throws InterruptedException {
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter username, password and click on the login button
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();

        String expectedHomePageHeader = "Products";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");

        //click on a hamburger menu
        clickOn("#react-burger-menu-btn");
        log.info("click on hambuger menu success");
        Thread.sleep(3000);

        //hover over & click on a logout link
        hoverOver("#logout_sidebar_link");
        log.info("click on logout link success");

        //check user is landed to the login page

        boolean loginPageHeaderIsDisplayed = isVisible("//div[contains(text(),'Swag Labs')]");
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        log.info("login page header is displayed");
        String expectedLoginPageHeaderText = "Swag Labs";
        String actualLoginPageHeaderText = getElementText("//div[contains(text(),'Swag Labs')]");
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");


    }


}
