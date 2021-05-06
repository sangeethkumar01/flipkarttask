$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/Searchredmi.feature");
formatter.feature({
  "name": "the readmi text and price",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "validate the readmi text and price",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user need to close login pops",
  "keyword": "When "
});
formatter.step({
  "name": "user need to click the search box",
  "keyword": "When "
});
formatter.step({
  "name": "user enter the product and click search \"\u003cproduct\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "user need to get redmi phone text and price",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "product"
      ]
    },
    {
      "cells": [
        "redmi mobile"
      ]
    }
  ]
});
formatter.scenario({
  "name": "validate the readmi text and price",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user need to close login pops",
  "keyword": "When "
});
formatter.match({
  "location": "Readmimobile.user_need_to_close_login_pops()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user need to click the search box",
  "keyword": "When "
});
formatter.match({
  "location": "Readmimobile.user_need_to_click_the_search_box()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter the product and click search \"redmi mobile\"",
  "keyword": "And "
});
formatter.match({
  "location": "Readmimobile.user_enter_the_product_and_click_search(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user need to get redmi phone text and price",
  "keyword": "And "
});
formatter.match({
  "location": "Readmimobile.user_need_to_get_redmi_phone_text_and_price()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});