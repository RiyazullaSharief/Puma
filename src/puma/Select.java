package puma;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Select
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.puma.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> menu=driver.findElements(By.xpath("//a[@class='digimeg-nav-item']"));
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		for(WebElement a:menu)
		{
			act.moveToElement(a).perform();
			Thread.sleep(3000);
			WebElement opts=driver.findElement(By.xpath("//a[.='SELECT']"));
			System.out.println(opts.getText());
		}
	}
}
