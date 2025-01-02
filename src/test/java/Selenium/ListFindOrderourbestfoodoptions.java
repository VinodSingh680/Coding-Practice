package Selenium;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListFindOrderourbestfoodoptions {
	public static void main(String[] args) {
		ListFindOrderourbestfoodoptions sw = new ListFindOrderourbestfoodoptions();
		sw.home();
	}

	public void home() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String expectedURL = "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto/PC_Mweb/Pizza.png";
		List<WebElement> items = driver.findElements(By.xpath("//button[@class='sc-hknOHE bPgEHF']"));
		for (WebElement item : items) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", item);
			WebElement img = item.findElement(By.tagName("img"));
			String imageUrl = img.getDomProperty("src");
			if (imageUrl.equals(expectedURL)) {
				item.click();
				break;
			}
		} 

		// Add to cart

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String expectedaddCart = "The Pizza Corner";
		List<WebElement> listdata = driver.findElements(By.xpath("//div[@class='sc-aXZVg kVQudY']"));
		for (WebElement cart : listdata) {
			wait.until(ExpectedConditions.elementToBeClickable(cart));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", cart);

//			WebElement findItem = cart.findElement(By.tagName("img"));
			String UrlImage = cart.getText();
			if (UrlImage.equals(expectedaddCart)) {
				cart.click();
				break;
			}
		}

	}

}