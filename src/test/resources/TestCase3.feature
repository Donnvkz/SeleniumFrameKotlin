@all

Feature: Test category Video

  Scenario: Scenario 1
    Given open startPage
    When writes in the search bar "EKATERINBURG" and click Searh Button
    Then is opened main page
    When click navigation item by name "Видео"
    Then is opened video page
    When number of search result over 2



  Scenario: Scenario 2
    Given open startPage
    When writes in the search bar "" and click Searh Button
    Then is opened main page
    When click navigation item by name "Видео"
    Then is opened video page
    When number of search result exactly 0
