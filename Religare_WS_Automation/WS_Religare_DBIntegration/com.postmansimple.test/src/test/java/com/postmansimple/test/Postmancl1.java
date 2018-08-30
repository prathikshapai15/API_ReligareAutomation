package com.postmansimple.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.spi.XmlReader;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Postmancl1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\\\Users\\\\bijaya\\\\Desktop\\\\Danger\\\\coohjcphdfgbiolnekdpbcijmhambjff-0.8.4.19-Crx4Chrome.com.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Broswer Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(capabilities);
		driver.get("chrome-extension://coohjcphdfgbiolnekdpbcijmhambjff/index.html");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	    driver.switchTo().window(driver.getWindowHandle());
	    
		//driver.manage().window().maximize();
	    
	    String FilePath = "C:\\Users\\bijaya\\Desktop\\Postman_inputs.xlsx";
		FileInputStream fs = new FileInputStream(FilePath);
	
	
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
  
		XSSFSheet sheet = workbook.getSheet("TestInputs");

		
		WebElement collection_element = driver.findElement(By.xpath("//a[contains(text(),'Collections')]"));
		collection_element.click();
		
		WebElement addNewCollection_element = driver.findElement(By.xpath("//div[@id=\"collections-options\"]/a[1]"));
		addNewCollection_element.click();
		
		WebElement newCollectionName_element = driver.findElement(By.xpath("//input[@id=\"new-collection-blank\"]"));
		newCollectionName_element.sendKeys("Mounika");
		
		WebElement newCollectionnameClick_element = driver.findElement(By.xpath("//div[@id=\"modal-new-collection\"]/div[3]/a[1]"));
		newCollectionnameClick_element.click();
		
		WebElement enterURL_element = driver.findElement(By.xpath("//input[@id=\"url\"]"));
		enterURL_element.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		
		WebElement methosdselector_element = driver.findElement(By.id("request-method-selector"));
		
		Select methodselector = new Select(methosdselector_element);
		methodselector.selectByVisibleText(sheet.getRow(1).getCell(2).getStringCellValue());
		
		WebElement headersbtn_element = driver.findElement(By.id("headers-keyvaleditor-actions-open"));
		headersbtn_element.click();
		
		WebElement headertext_element = driver.findElement(By.xpath("//div[@id=\"headers-keyvaleditor\"]/div[1]/input[1]"));
		headertext_element.sendKeys("Content-Type");
		Thread.sleep(1000);
		headertext_element.sendKeys(Keys.TAB);
		
		WebElement headervalue_element = driver.findElement(By.xpath("//div[@id=\"headers-keyvaleditor\"]/div[1]/input[2]"));
		headervalue_element.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		
		WebElement rawbtn_element = driver.findElement(By.xpath("//div[@id=\"data-mode-selector\"]/a[3]"));
		rawbtn_element.click();
		Thread.sleep(1000);
		
		
		WebElement TextEditor_element = driver.findElement(By.xpath("//div[@id=\"body-data-container\"]/div/div[3]/div/div/div[2]"));
		//TextEditor_element.click();
		//TextEditor_element.sendKeys("test");
		Actions actions = new Actions(driver);
		actions.moveToElement(TextEditor_element);
		actions.click();
		
		actions.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		actions.build().perform();
		
		WebElement send_element = driver.findElement(By.xpath("//*[@id=\"submit-request\"]"));
		send_element.click();
		
		WebElement xmlText_element = driver.findElement(By.xpath("//*[@id=\"response-as-code\"]/div/div[3]/div/div/div[2]/div/div[3]"));
		
		Thread.sleep(10000);
		
		String xmlText = xmlText_element.getText();
		
		xmlText = xmlText.replaceAll("<Code>", "");
		xmlText = xmlText.replaceAll("</Code>", "");
		
		StringBuffer sb_xmlresponse = new StringBuffer(xmlText);
		//System.out.println(sb_xmlresponse.toString());
		
		String a[] = sb_xmlresponse.toString().split("\n"); 
		System.out.println(a.length);
		
		for(int i=0; i<=a.length-1 ;i++) {
			
			//System.out.println(a[i]);
			if(a[i].contains("LUTHER")) {
			System.out.println("Values is matching"+ " "+a[i]);
			
			}
		}
		
		
		
		
	}

}
