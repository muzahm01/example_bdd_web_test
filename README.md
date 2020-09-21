# Example test project for Web using sellenium, cucumber (bdd) and maven. 
## Description
This is an example project to automate testing of a shopping web site, in this project we used amazon.com as example and search for the Nikon, from the result we sort from Highest price to the lowest price and then select the second item from the list, then we verify from selected product title we assert the keyword we are looking for is in the title or not. 

- The project has been built with maven, cucumber and selenium to automate a web page search (for example: amazon.com).
- To run this code you had to update the web driver at: https://github.com/muzahm01/example_bdd_web_test/blob/master/src/test/java/SearchSteps.java#L24-L25
- This project has been tested in Chrome version 85x and chrome driver compatible with version 85x.
- You can find Cucumber Feature written under : https://github.com/muzahm01/example_bdd_web_test/blob/master/src/test/resources/search.feature
- The url of site is parameterize at: https://github.com/muzahm01/example_bdd_web_test/blob/master/src/test/resources/search.feature#L5, you can set this as you like, as well as site title, the search and verifying keyword is also parameterized.
- The mapping of this Feature as steps at: https://github.com/muzahm01/example_bdd_web_test/blob/master/src/test/java/SearchSteps.java
- To run this project using command line in maven the runner is written at: https://github.com/muzahm01/example_bdd_web_test/blob/master/src/test/java/RunnerTest.java
- You can run this project with  "mvn clean test".
