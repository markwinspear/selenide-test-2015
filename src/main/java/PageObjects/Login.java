package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Condition.*;       //saves writing shouldHave(Condition.something)
import static com.codeborne.selenide.Selenide.$;


public class Login extends BasePage{
    // Can separate out declaration of page objects here, or use directly in methods
    SelenideElement usernameField       = $(By.id("username"));
    SelenideElement passwordField       = $(By.id("password"));
    SelenideElement submitButton        = $(By.xpath("//button[@type='submit']"));
    SelenideElement successMessage      = $(By.cssSelector(".flash.success"));
    SelenideElement failureMessage      = $(By.cssSelector(".flash.error"));

    public Login(WebDriver driver) {
        super(driver);
        visit("/login");
        $(By.xpath("//div[@class='example']")).shouldHave(text("Login Page"));
        }

    public void with(String username, String password) {
        usernameField.setValue(username);   //$(By.id("username")).setValue(username);  1       Example declaring and using object within a method
        passwordField.setValue(password);
        submitButton.click();
    }

    public void verifySucceeded() {
        successMessage.shouldBe(visible)
                .shouldHave(text("You logged into a secure area! "));
    }

    public void verifyFailed() {
        failureMessage.shouldBe(visible)
                    .shouldHave(text("Your password is invalid!"));
    }
}