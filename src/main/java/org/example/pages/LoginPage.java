package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // ელემენტების ძებნა
    @FindBy(xpath = "(//button[@class='sc-d211050a-0 dwOlyE'])[1]")
    WebElement enter;

    @FindBy(xpath = "(//input[contains(@placeholder,'ტელეფონი ან ელ.ფოსტა')])[1]")
    WebElement usernameField;

    @FindBy(xpath = "(//input[@placeholder='პაროლი'])[1]")
    WebElement passwordField;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement loginButton;

    @FindBy(xpath = "(//div[@class='sc-ad992dcf-3 foSBOj'])[1]")
    WebElement clickUserIcon;

    @FindBy(xpath = "(//a[normalize-space()='Eng'])[1]")
    WebElement changeLanguageButton;

    @FindBy(xpath = "(//span[normalize-space()='Event'])[1]")
    WebElement textInEnglish;

    @FindBy(xpath = "(//input[@placeholder='ძებნა'])[1]")
    WebElement searchField;

    @FindBy(xpath = "(//*[name()='svg'][@fill='none'])[2]")
    WebElement searchMagnifyingGlass;

    @FindBy(xpath = "(//span[@class='sc-f3c9326f-0 jKNwel'])[1]")
    WebElement foundTopic;

    @FindBy(xpath = "(//div[@class='sc-ad992dcf-0 lhJDlG header-container'])[1]")
    WebElement banner;

    @FindBy(xpath = "(//div[@class='sc-9d68623d-1 bWVDGh'])[2]")
    WebElement clickMovieIcon;

    @FindBy(xpath = "//span[@class='sc-f3c9326f-0 ljJyOT']")
    WebElement acceptCookies;

    @FindBy(xpath = "//span[@class='sc-f3c9326f-0 hVXjVZ'][contains(text(),'მთა')]")
    WebElement skiing;

    @FindBy(xpath = "(//div[@class='sc-944ffd45-2 CvNLm'])[1]")
    WebElement pressPlayerIcon;

    // მეთოდები
    public void login () {
        clickElement(enter);
        enterText(usernameField, username);
        enterText(passwordField, password);
        waitForElementToBeClickable(loginButton);
        clickElement(loginButton);
    }

    public void editProfile(){
        waitForElementToBeClickable(clickUserIcon);
        clickElement(clickUserIcon);
    }

    public void changeLanguage(){
        waitForElementToBeClickable(changeLanguageButton);
        clickElement(changeLanguageButton);
    }

    public String textTranslatedInEnglish(){
        return getElementText(textInEnglish);
    }

    public void searchTopic(String topic){
        clickElement(searchField);
        enterText(searchField,topic);
        clickElement(searchMagnifyingGlass);
    }

    public String foundTopicInSearch(){
        return getElementText(foundTopic);
    }

    public String getBannerColor(){
        return getCssValueOfBanner(banner, "background-color");
    }

    public void clickOnMovieIcon(){
        waitForElementToBeVisible(clickMovieIcon);
        clickElement(clickMovieIcon);
    }

    public void setAcceptCookies(){
        waitForElementToBeClickable(acceptCookies);
        clickElement(acceptCookies);
    }

    public void clickSkiingIcon(){
        waitForElementToBeVisible(skiing);
        clickElement(skiing);
    }

    public void turnOnOffTrailer(){
        waitForElementToBeVisible(pressPlayerIcon);
        clickElement(pressPlayerIcon);
        mouseMove();
    }

}
