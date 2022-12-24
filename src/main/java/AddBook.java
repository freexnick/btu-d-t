import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

public class AddBook {
    WebDriver driver;
    WebDriverWait wait;
    @Given("chrome browser is open")
    public void chromeBrowserIsOpen() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @When("user is on log in page")
    public void userIsOnLogInPage() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        driver.get("https://demoqa.com/login");
    }
    @When("user enters credentials")
    public void userEntersCredentials() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        WebElement userName = driver.findElement(By.id("userName"));
        WebElement pwd = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login"));
        userName.sendKeys("test123");
        pwd.sendKeys("Automation@123");
        login.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"submit\"]"),"Log out"));
    }
    @When("user goes to book store")
    public void userGoesToBookStore() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        WebElement bookStore = driver.findElement(By.id("gotoStore"));
        bookStore.click();

    }
    @When("user clicks on Git Pocket Guide button")
    public void userChoosesBook() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Thread.sleep(5000);
        WebElement gitGuide = driver.findElement(By.id("see-book-Git Pocket Guide"));
        gitGuide.click();

    }
    @When("user clicks on Add to your collection")
    public void userAddsBookToCollection() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        WebElement addCollection = driver.findElement(By.id("addNewRecordButton"));
        addCollection.click();
    }
}
