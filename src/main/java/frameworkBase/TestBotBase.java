package frameworkBase;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import frameworkUtils.Log;

/**
 * Hello world!
 *
 */
public class TestBotBase 
{
	/** The driver. */
	public static WebDriver driver;
	
	/** The wait. */
	public static WebDriverWait wait;
	
	/** The page generator. */
	public TestBotPageGenerator pageGenerator;
	
	/** The Constant CONFIG_FILENAME. */
	//static File propFile = new File(System.getProperty("user.dir")+"//src//test//java/resources//config.properties");
	private static final String CONFIG_FILENAME= "config";

	
	/** The resource bundle. */
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(CONFIG_FILENAME);
	
	/** Assertion */
	public SoftAssert softAssert = new SoftAssert();
    
	/**
	 * Global test setup.
	 *
	 * @param browser the browser
	 */
	@BeforeMethod(description = "Method level Setup!")
	@Parameters(value = {"browser", "env"})
	public void globalTestSetup(@Optional String browser, String env, ITestContext iTestContext) throws MalformedURLException {
		Log.info("BeforeMethod is started. " + Thread.currentThread().getId());
		if (System.getProperty("BROWSER") != null) {
            browser = System.getProperty("BROWSER");
        }		
		TestBotDrivers.setDriver(browser, iTestContext);
		driver = TestBotDrivers.getDriverAndListener(env);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Instantiate the PageGenerator Class
		pageGenerator =  new TestBotPageGenerator(getDriverWithListeners());
		Log.info("BeforeMethod is started. " + Thread.currentThread().getId());
	}
	
	/**
	 * Gets the driver with listeners.
	 *
	 * @return the driver with listeners
	 */
	public synchronized static WebDriver getDriverWithListeners() {
		
		return driver;
	}

	
	 /**
 	 * Global tear down.
 	 */
	 @AfterMethod(description = "Method Level Teardown!")
	 public void globalTearDown() {
	       getDriverWithListeners().quit();
	    }

	/**
	 * Method to read the property value.
	 *
	 * @param key the key
	 * @return the property
	 */
	public static String getProperty(final String key) {
	    String propertyValue = null;
	
	    if(resourceBundle != null) {
	    	propertyValue = resourceBundle.getString(key);
	    	
	    	Log.info("Property Value Found: " + propertyValue + " For Key: " +key);
	    }
	    else {
	    	Log.info("Property File not loaded successfully! ");
	    }
	    return propertyValue;
	}


}
