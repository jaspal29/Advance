import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;


class Video extends DataBaseAcess{
	
	public Video(WebDriver driver) throws InterruptedException, IOException, JSONException, ClassNotFoundException, SQLException
	{ 
		super(driver);
		Thread.sleep(5000);
		
		
		
		
	}
	
	
}