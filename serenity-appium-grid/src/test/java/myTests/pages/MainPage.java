package myTests.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPage extends PageObject {

	private static final String editName = "edit_name";
	private static final String editPhone = "edit_phone";
	private static final String editEmail = "edit_email";
	private static final String buttonPressMe = "button_pressMe";
	private static final String alertTitle = "alertTitle";
	private static final String messageContent =  "message";

    protected RemoteWebDriver driver;

	private String packageName = "com.myapplication:id/";

    public MainPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

	public WebElement findElementById(String elementId) {
		return driver.findElement(By.id(packageName+elementId));
	}

	public WebElement findAndroidElementById(String elementId) {
		return driver.findElement(By.id("android:id/"+elementId));
	}

	public void enterName(String name) {
		findElementById(editName).clear();
		findElementById(editName).sendKeys(name);
	}

	public void enterPhone(String phone) {
		findElementById(editPhone).clear();
		findElementById(editPhone).sendKeys(phone);
	}

	public void enterEmail(String email) {
		findElementById(editEmail).clear();
		findElementById(editEmail).sendKeys(email);
	}

	public void pressButton() {
		findElementById(buttonPressMe).click();
	}


	public void submitAllFields(String name,String phone, String email) {
		enterName(name);
		enterPhone(phone);
		enterEmail(email);
		pressButton();
	}

	public Boolean isAlertDialogDisplayed() {
		return findElementById(alertTitle).isDisplayed();
	}

	public String getMessageText() {
		return findAndroidElementById(messageContent).getText();
	}


}