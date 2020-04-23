package frameworkBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.LoginPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.CartPage;

public class TestBotPageGenerator {
	protected WebDriver driver;

	public  TestBotPageGenerator(WebDriver driver) {
	// TODO Auto-generated constructor stub

	this.driver = driver;
	}
	/**
	    * Login page elements.
	    *
	    * @return the login page elements
	    */
	public synchronized LoginPage LoginPage() {        
	   try { 

   		return PageFactory.initElements(driver, LoginPage.class);
   		}

   		catch (Exception e) {
   		e.printStackTrace();
   		throw e;
   		}
    }
	/**
	    * Home page elements.
	    *
	    * @return the Home page elements
	    */
	public synchronized HomePage HomePage() {        
	   try { 

		return PageFactory.initElements(driver, HomePage.class);
		}

		catch (Exception e) {
		e.printStackTrace();
		throw e;
		}
 }
	/**
	    * ProductDetails page elements.
	    *
	    * @return the Product Details page elements
	    */
	public synchronized ProductDetailsPage ProductDetailsPage() {        
	   try { 

		return PageFactory.initElements(driver, ProductDetailsPage.class);
		}

		catch (Exception e) {
		e.printStackTrace();
		throw e;
		}
}   
	/**
	    * Cart page elements.
	    *
	    * @return the cart page elements
	    */
	public synchronized CartPage CartPage() {        
	   try { 

		return PageFactory.initElements(driver, CartPage.class);
		}

		catch (Exception e) {
		e.printStackTrace();
		throw e;
		}
}   
	
}
