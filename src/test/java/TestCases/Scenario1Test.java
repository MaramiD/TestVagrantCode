package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.asserts.SoftAssert;

import frameworkBase.TestBotBase;
import frameworkBase.TestBotElementWrapper;

import frameworkUtils.ExcelUtils;
import io.qameta.allure.Description;




public class Scenario1Test extends TestBotBase{
SoftAssert sa ;
TestBotElementWrapper pageWrapper;
@BeforeClass
public void testSetUp() throws Exception {
	pageGenerator.LoginPage().get()
	                         .LoginToApp(ExcelUtils.getRowDataWithSheetName(1, "Ecom"));
}
@Test(priority=1)
	@Description("Test Description-Search a product and add it to cart")
	public void TC_SearchAndAddToCart() throws Exception {
	String expectedMessage=System.getProperty("HeadingMessage");
	String actualMessage=pageGenerator.HomePage()
			                                    .searchProduct(ExcelUtils.getRowDataWithSheetName(1, "Ecom"))
			                                    .clickAddToCart()
			                                    .getAddedToCartMessage();
	sa.assertEquals(actualMessage, expectedMessage);
	sa.assertAll();
}
@Test(priority=2)
@Description("Test Description-Increase product quantity and validate price")
public void TC_IncreaseQuantityAndValidatePrice() throws Exception {
double expectedlValue=pageGenerator.ProductDetailsPage()
                                                    .clickViewCart()
                                                    .increaseQuantity(ExcelUtils.getRowDataWithSheetName(1, "Ecom"))
                                                    .getFinalPrice(ExcelUtils.getRowDataWithSheetName(1, "Ecom"));
double actualValue=pageGenerator.CartPage().getDoubleValueOfFinalPrice();
sa.assertEquals(actualValue, expectedlValue, 0);
sa.assertAll();
                           
                                                     
}
		
}
