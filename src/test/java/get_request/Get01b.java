package get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01b {

           /*
         Given
             https://reqres.in/api/users/3
         When
             User sends a GET Request to the url
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
             Status Line should be HTTP/1.1 200 OK

          */
    @Test
    public void get01(){
        //First Step:Set the Url
        String url = "https://reqres.in/api/users/3";

        //Second Step:Set The Expected Data


        //Third Step:Send The Request and Get The Response
        Response response=given().when().get(url);
        response.prettyPrint();


        //HTTP Status Code should be 200
        // And
        //    Content Type should be JSON
        // And
        //    Status Line should be HTTP/1.1 200 OK


        //Four Step:Do Assertion
        response.then().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
    }



}
