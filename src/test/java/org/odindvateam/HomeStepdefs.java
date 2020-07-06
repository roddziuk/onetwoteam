package org.odindvateam;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.odindvateam.StepDef.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class  HomeStepdefs {

    public static WebDriver driver;

    @Given("User is connected to the login page")
    public static void userIsConnectedToTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/org/odindvateam/chromedriver");
        driver = new ChromeDriver();

        StepDef.iAmOnThePage("https://chewie.one2team.com/");
        StepDef.iEnter("userName", "etudiant3");
        StepDef.iEnter("passWord", "Etudiant3*");
        StepDef.iEnter("domainName", "telco");
        StepDef.clickOnButtonConnexion();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @When("user clicks on button {string} with {string}")
    public void userClicksOnButton(String arg0, String arg1) throws InterruptedException {
        String cssRoot = "#root > div > section > section > div > main > div > div > div.shortcuts-section > div.shortcuts";
        if (driver.findElement(By.cssSelector(cssRoot)).getAttribute("class").equals("shortcuts collapsed")) {
            driver.findElement(By.cssSelector("#root > div > section > section > div > main > div > div > div.shortcuts-section > div.show-more-shortcuts > button" ));
        }
        driver.findElement(By.cssSelector(cssRoot+arg1)).click();
    }

    @Then("user is redirected to right page {string}")
    public void userIsRedirectedToRightPage(String arg0) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        int size = tabs.size();
        //array 0 ---> physiquement tab n1 = tab[0] / tab n2 = tab[1]
        driver.switchTo().window(tabs.get(size-1));
        assertTrue(driver.getCurrentUrl().contains(arg0));
    }

    @When ("user disconnects from platform")
    public void userDisconnectsFromPlatform() {
        driver.findElement(By.cssSelector("#root > div > section > section > div > header:nth-child(2) > div > div > i")).click();
        driver.findElement(By.cssSelector("body > div:nth-child(8) > div > div > ul > li:nth-child(2)")).click();
    }

    @Then("user is redirected to Login page")
    public void userIsRedirectedToLoginPage() {
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

}