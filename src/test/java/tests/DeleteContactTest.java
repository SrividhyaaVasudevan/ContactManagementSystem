package tests;

import common.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class DeleteContactTest extends BaseTest {
    @Test
    public void verifyDeleteFunctionality() {
        Map<String, String> contactData = testData.getExcelData("contacts", "deleteContact");
        loginPageAction.login(contactData.get("email"), contactData.get("password"));
        AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        contactListPageAction.clickAddContactBtn();
        addContactPageAction.addContactDetail(contactData);
        AssertFail(contactListPageAction.numberOfContacts() == 1, "Verify if Contact added");
        contactListPageAction.clickOnFirstContact();
        contacDetailPageAction.clickOnDeleteContact();
        AssertFail(contactListPageAction.acceptAlert(), "Verify if Alert Present");
        AssertFail(contactListPageAction.numberOfContacts() == 0, "Verify if Contact removed");
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
