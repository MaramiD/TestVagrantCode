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

public class LoginPage extends LoadableComponent<LoginPage>{
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
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		pageWrapper= new TestBotElementWrapper(driver);
	}
@FindBy(how=How.XPATH, using="//div[@class='password-login']/a")
private WebElement enterUsingPassword_Button_Xpath;
@FindBy(how=How.ID,using="Password")
private WebElement password_Input_Id;
@FindBy(how=How.XPATH, using="//button[@type='submit']")
private List<WebElement> enter_Button_Xpath;

public HomePage LoginToApp(XSSFRow rowdata) {
	pageWrapper.click_Actions(enterUsingPassword_Button_Xpath);
	pageWrapper.writeText(password_Input_Id, rowdata.getCell(0).toString());
	pageWrapper.click_Actions(enter_Button_Xpath.get(0));
	return new HomePage(driver);

}
}
