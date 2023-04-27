package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
    WebDriver driver;
    public ConfirmPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='layer__link']")
    private WebElement header;
    @FindBy(xpath = " //span[@class='layer-sent-page__contact-item']\n")
    private WebElement author;

    public void confirmMessage(){
        header.getText().contains("Письмо отправлено");
        author.getText().contains(ConfigProperties.getProperty("login"));

    }
}
