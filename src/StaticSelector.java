import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticSelector {

    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        Select selector = new Select(driver.findElement(By.id("dropdown-class-example")));
        selector.selectByValue("option2");
        selector.selectByIndex(1);
        selector.selectByVisibleText("Option3");

    }
}
