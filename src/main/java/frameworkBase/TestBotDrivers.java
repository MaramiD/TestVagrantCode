package frameworkBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;

import frameworkListeners.WebEventListeners;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBotDrivers {
	/**
     * The tl driver.
     */
    private static ThreadLocal <WebDriver> tlDriver = new ThreadLocal <WebDriver>();
    /**
     * The driver.
     */
    private static WebDriver driver;

    /**
     * The web event listeners.
     */
    public static WebEventListeners webEventListeners = WebEventListeners.getInstance();

    /**
     * The event firing web driver.
     */
    public static EventFiringWebDriver eventFiringWebDriver;
    public static ChromeOptions chromeOptions = null;
    public static String host;
    public static String browserPropValue;
	private static boolean isLocal=false;
    /**
     * Sets the driver.
     *
     * @param browser the new driver
     * @param iTestContext
     */
    public synchronized static void setDriver(String browser, ITestContext iTestContext) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            setChrome(iTestContext);
        } else if (browser.equalsIgnoreCase("firefox")) {
            setFirefox(iTestContext);
        }
    }	

    /**
     * Gets the driver and listener.
     *
     * @param env
     * @return the driver and listener
     */
    public static WebDriver getDriverAndListener(String env) {

    	if(isLocal == true) {
    	     driver = getThreadLocalDriver();
    	}
        driver.manage().window().fullscreen();
        driver.manage().deleteAllCookies();

        eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(webEventListeners);
        driver = eventFiringWebDriver;
        driver.get(env);
        return driver;
    }

    /**
     * Sets the firefox.
     * @param iTestContext
     */
    private static void setFirefox(ITestContext iTestContext) throws MalformedURLException {
        FirefoxOptions firefoxoptions = new FirefoxOptions();       
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxoptions);
    }

    /**
     * Sets the chrome driver with chromeOptions.
     * @param iTestContext
     */
    private static void setChrome(ITestContext iTestContext) throws MalformedURLException {    	
    	
       if (System.getProperty("HUB_HOST") != null) {
        	chromeOptions = getChromeOptions(iTestContext);
            host = System.getProperty("HUB_HOST");
            String hubURL = "http://" + host + ":4444/wd/hub";
            driver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
        } else {

            WebDriverManager.chromedriver().setup();
            chromeOptions =  getChromeOptions(iTestContext);
            tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(chromeOptions));
            isLocal = true;
        }
    }

    private static ChromeOptions getChromeOptions(ITestContext iTestContext) {
    	 chromeOptions = new ChromeOptions();
         chromeOptions.addArguments("start-maximized", "disable-extensions",
                 "test-type", "no-default-browser-check", "disable-popup-blocking", "ignore-certificate-errors");
        if (System.getProperty("Headless") != null) {
            chromeOptions.addArguments("--headless");
        }
         chromeOptions.setCapability("name", iTestContext.getCurrentXmlTest().getName());         
         return chromeOptions;
	}

	/**
     * Gets the thread local driver.
     *
     * @return the thread local driver
     */
    //Get driver from tlDriver
    public synchronized static WebDriver getThreadLocalDriver() {

        return tlDriver.get();

    }

}
