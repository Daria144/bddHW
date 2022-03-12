Feature: base test for Dou.ua

  Background:
    Given open Dou main page


  Scenario: Find vacancies by query in Kharkiv
   Given user is on Job tab
    When search for vacancies by query "java" in Kharkiv
   Then there are more than 0 vacancies

  Scenario: List of companies with short descriptions contains 20 companies
    Given user is on Job tab
    When go to Companies section
    Then list of companies contains 20 companies

    Scenario: Topics column contains entered search query
      Given enter "TDD vs BDD" in search field
      When go to the first article link
      Then the Topics column contains "TDD" and "BDD"



