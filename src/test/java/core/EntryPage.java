package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryPage {
    WebDriver driver;

    public EntryPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@data-testid='logo-item']")
    private WebElement mailLogo;
    @FindBy(xpath = "//button[@class='ph-login svelte-1ke9xx5']")
    private WebElement signInButton;

    public void signIn() {
        signInButton.click();
    }

    public void checkLogo() {
        mailLogo.isDisplayed();
    }

}
