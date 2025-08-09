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

    public void clickAddContactBtn(){
        waitUntilElementDisplayed(addContactBtn);
        click(addContactBtn);
    }

    public void clickLogoutBtn(){
        waitUntilElementDisplayed(logoutBtn);
        click(logoutBtn);
    }

    public boolean checkContactAdded(){
        return true;
    }

    public int numberOfContacts(){
        try {
            waitUntilElementDisplayed(addContactBtn);
            return contacts.size();
        }catch (Exception e){
            System.out.println("No contacts found");
        }
        return 0;
    }

    public void clickOnFirstContact(){
        try{
            waitUntilElementDisplayed(addContactBtn);
            click(contactNames.get(0));
        }catch (Exception e){
            throw new RuntimeException("contacts not present");
        }

    }

}
