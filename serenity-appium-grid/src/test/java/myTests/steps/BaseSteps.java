package myTests.steps;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BaseSteps {

	protected static RemoteWebDriver driver;


	public void initialisation(String deviceModel) throws Exception {
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities(deviceModel));
	}

	public DesiredCapabilities capabilities(String deviceModel) {

		DesiredCapabilities capa = DesiredCapabilities.android();

		capa.setCapability("browserName", "");
		capa.setCapability("platformName", "Android");
		capa.setCapability("app", "/Users/mariiavitiuk/test_projects/serenity-appium-test-example/APK/app-debug.apk");

		if (deviceModel.equals("Samsung S5")) {
			capa.setCapability("deviceName", "879e6464");
			capa.setCapability("platformVersion","5.0");
		}

		if (deviceModel.equals("Samsung Win")) {
			capa.setCapability("platformVersion","16");
			capa.setCapability("deviceName", "3b037041");
		}

		if (deviceModel.equals("Samsung Grand")) {
			capa.setCapability("platformVersion","19");
			capa.setCapability("deviceName", "224bf2e7");
		}

		if (deviceModel.equals("HTC")) {
			capa.setCapability("deviceName", "192.168.57.101:5555");
			capa.setCapability("platformVersion","4.3");
		}

		if (deviceModel.equals("Nexus")) {
			capa.setCapability("deviceName", "192.168.57.102:5555");
			capa.setCapability("platformVersion","5.1");
		}

		if (deviceModel.equals("emulator")) {
			capa.setCapability("deviceName", "emulator-5554");
			capa.setCapability("platformVersion","5.1");
		}

		return capa;
	}

	public void stopDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
