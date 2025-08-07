package common;

import org.openqa.selenium.WebDriver;
import pages.action.HomepageAction;

public class PageInitializer extends BrowserInitializer {

    WebDriver driver;
    public HomepageAction homepageAction;

    public void intializePages(){
        homepageAction = new HomepageAction(driver);
    }
}
