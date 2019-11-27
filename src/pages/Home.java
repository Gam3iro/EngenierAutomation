package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private WebDriver driver;

    private By takeTourButton = By.xpath("//div[@class='welcomesection']/div/button");
    private By skipTourButton = By.xpath("//div[@class='contentholder active']/div[@class='letsskip']/button");
    private By closePopUp = By.xpath("//*[@class='trademark-strip']//*[@class='icon-cancel']");
    private By currencyDropdown = By.className("sel_state");
    private By selectCurrency = By.className("doneButton");
    private By discountPopup = By.xpath("//*[@class='discountTooltip active']//div[@class='closeButton']");
    private By loginButton = By.xpath("//*[@class='loginPanel']//button");
    private By registerButton = By.xpath("//*[@class='loginDropdown']//*[contains(text(),'Register')]");
    private By usernameMenuText = By.xpath("//*[@class='userPanel']//strong");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void Navigate(){
        driver.get("https://staging.engineer.ai");
    }

    public void TakeAndSkipTou(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(takeTourButton)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(skipTourButton)).click();
    }

    public void SelectCurrrency(String currency){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(closePopUp)).click();

        driver.findElement(currencyDropdown).click();
        driver.findElement(By.xpath("//[@class='currencyName][text()='" + currency + "']")).click();
    }

    public void ProceedToSignUp(){
        new WebDriverWait(driver, 35).until(ExpectedConditions.elementToBeClickable(discountPopup)).click();

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        driver.findElement(registerButton).click();
    }

    public void ConfirmRegist(String username){
        new WebDriverWait(driver, 25).until(ExpectedConditions.elementToBeClickable(selectCurrency)).click();

        WebElement userDropdown = driver.findElement(usernameMenuText);
        assert userDropdown.getText().equals(username): "Registered user " + username + " is not the same as in home page: " + userDropdown.getText();
        assert driver.getCurrentUrl().equals("https://staging.engineer.ai/home") : "Url did not match";
    }

    public void gotoHomePage(String url){
        driver.get(url);
    }
}