package com.briedgelab.selenium.rest;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class RestAssured {

    public String token = "";
    public static String userID ;
    public static String playlistId ;

    @BeforeTest
    public void setUp() {
        token = "Bearer BQAS2yXchmJ7I2M9hIn2HGM-2vGeDInKakZW2UnRnN1ec9v9bZmHR9-yDa1_wwbznXXuIg1SDCW0aLbShI3_D3oDvIJElRjstJrA6gPmWlKYFRLErG_TJXRK3N6UGEyUVlR_Txa430h-T4R_mVPqzrY4PUWT0MQFzxiiHXvo7VhYj9tCtaaeaOSMmZ4W4IO5We-n1cn14ULmHFDxeLwkSLXXsx3Gl_zzhDbJVawo0NzcicVrVHqQ6xCYkdGRCnopHUwjCQQsl2A1Fdx_X-PTgS_dsEe4pF02BF2QD0gZ";
    }

    @Test
    public void get_Current_UserProfile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();

        userID = response.path("id");

    }
    @Test
    public void get_UserProfile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/"+userID);
        response.prettyPrint();
    }

    @Test
    public void get_CurrentUsersPlaylist() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");

        playlistId = response.path("uri");
        System.out.println("---"+playlistId);

    }
}
