package helper;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler {

    public void addBulkListItem(HashMap<String,Integer> input){

        for(Map.Entry<String,Integer> entry : input.entrySet()){
            Map body = new HashMap();
            body.put("name",entry.getKey() );
            body.put("done", entry.getValue());

            ApiCalls apiCalls   = new ApiCalls();
            apiCalls.postAddItemToList( body).then().statusCode(200);

        }
    }

    public void deleteAllListItem(){
        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.getAllItemFromList();
        List<String> ids= response.body().jsonPath().get("_id");

        for (String id: ids) {
            apiCalls.deleteItemFromList(id);

        }


    }

}
