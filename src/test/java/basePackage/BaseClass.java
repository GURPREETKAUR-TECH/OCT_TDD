package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Time;

public class BaseClass {
 public static Properties prop=new Properties();
 public static WebDriver driver;
 //create constructor
public BaseClass() {
	// to connect config.properties file with base class
	try {
		FileInputStream file=new FileInputStream("C:\\Users\\gurpr\\eclipse-workspace\\newguru\\OCT_TDD\\src\\test\\java\\environVariables\\config.properties");
		// to read properties of file
         prop.load(file);
	                        }
	 catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	catch(IOException a) {
	a.printStackTrace();
}
}
// common commands
   public static void initiate() {
	   String browsername=prop.getProperty("browser");
	   if(browsername.equals("chrome")) {
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\OCT_TDD\\chromedriver-win64\\chromedriver.exe");
		   driver=new ChromeDriver();
	   }
	   else if(browsername.equals("FireFox")) {
		   System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		   driver=new FirefoxDriver();
   }
	   driver.get(prop.getProperty("url"));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.unit));
   }
   public static void screenshots(String filename) {
	   File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   try {
		FileUtils.copyFile(file,new File("C:\\Users\\gurpr\\eclipse-workspace\\newguru\\OCT_TDD\\src\\main\\java\\screenshot\\screenshots"+filename+".jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
