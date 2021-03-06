package TestCases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameworkBase.TestBotBase;
import frameworkBase.TestBotElementWrapper;
import frameworkUtils.ExcelUtils;
import io.qameta.allure.Description;

public class Scenarioe2Test extends TestBotBase{
	SoftAssert sa ;
	TestBotElementWrapper pageWrapper;
	@BeforeClass
	public void testSetUp() throws Exception {
		pageGenerator.LoginPage().get()
		                         .LoginToApp(ExcelUtils.getRowDataWithSheetName(1, "Ecom"));
	}
	@Test(priority=1)
	@Description("Test Description-Add product from featured collection")
	public void TC_AddProductFromCollection() throws Exception {
	String expectedMessage=System.getProperty("HeadingMessage");
	String actualMessage=pageGenerator.HomePage()
			                                    .selectFeaturedCollection()
			                                    .clickAddToCart()
			                                    .getAddedToCartMessage();
	sa.assertEquals(actualMessage, expectedMessage);
	sa.assertAll();
}
}
