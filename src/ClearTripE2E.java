import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClearTripE2E {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("OneWay")).click();
        Thread.sleep(10000L);
        driver.findElement(By.id("DepartDate")).click();
        Thread.sleep(3000L);
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

        driver.findElement(By.id("FromTag")).sendKeys("bang");
        Thread.sleep(3000L);
        List <WebElement> fromTag = driver.findElements(By.xpath("//ul[@id='ui-id-1'] //li"));
        for (WebElement fromOption : fromTag){
            if (fromOption.getText().contains("Bangkok")) {
                fromOption.click();
                break;
            }
        }

        Select adult = new Select(driver.findElement(By.id("Adults")));
        adult.selectByValue("2");
        Select child = new Select(driver.findElement(By.id("Childrens")));
        child.selectByValue("1");
        Select infant = new Select(driver.findElement(By.id("Infants")));
        infant.selectByValue("1");

        driver.findElement(By.id("MoreOptionsLink")).click();

        Select cabinClass = new Select(driver.findElement(By.id("Class")));
        cabinClass.selectByValue("Business");

        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("British Airways");

        driver.findElement(By.id("SearchBtn")).click();

        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

    }
}
