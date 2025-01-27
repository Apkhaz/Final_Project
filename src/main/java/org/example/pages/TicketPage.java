package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketPage extends BasePage {

    public TicketPage(WebDriver driver) {
        super(driver);
    }

    // ელემენტების ძებნა
    @FindBy(xpath = "(//div[contains(@data-testid,'filter_tagფილტრები')])[1]")
    WebElement filterDropdownMenu;

    @FindBy(xpath = "//div[@class='sc-9e2bf7de-2 etPpvf']//label[@for='movie_sessions_day_Morning']//span")
    WebElement daytimeSession;

    // მეთოდები
    public void setFilterDropdownMenu(){
        waitForElementToBeClickable(filterDropdownMenu);
        clickElement(filterDropdownMenu);
    }

    public void selectDaytimeSession (){
        waitForElementToBeVisible(daytimeSession);
        clickElement(daytimeSession);
    }

}
