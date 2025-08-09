package common;

import org.openqa.selenium.WebDriver;
import pages.action.*;

public class PageInitializer extends BrowserInitializer {

    public ContactListPageAction contactListPageAction;
    public LoginPageAction loginPageAction;
    public SigninPageAction signinPageAction;
    public AddContactPageAction addContactPageAction;
    public ContacDetailPageAction contacDetailPageAction;
    public EditContactPageAction editContactPageAction;

    public void initializePages(WebDriver driver){
        contactListPageAction = new ContactListPageAction(driver);
        loginPageAction = new LoginPageAction(driver);
        signinPageAction = new SigninPageAction(driver);
        addContactPageAction = new AddContactPageAction(driver);
        contacDetailPageAction = new ContacDetailPageAction(driver);
        editContactPageAction = new EditContactPageAction(driver);
    }

}
