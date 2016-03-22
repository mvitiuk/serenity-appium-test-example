package myTests.features;

import myTests.pages.MainPage;
import myTests.steps.BaseSteps;
import myTests.steps.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="testdata/values.csv")
//@Concurrent(threads = "2")
public class BaseWithDataFromCSVTest {

	@Steps
	public EndUserSteps userSteps;
	@Steps
	BaseSteps baseSteps;

	private static MainPage mainPage;

	private static String name;
	private static String phone;
	private static String email;

	public String message(){
		return "Hi, I am " + name + ", I can be reached at " + phone + " or " + email;
	}

	//ToDo fix this somehow. Get all rows, but submit only last one
	@Qualifier
	public String Qualifier(){
		//public String messsage() {
		return name + "=>" + phone + "=> " + email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Before
	public void setUp(){
		try {
			baseSteps.initialisation("HTC");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@WithTag("csv")
	@Title("Submiting values from file user should see correct message")
	public void submit_values_from_file_should_see_message_with_values() {
		userSteps.openMainPage();
		userSteps.submitValues(name, phone, email);
		userSteps.shouldSeeCorrectMessageWithDataFromCSV(message());
	}

	@After
	public void tearDown() {
		baseSteps.stopDriver();
	}

}
