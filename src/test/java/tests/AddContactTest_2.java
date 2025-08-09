package tests;

import common.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class AddContactTest_2 extends BaseTest {

    @Test
    public void verifyDuplicateContact() {
        Map<String, String> contactData = testData.getExcelData("contacts", "duplicateContact");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickAddContactBtn();
        addContactPageAction.addContactDetail(contactData);
        AssertFail(contactListPageAction.numberOfContacts() == 1, "Verify if Contact added");
        contactListPageAction.clickAddContactBtn();
        addContactPageAction.addContactDetail(contactData);
        AssertFail(contactListPageAction.numberOfContacts() == 2, "Verify if duplicate contact is added");
    }

    @Test
    public void verifyAddContactFormReset() {
        Map<String, String> contactData = testData.getExcelData("contacts", "formReset");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickAddContactBtn();
        addContactPageAction.addContactDetail(contactData);
        AssertFail(contactListPageAction.numberOfContacts() == 1, "Verify if Contact added");
        contactListPageAction.clickAddContactBtn();
        AssertFail(addContactPageAction.checkTextFieldValues(),  "Verify if form data is reset");

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
