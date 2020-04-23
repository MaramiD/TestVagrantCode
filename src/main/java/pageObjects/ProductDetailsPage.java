package pageObjects;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import frameworkBase.TestBotElementWrapper;
import frameworkUtils.ExcelUtils;

public class ProductDetailsPage extends LoadableComponent<ProductDetailsPage>{
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
	public ProductDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    pageWrapper = new TestBotElementWrapper(driver);
	}
	@FindBy(how=How.XPATH,using="//button[@name='add']")
	private WebElement addToCart_Button_Xpath;
	@FindBy(how=How.XPATH,using="//div[@class='site-header__icons-wrapper']/a")
	private WebElement cart_Button_Xpath;
	@FindBy(how=How.XPATH,using="//h2[@id='CartPopupHeading']")
	private WebElement addedTocart_Heading_Xpath;;
	@FindBy(how=How.XPATH,using="//div[@class='cart-popup']/a")
	private WebElement viewCart_Button_Xpath;
	@FindBy(how=How.ID,using="SingleOptionSelector-1")
	private WebElement selectSize_Select_Id;
	
	public ProductDetailsPage clickAddToCart() {
		pageWrapper.click_Actions(addToCart_Button_Xpath);
		return this;
	}
	public String getAddedToCartMessage() {
		return pageWrapper.getText(addedTocart_Heading_Xpath);
	}
	public ProductDetailsPage goToCart() {
		pageWrapper.click_Actions(viewCart_Button_Xpath);
		return this;
	}
	public CartPage clickViewCart() {
		pageWrapper.click_Actions(viewCart_Button_Xpath);
		return new CartPage(driver);			
	}
	public ProductDetailsPage selectDifferentSize(XSSFRow rowData) {
		pageWrapper.selectByVisibleText(selectSize_Select_Id, rowData.getCell(4).toString());
		clickAddToCart();
		return this;
	}
	public  ProductDetailsPage addProductOfDifferentSizes() throws Exception {
		selectDifferentSize(ExcelUtils.getRowDataWithSheetName(1, "Ecom"));
		selectDifferentSize(ExcelUtils.getRowDataWithSheetName(2, "Ecom"));
		selectDifferentSize(ExcelUtils.getRowDataWithSheetName(3, "Ecom"));
		return this;
	}
}
