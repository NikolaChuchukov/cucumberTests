//ScenarioOutline, Data tables
package tests;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class login{

    @Before public void startFirefox(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    WebDriver driver = null;
    @Given("^We have navigated to fantasyPL$")
    public void openBrowser(){
        driver.navigate().to("https://fantasy.premierleague.com/");
    }

    @When("^I enter email and I enter pass$")
    public void i_enter_email_email_and_I_enter_pass_password(DataTable table){
        List<List<String>> data = table.raw();

        driver.findElement(By.id("ismjs-username")).sendKeys(data.get(1).get(0));
        driver.findElement(By.id("ismjs-password")).sendKeys(data.get(1).get(1));
        driver.findElement(By.xpath("/html/body/main/div[4]/div/div[3]/div[1]/form/div[3]/div/button")).click();
    }

    @Then("^Login should fail$")
    public void validateRelogin() {
        if(driver.getCurrentUrl().equalsIgnoreCase(
                "https://fantasy.premierleague.com/?fail")){
            System.out.println("Test Pass");
        } else {
            Assert.fail("User logged in");
        }

    }

    @Given("^We are at relogin page$")
    public void goToFantasy(){
        driver.navigate().to("https://fantasy.premierleague.com/");
    }

    @When("^I enter correct email and I enter pass$")
    public void relogin(DataTable table1){
        List<List<String>> data1 = table1.raw();

        driver.findElement(By.id("ismjs-username")).sendKeys(data1.get(0).get(0));
        driver.findElement(By.id("ismjs-password")).sendKeys(data1.get(0).get(1));
        driver.findElement(By.xpath("/html/body/main/div[4]/div/div[3]/div[1]/form/div[3]/div/button")).click();
    }

    @Then("^Login should succeed$")
    public void validateLogin() {
        if(driver.getCurrentUrl().equalsIgnoreCase(
                "https://fantasy.premierleague.com/a/team/851291/event/27")){
            System.out.println("Test Pass");
        } else {
            Assert.fail("User log in failed");
        }

    }

    @After public void cleanUp(){
        driver.close();
    }
}