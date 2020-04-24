package frameworkBase;



import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import frameworkUtils.Constants;
import frameworkUtils.ExcelUtils;
import frameworkUtils.Log;

public class TestBotElementWrapper {
	/** The wait. */
 	private static WebDriverWait wait;
	 
 	/** The driver. */
 	private WebDriver driver;
 	 /** The javascript executor. */
 	public static JavascriptExecutor javascriptExecutor;
 	public Actions builder;
 	/**
 	 * Instantiates a new test bot elements wrapper.
 	 *
 	 * @param driver the driver
 	 */
 	public TestBotElementWrapper(WebDriver driver) {
	    this.driver = driver;
	    wait = new WebDriverWait(this.driver, Constants.TIMEOUT, Constants.POLLING);
	    builder = new Actions(this.driver);
	    javascriptExecutor =  (JavascriptExecutor)this.driver;
	    //pageGenerator = new TestBotPageGenerator(driver);
	    
	    }

    /**
  	 * writeText -> Check isElementDisplayed and then sendKeys.
  	 *
  	 * @param element the element
  	 * @param text the text
  	 */
 	   public void writeText(WebElement element, String text) {
 	    	if( isElementDisplayed(element))  { 
 	    		
 	    		element.sendKeys(text);
 	    	}
 		}
 	    
 	   
     	/* ============================================ Commands using wait conditions ============================================ */
 	    /**
     	 * Short wait.
     	 */
 	    public void shortWait() {
 			try {
 				Thread.sleep(2000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
 		}

 		/**
 		 * Medium wait.
 		 */
 		public void mediumWait() {
 			try {
 				Thread.sleep(5000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
 		}

 		/**
 		 * Long wait.
 		 */
 		public void longWait() {
 			try {
 				Thread.sleep(10000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
 		}
 	    
 		/**
 		 * Wait for element visible.
 		 *
 		 * @param webElement the web element
 		 * @return true, if successful
 		 */
 		public boolean waitForElementVisible( WebElement webElement)	{
 			
 			try {
 				wait.until(ExpectedConditions.visibilityOf(webElement));
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 				return false;
 			}
 			
 			return true;
 		}
 		
 		/**
 		 * Wait for element invisible.
 		 *
 		 * @param webElement the web element
 		 * @return true, if successful
 		 */
 		public boolean waitForElementInVisible(WebElement webElement) {
 			
 			try {
 				wait.until(ExpectedConditions.invisibilityOf(webElement));
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 				return false;
 			}
 			return true;
 		}
 		
 		/**
 		 * Wait for element to clickable.
 		 *
 		 * @param webElement the web element
 		 * @return true, if successful
 		 */
 		public boolean waitForElementToClickable(WebElement webElement) {
 			try {
 				wait.until(ExpectedConditions.elementToBeClickable(webElement));
 				
 			} catch (Exception e) {
 				e.printStackTrace();
 				return false;
 			}
 			return true;
 		}
 		
 		/**
 		 * Wait for page title.
 		 *
 		 * @param title the title
 		 * @return true, if successful
 		 */
 		public boolean waitForPageTitle(String title) {
 			try {
 				wait.until(ExpectedConditions.titleContains(title));
 			} catch (Exception e) {
 				e.printStackTrace();
 				return false;
 			}
 			return true;
 		}
 	
 		/**
 		 * Wait for text.
 		 *
 		 * @param webElement the web element
 		 * @param text the text
 		 * @return true, if successful
 		 */
 		public boolean waitForText(WebElement webElement, String text){
 			try{
 				
 				wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));	
 				
 			}
 			catch(Exception e)
 			{
 				return false;
 			}
 			return true;
 		}

 		/**
 		 * Wait and click web element.
 		 *
 		 * @param webElement the web element
 		 * @return true, if successful
 		 */
 		public boolean waitAndClickWebElement(WebElement webElement) {
 			
 			try {
 				wait.until(ExpectedConditions.elementToBeClickable(webElement));
 				//shortWait();
 				webElement.click();
 			
 				} catch (NoSuchElementException e) {
 			
 						System.out.println("Element was not found in DOM " +e.getStackTrace());
 						Log.error("Element was not found in DOM " +e.getStackTrace());
 			
 				} catch (Exception e) {
 					System.out.println("Unable to click on element " +e.getStackTrace());
 					Log.error("Unable to click on element " +e.getStackTrace());
 				}
 					return true;
 				}
 		
 		public void safeJavaScriptClick(WebElement webElement) throws Exception {
 			try {
 				
 				//if (webElement.isEnabled() && webElement.isDisplayed())
 				if (webElement.isDisplayed()) 
 				{
 				 javascriptExecutor.executeScript("arguments[0].click();", webElement);
 				
 				} 
 				
 			} catch (StaleElementReferenceException e) {
 				
 				System.out.println("Element is not attached to the page document " +e.getStackTrace());
 				Log.error("Element is not attached to the page document " +e.getStackTrace());
 				
 			} catch (NoSuchElementException e) {
 				
 				System.out.println("Element was not found in DOM " +e.getStackTrace());
 				Log.error("Element was not found in DOM " +e.getStackTrace());
 				
 			} catch (Exception e) {
 				System.out.println("Unable to click on element " +e.getStackTrace());
 				Log.error("Unable to click on element " +e.getStackTrace());
 			}
 		}
 		
 		
 	
 	
 	/* ============================================ START - Boolean Validatoins and Alerts ============================================ */
 	
 	/**
 	 * Checks if is element displayed.
 	 *
 	 * @param webElement the web element
 	 * @return true, if is element displayed
 	 */
 	public boolean isElementDisplayed(WebElement webElement){

 		try{
 			wait.until(ExpectedConditions.visibilityOf(webElement));
 			webElement.isDisplayed();
 		}
 		catch(NoSuchElementException e)
 		{
 			return false;
 		}
 		
 		catch(Exception e)
 		{
 			Log.error("Catch the exception"  +e.getStackTrace());
 			return false;
 		}
 		return true;
 	}
 	
 	/**
 	 * Checks if is element selected.
 	 *
 	 * @param element the element
 	 * @return true, if is element selected
 	 */
 	public boolean isElementSelected(WebElement element) {
 		
 		try {
 			element.isSelected();
 		}
 		catch(NoSuchElementException e) {
 			return false;
 		}
 		return true;
 	}
 	
 	/**
 	 * Checks if is element enabled.
 	 *
 	 * @param element the element
 	 * @return true, if is element enabled
 	 */
 	public boolean isElementEnabled(WebElement element) {
 		
 		try {
 			element.isEnabled();
 		}
 		catch(NoSuchElementException e) {
 			return false;
 		}
 		return true;
 	}
 	

 	/* ============================================ START - Select Methods  ============================================ */
 	
 	
 	/**
 	 * Select by visible text.
 	 *
 	 * @param webElement the web element
 	 * @param Key the key
 	 * @return true, if successful
 	 */
 	public void selectByVisibleText(WebElement webElement,String Key)
 	{
 		Select select = new Select(webElement);
 		select.selectByVisibleText(Key);
 	}

 	

 	
 	/**
 	 * Scroll down.
 	 *
 	 * @param element the element
 	 */
 	public void ScrollDown( WebElement element) {
 		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
 	}
 	
 	/* ============================================ START - Action Class Methods ============================================
 	 *  Mouse Actions: RED HAT - 
 	 * =================
 	 *  1. DragAndDrop	  
 	 *  3. MoveToElement
 	 *  6. Mouse hover
 	 *  
 	 *  4. ActionClick
 	 *  5. Rightclick
 	 *  6. Double Click
 	 *  2. ClickAndHold
 	 *  
 	 *  6. Mouse hover
 	 *  7. Send Enter / Tab Keys
 	 *  8. Double Click
 	 *  
 	 *  */
 	
 	/**
 	 * Drag and drop actions.
 	 *
 	 * @param driver the driver
 	 * @param sourceElement the source element
 	 * @param destinationElement the destination element
 	 */
 	public void dragAndDrop_Actions(WebElement sourceElement, WebElement destinationElement) {
 		
 		builder
 				.click(sourceElement)
 				.clickAndHold(sourceElement)  
 				.moveToElement(destinationElement)  
 				.release(destinationElement)  
 				.build()  // Get the action  
 				.perform();

 	}
 	
 	/**
 	 * Click and hold actions.
 	 *
 	 * @param driver the driver
 	 * @param webElement1 the web element 1
 	 * @param webElement2 the web element 2
 	 * @throws InterruptedException the interrupted exception
 	 */
 	public void clickAndHold_Actions(WebElement webElement1,WebElement webElement2) throws InterruptedException
 	{
 			builder
 					.clickAndHold(webElement1)
 					.build()
 					.perform();		
 		webElement2.click();
 		
 	}
 	
 	/**
 	 * Move to element actions.
 	 *
 	 * @param driver the driver
 	 * @param element the element
 	 */
 	public void moveToElement_Actions(WebElement element )
 	{
 		builder
 			.moveToElement(element)
 			.build()
 			.perform();

 	}
 	

 	/**
 	 * Click actions.
 	 *
 	 * @param driver the driver
 	 * @param element the element
 	 */
 	public void click_Actions(WebElement element )	
 	{
 		builder
 				.moveToElement(element)
 				.click()
 				.build()
 				.perform();

 	}
 	
 	// This method can be used when the element is visible but action cant be taken
 			public static void threadWait(WebElement e, long time) throws InterruptedException {
 				synchronized (e) {
 					e.wait(time);
 				}
 			}

 			// This method if element takes some time to be visible and we need a complete
 			// wait
 			public static void threadWait(WebDriver driver, long time) throws InterruptedException {
 				synchronized (driver) {
 					driver.wait(time);
 				}
 			}
 			
 		
 	  
 			
 			
 			public  void ScrollToElement( WebElement element) {
 				javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
 			}
 			
 			public void doubleClick(WebElement element)
 			{
 				builder.doubleClick(element).build().perform();
 			}
 	
 	//============================================ END - Action Class Methods ============================================//
 	
 	//================================= Basic Selenium GET Methods =============================//
 	
 	
 
 	
 	public String getText(WebElement webElement) {
 		return webElement.getText();
 		
 	}
 	public String getValue(WebElement webElement) {
 		return webElement.getAttribute("value");
 		
 	}
 	
 	public String getAttributeValue(WebElement webElement, String attribute) {
 		
 		return webElement.getAttribute(attribute);
 	}
 	
 	public String getTextAttribute(WebElement webElement) {
 		
 		return null;
 	}
 	public double getDoubleValue(WebElement element) {
 		String webText=element.getText();
 		String stringValue=webText.substring(4);
 		double doubleValue=Double.parseDouble(stringValue);
 		return doubleValue;
 	
 	}
 	
 	public double getFinalPrice(WebElement element, String quantity) {
 		double finalPrice=0;
 		double price=getDoubleValue(element);
 		int quantityValue=Integer.parseInt(quantity);
 		finalPrice=price*quantityValue;
 		return finalPrice;
 	}
 	

 	
 	
 	
 	
}
 
 			
 		
