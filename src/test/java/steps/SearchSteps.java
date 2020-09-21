package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


// this class is mapping of steps to test cases.

public class SearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    private String sortOption;

    @Given("^Browser is opened$")
    public void shouldOpenBrowser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        // implicit wait to load elements
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // explicit wait to wait to load a specific element on page refresh
        wait = new WebDriverWait(driver, 30);
    }

    @When("^I navigate to \"([^\"]*)\"$")
    public void souldNavigate(String url) throws Throwable {
        driver.navigate().to(url);
    }

    @And("^I verify page title \"([^\"]*)\" to confirm the site$")
    public void shouldVerifyTitle(String title) throws Throwable {
        // verify the page by its title
        assertTrue("website is not opened", driver.getTitle().contains(title));

    }

    @And("^I enter the search key \"([^\"]*)\"$")
    public void shouldEnterSearchKey(String searchKey) throws Throwable {
        // clear if anything already in search bar
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        // enter search key
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchKey);
    }

    @And("^I clicked on search button$")
    public void shouldClickOnSearchButton() throws Throwable {
        // click on search button
        driver.findElement(By.cssSelector("input.nav-input")).click();

    }

    @And("^I sort results as \"([^\"]*)\"$")
    public void shouldSortSearchResult(String sortOption) throws Throwable {
        // select the sorting option from drop down
        new Select(driver.findElement(By.id("sort"))).selectByVisibleText(sortOption);
    }

    @And("^I click on second item$")
    public void shouldClickOnSecondItem() throws Throwable {
        // wait until page is reload and sorted list is shown. this will check the presence of sort message.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='centerPlus']/h3")));
        // click on second item, you can change item number by changing "result_1" to "result_0-any positive integer"
        driver.findElement(By.xpath("//li[@id='result_1']/div/div[2]/div/a/h2")).click();
    }

    @Then("^I verify product topic contains text \"([^\"]*)\"$")
    public void shouldVerifyTextOfItemTopic(String verifyText) {
        try {
            // verify the product and close browser
            assertTrue("Product topic does not contain provide key", driver.findElement(By.id("productTitle")).getText().contains(verifyText));
            driver.close();
        } catch (AssertionError error) {

            Assert.fail(String.valueOf(error));
        }
        finally {
            driver.close();
            driver.quit();
        }

    }

}
