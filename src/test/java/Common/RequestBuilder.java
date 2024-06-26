package Common;

import io.restassured.response.Response;


import static Common.BasePaths.*;
import static Common.ContentTypes.json_contentType;
import static Common.Headers.getWeatherHeaders;
import static Common.PayloadBuilder.*;
import static io.restassured.RestAssured.*;

public class RequestBuilder {
    public static String EmployeeID;

    public static Response createEmployeeResponse() {
        Response response = given().
                when().
                body(createEmployeeObject()).
                contentType(json_contentType).
                log().all().
                post(ReqRes_baseURL + "/api/users").
                then().
                log().all().
                extract().response();
        EmployeeID = response.jsonPath().getString("id");

        return response;
    }

    public static Response getEmployeedetailsReponse() {
        Response response = given().
                when().
                get(ReqRes_baseURL + "/api/users?page=2").
                then().
                log().
                all().
                extract().response();

        return response;

    }

    public static Response updateEmployeeResponse() {
        Response response = given().
                when().
                body(updateEmployeeObject()).
                contentType(json_contentType).
                log().all().
                put(ReqRes_baseURL + "/api/users/" + EmployeeID).
                then().
                log().all().
                extract().response();

        return response;
    }

    public static Response patchEmployeeResponse() {
        Response response = given().
                when().
                body(patchEmployeeObject()).
                contentType(json_contentType).
                log().all().
                patch(ReqRes_baseURL + "/api/users/" + EmployeeID).
                then().
                log().all().
                extract().response();

        return response;
    }

    public static Response deleteEmployeedetailsReponse() {
        Response response = given().
                when().
                delete(ReqRes_baseURL + "/api/users/" + EmployeeID).
                then().
                log().
                all().
                extract().response();

        return response;
    }

    public static Response getListsOfAllBreeds() {
        Response response = given().
                when().
                get(DogsAPI_baseURL + "/breeds/list/all").
                then().
                log().
                all().
                extract().response();
        return response;
    }

    public static Response getRandomBreeds() {
        Response response = given().
                when().
                get(DogsAPI_baseURL + "/breeds/image/random").
                then().
                log().
                all().
                extract().response();
        return response;
    }

    public static Response getDogsbyBreeds() {
        Response response = given().
                when().
                get(DogsAPI_baseURL + "/breed/hound/images").
                then().
                log().
                all().
                extract().response();
        return response;
    }

    public static Response getListOfSubBreeds() {
        Response response = given().
                when().
                get(DogsAPI_baseURL + "/breed/hound/list").
                then().
                log().
                all().
                extract().response();

        return response;
    }

    public static Response getListsOfAllBreedsNegative() {
        Response response = given().
                when().
                get(DogsAPI_baseURL + "/breedsNoma/list/all").
                then().
                log().
                all().
                extract().response();
        return response;
    }

    public static String stationID;

    public static Response registerAWeatherstation() {
        Response response = given().
                queryParam("appid", "ca497274c14aef3abcab96bf314e8736").
                headers(getWeatherHeaders()).
                body(registerStationObject()).
                when().
                contentType(json_contentType).
                log().all().
                post(WeatherAPI_baseURL + "/data/3.0/stations").
                then().
                log().all().
                extract().
                response();
        stationID = response.jsonPath().getString("ID");
        return response;
    }

    public static Response getStationByID() {
        Response response = given().
                queryParam("appid", "ca497274c14aef3abcab96bf314e8736").
                headers(getWeatherHeaders()).
                when().
                get(WeatherAPI_baseURL + "/data/3.0/stations/" + stationID).
                then().
                log().
                all().
                extract().response();

        return response;
    }

    public static Response updateStationDetails() {
        Response response = given().
                queryParam("appid", "ca497274c14aef3abcab96bf314e8736").
                headers(getWeatherHeaders()).
                body(registerStationObject()).
                when().
                contentType(json_contentType).
                log().all().
                put(WeatherAPI_baseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all().
                extract().
                response();
        return response;
    }

    public static Response deleteStationID() {
        Response response = given().
                queryParam("appid", "ca497274c14aef3abcab96bf314e8736").
                headers(getWeatherHeaders()).
                when().
                delete(WeatherAPI_baseURL +"/data/3.0/stations/"+stationID).
                then().
                log().
                all().
                extract().response();

        return response;

    }
}
