package common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class UiBase{


    WebDriver driver;

    protected void setDriver(WebDriver driver){
        this.driver = driver;
    }
    protected boolean waitUntilElementDisplayed(WebElement element, int timeoutInSeconds , int pollingInMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingInMillis))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
        return isDisplayed(element);
    }

    protected boolean waitUntilElementDisplayed(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
        return isDisplayed(element);
    }

    protected  boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    protected  boolean isEnabled(WebElement element){
        return element.isEnabled();
    }

    protected  boolean isSelected(WebElement element){
        return element.isSelected();
    }

    protected  void click(WebElement element){
        element.click();
    }

    public void staticWait(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected  void clicker(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    protected void refresh(){
        driver.navigate().refresh();
    }

    protected void fill(WebElement element, String text){
        element.sendKeys(text);
    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected String getAttribute(WebElement element, String Attribute){
        return element.getAttribute(Attribute);
    }

    protected void clearAndFill(WebElement element, String text){
        element.clear();
        staticWait(500);
        element.sendKeys(text);
    }

    public static String generateUniqueEmail() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return "testuser" + timeStamp + "@test.com";
    }


}
