import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownAutosuggestiveAssignment {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).click();
        driver.findElement(By.id("autocomplete")).clear();
        String text1 = driver.findElement(By.id("autocomplete")).getAttribute("value");
        driver.findElement(By.id("autocomplete")).sendKeys("united");
        Thread.sleep(2000);

        int j=0;
        while(!text1.equalsIgnoreCase("United Kingdom (UK)")) {
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
            text1 = driver.findElement(By.id("autocomplete")).getAttribute("value");
            j++;
            if (j>10){
                System.out.println("Country not found");
                break;
            }
        }

        System.out.println(text1);

        driver.findElement(By.id("autocomplete")).clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"autocomplete\").value;";
        String text2 =(String) js.executeScript(script);

        driver.findElement(By.id("autocomplete")).sendKeys("bel");

        for (int i=0; i<10; i++){
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
            text2 = (String) js.executeScript(script);

            if (text2.equalsIgnoreCase("Belarus")){
                System.out.println(text2);
                break;
            }

        }


    }
}
