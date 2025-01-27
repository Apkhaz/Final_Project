package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfile extends BasePage {

    public EditProfile (WebDriver driver) {
        super(driver);
    }

    // ელემენტების ძებნა
    @FindBy(xpath = "(//h5[contains(text(),'ჩემი პროფილი')])[1]")
    WebElement myProfile;

    @FindBy(xpath = "(//*[name()='svg'])[18]")
    WebElement clickNameAddButton;

    @FindBy(xpath = "(//input[@name='firstName'])[1]")
    WebElement enterName;

    @FindBy(xpath = "(//*[name()='svg'][@fill='none'])[18]")
    WebElement clickLastnameAddButton;

    @FindBy(xpath = "(//input[@name='lastName'])[1]")
    WebElement enterLastname;

    @FindBy(xpath = "(//button[@data-testid='edit_profile_first_name_save'])[1]")
    WebElement saveButtonName;

    @FindBy(xpath = "(//button[@data-testid='edit_profile_last_name_save'])[1]")
    WebElement saveButtonLastname;

    // მეთოდები
    public String getMyProfile(){
        return getElementText(myProfile);
    }

    public void fillDetails(String name, String lastname){
        clickElement(clickNameAddButton);
        enterText(enterName,name);
        clickElement(saveButtonName);
        clickElement(clickLastnameAddButton);
        enterText(enterLastname,lastname);
        clickElement(saveButtonLastname);
        driver.get("https://biletebi.ge/profile/edit");
        driver.navigate().refresh();
    }

}
