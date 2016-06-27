import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Menu {
	
		
		public Menu(WebDriver driver) throws ClassNotFoundException, SQLException, InterruptedException, IOException, JSONException
		{
			driver.get("http://10.0.1.86/tatoc/advanced/hover/menu");
		    WebElement menu=driver.findElement(By.xpath("html/body/div/div[2]/div[2]/span[1]"));
		   
		    Actions actions = new Actions(driver);
		    
		    actions.moveToElement(menu);

		   WebElement subMenu = driver.findElement(By.xpath("html/body/div/div[2]/div[2]/span[5]"));

		    
		    actions.moveToElement(subMenu);
		    actions.click().build().perform();
		   
		}
		
	}

