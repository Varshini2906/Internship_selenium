
package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project {
	
	String keyword="dress";
	WebDriver driver;
	JavascriptExecutor js= (JavascriptExecutor)driver;
	@BeforeClass
	public void launch() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		    driver= new ChromeDriver();
		    Thread.sleep(3000);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("http://automationpractice.com/index.php");
	}
	@Test(priority=1)
    public void search() throws InterruptedException {
		driver.findElement(By.id("search_query_top")).sendKeys(keyword);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
    public void scroll() throws InterruptedException {
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)","");
        Thread.sleep(4000);
        
	}	
   @Test(priority=3)
    public void addtocart() throws InterruptedException {
	Actions action=new Actions(driver);
	WebElement ele= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/h5/a"));
	action.moveToElement(ele).click().perform();
	Thread.sleep(5000);
    
    
	WebElement el=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[4]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
	Thread.sleep(3000);
	action.moveToElement(el).click().perform();
	Thread.sleep(5000);
	
	WebElement e=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span"));
	Thread.sleep(4000);
	action.moveToElement(e).click().perform();
	Thread.sleep(6000);

}
   @Test(priority=4)
   public void toolbar_tshirt() throws InterruptedException 
   {
	Actions action=new Actions(driver);
    WebElement a=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a"));
    action.moveToElement(a).build().perform();
    Thread.sleep(4000);
    WebElement b=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
    action.moveToElement(b).click().perform();
    Thread.sleep(4000);
    
    WebElement image=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5"));
    Thread.sleep(3000);
    action.moveToElement(image).build().perform();
    Thread.sleep(4000);
    WebElement i=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[1]"));
    action.moveToElement(i).click().perform();
    Thread.sleep(3000);
   
    WebElement c=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span"));
    Thread.sleep(3000);
    action.moveToElement(c).click().perform();
    Thread.sleep(5000);
   }
 @Test(priority=5)
 public void toolbar_dresses() throws InterruptedException {
	 Actions action=new Actions(driver);
	 WebElement a=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
	 action.moveToElement(a).build().perform();
	 Thread.sleep(3000);
	 WebElement b=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[3]/a"));
	 action.moveToElement(b).click().perform();
	 Thread.sleep(3000);
	 
	 WebElement c=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/h5/a"));
	 action.moveToElement(c).build().perform();
	 Thread.sleep(3000);
	 
 }

@Test(priority=6)
public void viewcart() throws InterruptedException 
{
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]")).click();
	Thread.sleep(3000);
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)","");
	
}
@Test(priority=7)
public void sign_in() throws InterruptedException
{
	driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[5]/div/a[2]/span/i")).click();
	driver.findElement(By.xpath("//a[@class=\"button btn btn-default standard-checkout button-medium\"]")).click();
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)","");
	driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("varshini@gmail.com");
    driver.findElement(By.xpath("//input[@name=\"passwd\"]")).sendKeys("Lalala");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input//following::button[@class=\"button btn btn-default button-medium\"]")).click();
	js.executeScript("window.scrollBy(0,500)","");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//button[@name=\"processAddress\"]")).click();
}
@Test(priority=8)
public void Shippingitems() throws InterruptedException
{
    Thread.sleep(4000);
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)","");
	driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
	driver.findElement(By.xpath("//button[@name=\"processCarrier\"]")).click();
}
@AfterClass()
public void payment() {
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)","");
}
}