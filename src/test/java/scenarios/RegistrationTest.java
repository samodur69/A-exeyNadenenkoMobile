package scenarios;

import static org.testng.Assert.assertEquals;

import dto.User;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test(groups = {"native"})
    public void performRegistrationAndLoginTest() throws Exception {
        User user = new User("aa@aa.com", "alex", "12345678");
        assertEquals(nativePo
                .navigateToRegistration()
                .createAccount(user)
                .logIn(user)
                .getPageTitle(),
            "BudgetActivity",
            "Wrong title");
    }
}
