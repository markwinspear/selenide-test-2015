import PageObjects.Login;
import org.junit.Before;
import org.junit.Test;
//import org.junit.experimental.categories.Category;
//import tests.groups.Smoke;

public class TestLoginSimple extends Base {
    private Login login;

   @Before
   public void setUp() {
       login = new Login(driver);
    }

    @Test
   // @Category(Smoke.class)
    public void shouldSucceed() {
        login.with("tomsmith", "SuperSecretPassword!");
        login.successMessagePresent();
    }

    @Test
  //  @Category(Smoke.class)
    public void shouldFail() {
        login.with("tomsmith", "bad password");
        login.failureMessagePresent();
    }
}
