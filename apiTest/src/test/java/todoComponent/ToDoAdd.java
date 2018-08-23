package todoComponent;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ToDoAdd {


    @Before
    public void setup() throws IOException {
        Properties prop =  new Properties();
        InputStream input = new FileInputStream("config.properties");
        prop.load(input);

        RestAssured.basePath = prop.getProperty("basePath");
        RestAssured.baseURI = prop.getProperty("baseURI");
        RestAssured.port = Integer.parseInt( prop.getProperty("port"));
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
