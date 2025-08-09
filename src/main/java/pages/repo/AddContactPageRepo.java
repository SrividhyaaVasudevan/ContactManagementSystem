package pages.repo;

import common.UiBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactPageRepo extends UiBase {

    @FindBy(css = "#firstName")
    protected   WebElement firstNameField;
    @FindBy(css = "#lastName")
    protected WebElement lastNameField;
    @FindBy(css = "#email")
    protected   WebElement emailField;

    @FindBy(css = "#phone")
    protected   WebElement phoneField;

    @FindBy(css = "#birthdate")
    protected   WebElement birthdateField;
    @FindBy(css = "#street1")
    protected   WebElement street1Field;
    @FindBy(css = "#street2")
    protected   WebElement street2Field;

    @FindBy(css = "#city")
    protected   WebElement cityField;
    @FindBy(css = "#stateProvince")
    protected   WebElement stateProvinceField;
    @FindBy(css = "#postalCode")
    protected   WebElement postalCodeField;

    @FindBy(css = "#country")
    protected   WebElement countryField;

    @FindBy(css = "#submit")
    protected   WebElement submitBtn;
    @FindBy(css = "#cancel")
    protected   WebElement cancelBtn;
    @FindBy(css = "#error")
    protected   WebElement errorMsg;
    @FindBy(css = "#delete")
    protected   WebElement deleteBtn;



}
