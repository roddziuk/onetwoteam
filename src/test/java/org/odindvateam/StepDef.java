package org.odindvateam;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class StepDef {

    public static WebDriver driver;
    static String base_url = "https://chewie.one2team.com/";

   @Given("I am on the page {string}")
    public static void iAmOnThePage(String arg0) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/org/odindvateam/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get(base_url);
    }
    @When("I enter {string} {string}")
    public static void iEnter(String field, String value) {
        driver.findElement(By.id(field)).clear();
        driver.findElement(By.id(field)).sendKeys(value);
    }

    @And("click on button Connexion")
    public static void clickOnButtonConnexion() {
        //WebElement login = driver.findElement(By.id("SubmitLogin"));
        driver.findElement(By.xpath("//*[@id=\"flogin\"]/input")).submit();
    }

    @Then("login is successful")
    public static void loginIsSuccessful() {

        String expectedTitle = "One2team - Connexion";
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    @Then("Error message displayed")
    public static void errorMessageDisplayed() {
        assertTrue(driver.findElement(By.cssSelector("#errorMsg > div")).isDisplayed());
        driver.close();
    }

}
