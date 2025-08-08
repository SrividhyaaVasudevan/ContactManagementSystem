package pages.repo;

import common.UiBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPageRepo extends UiBase {

    @FindBy(css = "#firstName")
    protected   WebElement firstNameField;
    @FindBy(css = "#lastName")
    protected WebElement lastNameField;
    @FindBy(css = "#email")
    protected   WebElement emailField;

    @FindBy(css = "#password")
    protected   WebElement passwordField;

    @FindBy(css = "#submit")
    protected   WebElement submitBtn;
    @FindBy(css = "#cancel")
    protected   WebElement cancelBtn;
    @FindBy(css = "#error")
    protected   WebElement errorMsg;



}
