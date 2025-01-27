package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuySkiingTicket extends BasePage {

    public BuySkiingTicket(WebDriver driver){ super(driver);}

    // ელემენტების ძებნა
    @FindBy(xpath = "(//div[@data-testid='selectable_item_gudauri'])[1]")
    WebElement gudauri;

    @FindBy(xpath = "(//*[name()='svg'][@fill='none'])[7]")
    WebElement skiingDropdown;

    @FindBy(xpath = "(//span[contains(text(),'გუდაური 2 დღე')])[1]")
    WebElement twoDays;

    @FindBy(xpath = "(//button[@class='sc-d211050a-0 iCWxso'])[1]")
    WebElement selectForAdult;

    @FindBy(xpath = "//div[@data-testid='ski_buckets_quantity_numbers_plus']//*[name()='svg']")
    WebElement increaseNumber;

    @FindBy(xpath = "(//button[@class='sc-d211050a-0 jRnlGd'])[1]")
    WebElement buyButton;

    @FindBy(xpath = "//input[@placeholder=' ტელეფონი ან ელ.ფოსტა']")
    WebElement usernameSkiingPage;

    @FindBy(xpath = "//input[@placeholder='პაროლი']")
    WebElement passwordSkiingPage;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButtonSkiingPage;

    @FindBy(xpath = "(//span[contains(text(),'ჩემი აბონემენტები')])[1]")
    WebElement myTickets;

    // მეთოდები
    public void selectGudauri(){
        waitForElementToBeClickable(gudauri);
        clickElement(gudauri);

    }

    public void clickSkiingDropdownMenu(){
        waitForElementToBeVisible(skiingDropdown);
        clickElement(skiingDropdown);
    }

    public void chooseQuantityOfDays(){
        waitForElementToBeVisible(twoDays);
        clickElement(twoDays);
    }

    public void setSelectForAdult(){
        waitForElementToBeClickable(selectForAdult);
        clickElement(selectForAdult);
    }

    public void setIncreaseNumber(){
        waitForElementToBeClickable(increaseNumber);
        clickElement(increaseNumber);
    }

    public void setBuyButton(){
        waitForElementToBeClickable(buyButton);
        clickElement(buyButton);
    }

    public void login (){

        enterText(usernameSkiingPage, username);
        enterText(passwordSkiingPage, password);
        waitForElementToBeClickable(loginButtonSkiingPage);
        clickElement(loginButtonSkiingPage);
    }

    public String myTicketsPage(){
        return getElementText(myTickets);
    }
}
