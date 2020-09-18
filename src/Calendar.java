import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions");

        driver.findElement(By.id("ez-all-cookies")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='travel_date']")).click();

        //Requirement: Select 28th day of April in this or next year

        //While loop keeps on execution until it become false
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();

        }

        List<WebElement> dates = driver.findElements(By.className("day"));

        for (int i=7; i<dates.size(); i++){

            String date = dates.get(i).getText();
            if (date.equals("30")){
                dates.get(i).click();
                System.out.println(date);
                break;
            }
        }
    }
}
