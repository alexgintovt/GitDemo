import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutosuggestSelector {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("bel");
        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.id("autosuggest"));
        for (WebElement option : options){

            option.click();
            break;
        }



    }
}
