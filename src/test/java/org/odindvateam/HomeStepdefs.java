package org.odindvateam;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.odindvateam.StepDef.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class  HomeStepdefs {

    public static WebDriver driver;


    @Given("User is connected to the login page")
    public static void userIsConnectedToTheLoginPage() {

        driver = new ChromeDriver();

        StepDef.iAmOnThePage("https://chewie.one2team.com/");
        StepDef.iEnter("userName", "etudiant3");
        StepDef.iEnter("passWord", "Etudiant3*");
        StepDef.iEnter("domainName", "telco");
        StepDef.clickOnButtonConnexion();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @When("User is on the home page")
    public static void userIsOnTheHomePage() {
        driver.get("https://chewie.one2team.com/slideboard-new/home/");
    }
    @And("User clicks on the Photo button")
    public static void userClicksOnThePhotoButton() {
            driver.findElement(By.cssSelector("#root>div>section>section>div>header:nth-child(2)")).click();
            driver.findElement(By.cssSelector("body>div:nth-child(8)>div>div>ul>li:nth-child(2)")).click();
        }

    @Then("Photo options are displayed")
    public static void photoOptionsAreDisplayed() {
        driver.get("https://chewie.one2team.com/");
        driver.close();
    }
}