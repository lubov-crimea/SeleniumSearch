import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ResultPageFirst {
    private WebDriver driver;
    public ResultPageFirst(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement  resultPageTwoButton;

    public int getSearchResultsCount(){
        return searchResults.size();
    }
    public List<String> getSearchResult() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResult : searchResults){

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResult);
            String searchResultText = searchResult.getText();
            searchResultList.add(searchResultText);
        }
        return searchResultList;
    }
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/search");
    }
    public ResultPageTwo goToResultPageTwo() {
        resultPageTwoButton.click();
        return new ResultPageTwo(driver);
    }


}

