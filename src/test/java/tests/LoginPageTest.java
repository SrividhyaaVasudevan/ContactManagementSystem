package tests;

import common.BaseTest;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPageTest extends BaseTest {
    @Test
    public void verifyLoginWithValidCredentials() {
        Map<String, String> data = testData.getExcelData("login", "validData");
        loginPageAction.login(data.get("email"), data.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
    }

    @Test
    public void verifyLoginWithIncorrectPassword() {
        Map<String, String> data = testData.getExcelData("login", "InvalidPassword");
        loginPageAction.login(data.get("email"), data.get("password"));
        AssertFail(loginPageAction.validateError(data.get("error")), "Verify valid error displayed");
    }

    @Test
    public void verifyLoginWithEmptyFields() {
        Map<String, String> data = testData.getExcelData("login", "EmptyData");
        loginPageAction.login(data.get("email"), data.get("password"));
        AssertFail(loginPageAction.validateError(data.get("error")), "Verify valid error displayed");
    }

    @Test
    public void verifyLoginWithInvalidEmailFormat() {
        Map<String, String> data = testData.getExcelData("login", "InvalidEmailFormat");
        loginPageAction.login(data.get("email"), data.get("password"));
        AssertFail(loginPageAction.validateError(data.get("error")), "Verify valid error displayed");
    }

    @Test
    public void verifyPasswordInputFieldMasked() {
        Map<String, String> data = testData.getExcelData("login", "validData");
        loginPageAction.fillEmailAndPassword(data.get("email"), data.get("password"));
        AssertFail(loginPageAction.checkIfPasswordMasked(), "Verify if Password field Masked");
    }

}
