package todoComponent;

import common.Common;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ToDoAdd {


    @Before
    public void setup() {
        Common c =  new Common();
        c.setter();
    }
    @Test
    public void testAddItemToList(){
        String itemName = "testing";
        Integer done = 1;


        given()
                .contentType("application/json;charset=UTF-8")
                .body("{\"name\":\""+itemName+"\",\"done\":"+done+"}")
                .when().post("add")
                .then()
                .statusCode(200)
                .body("name",Matchers.is(itemName)).body("done", Matchers.is(false))
                .body("__v", Matchers.is(0));

    }



}
