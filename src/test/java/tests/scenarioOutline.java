package tests;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class scenarioOutline {

    WebDriver driver = null;

    @Given("^We have navigated to PL$")
    public void goToPL() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://fantasy.premierleague.com/");
    }

    @When("^I enter Email \"([^\"]*)\" and I enter Password \"([^\"]*)\"$$")
    public void i_enter_email_email_and_I_enter_pass_password(String arg1, String arg2) {
        driver.findElement(By.id("ismjs-username")).sendKeys(arg1);
        driver.findElement(By.id("ismjs-password")).sendKeys(arg2);
        driver.findElement(By.xpath("/html/body/main/div[4]/div/div[3]/div[1]/form/div[3]/div/button")).click();
    }

    @Then("^Login fails$")
    public void failedLogin() {
        if (driver.getCurrentUrl().equalsIgnoreCase(
                "https://fantasy.premierleague.com/?fail")) {
            System.out.println("Test Pass");
        } else {
            Assert.fail("User logged in");
        }
        driver.close();
    }
}