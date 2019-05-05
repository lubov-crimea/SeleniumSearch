import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;


public class SeleniumSearchTest {
    private WebDriver driver;
    public PageStartGoogle pageStartGoogle;

    /**
     * beforeMethod - метод для входа на сайт
     */
    @BeforeMethod
    public void beforeMethod() {

        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        pageStartGoogle = new PageStartGoogle(driver);
    }
    /**
     * afterMethod - метод для выхода из аккаунта
     */
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    /*@DataProvider
    public Object[][] GoogleDataProvider() {
        return new Object[][]{
                {"selenium"},
        };
    }*/
    @Test /*(dataProvider = "googleDataProvider") */
    public void seleniumSearchTest(){
        String searchTerm = "selenium"; //
        //public void seleniumSearchTest(String searchTerm){
        try {
            sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResultPageFirst resultPageFirst = pageStartGoogle.search(searchTerm);

        Assert.assertTrue(resultPageFirst.isPageLoaded(),
                "page.SearchResultPage is not loaded");

        Assert.assertEquals(resultPageFirst.getSearchResultsCount(), 10,
                "Results count is wrong!");

        List<String> searchResults = resultPageFirst.getSearchResult();

        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm: " +searchTerm+ " not found in:  \n" +searchResult);
        }

        ResultPageTwo resultPageTwo = resultPageFirst.goToResultPageTwo();

        Assert.assertEquals(resultPageTwo.getSearchResultsCount2(), 10,
                "Results count is wrong!");

        List<String> searchResults2 = resultPageTwo.getSearchResult();

        for (String searchResult2 : searchResults2) {
            Assert.assertTrue(searchResult2.contains(searchTerm),
                    "SearchTerm: " +searchTerm+ " not found in:  \n" +searchResult2);
        }
    }


}
