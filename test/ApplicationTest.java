import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApplicationTest {

    @Test
    public void testMe() {

    }
    @Test
    public void testAddItemToToDoList(){
        given().when().get("http://localhost:4000/api/all").then().statusCode(200);

    }
}