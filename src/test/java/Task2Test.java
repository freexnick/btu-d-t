import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;
import java.util.List;

public class Task2Test {
  WebDriver driver;

  public Task2Test() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Test
  public void progressBar() {
    driver.get("https://demoqa.com/progress-bar");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/button")).click();
    new WebDriverWait(driver,
        Duration.ofSeconds(60)).until(
            ExpectedConditions.textToBe(
                By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div"), "100%"));
    System.out.println("100%");
  }

  @Test
  public void select() throws InterruptedException {
    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    driver.manage().window().maximize();
    WebElement dropdownJS = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/select[3]/option[3]"));
    dropdownJS.click();
    Assert.assertTrue(dropdownJS.isSelected());
    List<WebElement> checkboxes = driver
        .findElements(By.xpath("//input[@type='checkbox' and not(@checked)]"));
    for (int i = 0; i < checkboxes.size(); i++) {
      checkboxes.get(i).click();
    }
    driver.findElement(By.xpath("/html/body/div/div[4]/div/div/form/input[5]")).click();
    Assert.assertFalse(driver.findElement(By.xpath("/html/body/div/div[5]/div/div/select/option[2]")).isEnabled());
    Thread.sleep(10000);
    driver.quit();
  }

}
