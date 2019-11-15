package FlipkartBrand;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	WebDriver driver = new ChromeDriver();
		// This method is to navigate flipkart URL
	@BeforeClass
	public void init() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://www.flipkart.com");
	}

	// To log in flipkart
	@Test
	public void login() {
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(
				By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"))
				.sendKeys("delightfulramya2@gmail.com	");
		driver.findElement(
				By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"))
				.sendKeys("Ramya7714");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button"))s.click();
	}

	// Search For product
	@Test
	public void HoverAndSelectProduct() {
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
	}
	
	@AfterClass
	public void quit() {
		driver.close();
	}
	
	@Test
	public void SelectRam() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
		Actions Ramcheck = new Actions(driver);
		WebElement Ram = driver.findElement(By.xpath("//div[contains(text(), '4 GB')]"));
		Ramcheck.moveToElement(Ram).build().perform();
		Boolean checkRam = Ram.isSelected();
		if (checkRam == false) {
			Ram.click();
		}
	}
		@Test
		public void SelectBrand() {
			js.executeScript("window.scrollBy(0,450)");
			Actions BrandCheck = new Actions(driver);
			WebElement Brand = driver.findElement(By.xpath("//div[contains(text(), 'Samsung')]"));
			BrandCheck.moveToElement(Brand).build().perform();
			Boolean checkBrand = Brand.isSelected();
			if (checkBrand == false) {
				Brand.click();
			}
		}
	

	@Test
	public void AddToCart() {
		driver.findElement(
				By.xpath("//div[contains(text(), 'Samsung Galaxy A50s (Prism Crush Violet, 128 GB)')]"))
				.click();
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	@AfterClass
	public void quit() {
		driver.close();
	}

}
