package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import us.piit.base.CommonAPI;

public class LoginPage extends CommonAPI {

    Logger log = LogManager.getLogger(LoginPage.class.getName());
    String usernameField = "#user-name";
    String passwordField = "standard_user";
    String loginBtn = "#login-button";
    String errorMessage = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]";

    //reusable methods
    public void enterUsername(String username) {
        type(usernameField, username);
        log.info("enter userName successfully");

    }
    public void enterPassword(String password){
        type(passwordField, password);
        log.info("enter password successfully");
    }
    public void clickOnLoginBtn(){
        clickOn(loginBtn);
        log.info("click on button login Success");
    }
    public String getErrorMessage(){
        String text = getElementText(errorMessage);
        log.info("get error message success");
        return text;
    }
}
