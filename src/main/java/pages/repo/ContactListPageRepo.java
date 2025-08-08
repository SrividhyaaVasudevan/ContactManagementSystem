package pages.repo;

import common.UiBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPageRepo extends UiBase {

    @FindBy(xpath = "//h1[contains(text(), \"Contact List App\")]")
    protected WebElement contactPageHeader;

    @FindBy(xpath = "//button[contains(text(),\"Add\")]")
    protected WebElement contactPageAddBtn;



}
