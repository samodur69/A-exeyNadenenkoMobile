package scenarios;

import static org.assertj.core.api.Assertions.assertThat;

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
                                                String expectedTitle) throws Exception {

        User user = new User(email, username, psw);
        String actualTitle = nativePo
            .navigateToRegistration()
            .createAccount(user)
            .logIn(user)
            .getPageTitle();

        assertThat(expectedTitle)
            .containsIgnoringCase(actualTitle)
            .as("Wrong Title");
    }
}
