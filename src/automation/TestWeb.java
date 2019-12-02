package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ClientRegistration;
import pages.Home;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestWeb {
    private static WebDriver driver;

    public static void main(String[] args) {
        driver = chromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Home home = new Home(driver);
        home.navigate();
        home.takeAndSkipTour();
        home.selectCurrency("US Dollars");
        home.proceedToSignUp();

        ClientRegistration register = new ClientRegistration(driver);

        String email = "AutomatedEngenier"+ getRandomInt() + "@test.com";
        String username = "TestUsername";
        String password = "TestWebPassword"+ getRandomInt();

        register.signUp(email, username, "919876543", password);

        home.confirmRegist(username);

        driver.close();
    }

    private static Integer getRandomInt(){
        Random rand = new Random();
        return rand.nextInt(100000);
    }

    private static WebDriver chromeDriver() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}