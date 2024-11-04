Feature: API test with Cucumber

  Scenario: GET status code form postman API endpoint
    Given sets facts for test case
    When api call is made for given url "/status/200"
    Then HTTP response status code will have 200
    And actual response body is equal to '{"status": 200}'

  Scenario Outline: GET parameters form postman API endpoint
    Given sets facts for test case
    When api call is made for given url "/get?<parameter>"
    Then HTTP response status code will have <status>
    And actual response body args is equal to '<message>'

    Examples:
      | parameter           | status | message                          |
      | grze=gorz           | 200    | {"grze": "gorz"}                 |
      | foo1=bar1&foo2=bar2 | 200    | {"foo1": "bar1", "foo2": "bar2"} |

