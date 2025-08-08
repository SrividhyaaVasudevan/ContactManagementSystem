package tests;

import common.BaseTest;
import org.testng.annotations.Test;
import java.util.Map;

public class SigninPageTest extends BaseTest {
    @Test
    public void verifySigninWithExistingCredentials() {
        Map<String, String> data = testData.getExcelData("signin", "ExistingUser");
        loginPageAction.clickSignIn();
        signinPageAction.signin(data.get("firstname"), data.get("lastname"),data.get("email"), data.get("password"));
        AssertFail(signinPageAction.checkSigninErrorDisplayed(data.get("error")), "Verify appropriate error displayed");
    }
    @Test
    public void verifySigninWithEmptyData() {
        Map<String, String> data = testData.getExcelData("signin", "EmptyData");
        loginPageAction.clickSignIn();
        signinPageAction.signin(data.get("firstname"), data.get("lastname"),data.get("email"), data.get("password"));
        AssertFail(signinPageAction.checkSigninErrorDisplayed(data.get("error")), "Verify appropriate error displayed");
    }
    @Test
    public void verifySigninWithInvalidEmailFormat() {
        Map<String, String> data = testData.getExcelData("signin", "InvalidEmailFormat");
        loginPageAction.clickSignIn();
        signinPageAction.signin(data.get("firstname"), data.get("lastname"),data.get("email"), data.get("password"));
        AssertFail(signinPageAction.checkSigninErrorDisplayed(data.get("error")), "Verify appropriate error displayed");
    }
    @Test
    public void verifySigninAsNewUser() {
        Map<String, String> data = testData.getExcelData("signin", "validData");
        loginPageAction.clickSignIn();
        signinPageAction.signinNewUser(data.get("firstname"), data.get("lastname"), data.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
    }


}
