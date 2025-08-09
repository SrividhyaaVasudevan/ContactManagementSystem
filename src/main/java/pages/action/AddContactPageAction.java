package pages.action;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import pages.repo.AddContactPageRepo;

import java.util.Map;

public class AddContactPageAction extends AddContactPageRepo {
    WebDriver driver;
    String URL = "https://thinking-tester-contact-list.herokuapp.com/";
    public AddContactPageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    private void fillAddContactDetails(String firstName, String lastName, String birthdate, String email,
                                      String phoneNumber, String street1, String street2, String city,
                                      String stateProvince, String postalCode, String country){
        waitUntilElementDisplayed(firstNameField);
        fill(firstNameField, firstName);
        fill(lastNameField, lastName);
        fill(birthdateField, birthdate);
        fill(emailField, email);
        fill(phoneField, phoneNumber);
        fill(street1Field, street1);
        fill(street2Field, street2);
        fill(cityField, city);
        fill(stateProvinceField, stateProvince);
        fill(postalCodeField, postalCode);
        fill(countryField, country);
    }

    public void addContactDetail(Map<String, String> data){
        fillAddContactDetails(data.get("firstname"), data.get("lastname"), data.get("birthdate"), data.get("email"),
                data.get("phone"), data.get("street1"), data.get("street2"), data.get("city"),
                data.get("state"), data.get("postalcode"), data.get("country"));
        click(submitBtn);
    }

    public void fillAddContactDetails(Map<String, String> data){
        fillAddContactDetails(data.get("firstname"), data.get("lastname"), data.get("birthdate"), data.get("email"),
                data.get("phone"), data.get("street1"), data.get("street2"), data.get("city"),
                data.get("state"), data.get("postalcode"), data.get("country"));
        click(submitBtn);
    }

    public String checkContactPageError(){
        waitUntilElementDisplayed(errorMsg);
        return getText(errorMsg);
    }

    public boolean checkTextFieldValues(){
        waitUntilElementDisplayed(firstNameField);
        return isEmpty(firstNameField) && isEmpty(lastNameField) && isEmpty(birthdateField) && isEmpty(emailField) &&
                isEmpty(phoneField) && isEmpty(street1Field) && isEmpty(street2Field) && isEmpty(cityField) &&
                isEmpty(stateProvinceField) && isEmpty(postalCodeField) && isEmpty(countryField);
    }

}
