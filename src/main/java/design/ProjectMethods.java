package design;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.DataInputProvider;

public class ProjectMethods {
	public static ChromeDriver driver;
	public String dataSheetName;

	@Parameters({ "url" })
	@BeforeMethod

	public void startApp(String URL) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void closeapp() {
		driver.close();

	}

	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {
		return DataInputProvider.getSheet(dataSheetName);
	}

}
