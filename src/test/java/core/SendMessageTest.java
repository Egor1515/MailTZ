package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class SendMessageTest {
    public static LoginPage loginPage;
    public static EntryPage entryPage;
    public static ConfirmPage confirmPage;
    public static PasswordPage passwordPage;
    public static SendMessage sendMessage;
    public static WebDriver driver;
    public static CaptchaPage cap;


    @BeforeEach
    public void setUpTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        entryPage = new EntryPage(driver);
        sendMessage = new SendMessage(driver);
        passwordPage = new PasswordPage(driver);
        confirmPage = new ConfirmPage(driver);
        cap = new CaptchaPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigProperties.getProperty("loginpage"));
    }

//    @AfterEach
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void sendMessage() {
        entryPage.checkLogo();
        entryPage.signIn();
        loginPage.checkPageElements();
        loginPage.inputLogin();
        passwordPage.checkPageElements();
        passwordPage.inputPass();
        if (cap.getCaptchaHeader() != null) {
            cap.confirmCaptcha();
        } else {
            sendMessage.sendMessageWithSubject();
//        sendMessage.sendMessageWithNoSubject();
//            confirmPage.confirmMessage();
        }
        sendMessage.sendMessageWithSubject();
//        sendMessage.sendMessageWithNoSubject();
//        confirmPage.confirmMessage();
    }
}