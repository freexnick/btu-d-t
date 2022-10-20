import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Quiz {
  WebDriver driver;

  public Quiz() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Test
  public void auth() {
    driver.get("https://demoqa.com/login");
    driver.manage().window().maximize();
    driver.findElement(By.id("userName")).sendKeys("test123");
    driver.findElement(By.id("password")).sendKeys("Automation@123");
    driver.findElement(By.id("login")).click();
    new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
  }

  public List<WebElement> checkBooks() {
    return new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.numberOfElementsToBe(By.className("action-buttons"), 8));
  }

  @Test
  public void books() {
    new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.id("gotoStore")))
        .click();
    checkBooks();
    driver.findElement(By.linkText("Git Pocket Guide")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='title-wrapper']/div[2]/label")).getText(),
        "Git Pocket Guide");
    driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")).click();
    new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    Alert bookAlert = driver.switchTo().alert();
    Assert.assertEquals(bookAlert.getText(), "Book already present in the your collection!");
    bookAlert.dismiss();
    driver.navigate().back();
    checkBooks();
  }

  @Test
  public void logout() throws InterruptedException {
    driver.findElement(By.id("submit")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='userForm']/div[1]/h5")).getText(), "Login in Book Store");
    Thread.sleep(5000);
    driver.quit();
  }

}