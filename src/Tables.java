import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tables {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/29790/jt-vs-tkr-21st-match-caribbean-premier-league-2020");

        WebElement table = driver.findElement(By.cssSelector("div[id='innings_1'] div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int rowcount = table.findElements(By.cssSelector("div[id='innings_1'] div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
        int sum=0;

        for(int i=0; i<rowcount-3; i++){
            String value = table.findElements(By.cssSelector("div[id='innings_1'] div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            sum = sum + Integer.parseInt(value);
        }

        String extras = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
        int totalSum = sum + Integer.parseInt(extras);
        System.out.println(totalSum);
        int actualTotalSum = Integer.parseInt(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText());
        System.out.println(actualTotalSum);

        Assert.assertEquals(totalSum, actualTotalSum);

    }

}
