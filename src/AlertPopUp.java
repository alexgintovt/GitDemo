import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AlertPopUp {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String name = "Alex Gintovt";
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());

        Assert.assertTrue(driver.switchTo().alert().getText().contains(name));
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());

        Assert.assertTrue(driver.switchTo().alert().getText().contains(name));
        driver.switchTo().alert().dismiss();

    }
}
