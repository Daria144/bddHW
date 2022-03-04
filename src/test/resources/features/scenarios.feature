Feature: base test for Dou.ua

  Scenario: Find vacancies by query java in Kharkiv
    Given user is on Job tab in Vacancies section
    When search for vacancies by query java in Kharkiv
    Then there are more than 0 vacancies