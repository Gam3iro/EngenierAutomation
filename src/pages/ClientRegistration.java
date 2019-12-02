package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientRegistration {
    private WebDriver driver;

    private  By emailSet = By.name("signup_email");
    private  By signUpNextButton = By.xpath("//button[contains(@class,'signUpNextButtonClass')]");
    private  By usernameSet = By.name("firstlastname");
    private  By phoneSet = By.xpath("//input[@placeholder='Mobile Number']");
    private  By signUpPassword = By.name("signup_password");
    private  By submitButton = By.xpath("//button[@class='submitButton']");

    public ClientRegistration(WebDriver driver){
        this.driver = driver;
    }

    public void signUp(String email, String username, String phoneNumber, String password){
        driver.findElement(emailSet).sendKeys(email);
        driver.findElement(signUpNextButton).click();

        driver.findElement(usernameSet).sendKeys(username);
        driver.findElement(phoneSet).sendKeys(phoneNumber);
        driver.findElement(signUpPassword).sendKeys(password);

        driver.findElement(submitButton).click();
    }
}
