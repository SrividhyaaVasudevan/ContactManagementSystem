package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.time.Duration;

public class BrowserInitializer {

    WebDriver driver;
    public WebDriver driverInitializer()
    {

        String browserName = System.getProperty("browser", "edge"); // default: chrome

        if (browserName.equalsIgnoreCase("chrome")) {
            chromeBrowser();
        } else if (browserName.equalsIgnoreCase("edge")) {
            edgeBrowser();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            firefoxBrowser();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public void chromeBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
    }

    public void edgeBrowser(){
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new EdgeDriver(options);
    }

    public void firefoxBrowser(){
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver(){
        return driver;
    }

}
