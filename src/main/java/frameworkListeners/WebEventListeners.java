package frameworkListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListeners implements WebDriverEventListener{
	/** The instance. */
	/*
	 * Declare singleton instance;
	 */
	public static WebEventListeners instance;
	
	/**
	 * Instantiates a new web event listeners.
	 */
	public WebEventListeners() {
		
	}
	
	/**
	 * Gets the single instance of WebEventListeners.
	 *
	 * @return single instance of WebEventListeners
	 */
	/*
	 * Singleton Method
	 */
	public static synchronized WebEventListeners getInstance() {
		
		return instance == null?(instance = new WebEventListeners()):instance;
	}
	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateTo(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateTo(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	/**
	 * Before change value of.
	 *
	 * @param element the element
	 * @param driver the driver
	 */
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString()
				+ " before any changes made");
	}

	/**
	 * After change value of.
	 *
	 * @param element the element
	 * @param driver the driver
	 */
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeClickOn(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterClickOn(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateBack(org.openqa.selenium.WebDriver)
	 */
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateBack(org.openqa.selenium.WebDriver)
	 */
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateForward(org.openqa.selenium.WebDriver)
	 */
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateForward(org.openqa.selenium.WebDriver)
	 */
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#onException(java.lang.Throwable, org.openqa.selenium.WebDriver)
	 */
	public void onException(Throwable error, WebDriver driver) {
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeFindBy(org.openqa.selenium.By, org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterFindBy(org.openqa.selenium.By, org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeScript(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterScript(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	public void afterScript(String script, WebDriver driver) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeAlertAccept(org.openqa.selenium.WebDriver)
	 */
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterAlertAccept(org.openqa.selenium.WebDriver)
	 */
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterAlertDismiss(org.openqa.selenium.WebDriver)
	 */
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeAlertDismiss(org.openqa.selenium.WebDriver)
	 */
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeChangeValueOf(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver, java.lang.CharSequence[])
	 */
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterChangeValueOf(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver, java.lang.CharSequence[])
	 */
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterGetScreenshotAs(org.openqa.selenium.OutputType, java.lang.Object)
	 */
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterGetText(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver, java.lang.String)
	 */
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterSwitchToWindow(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeGetScreenshotAs(org.openqa.selenium.OutputType)
	 */
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeGetText(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeSwitchToWindow(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
