package amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAmazon {

    @Test
    public void checkSearchOnAmazon() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();
        driver.findElement(By.xpath(""));
        Assert.assertTrue(driver.getCurrentUrl().contains("iPhone+13+case"));
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'iPhone 13')]")).isDisplayed());
        Assert.assertTrue((driver.getTitle().contains("iPhone 13")));
        driver.quit();
    }
}

