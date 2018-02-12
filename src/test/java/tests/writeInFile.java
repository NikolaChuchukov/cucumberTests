//NoWebTest
package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class writeInFile{

    PrintWriter writer = null;

    @Given("^I have created a test file$")
    public void createFile(){
        try {
            writer = new PrintWriter ("C:/Users/DELL/Desktop/test.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @When("^I write a text in it$")
    public void writeText(){
        writer.println("Nikola");
        writer.println("Chuchukov");
        writer.close();
    }

    @Then("^The file should be saved$")
    public void isFileSaved(){
        if(new File("C:/Users/DELL/Desktop/test.txt").exists()){
            System.out.println("Test passed");
        }else{
            Assert.fail("Test failed");
            System.out.println("Test failed");
        }
    }
}