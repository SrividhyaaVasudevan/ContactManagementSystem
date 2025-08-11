package tests;

import common.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Map;

public class SigninPageTest extends BaseTest {

    @Test(dataProvider = "mapData")
    public void verifySigninFunctionality(Map<String, String> data) {
        loginPageAction.clickSignIn();
        if(data.get("scenario").equalsIgnoreCase("valid")){
            signinPageAction.signinNewUser(data.get("firstname"), data.get("lastname"), data.get("password"));
            AssertFail(contactListPageAction.isContactListPageVisible(), "Verify My Contact page is displayed");
        }else{
            signinPageAction.signin(data.get("firstname"), data.get("lastname"),data.get("email"), data.get("password"));
            AssertFail(signinPageAction.checkSigninErrorDisplayed(data.get("error")), "Verify appropriate error displayed");
        }
    }

    @DataProvider(name = "mapData")
    public Object[][] provideObjectData() {
        return testData.provideData("signin");
    }

}
