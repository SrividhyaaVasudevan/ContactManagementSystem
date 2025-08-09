package pages.action;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.repo.EditContactPageRepo;

public class EditContactPageAction extends EditContactPageRepo {
    WebDriver driver;
    String URL = "https://thinking-tester-contact-list.herokuapp.com/";
    public EditContactPageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnSubmit(){
        waitUntilElementDisplayed(submitBtn);
        click(submitBtn);
    }

    public void clickOnCancel(){
        waitUntilElementDisplayed(cancelBtn);
        click(cancelBtn);
    }

    public void changePhoneField(String number){
        waitUntilElementDisplayed(editPageHeader);
        clearAndFill(phoneField,number);
    }
    public void changeLastNameField(String name){
        waitUntilElementDisplayed(editPageHeader);
        clearAndFill(lastNameField,name);
    }


}
