package Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





public class crossbrowserTesting {

	
		// TODO Auto-generated method stub
	  WebDriver driver;

	    @Parameters("browser")
	    @BeforeMethod
	    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
	        switch (browser.toLowerCase()) {
	            case "firefox":
	              
	                driver = new FirefoxDriver();
	                break;
	            case "edge":
	              
	                driver = new EdgeDriver();
	                break;
	            case "chrome":
	            default:
	             
	                driver = new ChromeDriver();
	                break;
	        }
	        driver.manage().window().maximize();
	        driver.get("https://www.analyticsvidhya.com/");
	    }

	    @Test
	    public void verifyHomePageTitle() {
	        String actualTitle = driver.getTitle();
	        Assert.assertTrue(actualTitle.contains("Analytics Vidhya"), "Homepage title mismatch!");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


