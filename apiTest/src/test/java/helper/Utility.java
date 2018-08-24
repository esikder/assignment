package helper;

import io.restassured.RestAssured;

public class Utility {

    public void init()  {

        RestAssured.basePath = ConfigHandler.getConfigValue(("basePath"));
        RestAssured.baseURI = ConfigHandler.getConfigValue(("baseURI"));
        RestAssured.port = Integer.parseInt( ConfigHandler.getConfigValue(("port")));

    }

    public void cleanup() {
        DataHandler dataHandler = new DataHandler();
        dataHandler.deleteAllListItem();
    }
}
