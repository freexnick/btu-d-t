import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExampleTests {

    @Test
    public void firstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.xpath("//ul/li/a"));
        button.click();
        driver.navigate().back();
        driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[11]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/select/option[2]")).click();
        Thread.sleep(10000);
        driver.quit();
    }
}
