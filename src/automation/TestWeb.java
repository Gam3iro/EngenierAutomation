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
        driver = ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Home home = new Home(driver);
        home.Navigate();
        home.TakeAndSkipTou();
        home.SelectCurrrency("US Dollars");
        home.ProceedToSignUp();

        ClientRegistration register = new ClientRegistration(driver);

        String email = "TestWeb"+ GetRandomInt() + "@test.com";
        String username = "TestWebName"+ GetRandomInt();
        String password = "TestWebPassword"+ GetRandomInt();

        register.SignUp(email, username, "919876543", password);
        //POM structure

        home.ConfirmRegist(username);

        home.gotoHomePage("www.google.pt");

        driver.close();
    }

    private static Integer GetRandomInt(){
        Random rand = new Random();
        return rand.nextInt(1000);
    }

    private static WebDriver ChromeDriver() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}