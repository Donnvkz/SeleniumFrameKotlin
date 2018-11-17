@dev
Feature: Test search result

  Scenario: Scenario 1
    Given open startPage
    When writes in the search bar "NOVOSIBIRSK" and click Searh Button
    Then is opened main page
    When number of search result over 10


  Scenario: Scenario 2
    Given open startPage
    When writes in the search bar "" and click Searh Button
    Then is opened main page
    When number of search result exactly 0

