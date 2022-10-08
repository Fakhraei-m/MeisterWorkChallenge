package ms.app.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

import ms.app.qa.util.MyWebDriverListener;
import ms.app.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver e_driver;
	
	public static void GetProperties()
	{
		try {
			String ProjectPath = System.getProperty("user.dir");
			prop = new Properties();
			FileInputStream ip = new FileInputStream(ProjectPath+"/src/main/java/ms/app/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		GetProperties();
		String browserName = prop.getProperty("browser");
		String ProjectPath = System.getProperty("user.dir");
		if(browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "D:\\Users\\samsung\\Desktop\\SQA\\Projects\\Browser_Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", ProjectPath+"/src/main/resources/drivers/chromedriver.exe");// move drivers exe file to src/main/resources/drivers/
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")) {
			//System.setProperty("webdriver.gecko.driver", "D:\\Users\\samsung\\Desktop\\SQA\\Projects\\Browser_Drivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", ProjectPath+"/src/main/resources/drivers/geckodriver.exe");// move drivers exe file to src/main/resources/drivers/
			driver = new FirefoxDriver();
		}
		
		WebDriverListener listener = new MyWebDriverListener();
		e_driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));		
		driver.get(prop.getProperty("url"));
	}
}

