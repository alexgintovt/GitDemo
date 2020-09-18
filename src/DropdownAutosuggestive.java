import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownAutosuggestive {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com/");

        driver.findElement(By.id("fromCity")).click();
        driver.findElement(By.id("fromCity")).sendKeys("MUM");
        Thread.sleep(2000);
        driver.findElement(By.id("fromCity")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("fromCity")).sendKeys(Keys.ENTER);

    }
}
