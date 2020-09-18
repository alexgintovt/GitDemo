import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicSelector {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://en.belavia.by/");
        driver.findElement(By.xpath("//label[@for='OriginLocation_Combobox']")).click();
        driver.findElement(By.id("OriginLocation_Combobox")).sendKeys("min");

        List<WebElement> origins = driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));

        for (WebElement origin : origins){
            if(origin.getText().equalsIgnoreCase("Minsk (MSQ), BY")) {
                origin.click();
                break;
            }
        }

        driver.findElement(By.xpath("//label[@for='DestinationLocation_Combobox']")).click();
        driver.findElement(By.id("DestinationLocation_Combobox")).sendKeys("st");

        List<WebElement> destinations = driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));

        for (WebElement destination : destinations){
            if(destination.getText().equalsIgnoreCase("St Petersburg (LED), RU")) {
                destination.click();
                break;
            }
        }

        driver.findElement(By.cssSelector(".icon-calendar")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();


/*
        driver.findElement(By.xpath("//a[@id='ui-id-1']")).click();
        Thread.sleep(2000L);

                driver.findElement(By.xpath("(//*[@class='icon-plus'])[2]")).click();


                System.out.println(driver.findElement(By.xpath("(//span[@class='value'])[2]")).getText() +
                        " " + driver.findElement(By.xpath("(//span[@class='type'])[2]")).getText() +
                        " " + driver.findElement(By.xpath("(//span[@class='ages'])[2]")).getText());
*/

    }
}
