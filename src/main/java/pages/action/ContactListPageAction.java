package pages.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.repo.ContactListPageRepo;

public class ContactListPageAction extends ContactListPageRepo {
    WebDriver driver;
    public ContactListPageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isContactListPageVisible(){
        return waitUntilElementDisplayed(contactPageAddBtn);
    }
}
