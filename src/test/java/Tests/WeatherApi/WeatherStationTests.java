package Tests.WeatherApi;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static Common.BasePaths.WeatherAPI_baseURL;
import static Common.CommonTestData.Create_Success_Status_Code;
import static Common.RequestBuilder.registerAWeatherstation;

@Test
@Feature("WeatherStation")
@Story("Register a new weather station")
public class WeatherStationTests {
     public void registerStationTest(){
          registerAWeatherstation().
                  then().
                  assertThat().
                  statusCode(Create_Success_Status_Code);
     }

}
