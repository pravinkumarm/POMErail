package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import design.ProjectMethods;

public class LoginPage extends ProjectMethods {

	public LoginPage enterTrainFrom(String FR) {

		driver.findElementById("txtStationFrom").clear();

		driver.findElementById("txtStationFrom").sendKeys(FR, Keys.TAB);
		return this;
	}

	public LoginPage enterTrainTo(String T) {
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys(T, Keys.TAB);
		return this;
	}

	public LoginPage clickCheckbox() throws InterruptedException {
		WebElement checkbox = driver.findElementById("chkSelectDateOnly");
		if (checkbox.isSelected()) {
			driver.findElementById("chkSelectDateOnly").click();
		}
		Thread.sleep(3000);
		return this;

	}

	public LoginPage checkExpress(String Express) throws InterruptedException {
		// char check = 'S';

		Thread.sleep(3000);
		WebElement table = driver.findElementByXPath("//table[@class='DataTable TrainList']");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowcount = rows.size();
		for (int i = 0; i < rowcount; i++) {
			WebElement singlerow = rows.get(i);
			List<WebElement> columns = singlerow.findElements(By.tagName("td"));
			String trainname = columns.get(1).getText();
			if (trainname.equalsIgnoreCase(Express)) {
				System.out.println("Train seats in " +Express +":"  +columns.get(18).getText());
			}

		}
		return this;
	}

}
