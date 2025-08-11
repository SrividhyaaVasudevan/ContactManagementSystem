package tests;

import common.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "mapData")
    public void verifyLoginFunctionality(Map<String, String> data) {
        loginPageAction.login(data.get("email"), data.get("password"));
        if(data.get("scenario").equalsIgnoreCase("valid")){
            AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        }else{
            AssertFail(loginPageAction.validateError(data.get("error")), "Verify valid error displayed");
        }
    }

    @DataProvider(name = "mapData")
    public Object[][] provideObjectData() {
        return testData.provideData("login");
    }

}
