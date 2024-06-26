package Tests.WeatherApi;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.BasePaths.WeatherAPI_baseURL;
import static Common.CommonTestData.Create_Success_Status_Code;
import static Common.CommonTestData.Retrieve_Data_Status_Code;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.notNullValue;

@Test
@Feature("WeatherStation")
@Story("Register a new weather station")
public class WeatherStationTests {

    @Description("As an api user i want to register a weather station")
    @Severity(SeverityLevel.BLOCKER)

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

    @Description("As an api user i want get a station using the ID")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods = "registerStationTest")

    public void getWeatherStationByID() {
        getStationByID().
                then().
                assertThat().
                statusCode(Retrieve_Data_Status_Code).
                body("id", notNullValue()).
                body("updated_at", notNullValue()).
                body("created_at", notNullValue()).
                body("external_id", notNullValue()).
                body("name", notNullValue()).
                body("latitude", notNullValue());
    }

    @Description("As an api user i want update a station details using the ID")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods = "registerStationTest")

    public void updateStationDetailUsingID() {
        updateStationDetails().
                then().
                assertThat().
                statusCode(Retrieve_Data_Status_Code).
                body("id", notNullValue()).
                body("updated_at", notNullValue()).
                body("created_at", notNullValue()).
                body("external_id", notNullValue()).
                body("name", notNullValue()).
                body("latitude", notNullValue());
    }

}
