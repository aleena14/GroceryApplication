package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility { //its a page helper class
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	public void selectDropdownWithIndex(WebElement element, int value) {
		Select object=new Select(element);
		object.selectByIndex(value);
	}
	public void selectDropdownWithVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	public void scrollPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)","");
	}
   public void click(WebDriver driver,WebElement element) {
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();",element);
  }
}
