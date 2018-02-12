// Setup Cucumber environment and Step definition file
package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class homePage{

WebDriver driver = null;

    @Given("^We have opened the browser$")
    public void openBrowser(){
        driver = new FirefoxDriver();
    }

    @When("^We try to access home page$")
    public void goToPL(){
        driver.navigate().to("https://fantasy.premierleague.com/");
    }

    @Then("^The home page is successfully opened$")
    public void isHomePageOpened(){
        if (driver.findElement(By.id("ismjs-username")).isDisplayed())
        {
            System.out.println("Test passed");
        }else{
            Assert.fail("Test failed");
            System.out.println("Test failed");
        }
        driver.close();
    }

}