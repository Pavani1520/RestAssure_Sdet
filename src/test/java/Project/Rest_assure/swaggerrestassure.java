package Project.Rest_assure;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class swaggerrestassure {
	
	 
	@Test(enabled=true)
	public static class create_user {
		public static Response res = null;
		@Test(enabled=true)
		//Perform the Get Operation 
		public void get_method() {	
			System.out.println("Get user");
			Response resp = RestAssured.get("https://petstore.swagger.io/v2/user/pavani");
			Assert.assertEquals(200, resp.getStatusCode());
			System.out.println(resp.asString());
			System.out.println(resp.statusCode());
			System.out.println(resp.statusLine());
			System.out.println(resp.asPrettyString());			
		}
		
		//Perform the POST Operation with escape char , perform assertions for success code 
		@Test(enabled=true)
		public void post_method(ITestContext obj) {
		System.out.println("creating user"); 
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
		String body="{\"id\":11,\"username\":\"pavani\",\"firstName\":\"emani\",\"lastName\":\"I\",\"email\":\"xyz@abc.com\",\"password\":\"abc123\",\"phone\":\"12345678\",\"userStatus\":0}";
		Response resp=given().contentType(ContentType.JSON)
		.body(body).
	     when()
		.post("/user");
		System.out.println(resp.asString());
		assertEquals(resp.getStatusCode(),200);		
		}
		
		public void put_method() {
			System.out.println("updating user");
			RestAssured.baseURI = "https://petstore.swagger.io/v2/user/pavani111";
			String body="{\"id\":11,\"username\":\"pavani\",\"firstName\":\"emani\",\"lastName\":\"I\",\"email\":\"xyz@abc.com\",\"password\":\"abc123\",\"phone\":\"12345678\",\"userStatus\":0}";
			Response resp=given().contentType(ContentType.JSON)
			.body(body).
			when()
			.put("/user");
			System.out.println(resp.asString());
			assertEquals(resp.getStatusCode(),200);
		}
		
	@Test(enabled = true)
		public void login_method() {
			System.out.println("logging user");
			Response resp = RestAssured.get("https://petstore.swagger.io/v2/user/login?username=pavani&password=abc123");
		}
	
@Test(enabled=true)
		public void logout_method() {
			System.out.println("loggingout user");
			RestAssured.baseURI = "https://petstore.swagger.io/v2/user/logout";	
		}
		
		@Test(enabled=true)
		public void delete_method() {
			System.out.println("deleting user");
			Response resp = RestAssured.delete("https://petstore.swagger.io/v2/user/pavani");
			System.out.println(resp.statusCode());
			System.out.println(resp.statusLine());
			System.out.println(resp.asPrettyString());
		}
		
	}
	}

	