package amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class RozetkaTest {

    @Test
    public void checkTestRozetka() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        sleep(3000);

        driver.findElement(By.xpath("//button[@id='fat-menu']")).click();
        sleep(3000);
        driver.findElement(By.xpath("//button[@id='fat-menu']")).click();
    }
}
