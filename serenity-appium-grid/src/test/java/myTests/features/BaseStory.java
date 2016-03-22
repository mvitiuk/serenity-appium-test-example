package myTests.features;

import myTests.pages.MainPage;
import myTests.steps.BaseSteps;
import myTests.steps.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class BaseStory {

    @Steps
    public EndUserSteps userSteps;
    @Steps
    BaseSteps baseSteps;

    private static MainPage mainPage;

    private static String name = "mvitiuk";
    private static String phone = "+46 73 123 45 67";
    private static String email = "https://github.com/mvitiuk";

    @Before
    public void setUp(){
        try {
            baseSteps.initialisation("Nexus");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Title("Submiting values user should see correct message")
    public void submit_values_should_see_message_with_values() {
        userSteps.openMainPage();
        userSteps.submitValues(name, phone, email);

        userSteps.shouldSeeCorrectMessage(name, phone, email);
    }

    @After
    public void tearDown() {
        baseSteps.stopDriver();
    }
} 