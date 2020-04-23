package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameworkBase.TestBotBase;
import frameworkBase.TestBotElementWrapper;
import frameworkListeners.TestListeners;
import frameworkUtils.ExcelUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;



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
	AssertJUnit.assertEquals(actualMessage, expectedMessage);
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
AssertJUnit.assertEquals(actualValue, expectedlValue, 0);
sa.assertAll();
                           
                                                     
}
		
}
