package tests;

import common.BaseTest;
import org.testng.annotations.Test;

import java.util.Map;

public class SessionNavigationTest extends BaseTest {
    @Test
    public void verifyLogout() {
        Map<String, String> data = testData.getExcelData("login", "validData");
        loginPageAction.login(data.get("email"), data.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickLogoutBtn();
        AssertFail(loginPageAction.loginPageVisible(), "Verify Login page is displayed after logout");
    }

    @Test
    public void verifyContactListNavigation() {
        navigateToContactListPage();
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        AssertFail(contactListPageAction.numberOfContacts() == 0, "Verify if no Contact List appears");
    }

    @Test
    public void verifySiteRefresh() {
        Map<String, String> data = testData.getExcelData("login", "validData");
        loginPageAction.login(data.get("email"), data.get("password"));
        AssertFail(contactListPageAction.numberOfContacts() == 1, "Verify if Contact List appears");
        contactListPageAction.refresh();
        AssertFail(contactListPageAction.numberOfContacts() == 1, "Verify if Contact List appears after refresh");
    }

    @Test(priority = -1)
    public void verifyLogoutNavigation() {
        Map<String, String> data = testData.getExcelData("login", "validData");
        loginPageAction.login(data.get("email"), data.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickLogoutBtn();
        AssertFail(loginPageAction.loginPageVisible(), "Verify Login page is displayed after logout");
        navigateBack();
        navigateBack();
        AssertFail(loginPageAction.loginPageVisible(), "Verify user cannot go back to contact list after logout using browser back button");
    }

}
