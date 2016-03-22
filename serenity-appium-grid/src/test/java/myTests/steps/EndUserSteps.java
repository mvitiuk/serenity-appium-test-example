package myTests.steps;

import myTests.pages.MainPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class EndUserSteps extends BaseSteps {

	private static MainPage mainPage;


    @Step
    public void openMainPage(){
        mainPage = new MainPage(driver);
    }

	@Step
	public void submitValues(String name, String phone, String email) {
		mainPage.submitAllFields(name, phone, email);
		Serenity.takeScreenshot();
	}

	@Step
	public void shouldSeeCorrectMessage(String name, String phone, String email){
		String expectedMessage = "Hi, I am " + name + ", I can be reached at " +
		phone + " or " + email;
		String actualMessage = mainPage.getMessageText();
		assertTrue("Dialog is not displayed", mainPage.isAlertDialogDisplayed());
		assertEquals("Wrong message", expectedMessage, actualMessage);
	}

	@Step
	public void shouldSeeCorrectMessageWithDataFromCSV(String expectedMessage) {
		String actualMessage = mainPage.getMessageText();
		assertTrue("Dialog is not displayed", mainPage.isAlertDialogDisplayed());
		assertEquals("Wrong message", expectedMessage, actualMessage);

	}


}