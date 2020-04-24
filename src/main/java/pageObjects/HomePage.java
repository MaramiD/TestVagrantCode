package pageObjects;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import frameworkBase.TestBotElementWrapper;

public class HomePage extends LoadableComponent<HomePage>{
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
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	pageWrapper= new TestBotElementWrapper(driver);
}
@FindBy(how=How.XPATH,using="//button[span[text()='Search']]")
private WebElement search_Button_Xpath;
@FindBy(how=How.XPATH,using="//input[@name='q']")
private WebElement search_input_Xpath;
@FindBy(how=How.XPATH,using="//li[a[div[span[span[text()='RoundNeck Shirt 14']]]]]")
private WebElement searchList_Dropdown_Xpath;
@FindBy(how=How.XPATH,using="//div[@class='page-width']/ul/li")
private List<WebElement> featuredCoolection_Item_Xpath;
@FindBy(how=How.XPATH,using="//h2[text()='Optimus Ecom']")
private WebElement scroll_Element1_Xpath;
@FindBy(how=How.XPATH,using="//h2[text()='Customised Shirts']")
private WebElement scroll_Element2_Xpath;
@FindBy(how=How.XPATH,using="//h2[text()='Featured collection']")
private WebElement scroll_Element3_Xpath;
 
 
public ProductDetailsPage searchProduct(XSSFRow rowData) {
	pageWrapper.click_Actions(search_Button_Xpath);
	pageWrapper.writeText(search_input_Xpath, rowData.getCell(1).toString());
	pageWrapper.click_Actions(searchList_Dropdown_Xpath);
	return new ProductDetailsPage(driver);
}
public ProductDetailsPage selectFeaturedCollection() {
	pageWrapper.ScrollToElement(scroll_Element1_Xpath);
	pageWrapper.ScrollToElement(scroll_Element2_Xpath);
	pageWrapper.ScrollToElement(scroll_Element3_Xpath);
	pageWrapper.click_Actions(featuredCoolection_Item_Xpath.get(1));
	return new ProductDetailsPage(driver);
}
}
