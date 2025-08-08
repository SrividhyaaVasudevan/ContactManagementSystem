package common;

import org.openqa.selenium.WebDriver;
import pages.action.ContactListPageAction;
import pages.action.LoginPageAction;
import pages.action.SigninPageAction;

public class PageInitializer extends BrowserInitializer {

    public ContactListPageAction contactListPageAction;
    public LoginPageAction loginPageAction;
    public SigninPageAction signinPageAction;

    public void initializePages(WebDriver driver){
        contactListPageAction = new ContactListPageAction(driver);
        loginPageAction = new LoginPageAction(driver);
        signinPageAction = new SigninPageAction(driver);
    }
}
