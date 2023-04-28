package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaptchaPage {

    WebDriver driver;

    public CaptchaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h3[@data-test-id='recaptcha-inter-header']")
    private WebElement captchaHeader;

    public WebElement getCaptchaHeader() {
        return captchaHeader;
    }

    public CaptchaPage(WebElement captchaHeader) {
        this.captchaHeader = captchaHeader;
    }

    @FindBy(xpath = "//button[@data-test-id='recaptcha-inter-next']")
    private WebElement itIsMeButton;
    @FindBy(xpath = "//input[@class='input-0-2-129 withIcon-0-2-130']")
    private WebElement inputPassAgain;
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private WebElement chekcBoxCaptcha;
    @FindBy(xpath = "//button[@class='base-0-2-62 primary-0-2-76 auto-0-2-88']")
    private WebElement signInButton;

    public void confirmCaptcha() {
//        captchaHeader.isDisplayed();
        driver.switchTo().parentFrame().getPageSource();
        itIsMeButton.click();
        inputPassAgain.sendKeys(ConfigProperties.getProperty("password"));
        WebElement captcha = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(captcha);
        chekcBoxCaptcha.click();
        driver.switchTo().parentFrame().getPageSource();
        signInButton.click();

    }
}

