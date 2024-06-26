package Common;

import java.util.HashMap;
import java.util.Map;

public class Headers {
        static final String WeatherAPI_KEY = "ca497274c14aef3abcab96bf314e8736";

        public static Map<String, String> getWeatherHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", WeatherAPI_KEY);
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
