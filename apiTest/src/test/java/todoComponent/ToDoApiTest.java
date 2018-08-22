package todoComponent;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ToDoApiTest {
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
    public void testGetList(){
        given()
                .when()
                .get("all").then()
                .statusCode(200);

    }
    @Test
    public void testAddItemToList(){
        Map body = new HashMap<>();
        body.put("name","sadsfetertertret");
        body.put("done","0");
        given()
                .contentType("application/json")
                .body("{\"sadsfetertertret\": 0}")
                .when().post("add").then()
                .statusCode(200);

    }

    @Test
    public void testUpdateItemInList(){
        Map body = new HashMap<>();
        body.put("name","sadsfetertertret");
        body.put("done","0");
        given()
                .contentType("application/json")
                .body("{\"sadsfetertertret\": 0}")
                .when().post("add").then()
                .statusCode(200);

    }
}