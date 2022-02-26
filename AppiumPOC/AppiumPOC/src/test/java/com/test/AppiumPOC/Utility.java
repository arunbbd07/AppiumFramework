package com.test.AppiumPOC;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Utility {

	public void smartClick(WebDriver driver, String locatorType, String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		switch (locatorType.toLowerCase()) {
		case "xpath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			driver.findElement(By.xpath(locator)).click();
			break;
		case "id":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
			driver.findElement(By.id(locator)).click();
			break;
		}

	}

	public void smartSendkeys(WebDriver driver, String locatorType, String locator, String dataToEnter)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		switch (locatorType.toLowerCase()) {
		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			driver.findElement(By.xpath(locator)).sendKeys(dataToEnter);
			break;
		case "id":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			driver.findElement(By.id(locator)).sendKeys(dataToEnter);
			break;
		}

	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		try {
			switch (locatorType.toLowerCase()) {
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				break;
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void smartClickFirstItemOfList(WebDriver driver, String locatorType, String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		switch (locatorType.toLowerCase()) {
		case "id":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
			driver.findElements(By.id(locator)).get(0).click();
			break;
		}

	}

	public void smartSendkeysOnFirstItemList(WebDriver driver, String locatorType, String locator, String dataToEnter)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		switch (locatorType.toLowerCase()) {
		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			driver.findElements(By.xpath(locator)).get(0).clear();
			driver.findElements(By.xpath(locator)).get(0).sendKeys(dataToEnter);
			break;
		case "id":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			driver.findElements(By.id(locator)).get(0).clear();
			driver.findElements(By.id(locator)).get(0).sendKeys(dataToEnter);
			break;
		}

	}

	@SuppressWarnings("rawtypes")
	public void swipeToVerticalBottom(WebDriver driver) throws InterruptedException {
		Dimension size;
		size = ((WebDriver) driver).manage().window().getSize();
		int startY = (int) (size.height * 0.90);
		int endY = (int) (size.height * 0.10);
		int startX = size.width / 2;
		TouchAction action = new TouchAction((PerformsTouchActions) driver);
		action.press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(startX, endY)).release()
				.perform();

	}

}
