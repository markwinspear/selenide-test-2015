package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;


public class Login extends BasePage{

    // Can separate out declaration of page objects here, or use directly in methods
    SelenideElement usernameField       = $(By.id("username"));
    SelenideElement passwordField       = $(By.id("password"));
    SelenideElement submitButton        = $(By.xpath("//button[@type='submit']"));

    public Login(WebDriver driver) {
        super(driver);
        visit("/login");
        $(By.xpath("//div[@class='example']")).shouldHave(Condition.text("Login Page"));
        }

    public void with(String username, String password) {
            //$(By.id("username")).setValue(username);  1       Example declaring and using object within a method
        usernameField.setValue(username);
        passwordField.setValue(password);
        submitButton.click();
    }

    public void verifySucceeded() {
        $(By.cssSelector(".flash.success")).shouldBe(Condition.visible).shouldHave(Condition.text("You logged into a secure area! "));
    }

    public void verifyFailed() {
        $(By.cssSelector(".flash.error")).shouldBe(Condition.visible).shouldHave(Condition.text("Your password is invalid!"));
    }
}