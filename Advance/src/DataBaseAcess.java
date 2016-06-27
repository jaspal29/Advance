import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


class DataBaseAcess extends Menu{	
	
	public DataBaseAcess(WebDriver driver) throws ClassNotFoundException, SQLException, InterruptedException, IOException, JSONException{
	  super(driver);
		WebElement webElement=driver.findElement(By.xpath("html/body/div/div[2]/div/form/div"));
	    String str1=webElement.getText().toString();
	    Thread.sleep(2000);
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc","tatocuser","tatoc01"); 
	 
	    Statement query = con.createStatement();
	    String strname="SELECT id  FROM identity where Symbol="+"'"+str1+"'";
	   ResultSet set=query.executeQuery(strname);
	   set.first();
	   
	   String str=set.getString("id");
	   System.out.print(set.getString("id"));
	   set.close();
	   String strnameandpass="SELECT name,passkey  FROM credentials where id="+"'"+str+"'";
	   
	  ResultSet set1=query.executeQuery(strnameandpass);
	  set1.first();
	  
	 
	  WebElement nametext=driver.findElement(By.id("name"));
	  WebElement passtext=driver.findElement(By.id("passkey"));
	  nametext.sendKeys(set1.getString("name"));
	  passtext.sendKeys(set1.getString("passkey"));
	  driver.findElement(By.id("submit")).click();;
	  set1.close();
	  	  
	}
	
}
