package amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class RozetkaTest {

    @Test
    public void checkTestRoz() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        sleep(3000);

        driver.findElement(By.xpath("//button[@id='fat-menu']")).click();
        sleep(3000);
        driver.findElement(By.xpath("//button[@id='fat-menu']")).click();
       // driver.findElement(By.xpath("//input[@placeholder='Я ищу...']")).sendKeys("iphone 14 pro max");
       // driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")).click();


    }
}