package amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class TestQA {
    @Test(priority = 1)
    public void checkTextBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box/");
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Max 23");
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']"))
                .sendKeys("12345@gmail.com");
        driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"))
                .sendKeys("Lutsk, Volunskaya oblast");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']"))
                .sendKeys("Address qwerty");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        sleep(2000);

        assertTrue(driver.findElement(By.xpath("//p[@id='name']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='email']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='currentAddress']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='permanentAddress']")).isDisplayed());

        driver.quit();
    }

    @Test
    public void testCheck() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[1]")).click();
        sleep(2000);
        driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']//li[3]//button")).click();
        sleep(2000);
        driver.findElement(By.xpath("//label[@for='tree-node-excelFile']//span[@class='rct-checkbox']")).click();

        assertTrue(driver.findElement(By.xpath("//div[@id='result']")).isDisplayed());

        driver.quit();
    }

    @Test
    public void checkRadioButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        assertEquals(driver.findElement(By.xpath("//div[@class='main-header']")).getText(), "Radio Button");

        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

        assertEquals(driver.findElement(By.xpath("//span[@class='text-success']")).getText(), "Yes");

        driver.findElement(By.xpath("//label[@for='impressiveRadio'] ")).click();

        assertEquals(driver.findElement(By.xpath("//span[@class='text-success']")).getText(), "Impressive");

        driver.findElement(By.xpath("//label[@class='custom-control-label disabled']")).click();

        assertNotEquals(driver.findElement(By.xpath("//span[@class='text-success']")).getText(), "No");

        //driver.quit();
    }

    @Test
    public void checkWebTables() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        //sleep(2000);
        driver.findElement(By.xpath("//div[@class='avatar mx-auto white']")).click();
        //sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//li[@id='item-3']")).click();

        assertEquals(driver.findElement(By.xpath("//div[@class='main-header']")).getText(), "Web Tables");

        driver.findElement(By.xpath("//span[@id='delete-record-3']")).click();
        sleep(1000);

        driver.findElement(By.xpath("//span[@id='delete-record-2']")).click();
        sleep(1000);
        driver.findElement(By.xpath("//span[@id='edit-record-1']")).click();

        driver.findElement(By.xpath("//input[@value='Cierra']")).clear();
        sleep(1000);
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Max");

        driver.findElement(By.xpath("//input[@value='Vega']")).clear();
        sleep(1000);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("QATest");

        driver.findElement(By.xpath("//input[@value='cierra@example.com']")).clear();
        sleep(1000);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("12345@gmail.com");

        driver.findElement(By.xpath("//input[@value='39']")).clear();
        sleep(1000);
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("20");

        driver.findElement(By.xpath("//input[@value='10000']")).clear();
        sleep(1000);
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("12345");

        driver.findElement(By.xpath("//input[@value='Insurance']")).clear();
        sleep(1000);
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("TestClub");
        sleep(1000);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        //driver.quit();

        assertEquals(driver.findElement(By.xpath("//div[@class='rt-td']")).getText(), "Max");
        assertEquals(driver.findElement(By.xpath("//div[@class='rt-td'][2]")).getText(), "QATest");
        assertEquals(driver.findElement(By.xpath("//div[@class='rt-td'][3]")).getText(), "20");
        assertEquals(driver.findElement(By.xpath("//div[@class='rt-td'][4]")).getText(), "12345@gmail.com");
        assertEquals(driver.findElement(By.xpath("//div[@class='rt-td'][5]")).getText(), "12345");
        assertEquals(driver.findElement(By.xpath("//div[@class='rt-td'][6]")).getText(), "TestClub");
    }

    @Test //(enabled = false)
    public void checkButtons() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        Actions actions = new Actions(driver);
        WebElement element2 = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        actions.contextClick(element2).perform();

        WebElement element1 = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(element1).build().perform();

        sleep(2000);
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        assertEquals(driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText(), "You have done a double click");
        assertEquals(driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText(), "You have done a right click");
        assertEquals(driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText(), "You have done a dynamic click");
    }

    @Test
    public void testLinks() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
        driver.findElement(By.xpath("//a[@id='simpleLink']")).click();
        sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        String currentTab = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@id='simpleLink']")).click();

        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();

        assertEquals(actualTitle, expectedTitle);

        driver.switchTo().window(currentTab);
        driver.findElement(By.xpath("//a[@id='dynamicLink']")).click();

        assertEquals(actualTitle, expectedTitle);

        driver.switchTo().window(currentTab);
        driver.findElement(By.xpath("//a[@id='created']")).click();
        sleep(2000);
        String resultCreated = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        assertTrue(resultCreated.contains("201") && (resultCreated.contains("Created")));

        driver.findElement(By.xpath("//a[@id='no-content']")).click();
        sleep(3000);
        String resultContent = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        assertTrue(resultContent.contains("204") && (resultContent.contains("No Content")));

        driver.findElement(By.xpath("//a[@id='moved']")).click();
        sleep(2000);
        String resultMoved = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        assertTrue(resultMoved.contains("301") && (resultMoved.contains("Moved Permanently")));

        driver.findElement(By.xpath("//a[@id='bad-request']")).click();
        sleep(2000);
        String resultBadRequest = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        assertTrue(resultBadRequest.contains("400") && (resultBadRequest.contains("Bad Request")));

        driver.findElement(By.xpath("//a[@id='unauthorized']")).click();
        sleep(2000);
        String resultUnauthorized = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        assertTrue(resultUnauthorized.contains("401") && (resultUnauthorized.contains("Unauthorized")));

        driver.findElement(By.xpath("//a[@id='forbidden']")).click();
        sleep(2000);
        String resultForbbiden = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        assertTrue(resultForbbiden.contains("403") && (resultForbbiden.contains("Forbidden")));

        driver.findElement(By.xpath("//a[@id='invalid-url']")).click();
        sleep(2000);
        String resultNotFound = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        assertTrue(resultNotFound.contains("404") && (resultNotFound.contains("Not Found")));

        driver.quit();
    }

    @Test
    public void brokenListImages() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        sleep(1000);
        driver.findElement(By.xpath("//div[@class='card-up'][1]")).click();
        sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.xpath("//li[@id='item-6'][1]")).click();

        assertTrue(driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-3']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//img[@src='/images/Toolsqa.jpg'])[2]")).isDisplayed());

        js.executeScript("window.scrollBy(0,250)", "");

        String currentTables = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href='http://demoqa.com']")).click();

        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();

        assertEquals(actualTitle, expectedTitle);
        driver.navigate().back();
    }
}