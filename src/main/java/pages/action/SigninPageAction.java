package pages.action;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.repo.SigninPageRepo;

public class SigninPageAction extends SigninPageRepo {
    WebDriver driver;
    String URL = "https://thinking-tester-contact-list.herokuapp.com/";
    public SigninPageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillSigninDetails(String firstName, String lastName, String email, String password){
        waitUntilElementDisplayed(firstNameField);
        fill(firstNameField, firstName);
        fill(lastNameField, lastName);
        fill(emailField, email);
        fill(passwordField, password);
    }

    public void signin(String firstName, String lastName, String email, String password){
        fillSigninDetails(firstName, lastName, email, password);
        click(submitBtn);
    }

    public boolean checkSigninErrorDisplayed(String error){
        waitUntilElementDisplayed(errorMsg);
        return getText(errorMsg).equalsIgnoreCase(error);
    }

    public void signinNewUser(String firstName, String lastName, String password){
        String newEmail = generateUniqueEmail();
        System.out.println(newEmail);
        fillSigninDetails(firstName, lastName, newEmail, password);
        click(submitBtn);
    }


}
