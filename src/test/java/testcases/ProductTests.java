package testcases;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.Payloads;
import pojo.ProductPojo;
import routes.Routes;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ProductTests extends BaseClass{

    @Test
    void testGetAllProducts(){
        given()
                .when().get(Routes.GET_ALL_PRODUCTS)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    void testGetProductById(){
        int prodid=cf.getConfigNumProperty("product_id");

        given()
                .pathParam("id",prodid)
                .when().get(Routes.GET_SINGLE_PRODUCT)
                .then()
                .statusCode(200)
                .body("id",equalTo(prodid))
                .log().body();
    }

    @Test
    void testGetLimitedProducts(){
        given().pathParam("limit",3)
                .when().get(Routes.GET_LIMIT_PRODUCTS)
                .then()
                .statusCode(200)
                .body("id",everyItem(notNullValue()))
                .log().body();
    }

    @Test
    void testgetAllProductCategories(){
        Response response=given()
                .when().get(Routes.GET_ALL_PRODUCTS_CATEGORIES)
                .then().statusCode(200)
                .body("size()",greaterThan(0))
                .log().all()
                .extract().response();
    }

    @Test
    void testProductCategory(){
        Response res=given()
                .pathParam("category","electronics")
                .when().get(Routes.GET_PRODUCT_CATEGORY)
                .then()
                .statusCode(200)
                .body("category",everyItem(notNullValue()))
                .body("category",everyItem(equalTo("electronics")))
                .extract().response();

        List<Integer> categories=res.jsonPath().getList("electronics",Integer.class);

    }

    @Test
    void testAddNewProduct(){
        ProductPojo pp=Payloads.ProductPayload();

        given().contentType("application/json")
                .body(pp)
                .when().post(Routes.POST_NEW_PRODUCT)
                .then()
                .statusCode(201)
                .log().body();
    }

    @Test
    void testUpdateProduct(){
        ProductPojo pp=Payloads.ProductPayload();

        given().contentType("application/json")
                .pathParam("id",2)
                .body(pp)
                .when().put(Routes.PUT_SINGLE_PRODUCT)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void testPartialupdateProduct(){
        ProductPojo pp=Payloads.ProductPayload();


        given().contentType("application/json")
                .pathParam("id",2)
                .body(pp)
                .when().patch(Routes.PATCH_SINGLE_PRODUCT)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void testDeleteProduct(){
        ProductPojo pp=Payloads.ProductPayload();

        given().contentType("application/json")
                .pathParam("id",2)
                .body(pp)
                .when().delete(Routes.DELETE_SINGLE_PRODUCT)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void testDescSort(){
        Response re=given()
                .pathParam("order","desc")
                .when().get(Routes.GET_SORTING_PRODUCTS)
                .then()
                .statusCode(200)
                .extract().response();

        List<Integer> ids= re.jsonPath().getList("id",Integer.class);
        assertThat(sortDesc(ids),is(true));

    }

    @Test
    void testAscSort(){
        Response re=given()
                .pathParam("order","asc")
                .when().get(Routes.GET_SORTING_PRODUCTS)
                .then()
                .statusCode(200)
                .extract().response();

        List<Integer> ids= re.jsonPath().getList("id",Integer.class);
        assertThat(sortAsc(ids),is(true));

    }

}
