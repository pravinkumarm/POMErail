package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import design.ProjectMethods;
import pages.LoginPage;

public class TC101_Erail extends ProjectMethods {

	@BeforeTest
	public void setData() {
		dataSheetName = "Erailspread";

	}

	@Test(dataProvider = "fetchData")
	public void loginerail(String FR, String T, String Express) throws InterruptedException {
		new LoginPage().enterTrainFrom(FR).enterTrainTo(T).clickCheckbox().checkExpress(Express);

	}

}
