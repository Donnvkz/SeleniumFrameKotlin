@all
Feature: Test category Picture

  Scenario: Scenario 1
    Given open startPage
    When writes in the search bar "MOSCOW" and click Searh Button
    Then is opened main page
    When click navigation item by name "Картинки"
    Then is opened picture page
    When number of search result over 10



  Scenario: Scenario 2
    Given open startPage
    When writes in the search bar "" and click Searh Button
    Then is opened main page
    When number of search result exactly 0
    When click navigation item by name "Картинки"
    Then is opened picture page
    When number of search result exactly 0
