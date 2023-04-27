package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessage {

    WebDriver driver;
    public SendMessage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//a[@class='ph-project__link svelte-8ixhwv ph-project__link_current']")
    private WebElement mailLogo;
    @FindBy(xpath = "//a[@class='compose-button compose-button_white compose-button_short compose-button_compact js-shortcut']")
    private WebElement composeButton;
    @FindBy(xpath = "//div[@class='input--3slxg']")
    private WebElement sendToButton;
    @FindBy(xpath = "//div[@class='subject__wrapper--2mk6m']")
    private WebElement mailSubject;
    @FindBy(xpath = "//div[@class='editor_container--3Rj-8']")
    private WebElement messageBody;
    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='wrapper-0-2-75']//h3[@data-test-id='caption']")
    private WebElement noSubjectPopUp;
    @FindBy(xpath = "//button[@class='vkuiButton vkuiButton--size-l vkuiButton--mode-primary vkuiButton--appearance-accent vkuiButton--align-center vkuiButton--sizeY-none vkuiButton--android vkuiTappable vkuiTappable--sizeX-none vkuiTappable--hover-none vkuiTappable--hasActive vkuiTappable--mouse']")
    private WebElement confirmNoSubject;

    public void checkPageElements() {
    mailLogo.isDisplayed();
    }
    public void sendMessageWithSubject(){
        composeButton.click();
        sendButton.sendKeys(ConfigProperties.getProperty("login"));
        mailSubject.sendKeys(ConfigProperties.getProperty("mailSubject"));
        messageBody.clear();
        messageBody.sendKeys(ConfigProperties.getProperty("mailText"));
        sendButton.click();

    }
    public void sendMessageWithNoSubject(){
        composeButton.click();
        sendButton.sendKeys(ConfigProperties.getProperty("login"));
        messageBody.clear();
        messageBody.sendKeys(ConfigProperties.getProperty("mailText"));
        sendButton.click();
        noSubjectPopUp.getText().contains("Вы действительно хотите отправить пустое письмо?");
        confirmNoSubject.click();
    }
}
