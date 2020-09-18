import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int columnSize = columndriver.findElements(By.tagName("a")).size();
        System.out.println(columnSize);

        for (int i=1; i<columnSize; i++) {

            String openTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(openTab);

        }

        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> it = windowIds.iterator();
        it.next();

        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

/*        **Alternative loop**
            for(int i=1; i<windowIds.size(); i++){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }*/

    }
}
