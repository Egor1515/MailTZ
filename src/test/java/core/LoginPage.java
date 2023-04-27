package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //    INPUT LOGIN
    @FindBy(xpath = "//h3[@data-test-id='header-text']")
    private WebElement signInHeader;
    @FindBy(xpath = "//input[@class='input-0-2-71']")
    private WebElement inputLogin;
    @FindBy(xpath = "//div[@data-test-id='mailru']")
    private WebElement mailDomain;
    @FindBy(xpath = "//div[@class='Select__value-container Select__value-container--has-value css-0']")
    private WebElement chooseDomain;
    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[@data-test-id='qr-code-holder']")
    private WebElement codeQR;


    public void checkPageElements() {
        signInHeader.isDisplayed();
        codeQR.isDisplayed();
        mailDomain.click();
    }

    public void inputLogin() {
        inputLogin.sendKeys(ConfigProperties.getProperty("login"));
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='input-0-2-71']"))).sendKeys("asdsa");
        continueButton.click();

    }
}

