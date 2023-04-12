package amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestQA {
    @Test
    public void checkTextBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box/");
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Max 23");
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys("12345@gmail.com");
        driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("Lutsk, Volunskaya oblast");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Address qwerty");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='name']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='email']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='currentAddress']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='permanentAddress']")).isDisplayed());
    }
    @Test
    public void TestCheck() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[1]")).click();
        sleep(2000);
        driver.findElement(By.xpath("//li[@class=\"rct-node rct-node-parent rct-node-expanded\"]//li[3]//button")).click();
        sleep(2000);
        driver.findElement(By.xpath("//label[@for='tree-node-excelFile']//span[@class='rct-checkbox']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result']")).isDisplayed());
        driver.quit();

    }

}
