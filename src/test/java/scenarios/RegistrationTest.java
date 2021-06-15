package scenarios;

import static org.testng.Assert.assertEquals;

import dto.User;
import org.testng.annotations.Test;
import setup.BaseTest;

public class RegistrationTest extends BaseTest {

    @Test(groups = {"native"})
    public void performRegistrationAndLoginTest() throws Exception {
        User user = new User("aa@aa.com", "alex", "12345678");
        String actual = getPo()
            .navigateToRegistration()
            .createAccount(user)
            .logIn(user)
            .getPageTitle();
        System.out.println(actual);
        assertEquals(actual, "BudgetActivity", "Wrong title");
    }
}
