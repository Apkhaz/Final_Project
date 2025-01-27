package ge.automation.tests;

import ge.automation.BaseTest;
import org.example.BasePage;
import org.example.pages.BuySkiingTicket;
import org.example.pages.EditProfile;
import org.example.pages.LoginPage;
import org.example.pages.TicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends BaseTest {

    @Test
    public void testLoginWithValidCredentials(){
        // ინიციალიზაცია
        LoginPage loginPage = new LoginPage(driver);

        // ავტორიზაცია იუზერით და პაროლით & შემოწმება
        loginPage.setAcceptCookies();
        loginPage.login ();
        String expectedUrl = "https://biletebi.ge/";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "არასწორი მისამართი");

    }

    @Test
    public void testTurningOnOffTrailer() {
        // ინიციალიზაცია
        LoginPage loginPage = new LoginPage(driver);

        // თრეილერის გახსნა და დახურვა
        loginPage.setAcceptCookies();
        loginPage.turnOnOffTrailer();

    }

    @Test
    public void fillProfileDetails(){
        // ინიციალიზაცია
        LoginPage loginPage = new LoginPage(driver);

        // ავტორიზაცია იუზერით და პაროლით
        loginPage.setAcceptCookies();
        loginPage.login ();
        String expectedUrl = "https://biletebi.ge/";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "არასწორი მისამართი");

        // ინიციალიზაცია
        EditProfile editProfile = new EditProfile(driver);

        // შემოწმება & სახელისა და გვარის შევსება
        loginPage.editProfile();
        String expectedText = "ჩემი პროფილი";
        String currentText = editProfile.getMyProfile();
        Assert.assertEquals(currentText,expectedText, "ტექსტი არ ემთხვევა");
        editProfile.fillDetails("მარიამი","აფხაზავა");

    }

    @Test
    public void changeLanguageOfPage(){
        // ინიციალიზაცია
        LoginPage loginPage = new LoginPage(driver);

        // გვერდზე ენის შეცვლა & შემოწმება
        loginPage.setAcceptCookies();
        loginPage.changeLanguage();
        String expectedText = "Event";
        String currentText = loginPage.textTranslatedInEnglish();
        Assert.assertEquals(currentText,expectedText, "ტექსტი არ ემთხვევა");

    }

    @Test
    public void searchForDesiredTopic(){
        // ინიციალიზაცია
        LoginPage loginPage = new LoginPage(driver);

        // ფილმის ძიება & შემოწმება
        loginPage.setAcceptCookies();
        loginPage.searchTopic("მეფე ლომი");
        String expectedText = "მუფასა: მეფე ლომი";
        String currentText = loginPage.foundTopicInSearch();
        Assert.assertEquals(currentText,expectedText, "ტექსტი არ ემთხვევა");

    }

    @Test
    public void testBannerColor(){
        // ინიციალიზაცია
        LoginPage loginPage = new LoginPage(driver);

        // ბანერის ფერის შემოწმება
        loginPage.setAcceptCookies();
        String expectedColor = "rgba(23, 23, 28, 1)";
        String actualColor = loginPage.getBannerColor();
        Assert.assertEquals(actualColor,expectedColor, "ფერი არ ემთხვევა");

    }

    @Test
    public void testDropdownMenu (){
        // ინიციალიზაცია
        LoginPage loginPage = new LoginPage(driver);
        TicketPage ticketPage = new TicketPage(driver);
        BasePage basePage = new BasePage(driver);

        // ჩამოსაშლელი მენიუს შემოწმება
        loginPage.setAcceptCookies();
        loginPage.clickOnMovieIcon();
        ticketPage.setFilterDropdownMenu();
        ticketPage.selectDaytimeSession();
        ticketPage.setFilterDropdownMenu();
        basePage.scrollDown();

    }

    @Test
    public void buySkiingTicket() {
        // ინიციალიზაცია
        LoginPage loginPage = new LoginPage(driver);
        BuySkiingTicket buySkiingTicket = new BuySkiingTicket(driver);

        // აბონემენტის დეტალების არჩევა & ავტორიზაცია & შემოწმება
        loginPage.setAcceptCookies();
        loginPage.clickSkiingIcon();
        buySkiingTicket.selectGudauri();
        buySkiingTicket.clickSkiingDropdownMenu();
        buySkiingTicket.chooseQuantityOfDays();
        buySkiingTicket.setSelectForAdult();
        buySkiingTicket.setIncreaseNumber();
        buySkiingTicket.setBuyButton();
        buySkiingTicket.login ();
        String expectedText = "ჩემი აბონემენტები";
        String currentText = buySkiingTicket.myTicketsPage();
        Assert.assertEquals(currentText,expectedText, "ტექსტი არ ემთხვევა");

    }
}
