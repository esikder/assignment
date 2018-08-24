package helper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class ApiCalls {
    public Response postAddItemToList(Map body){
        Response response = (Response)RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(body).post(ConfigHandler.getConfigValue("addEndpoint"));
        return response;
    }

    public Response getAllItemFromList(Map body){
        Response response = (Response)RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(body).get("add");
        return response;
    }



}
