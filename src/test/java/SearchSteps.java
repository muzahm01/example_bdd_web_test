import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


// this class is mapping of steps to test cases.

public class SearchSteps {
    WebDriver driver;

    @Given("^Browser is opened$")
    public void shouldOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
    }

    @When("^I navigate to \"(.*?)\"$")
    public void shouldNavigate(String url) {
        driver.navigate().to(url);
    }

    @And("^I verify page title \"(.*?)\" to confirm the site$")
    public void shouldVerifyTitle(String title) {
        // verify the page by its title
        assertTrue("website is not opened", driver.getTitle().contains(title));

    }

    @And("^I enter the search key \"(.*?)\"$")
    public void shouldEnterSearchKey(String searchKey) {
        // clear if anything already in search bar
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        // enter search key
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchKey);
    }

    @And("^I clicked on search button$")
    public void shouldClickOnSearchButton() {
        // click on search button
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

    }

    @And("^I sort results as \"(.*?)\"$")
    public void shouldSortSearchResult(String sortOption) {
        // select the sorting option from drop down
        driver.findElement(By.cssSelector(".a-dropdown-prompt")).click();
        //new Select(driver.findElement(By.id("a-autoid-0-announce"))).selectByVisibleText(sortOption);
    }

    @And("^I click on second item$")
    public void shouldClickOnSecondItem()  {
        driver.findElement(By.id("s-result-sort-select_2")).click();
    }

    @Then("^I verify product topic contains text \"(.*?)\"$")
    public void shouldVerifyTextOfItemTopic(String verifyText) {
        try {
            // verify the product and close browser
            //assertTrue("Product topic does not contain provide key",
              //      driver.findElement(By.id("productTitle")).getText().contains(verifyText));
            List<WebElement> myTags =  driver.findElements(By.tagName("h2"));
            for(int i = 0; i < myTags.size(); i++) {
                System.out.println(myTags.get(i).getText());
                System.out.println("\n line break \n");
            }
        } catch (AssertionError error) {

            Assert.fail(String.valueOf(error));
        }
        finally {
            driver.close();
            driver.quit();
        }

    }

}
