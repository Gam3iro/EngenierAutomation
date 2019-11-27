package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home;

import java.util.concurrent.TimeUnit;

public class TestWeb {
    private static WebDriver driver;

    public static void main(String[] args) {
        driver = ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //POM structure
        Home home = new Home(driver);
        home.gotoHomePage("www.google.pt");
    }

    private static WebDriver ChromeDriver() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}