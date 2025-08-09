package pages.action;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.repo.ContactDetailPageRepo;

import java.util.Map;

public class ContacDetailPageAction extends ContactDetailPageRepo {
    WebDriver driver;
    String URL = "https://thinking-tester-contact-list.herokuapp.com/";
    public ContacDetailPageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickDeleteContact(){
        clickOnDeleteContact();
        acceptAlert();
    }

    public void clickOnDeleteContact(){
        waitUntilElementDisplayed(deleteBtn);
        click(deleteBtn);
    }

    public void clickEditContact(){
        waitUntilElementDisplayed(editContactBtn);
        click(editContactBtn);
    }

    public boolean isContactDetailPageVisible(){
        staticWait(3000);
        return waitUntilElementDisplayed(editContactBtn);
    }

    public boolean verifyPhoneField(String number){
        waitUntilElementDisplayed(editContactBtn);
        staticWait(3000);
        return getText(phoneField).equalsIgnoreCase(number);
    }

    public boolean verifyErrorMessage(String error){
        waitUntilElementDisplayed(errorMsg);
        return getText(errorMsg).equalsIgnoreCase(error);
    }

}
