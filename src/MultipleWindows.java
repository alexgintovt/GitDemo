import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://accounts.google.com/signup");
        driver.findElement(By.xpath("//ul[@class='Bgzgmd']/li[1]")).click();
        System.out.println("Before Switching");
        //Prints parent page title
        System.out.println(driver.getTitle());

        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> it = windowIds.iterator();
        String parentId = it.next();
        String childId = it.next();

        System.out.println("After Switching");
        //Prints child page title
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());

        System.out.println("Switching back to parent");
        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());

    }
}
