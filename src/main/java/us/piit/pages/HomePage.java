package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());
   String mainHeader = "//span[contains(text(),'Products')]";

   public String getHeaderText(){
       String text = getElementText(mainHeader);
       log.info("user logged in success");
       return text;
   }
}
