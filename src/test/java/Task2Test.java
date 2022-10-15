import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2Test {

  @Test
  public void secondTest() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/progress-bar");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/button")).click();
    new WebDriverWait(driver,
        Duration.ofSeconds(60)).until(
            ExpectedConditions.textToBe(
                By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div"), "100%"));
    System.out.println("100%");
    driver.quit();
  }
}
