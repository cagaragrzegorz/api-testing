package com.cagara.postmanApi

import io.restassured.RestAssured
import spock.lang.Shared
import spock.lang.Specification

abstract class ApiTestBase extends Specification {

    @Shared
    def headers = ['Accept'         : '*/*',
                   'Accept-Language': 'pl-PL',
                   'User-Agent'     : 'PostmanRuntime/7.29.0'
    ]

    def setupSpec() {
        RestAssured.baseURI = 'https://postman-echo.com'
    }
}
