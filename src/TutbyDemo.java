import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TutbyDemo {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gint\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://mail.tut.by");
        driver.findElement(By.cssSelector("#Username")).sendKeys("admin");
        driver.findElement(By.cssSelector("[id='Password']")).sendKeys("admin");
        driver.findElement(By.cssSelector(".button.loginButton.gradientforbutton")).click();
        System.out.println(driver.findElement(By.cssSelector(".graiLight")).getText());
        System.out.println(driver.findElement(By.xpath("//form[@id='form']//fieldset//strong")).getText());

//        driver.findElement(By.xpath("//a[@class='user-account user-account_left-name user-account_has-ticker_yes user-account_has-accent-letter_yes count-me legouser__current-account legouser__current-account i-bem']//img[@class='user-pic__image']")).click();
//        driver.findElement(By.xpath("//a[@class='menu__item menu__item_type_link count-me legouser__menu-item legouser__menu-item_action_exit legouser__menu-item legouser__menu-item_action_exit']//span[@class='menu__text']")).click();
        driver.quit();

    }
}
