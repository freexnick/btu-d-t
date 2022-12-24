import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    WebDriverWait wait;
    WebDriver driver;
    JavascriptExecutor js;
    @Given("browser is open")
    public void browserIsOpen() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("user is on login page")
    public void userIsOnLoginPage() {

        driver.get("https://demoqa.com/login");
    }

    @Then("users enters username and password")
    public void usersEntersUsernameAndPassword() {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        //login
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userName"))));
        WebElement userName= driver.findElement(By.id("userName")),
                pass= driver.findElement(By.id("password")),
                login= driver.findElement(By.id("login"));

        userName.sendKeys("test123");
        pass.sendKeys("Automation@123");
        js.executeScript("arguments[0].scrollIntoView(true);", login);
        login.click();
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {
        System.out.println("This is a home page");
    }

    @Then("users enters {string} and {string}")
    public void usersEntersAnd(String username,String password) {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        //login
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userName"))));
        WebElement userName= driver.findElement(By.id("userName")),
                pass= driver.findElement(By.id("password")),
                login= driver.findElement(By.id("login"));

        userName.sendKeys(username);
        pass.sendKeys(password);
        js.executeScript("arguments[0].scrollIntoView(true);", login);
        login.click();
    }
}


