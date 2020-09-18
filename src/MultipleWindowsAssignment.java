import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsAssignment {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//div[@class='example']/a")).click();

/*        System.out.println("Before switching");
        System.out.println(driver.getTitle());*/

        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> it = windowIds.iterator();
        String parentId = it.next();
        String childId = it.next();

        System.out.println("Switch 1");
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

        System.out.println("Switch 2");
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
    }
}
