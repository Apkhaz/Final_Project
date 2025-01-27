package org.example;

import org.example.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.Utils;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.read("wait"))));
        PageFactory.initElements(driver, this);
    }

    // ვეითები
    public void waitForElementToBeClickable(WebElement locator){
        Utils.log("ველოდებით რომ ელემენტი [" + locator + "] იყოს დაკლიკებადი");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Utils.log("ვიპოვეთ ელემენტი [" + locator + "]");
    }

    public void waitForElementToBeVisible (WebElement locator){
        Utils.log("ველოდებით რომ ელემენტი [" + locator + "] გამოჩნდეს");
        wait.until(ExpectedConditions.visibilityOf(locator));
        Utils.log("გამოჩნდა ელემენტი [" + locator + "]");
    }

    // მეთოდები
    public String username = ConfigReader.get("username");
    public String password = ConfigReader.get("password");

    public void enterText (WebElement locator, String text){
        waitForElementToBeClickable(locator);
        locator.clear();
        locator.sendKeys(text);
        Utils.log("მოვძებნეთ ელემენტი [" + locator + "] და გადავეცით ტექსტი " + text);
    }

    public void clickElement (WebElement locator){
        waitForElementToBeVisible(locator);
        locator.click();
        Utils.log("დავაკლიკეთ ელემენტზე [" + locator + "]");
    }


    public String getElementText(WebElement locator) {
        waitForElementToBeVisible(locator);
        Utils.log("მოვძებნეთ ტექსტი" + locator);
        return locator.getText();
    }

    public String getCssValueOfBanner (WebElement locator, String bannerColor){
        waitForElementToBeVisible(locator);
        Utils.log("ვამოწმებთ ელემენტის [" + locator + "] ფერს");
        return locator.getCssValue(bannerColor);
    }

    public void scrollDown() {
        try {
            Thread.sleep(2000);  // დალოდება 2 წამით
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();  // Scrolls down twice
        Utils.log("ჩავსქროლეთ ქვემოთ");
    }

    public static void mouseMove() {
        try {
            Thread.sleep(8000);  // დალოდება 8 წამით
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // კურსორის გამოჩენა, ადგილმდებარეობის დასადგენად
        try {
            Robot robot = new Robot();
            Toolkit.getDefaultToolkit();
            Cursor.getDefaultCursor();

            int x = 100;  // X კოორდინატი
            int y = 400;  // Y კოორდინატი
            robot.mouseMove(x, y);

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);  // დალოდება 2 წამით
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
