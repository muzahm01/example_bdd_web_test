Feature: search and verify item
# to test amazon.com for nikon camera
  Scenario: open amazon.com and search for nikon.com
    Given Browser is opened
    When I navigate to "http://www.amazon.com/"
    And I verify page title "Amazon" to confirm the site
    And I enter the search key "Nikon"
    And I clicked on search button
    And I sort results as "Price: High to Low"
    And I click on second item
    Then I verify product topic contains text "Nikon D3X"
