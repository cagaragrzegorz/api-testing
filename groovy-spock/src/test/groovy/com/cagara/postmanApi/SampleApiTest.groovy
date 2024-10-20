package com.cagara.postmanApi


import io.restassured.response.Response
import org.json.JSONObject
import org.skyscreamer.jsonassert.JSONAssert
import spock.lang.Unroll

import static io.restassured.RestAssured.given

class SampleApiTest extends ApiTestBase {

    def 'GET status code form postman API endpoint'() {
        given: 'sets facts for test case'
        def expectedResponse = '{"status":200}'
        def requestStatus = 200

        when: 'api call is made for given query'
        Response response = given()
                .headers(headers)
                .get('/status/200')

        then: 'expected output matched actual output'
        response.getStatusCode() == requestStatus
        JSONAssert.assertEquals(expectedResponse, new JSONObject(response.getBody().asString()), true)
    }

    @Unroll
    def 'GET parameters form postman API endpoint'() {
        given: 'sets facts for test case'
        def requestStatus = 200

        when: 'api call is made for given query'
        Response response = given()
                .headers(headers)
                .get("/get?$arguments")

        then: 'expected output matched actual output'
        response.getStatusCode() == requestStatus
        JSONAssert.assertEquals(expectedResponse, new JSONObject(response.getBody().asString()).get('args'), true)

        where:
        arguments             | expectedResponse
        'grze=gorz'           | '{"grze": "gorz"}'
        'foo1=bar1&foo2=bar2' | '{"foo1": "bar1", "foo2": "bar2"}'
    }
}
