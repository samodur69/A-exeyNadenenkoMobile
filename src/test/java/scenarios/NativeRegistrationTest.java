package scenarios;

import static org.testng.Assert.assertEquals;

import dto.User;
import org.testng.annotations.Test;
import setup.TestDataProvider;

public class NativeRegistrationTest extends BaseTest {

    @Test(groups = {"native"},
          dataProviderClass = TestDataProvider.class,
          dataProvider = "nativeData")
    public void performRegistrationAndLoginTest(String email,
                                                String username,
                                                String psw,
                                                String title) throws Exception {

        User user = new User(email, username, psw);
        assertEquals(nativePo
                .navigateToRegistration()
                .createAccount(user)
                .logIn(user)
                .getPageTitle(),
            title,
            "Wrong title");
    }
}
