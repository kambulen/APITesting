package Tests.WeatherApi;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static Common.BasePaths.WeatherAPI_baseURL;
import static Common.CommonTestData.Create_Success_Status_Code;
import static Common.RequestBuilder.registerAWeatherstation;
import static org.hamcrest.Matchers.notNullValue;

@Test
@Feature("WeatherStation")
@Story("Register a new weather station")
public class WeatherStationTests {
    public void registerStationTest() {
        registerAWeatherstation().
                then().
                assertThat().
                statusCode(Create_Success_Status_Code).
                body("ID", notNullValue()).
                body("updated_at", notNullValue()).
                body("created_at", notNullValue()).
                body("external_id", notNullValue()).
                body("name", notNullValue()).
                body("latitude", notNullValue());
    }

}
