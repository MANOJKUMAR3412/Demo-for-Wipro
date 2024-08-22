//B.Manoj kumar
//Keyword
//08-08-2024




package KeywordDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionKeyword {

	WebDriver driver;

	public void setUpDriver() {

		String userDir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", userDir + "\\Drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void launchHomePage() {
		driver.get("https://www.oyorooms.com/");
	}

	public void setLocation(String location) {
		// Select Location
		driver.findElement(By.xpath("//*[@id=\"autoComplete__home\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"autoComplete__home\"]")).sendKeys(location);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"autoComplete__home\"]")).sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"autoComplete__home\"]")).sendKeys(Keys.ENTER);
	}

	public void setDate() {
		// select date
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[2]/div/div/span[1]"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[2]/div/span/div/div/div[2]/table/tbody/tr[5]/td[4]/span"))
				.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[2]/div/span/div/div/div[2]/table/tbody/tr[5]/td[5]/span"))
				.click();
	}

	public void clickSearchButton() {
		// Click Search Button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[4]/button")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ValidateSearchResult() {
		String searchResult = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/section/div/div[1]/div[1]/span/h1"))
				.getText();
		System.out.println("Results: " + searchResult);
		if (searchResult.contains("OYOs"))
			System.out.println("Results are displayed");
		else
			System.out.println("Error - No Result are displayed");
	}

	public void getHotelDetails() {
		String hotelName;
		String hotelPrice;

		System.out.println("Hotel Name  - Hotel Price");

		for (int i = 1; i <= 9; i = i + 2) {
			hotelName = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/section/div/div[2]/div[" + i
							+ "]/div/div[2]/div/div[1]/div[2]/div[1]/a/h3"))
					.getText();
			hotelPrice = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/section/div/div[2]"
					+ "/div[" + i + "]/div/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/span[1]")).getText();
			System.out.println(hotelName + " - " + hotelPrice);
		}

	}

}
