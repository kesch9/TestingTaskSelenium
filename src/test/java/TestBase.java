import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import ru.kashenkov.pages.HomePage;
import ru.kashenkov.pages.SearchResultPage;

public class TestBase{

	WebDriver driver;
	HomePage homePage;
	SearchResultPage searchResultsPage;
	@FindBy(id = "error-message")
	WebElement searchError;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "/home/sergej/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cnn.com");
		homePage = new HomePage(driver);
	}

	@Test
	public void searchTestError(){
		homePage.searchForText("NFL");
		Assert.assertFalse("Error message should be present",
					searchError.isDisplayed());
//		return goToSearchResultPage();

	}

	@Test
	public void searchTest(){
		homePage.searchForText("NFLFake");
		Assert.assertTrue("Error message should be present",
				searchError.isDisplayed());
//		return goToSearchResultPage();
	}
}


