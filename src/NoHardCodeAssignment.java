import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class NoHardCodeAssignment {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkboxArea = driver.findElement(By.id("checkbox-example"));
        List<WebElement> options = checkboxArea.findElements(By.tagName("label"));
        int i = (int) Math.random()*(options.size()-1);
        WebElement option = options.get(i);
        String optionText = option.getText();
        System.out.println(optionText);
        option.findElement(By.tagName("input")).click();

        Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdown.selectByVisibleText(optionText);

        driver.findElement(By.id("name")).sendKeys(optionText);
        driver.findElement(By.id("alertbtn")).click();

        System.out.println(driver.switchTo().alert().getText());
        Assert.assertTrue(driver.switchTo().alert().getText().contains(optionText));

        driver.switchTo().alert().dismiss();

    }

}
