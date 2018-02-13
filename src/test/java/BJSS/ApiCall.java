package BJSS;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ApiCall {

    //all API Tests in one class

    //Read Action - GET Request
    @Test
    public void ResponseCodeAndBody() {

        int statusCode = get("https://reqres.in/api/users").getStatusCode();

        System.out.println("Status code is "+ statusCode);

        assertEquals (statusCode, 200);

        String responseBody = get("https://reqres.in/api/users").asString();

        System.out.println("Response body is"+ responseBody);

    }

    //Create Action - POST Request
    @Test
    public void CreateUser() {

        //URL
        RequestSpecification myRequest = given();

        //header
        myRequest.header("Content-Type", "application/json");

        //body - by creating a new json object

        JSONObject requestParams = new JSONObject();

        requestParams.put("name", "Larry Test");
        requestParams.put("job","tester");

        myRequest.body(requestParams.toJSONString());

        Response myResponse = myRequest.post("https://reqres.in/api/users");

        String myResponseBody = myRequest.post("https://reqres.in/api/users").asString();

        int statusCode = myResponse.getStatusCode();

        //asserting if the status code is correct, so the post request was successful
        assertEquals(statusCode, 201);

        System.out.println("Response body is "+ myResponseBody);

        //asserting if the user was created successfully
        assertTrue(myResponseBody.contains("Larry Test"));
    }

    //Update - PUT Request
    @Test
    public void UpdateUser() {

        //URL
        RequestSpecification myRequest = given();

        //header
        myRequest.header("Content-Type", "application/json");

        //body - by creating a new json object

        JSONObject requestParams = new JSONObject();

        requestParams.put("name","Rachel Larry");
        requestParams.put("job","traveller");

        myRequest.body(requestParams.toJSONString());

        //Update post 12
        Response myResponse = myRequest.put("https://reqres.in/api/users/12");

        String myResponseBody = myRequest.put("https://reqres.in/api/users/12").asString();

        int statusCode = myResponse.getStatusCode();

        //asserting if the status code is correct, so the put request was successful
        assertEquals(statusCode, 200);

        System.out.println("Response body is "+ myResponseBody);

        //asserting if the user was updated successfully
        assertTrue(myResponseBody.contains("Rachel Larry"));
    }


    //Delete Action - DELETE Request
    @Test
    public void DeleteUser() {

        RequestSpecification myRequest = given();

        Response myResponse = myRequest.delete("https://reqres.in/api/users/610");

        int statusCode = myResponse.getStatusCode();

        assertEquals(statusCode, 204);

    }

}




