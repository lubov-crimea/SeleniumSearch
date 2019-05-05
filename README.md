Liubov. Test project "SeleniumSearch"
=============================
It is simple test, that will open google.com in web browser, search for "Selenium" and verify results on first 2 pages.

ABOUT COMPONENTS
------------
The project consists of 2 parts-main and test. 
Section "Main" includes 3 classes:
PageStartGoogle (this class is dedicated to the Google start page, contains x-path for search fields, methods for entering a search query, and moving to the next page)
ResultPageFirst (algorithm for displaying the list of results by the search word is displayed, if the given page is checked, the page is moved to the next page with the search results)
ResultPageTwo (essentially duplicates the previous class, sets the algorithm for generating a list of results on the second search page)
"Test" folder contains one class "SeleniumSearchTest" (contains: beforeMethod-open google.com page, afterMethod-close browser; assert-test number of Search results is 10 on page 1/2, assert, that each result in a list contains searchterm).

WHAT IS NEEDED TO RUN AUTO-TEST
------------
1) mvn
2) jdk
3) chrome driver
4) chrome browser
5) Git
6) Jenkins etc.

To start the test you need to open the project "SeleniumSearch" in Jenkins. You can also use IntelliJ IDEA and click "Run" 
to run the test.
Link for download this project from the git repository: https://github.com/lubov-crimea/SeleniumSearch
