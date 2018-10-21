package puma1;

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
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.puma.com");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	ArrayList<String> tmen=new ArrayList<String>();
	ArrayList<String> twmen=new ArrayList<String>();
	ArrayList<String> tsports=new ArrayList<String>();
	ArrayList<String> tcol=new ArrayList<String>();
	ArrayList<String> tsale=new ArrayList<String>();
	List<WebElement> menu1=driver.findElements(By.xpath("//a[@class='digimeg-nav-item']"));
	ArrayList<String> menu=new ArrayList<String>();
	List<WebElement> opts=driver.findElements(By.xpath("//div[@class='digimeg-nav-chunk']|//div[@class='digimeg-nav-chunk2']|//div[@class='digimeg-nav-chunk3']|//div[@class='digimeg-nav-chunk4']|//div[@class='digimeg-nav-chunk1 nav-border']"));
	List<WebElement> opt = opts.subList(3,7);
	List<WebElement> men1 = driver.findElements(By.xpath("//a[contains(@href,'https://in.puma.com/men/')]"));
	List<WebElement> men = men1.subList(36,72);
	List<WebElement> wm = driver.findElements(By.xpath("//a[contains(@href,'https://in.puma.com/women')]"));
	List<WebElement> women = wm.subList(41,75);
	List<WebElement> sp = driver.findElements(By.xpath("//a[text()='TRAINING'  or text()='RUNNING' or text()='Football' or text()='ARSENAL' or text()='Usain Bolt' or text()='Virat Kohli']"));
	List<WebElement> sports = sp.subList(7,12);
	List<WebElement> col1 = driver.findElements(By.xpath("//a[text()='Ferrari' or text()='BMW' or text()='Mercedes' or text()='Red Bull']"));
	List<WebElement> collection = col1.subList(4,8);
	List<WebElement> sale1 = driver.findElements(By.xpath("//a[text()='Men' or text()='Clothing' or text()='Accessories' or text()='Shoes' or text()='Women' ]"));
	List<WebElement> sale = sale1.subList(21,28);
System.out.println(sports.size());
	for(int z=0;z<menu1.size();z++)
	{
		menu.add(menu1.get(z).getText());
	}
	Collections.sort(menu);
	Thread.sleep(1000);
	System.out.println("Number of Modules"+menu.size());
	Actions act=new Actions(driver);
	
	for(int j=0;j<menu.size();j++)
	{
		
		act.moveToElement(menu1.get(j)).perform();
Thread.sleep(2000);			
		
		if(j==0) {
		for(int i=0;i<opt.size();i++)
		{
			tmen.add(opt.get(i).getText());
		}
		
		}
		else if(j==1)
		{
			for(int k=0;k<women.size();k++)
			{
			twmen.add(women.get(k).getText());
			}
			
		}
		else if(j==2)
		{
			//System.out.println("No Sub Modules");
		}
		else if(j==3)
		{
		for(int l=0;l<sports.size();l++)
		{
			
			tsports.add(sports.get(l).getText());
			
		}
		}
		else if(j==4)
		{
			for(int m=0;m<collection.size();m++)
			{
tcol.add(collection.get(m).getText().toString());
			}
			
		}
		else if(j==5)
		{
			for(int n=0;n<sale.size();n++)
			{
			tsale.add(sale.get(n).getText());
			}
		
		}
	
	}
	Collections.sort(tcol);
	Collections.sort(tsale);
	Collections.sort(twmen);
	Collections.sort(tmen);
	Collections.sort(tsports);
	for(int a=0;a<menu.size();a++)
	{
		System.out.println(menu.get(a));
		System.out.println("....................");  
		if(a==0) {
for(String s:tcol)
{
System.out.println(s);	
}
		}
		else if(a==1)
		{
			System.out.println("No Sub modules");
		}
		else if(a==2)
		{
			for(String s:tmen)
			{
				System.out.println(s);
			}
		}
		else if(a==3)
		{
			for(String s:tsale)
			{
				System.out.println(s);
			}
		}
		else if(a==4)
		{
			for(String s:tsports)
			{
				System.out.println(s);
			}
		}
		else if(a==5)
		{
			for(String s:twmen)
			{
				System.out.println(s);
			}
		}
	}
}
}
