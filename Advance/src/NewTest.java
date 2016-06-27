import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class NewTest {

	// for menu 
	public static void main(String [] args) throws SQLException, ClassNotFoundException, InterruptedException, IOException, JSONException
	{
		System.setProperty("webdriver.chrome.driver", "/home/jaspalchandramola/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		Download d=new Download(driver);
	
}}