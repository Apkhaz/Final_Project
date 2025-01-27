package ge.automation;

import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    // გაეშვას ყველა ტესტის თავში
    @BeforeMethod
    public void setUp(){
        driver = org.example.utils.DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://biletebi.ge/");
    }

    // გაეშვას ყველა ტესტის ბოლოს
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        DriverManager.quit();
    }
}
