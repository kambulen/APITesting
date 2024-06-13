package Common;

import io.restassured.response.Response;

import static Common.BasePaths.ReqRes_baseURL;
import static Common.ContentTypes.json_contentType;
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

    public static Response updateEmployeeResponse(){
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

    public static Response patchEmployeeResponse(){
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

}
