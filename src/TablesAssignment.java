import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TablesAssignment {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        WebElement table = driver.findElement(By.id("product"));

        int rowcount = table.findElements(By.tagName("tr")).size();
        System.out.println("rows: " + rowcount);

        int columncount = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
        System.out.println("columns: " + columncount);

        //System.out.println(table.findElement(By.xpath("//table[@id='product']//tbody//tr[3]")).getText());

        List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

        for (int i=0; i<columncount; i++){
            System.out.println(secondrow.get(i).getText());
        }
    }
}
