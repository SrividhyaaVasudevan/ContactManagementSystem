package tests;

import common.BaseTest;
import org.testng.annotations.Test;

import java.util.Map;

public class EditContactTest extends BaseTest {
    @Test
    public void verifyEditExistingContact() {
        Map<String, String> contactData = testData.getExcelData("contacts", "editContact");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickOnFirstContact();
        AssertFail(contacDetailPageAction.isContactDetailPageVisible(), "Before Edit");
        contacDetailPageAction.clickEditContact();
        String newNumber = generateUniquePhoneNumber();
        editContactPageAction.changePhoneField(newNumber);
        editContactPageAction.clickOnSubmit();
        AssertFail(contacDetailPageAction.verifyPhoneField(newNumber), "Verify if phone number field is updated");

    }

    @Test
    public void verifyCancelEdit() {
        Map<String, String> contactData = testData.getExcelData("contacts", "editContact");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickOnFirstContact();
        AssertFail(contacDetailPageAction.isContactDetailPageVisible(), "Before Edit");
        contacDetailPageAction.clickEditContact();
        String newNumber = generateUniquePhoneNumber();
        editContactPageAction.changePhoneField(newNumber);
        AssertFail(true, "phone number field is edited but not submitted");
        editContactPageAction.clickOnCancel();
        AssertFail(!contacDetailPageAction.verifyPhoneField(newNumber), "Verify if phone number field is updated");

    }

    @Test
    public void verifyEditError() {
        Map<String, String> contactData = testData.getExcelData("contacts", "editContact");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickOnFirstContact();
        contacDetailPageAction.clickEditContact();
        editContactPageAction.changeLastNameField("");
        editContactPageAction.clickOnSubmit();
        AssertFail(contacDetailPageAction.verifyErrorMessage(contactData.get("error")), "Verify if error displayed");

    }

}
