package bookshow.controller;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Ivan V. on 16-Apr-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BidControllerT {

    @Test
    public void testGetBidByUsedProp(){
        RestAssured.given().header("Auth-Token","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZWphbiIsImF1ZGllbmNlIjoid2ViIiwicm9sZSI6IlVTRVIiLCJjcmVhdGVkIjoxNTIzODgzNTY3MTE2LCJleHAiOjE1MjQ0ODgzNjd9.0TRDhwEinCnIKAofmgqBfJN2lU71_uiQwF0ZlROvGdR32ySxEIAV8cnVjRCkWp8sflgNU-Fg5wBi2YYKXMBEpA")
                .when()
                .get("/api/bids/used-prop/2")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK)
                .body("id", CoreMatchers.hasItems(2));

    }

}
