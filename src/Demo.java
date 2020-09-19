import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {


    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

/*        driver.get("http://google.com"); // navigate to url
        System.out.println(driver.getTitle()); //validate if your page title is correct

        System.out.println(driver.getCurrentUrl()); // validate you are landed on correct url

        System.out.println(driver.getPageSource());

        driver.get("http://yahoo.com");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        driver.close(); //closes current browser
        driver.quit(); // closes all the browsers opened by selenium script*/

 /*       driver.get("http://login.salesforce.com");
        driver.findElement(By.cssSelector("input#username")).sendKeys("emailaddress");
        driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
        System.out.println(driver.findElement(By.cssSelector("#error")).getText());*/

        driver.get("http://facebook.com");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("emailaddress");
        driver.findElement(By.cssSelector("input[id*='pass']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[contains(@data-testid='login')]")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText());

        System.out.println("end of test!");

    }

    //Create Driver object for Chrome browser


}
