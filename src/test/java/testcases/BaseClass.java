package testcases;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import routes.Routes;
import utils.ConfigReader;

public class BaseClass {

    ConfigReader cf;

    @BeforeClass
    void setUp(){
        RestAssured.baseURI= Routes.BASE_URL;

        cf=new ConfigReader();
    }
}
