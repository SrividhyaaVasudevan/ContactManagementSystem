package pages.repo;

import common.UiBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactListPageRepo extends UiBase {

    @FindBy(xpath = "//h1[contains(text(), \"Contact List App\")]")
    protected WebElement contactPageHeader;

    @FindBy(xpath = "//button[contains(text(),\"Add\")]")
    protected WebElement contactPageAddBtn;

    @FindBy(css = "#add-contact")
    protected WebElement addContactBtn;

    @FindBy(css = "#logout")
    protected WebElement logoutBtn;

    @FindBy(xpath = "//h1[contains(text(), \"Add Contact\")]")
    protected WebElement addContactHeader;

    @FindBy(xpath = "//table/tr")
    protected List<WebElement> contacts;

    @FindBy(xpath = "(//table/tr/td)[2]")
    protected List<WebElement> contactNames;


}
