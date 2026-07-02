package testcases;

import org.testng.annotations.Test;
import payloads.Payloads;
import pojo.ProductPojo;
import routes.Routes;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProductDataDriven extends BaseClass{

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = utils.DataProviders.class)
    public void testProductDataDriven(Map<String,String> data){
        String title=data.get("title");
        Double price=Double.parseDouble(data.get("price"));
        String description=data.get("description");
        String image=data.get("image");
        String category=data.get("category");

        ProductPojo pp= new ProductPojo(title,price,description,category,image);

        given().contentType("application/json")
                .body(pp)
                .when().post(Routes.POST_NEW_PRODUCT)
                .then()
                .statusCode(201)
                .log().body();
    }
}
