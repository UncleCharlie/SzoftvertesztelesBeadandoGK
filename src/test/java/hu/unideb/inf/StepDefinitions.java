package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @io.cucumber.java.en.Given("^the homepage is opened$")
    public void theHomepageIsOpened() {
        driver.get("http://automationpractice.com/index.php");
    }

    @io.cucumber.java.en.And("^the sign in link is clicked$")
    public void theSignInLinkIsClicked() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
    }
    @Given("the Log In Button is clicked")
    public void theLogInButtonIsClicked() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("missing email message is shown")
    public void missingEmailMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
        Assert.assertNotEquals(0, elements.size());
        Assert.assertEquals("An email address required.", elements.get(0).getText());
    }

    @Given("the create account button is clicked")
    public void theCreateAccountBoxIsClicked() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @Then("no email message is shown")
    public void noEmailMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/ol"));
        Assert.assertNotEquals(0, elements.size());
        Assert.assertEquals("Invalid email address.", elements.get(0).getText());
    }
    @Then("invalid email message is shown")
    public void invalidEmailMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"create_account_error\"]/ol"));
        Assert.assertNotEquals(0, elements.size());
        Assert.assertEquals("Invalid email address.", elements.get(0).getText());
    }

    @Given("the email field is populated")
    public void theEmailFieldIsPopulated() {
        driver.findElement(By.id("email_create")).sendKeys("validmail@provider.com");
    }

    @Then("register form is opened")
    public void registerFormIsOpened() {
        //Assert.assertEquals("Create an account",driver.findElement(By.className("page-heading")).getText());
        boolean exists = driver.findElements(By.id("account-creation_form")).size() != 0;
        Assert.assertTrue("Check whether the form is presented",exists);
    }

    @Given("the email field is populated with {string}")
    public void theEmailFieldIsPopulatedWithValue(String value) {
        driver.findElement(By.id("email_create")).sendKeys(value);
    }

    @Given("the search field is populated with {string}")
    public void theSearchFieldIsPopulatedWithValue(String testSearchItem) {
        driver.findElement(By.id("search_query_top")).sendKeys(testSearchItem);
    }

    @And("the search button is clicked")
    public void theSearchButtonIsClicked() {
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
    }

    @Then("items are found")
    public void itemsAreFound() {
        Assert.assertNotEquals("0 results have been found.", driver.findElement(By.className("heading-counter")).getText());
    }
}