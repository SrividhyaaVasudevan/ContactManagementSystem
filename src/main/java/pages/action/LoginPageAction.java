package pages.action;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.repo.LoginPageRepo;

public class LoginPageAction extends LoginPageRepo {
    WebDriver driver;
    String URL = "https://thinking-tester-contact-list.herokuapp.com/";
    public LoginPageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password){
        fillEmailAndPassword(email, password);
        click(submitBtn);
    }

    public void clickSignIn(){
        waitUntilElementDisplayed(signinBtn);
        click(signinBtn);
    }

    public void fillEmailAndPassword(String email, String password){
        waitUntilElementDisplayed(emailField);
        clearAndFill(emailField, email);
        clearAndFill(passwordField, password);
    }

    public boolean checkIfPasswordMasked(){
        waitUntilElementDisplayed(passwordField);
        return getAttribute(passwordField, "type").equalsIgnoreCase("password");
    }

    public boolean validateError(String error){
        waitUntilElementDisplayed(errorMsg);
        return error.equalsIgnoreCase(getText(errorMsg));
    }


}
