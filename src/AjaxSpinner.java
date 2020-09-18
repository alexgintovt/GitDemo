import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxSpinner {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

        driver.findElement(By.cssSelector("a[href*='loadAjax']")).click();

        WebDriverWait waitSpinner = new WebDriverWait(driver, 5);
        waitSpinner.until(ExpectedConditions.elementToBeClickable(By.id("results")));
        System.out.println(driver.findElement(By.id("results")).getText());
    }

}
