Feature: search and verify item
# to test amazon.com for nikon camera
  Scenario: open amazon.com and search for nikon.com
    Given Browser is opened
    When navigate to "http://www.amazon.com/"
    And verify page title "Amazon" to confirm the site
    And enter the search key "Nikon"
    And clicked on search button
    And sort results as Price High to Low
    And click on second item
    Then verify product topic contains text "Nikon"
