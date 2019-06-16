package ru.kashenkov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;
	private WebDriverWait webDriverWait;

	//Constructor
	public BasePage(WebDriver driver){
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, 10);
	}

	//Wait Wrapper Method
	public void waitVisibility(By elementBy) {
		webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	//Click Method
	public void click (By elementBy) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).click();
	}

	//Write Text
	public void writeText (By elementBy, String text) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
	}

	//Read Text
	public String readText (By elementBy) {
		waitVisibility(elementBy);
		return driver.findElement(elementBy).getText();
	}

}
