package com.optum.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;


public class Driver {


    private Driver() {
    }
    /*
    We make the Webdriver private, because we want to close access from outside the class
    We are making it static, because we will use it in a static method
     */
    // private static WebDriver driver;//default value = null

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    If an instance doesn't exist, it will create first, and then it will always return the same instance.
    */
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
        /*
        We will read our browserType from the configuration.properties file.
        This way, we can control which browser is opened from outside our code
        */
            String browserType = ConfigurationReader.getProperty("browser").toLowerCase();
        /*
        Depending on the browserType returned from the configuration.properties
        a switch statement will determine the case, and open the matching browser
        */
            switch (browserType) {
                case "chrome":
                    // WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    //  WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "safari":
                    //  WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    break;
                case "edge":
                    //  WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            // This line terminates the currently existing driver completely. It will be non-existent
            driverPool.get().quit();

            //We assign the value back to null so that singleton can create a newer one if needed.
            driverPool.remove();
        }
    }

}