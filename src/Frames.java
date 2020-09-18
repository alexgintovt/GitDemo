import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable");

        WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(frame);
        driver.findElement(By.id("draggable")).click();

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();

        driver.switchTo().defaultContent();

    }
}
