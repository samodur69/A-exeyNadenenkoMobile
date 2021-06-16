package setup;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    private static final PropertyReader reader = new PropertyReader();

    @DataProvider (name = "nativeData")
    private static Object[][] testData() {

        return new Object[][] {
            {reader.getEmail(),
                reader.getUsername(),
                reader.getPsw(),
                reader.getExpectedTitle()}
        };
    }

    @DataProvider (name = "webData")
    private static Object[][] webTestData() {
        return new Object[][] {
            {reader.getUrl(), reader.getRequest()}
        };
    }
}
