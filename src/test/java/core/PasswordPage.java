package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
    WebDriver driver;
    public PasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //INPUT PASSWORD
    @FindBy(xpath = "//h3[@data-test-id='header-text']")
    private WebElement passHeader;
    @FindBy(xpath = "//input[@class='input-0-2-71 withIcon-0-2-72']")
    private WebElement inputPass;
    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement submitButton;

    public void checkPageElements() {
        passHeader.isDisplayed();
        passHeader.getText().contains("Введите пароль");
    }

    public void inputPass() {
        inputPass.sendKeys(ConfigProperties.getProperty("password"));
        submitButton.click();
    }
}
