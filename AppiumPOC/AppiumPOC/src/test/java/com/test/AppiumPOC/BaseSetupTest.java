package com.test.AppiumPOC;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseSetupTest {
	Utility mobileUtils = new Utility();
	AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> baseSetUp() throws MalformedURLException {
		File file = new File("src/test/java");
		File fileApk = new File(file, "ShopsClues1.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		// To run on real device
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "R9ZN710L3YF");
		// To run on emulator device
		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "EmulatorArun");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		cap.setCapability("uiautomator2ServerInstallTimeout", "5000000");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
}
