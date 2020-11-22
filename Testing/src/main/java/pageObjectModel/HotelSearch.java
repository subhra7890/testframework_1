package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class HotelSearch extends Base{
	By searchResult=By.xpath("//div[contains(@class,'HotelCardstyles__OuterWrapper')]");
	
	public List<WebElement> searchResult()
	{
		List<WebElement> element=driver.findElements(searchResult);
		return element;
	}

}
