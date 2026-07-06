package testcases;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.Payloads;
import pojo.UserPojo;
import routes.Routes;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class UserTests extends BaseClass{

    //@Test
    public void testGenerateToken(){
        UserPojo up= Payloads.UserPayload();

        given().contentType("application/json")
                .body(up)
                .when().post(Routes.POST_GENERATE_TOKEN)
                .then()
                .log().all();
    }

    @Test
    public void testGetAllUserbyid(){
        int userid =cf.getConfigNumProperty("userId");

                given().pathParam("id",userid)
                .when().get(Routes.GET_SINGLE_USER)
                .then()
                        .statusCode(200)
                        .body("size()",greaterThan(0))
                        .body("id",equalTo(userid))
                .log().all();
    }

    @Test
    public void testGetAllUsers(){
        given()
                .when().get(Routes.GET_ALL_USERS)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testGetAscUsers(){
        Response res=given()
                .pathParam("order","asc")
                .when().get(Routes.GET_SORTED_USERS)
                .then()
                .log().body()
                .extract().response();

        List<Integer> ids=res.jsonPath().getList("id",Integer.class);
        assertThat(sortAsc(ids),is(true));

    }

    @Test
    public void testGetDescUsers(){
        Response res=given().pathParam("order","desc")
                .when().get(Routes.GET_SORTED_USERS)
                .then()
                .log().body()
                .extract().response();

        List<Integer> ids=res.jsonPath().getList("id",Integer.class);
        assertThat(sortDesc(ids),is(true));
    }

    @Test
    public void testAddNewUser(){
        UserPojo up=Payloads.UserPayload();

        given().contentType("application/json")
                .body(up)
                .when().post(Routes.POST_NEW_USER)
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void testUpdateUser(){
        UserPojo up=Payloads.UserPayload();
        int userid =cf.getConfigNumProperty("userId");

        given().pathParam("id",userid)
                .contentType("application/json")
                .body(up)
                .when().put(Routes.PUT_UPDATE_USER)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testpartialUpdateUser(){
        UserPojo up=Payloads.UserPayload();
        int userid =cf.getConfigNumProperty("userId");

        given().pathParam("id",userid)
                .contentType("application/json")
                .body(up)
                .when().patch(Routes.PATCH_UPDATE_USER)
                .then()
                .statusCode(200)
                .log().all();
    }
}
