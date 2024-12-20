package testngbasics;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "searchproduct")
	public Object[][] searchFunction() {
		return new Object[][] { { "kurta" }, { "airpod"}, { "laptop"}};
	}
	
	@DataProvider(name = "loginfb")
	public Object[][] loginFunction() {
		return new Object[][] { { "anjusathyanath","1234" }, { "reshmasuresh","password1" }, { "malu","pass2" } };
	}
}
