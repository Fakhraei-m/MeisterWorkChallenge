package ms.app.qa.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ms.app.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 10;	


	public void SwitchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	
	public static void TakeScreenshot() throws IOException{
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String CurrentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(SrcFile, new File(CurrentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}

