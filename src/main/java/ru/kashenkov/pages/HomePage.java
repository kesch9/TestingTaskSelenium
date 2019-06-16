package ru.kashenkov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//*********Constructor*********
	public HomePage (WebDriver driver) {
		super(driver);
	}

	//*********Page Variables*********
	String baseURL = "http://www.cnn.com/";

	//*********Web Elements*********
	@FindBy(id = "submit_button")
	WebElement searchButtonBy;
	@FindBy(id = "search__input-field")
	WebElement inputField;


	//*********Page Methods*********
	//Go to Homepage
	public HomePage goToN11(){
		driver.get(baseURL);
		return this;
	}
	//Search text
	public void searchForText(String text){
		inputField.sendKeys(text);
		searchButtonBy.click();
	}
	//Clear Search
	public void clearSearch() {
		inputField.clear();
	}

	//Go to SearchResultPage
	public SearchResultPage goToSearchResultPage (){
		return new SearchResultPage(driver);
	}


}
