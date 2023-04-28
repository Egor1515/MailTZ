package core;

import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) throws InterruptedException {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        TimeUnit.SECONDS.sleep(10);
    }


    //    INPUT LOGIN
    @FindBy(tagName = "h3")
    private WebElement signInHeader;
    @FindBy(xpath = "//*[@id='root']/div/div/div/div[2]/div/div/form/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/div/input")
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
//        codeQR.isDisplayed();
//        mailDomain.click();
    }

    public void inputLogin() {
//        inputLogin.sendKeys(ConfigProperties.getProperty("login"));
        WebElement fr1 = driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"));
//        WebElement fr2 = driver.findElement(By.xpath("//iframe[@class='iframe-0-2-16']"));
        driver.switchTo().frame(fr1);
//        driver.switchTo().frame(fr2);
        inputLogin.sendKeys(ConfigProperties.getProperty("login"));
        continueButton.click();

    }

//    driver.switchTo().frame(driver.findElement(By.cssSelector(“iframe[title=‘Этап: Заповнення заявки’]”))).switchTo().frame(driver.findElement(By.cssSelector(“iframe[title=‘Coach’]”)));
}

