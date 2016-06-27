import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


class Download extends GetAndPost
{
	
public Download(WebDriver driver) throws InterruptedException, ClassNotFoundException, IOException, JSONException, SQLException
{
	super(driver);
	File file=new File("/home/jaspalchandramola/Downloads/file_handle_test.dat");
	if(file.exists())
	{
		file.delete();
		
	}	
	driver.findElement(By.linkText("Download File")).click();
	Thread.sleep(4000);

	Scanner data = new Scanner(new File("/home/jaspalchandramola/Downloads/file_handle_test.dat"));     
	ArrayList<String> dictionary=new ArrayList<String>();
	int i=0;
	while(data.hasNext())
	{
		dictionary.add(data.next());
		
		System.out.println(dictionary.get(i));
	i++;
	}
	String str4=dictionary.get(6);
	String []str3=str4.split(":");
	System.out.println(str4);
	WebElement webElement2=driver.findElement(By.id("signature"));
	webElement2.sendKeys(str4);
	WebElement x=driver.findElement(By.className("submit"));
	x.click();
	} 	



}
