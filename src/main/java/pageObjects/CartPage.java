package pageObjects;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import frameworkBase.TestBotElementWrapper;

public class CartPage extends LoadableComponent<CartPage>{
	TestBotElementWrapper pageWrapper;
	private WebDriver driver;
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    pageWrapper = new TestBotElementWrapper(driver);
	}
	@FindBy(how=How.XPATH,using="//td[@class='cart__price text-right']/div[1]/dl/div/dd")
	private WebElement productPrice_Input_Xpath;
	@FindBy(how=How.XPATH,using="//td[@class='cart__final-price text-right small--hide']/div/span")
	private WebElement productFinalPrice_Input_Xpath;
	@FindBy(how=How.XPATH,using="//td[@class='cart__quantity-td text-right small--hide']/div[1]/input")
	private WebElement productQuantity_Input_Xpath;
	
	
	public CartPage increaseQuantity(XSSFRow rowData) {
		pageWrapper.writeText(productQuantity_Input_Xpath, rowData.getCell(3).toString());
		return this;
	}
	public double getFinalPrice(XSSFRow rowData) {
		return pageWrapper.getFinalPrice(productPrice_Input_Xpath, rowData.getCell(3).toString());
	}
	public double getDoubleValueOfFinalPrice() {
		return pageWrapper.getDoubleValue(productFinalPrice_Input_Xpath);
	}
	
}
