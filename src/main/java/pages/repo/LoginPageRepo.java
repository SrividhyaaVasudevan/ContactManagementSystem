package pages.repo;

import common.UiBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageRepo extends UiBase {

    @FindBy(css = "#email")
    protected   WebElement emailField;
    @FindBy(css = "#password")
    protected WebElement passwordField;
    @FindBy(css = "#submit")
    protected   WebElement submitBtn;
    @FindBy(css = "#error")
    protected   WebElement errorMsg;
    @FindBy(css = "#signup")
    protected   WebElement signinBtn;

    @FindBy(xpath = "//p[contains(text(),\"Log In\")]")
    protected   WebElement loginLabel;


}
