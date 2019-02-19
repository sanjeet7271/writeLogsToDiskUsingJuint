package com.testcases;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import com.WriteLogsToDisk.WriteLogsToDisk;

import io.restassured.RestAssured;

public class TestCasesWithDifferentLoggingFile {
	@Rule
    public WriteLogsToDisk writeLogsToDisk = new WriteLogsToDisk("./src/main/resources/Logs");

	/**
	 * Passing Parameters to any call like PUT or POST
	 * 
	 */
	@Test
	public void Test1() {
		RestAssured.given().log().all().param("page", "2").param("page", "3").when().get("https://reqres.in/api/users")
				.then().statusCode(200).log().all();
	}

	/**
	 * Passing multi-Parameters in single line
	 * 
	 */
	@Test
	public void Test2() {
		RestAssured.given().log().all().param("page", "2", "3").when().get("https://reqres.in/api/users").then()
				.statusCode(200).log().all();
	}

	/**
	 * Passing multi-Parameters in Array-List
	 * 
	 */
	@Test
	public void Test3() {
		// ArrayList
		List<String> values = new ArrayList<String>();
		values.add("2");
		values.add("3");
		// Starts code part
		RestAssured.given().log().all().param("page", values).when().get("https://reqres.in/api/users").then()
				.statusCode(200).log().all();
	}

	/**
	 * Passing Parameters to GET call
	 * 
	 */
	@Test
	public void Test4() {
		RestAssured.given().log().all().queryParam("page", "2").queryParam("page", "3").when()
				.get("https://reqres.in/api/users").then().statusCode(200).log().all();
		;
	}

	/**
	 * Passing Parameters to POST call its dummy data, did have any parameter to
	 * pass
	 */
	@Test
	public void Test5() {
		RestAssured.given().log().all().formParam("page", "2").formParam("page", "3").when()
				.get("https://reqres.in/api/users").then().statusCode(415).log().all();
		;
	}
}
