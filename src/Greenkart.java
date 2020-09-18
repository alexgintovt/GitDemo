import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Greenkart {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");

        addItems(driver, itemsNeeded);

        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


    }

    public static void addItems(WebDriver driver, String[] itemsNeeded){

        List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int itemsCount = itemsNeeded.length;

        int j=0;
        for (int i=0; i< products.size(); i++){
            String[] product = products.get(i).getText().split("-");
            String formattedProduct = product[0].trim();
            //check whether item is present in itemsNeeded list
            //convert array into arraylist for easy search "contain"

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedProduct)){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;
                if (j==itemsCount){
                    break;
                }
            }
        }

    }
}
