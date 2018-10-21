package puma;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class GetText
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.puma.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> menu=driver.findElements(By.xpath("//a[@class='digimeg-nav-item']"));
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		for(WebElement a:menu)
		{
			String text=a.getText();
			System.out.println(text);
			System.out.println("==================");
			act.moveToElement(a).perform();
			Thread.sleep(3000);
			List<WebElement> opts=driver.findElements(By.xpath("//div[@class='digimeg-nav-chunk']|//div[@class='digimeg-nav-chunk2']|//div[@class='digimeg-nav-chunk3']|//div[@class='digimeg-nav-chunk4']|//div[@class='digimeg-nav-chunk1 nav-border']"));
			List<WebElement> opt=opts.subList(3,20);
			//Collections.sort(opts);
			
			for(WebElement b:opt)
			{
				if(b.getText()!=" ")
				{
					System.out.println(b.getText());
					Thread.sleep(500);
				}
			}
		}
		driver.close();
	}
}
