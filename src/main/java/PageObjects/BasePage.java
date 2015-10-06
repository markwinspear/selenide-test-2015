package PageObjects;

import org.openqa.selenium.WebDriver;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class BasePage implements Config {
    private WebDriver driver;
    Boolean mobile;

    public BasePage(WebDriver driver){
        this.driver = driver;
        if (host.equals("saucelabs-mobile")) {
            mobile = TRUE;
        }
        else {
            mobile = FALSE;
        }
    }

    public void visit(String url) {
        if (url.contains("http")) {
            driver.get(url);
        } else {
            driver.get(baseUrl + url);
        }
        if (mobile == false) {
            driver.manage().window().maximize();
        }
    }
}
