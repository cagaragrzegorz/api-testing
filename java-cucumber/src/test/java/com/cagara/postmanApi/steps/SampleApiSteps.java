package com.cagara.postmanApi.steps;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class SampleApiSteps {

    final static String BASE_URL = "https://postman-echo.com";
    final static Map<String, String> headers = Map.of("Accept", "*/*", "Accept-Language", "pl-PL", "User-Agent", "PostmanRuntime/7.29.0");

    private int requestStatus;
    private Response response;
    private Scenario scenario;

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = BASE_URL;
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }


    @Given("sets facts for test case")
    public void setsFactsForTestCase() {
        requestStatus = 200;
    }

    @When("api call is made for given url {string}")
    public void apiCallIsMadeForGivenUrl(String url) {
        response = given()
                .headers(headers)
                .get(url);
    }

    @Then("HTTP response status code will have {int}")
    public void httpResponseStatusCodeWillHave(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        scenario.log("actualStatusCode: " + actualStatusCode);
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("actual response body is equal to {string}")
    public void actualResponseBodyIsEqualTo(String responseBody) {
        String actualResponseBody = response.getBody().asString();
        scenario.attach(actualResponseBody, "application/json", "responseBody.json");
        JSONAssert.assertEquals(new JSONObject(responseBody), new JSONObject(actualResponseBody), true);
    }

    @And("actual response body args is equal to {string}")
    public void actualResponseBodyArgsIsEqualTo(String args) {
        String actualResponseBody = response.getBody().asString();
        scenario.attach(actualResponseBody, "application/json", "responseBody.json");
        JSONAssert.assertEquals(new JSONObject(args), new JSONObject(actualResponseBody).getJSONObject("args"), true);
    }
}
