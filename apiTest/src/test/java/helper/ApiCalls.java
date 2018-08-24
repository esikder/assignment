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

    public Response getAllItemFromList(){
        Response response = (Response)RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .get(ConfigHandler.getConfigValue("allEndpoint"));
        return response;
    }
    public Response deleteItemFromList(String id){
        Response response = (Response)RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .get(ConfigHandler.getConfigValue("deleteEndpoint")+"/"+id);
        return response;
    }


}
