import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


class GetAndPost extends Video {

public GetAndPost(WebDriver driver) throws InterruptedException, IOException, JSONException, ClassNotFoundException, SQLException{
	super(driver);
	driver.get("http://10.0.1.86/tatoc/advanced/rest/");
	
	  String []session=driver.findElement(By.id("session_id")).getText().split(":");
	 String sessionid=session[1].trim();
	  System.out.println(sessionid);
	 
	String urlString="http://10.0.1.86/tatoc/advanced/rest/service/token/"+sessionid;

		  URL url = new URL(urlString);
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();
		  if(conn!=null){
			  System.out.print(" its connected !!");
		  }
			conn.setRequestProperty("Accept", "application/json");

		  
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  conn.disconnect();
		  String strq=new String(sb);
		  System.out.println(sb);
		  JSONObject obj = new JSONObject(strq);
		 	  System.out.println(obj.getString("token"));
		 	  String Token1=(String)obj.get("token");
		 //post
	  String poststring="http://10.0.1.86/tatoc/advanced/rest/service/register";
	  String urlParameters = "id="+sessionid+"&signature="+Token1+"&allow_access=1";
	  URL url2 = new URL(poststring);
	  HttpURLConnection conn1 = (HttpURLConnection)url2.openConnection();
	  conn1.setRequestMethod("POST");
	  conn1.setDoOutput(true);
	  conn1.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	  DataOutputStream wr = new DataOutputStream(conn1.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
	  	int responseCode = conn1.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		WebElement webElement123=driver.findElement(By.linkText("Proceed"));
		webElement123.click();
		
	
}


}