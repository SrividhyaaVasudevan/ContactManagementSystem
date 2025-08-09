package tests;

import common.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class AddContactTest_1 extends BaseTest {

    @Test
    public void verifyAddContactWithValidDetails() {
        Map<String, String> contactData = testData.getExcelData("contacts", "addContact");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickAddContactBtn();
        addContactPageAction.addContactDetail(contactData);
        AssertFail(contactListPageAction.numberOfContacts() == 1, "Verify if Contact added");
    }

    @Test
    public void verifyAddContactWithMissingRequiredField() {
        Map<String, String> contactData = testData.getExcelData("contacts", "missingField");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickAddContactBtn();
        addContactPageAction.addContactDetail(contactData);
        AssertFail(addContactPageAction.checkContactPageError().equalsIgnoreCase(contactData.get("error")),
                "Verify if error displayed for missing required fields");
    }

    @Test
    public void verifyAddContactPhoneField() {
        Map<String, String> contactData = testData.getExcelData("contacts", "phoneError");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickAddContactBtn();
        addContactPageAction.addContactDetail(contactData);
        AssertFail(addContactPageAction.checkContactPageError().equalsIgnoreCase(contactData.get("error")),
                "Verify if error displayed for invalid phone number");
    }

    @AfterMethod
    public void postCleanup(){
        try {
            deleteAllContacts();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
