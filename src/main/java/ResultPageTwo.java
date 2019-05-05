import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultPageTwo {
    private WebDriver driver;
    public ResultPageTwo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults2;

    public int getSearchResultsCount2() {
        return searchResults2.size();
    }
    public List<String> getSearchResult(){
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults2) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResult);

            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
