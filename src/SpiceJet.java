import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpiceJet {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://spicejet.com/");
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement((By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='PNQ']"))).click();

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        String enabledStyle = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(enabledStyle);
        Assert.assertTrue(enabledStyle.contains("1"));

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        String disabledStyle = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(disabledStyle);
        Assert.assertTrue(disabledStyle.contains("0.5"));

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();

        driver.findElement(By.id("divpaxinfo")).click();
        Select adult = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        adult.selectByValue("4");

        Select ccy = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")));
        ccy.selectByVisibleText("USD");

        driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

    }
}

