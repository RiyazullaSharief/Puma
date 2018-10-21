package puma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Puma
{	
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.puma.com");
		List<String> names = new ArrayList<>();
		List<WebElement> allLinks = driver.findElements(By.xpath("//a[@class='digimeg-nav-item']"));
		for (WebElement ele : allLinks) {
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).perform();
			String module = ele.getText();
			String menu = module.toLowerCase();
			names.add(module);
			List<WebElement> allSubLinks = driver.findElements(By.xpath("//a[contains(@href,'/"+menu+"/')]"));
			for( WebElement sublink : allSubLinks) {
				String subMenu = sublink.getText();
				if(subMenu.length()>0) {
					System.out.println(subMenu);
					names.add(subMenu);
				}
			}
		}
		Collections.sort(names);
		System.out.println(names);
		driver.close();
	}
}
