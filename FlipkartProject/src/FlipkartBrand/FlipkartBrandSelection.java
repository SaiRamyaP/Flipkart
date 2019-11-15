package FlipkartBrand;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartBrandSelection {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		//setting chromedriver
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//getURL
		driver.get("https://www.flipkart.com");
		//Maximize the window
		driver.manage().window().maximize();
		
		//SignIn
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("delightfulramya2@gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Ramya7714");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		
		//MouseMove functionality to particular element
		driver.manage().window().setPosition(new Point(0, 0));
	    org.openqa.selenium.Dimension d = new org.openqa.selenium.Dimension(1680, 1010);
	    driver.manage().window().setSize(d);
	    Robot robot = new Robot();
	    robot.mouseMove(1050, 0);
	    
	    //Selecting Electronics and the Mobile from Main menu
		Actions act = new Actions(driver);
		WebElement mainmenu= driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		act.moveToElement(mainmenu).build().perform();//taking mouse
		WebElement mobiles = driver.findElement(By.xpath("//a[contains(text(),'Mobiles')]"));
		mobiles.click();//clicking on Mobiles
		
		//ScrollUp and checking functionality for getting 4 GB selected Checkbox
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
		Actions Ramcheck = new Actions(driver);
		WebElement Ram = driver.findElement(By.xpath("//div[contains(text(), '4 GB')]"));
		Ramcheck.moveToElement(Ram).build().perform();
		Boolean checkRam = Ram.isSelected();
		if (checkRam == false) {
			Ram.click();
		}
		
		//ScrollUp and checking functionality for getting Samsung Brand selected Checkbox
		js.executeScript("window.scrollBy(0,450)");
		Actions BrandCheck = new Actions(driver);
		WebElement Brand = driver.findElement(By.xpath("//div[contains(text(), 'Samsung')]"));
		BrandCheck.moveToElement(Brand).build().perform();
		Boolean checkBrand = Brand.isSelected();
		if (checkBrand == false) {
			Brand.click();
		}
		
		//Select an item to add to cart
		driver.findElement(By.xpath("//div[contains(text(), 'Samsung Galaxy A50s (Prism Crush Violet, 128 GB)')]")).click();
		
		//Handling Different window which was switched as another tab
		ArrayList<String> tablist = new ArrayList<String> (driver.getWindowHandles());

		driver.switchTo().window(tablist.get(0));
		
		driver.findElement(By.xpath("//button[contains(text(), 'ADD TO CART')]")).click(); //Add to Cart
		
		//Place Order
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[2]/div/div[1]/div/div[3]/div/form/button/span")).click();
		Thread.sleep(1000);
		driver.close();//Close the browser automatically
	}
}
