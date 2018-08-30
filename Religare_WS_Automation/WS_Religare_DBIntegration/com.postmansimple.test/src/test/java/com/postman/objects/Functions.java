package com.postman.objects;

import java.io.File;
import java.io.FileInputStream;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class Functions {
	public static ChromeDriver driver;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public static String[][] excelData = null;
	static int colCount=0;
	static int rowCount=0;
	
	public static int lastRow ;
	
	public static void browserLaunchWithExtension() {
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\Automation\\Automation_Softwares\\coohjcphdfgbiolnekdpbcijmhambjff-0.8.4.19-Crx4Chrome.com.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Automation_Softwares\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver(capabilities);
		driver.get("chrome-extension://coohjcphdfgbiolnekdpbcijmhambjff/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	    driver.switchTo().window(driver.getWindowHandle());
	    
	}
	
	@DataProvider(name="empLogin")
	public static String[][] excel_Files(String sheetname) throws Exception {
		
		try {
		String FilePath = "D:\\Automation\\Religare_Automation\\Religare_WS_Automation\\WS_Religare_DBIntegration\\com.postmansimple.test\\ExcelFile\\Postman_inputs.xlsx";
		FileInputStream finputStream = new FileInputStream(new File(FilePath));
		
		workbook = new XSSFWorkbook(finputStream);
		sheet = workbook.getSheet(sheetname);
		 colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("Columns"+ colCount);
		
		 rowCount = sheet.getPhysicalNumberOfRows();
		
		System.out.println("Rows"+ rowCount);
		
		excelData = new String[rowCount][colCount];
		
		for(int Nrow = 0; Nrow<rowCount; Nrow++) {
			
			row = sheet.getRow(Nrow);
			
			for(int Ncolumn =0; Ncolumn<colCount ; Ncolumn++) {
				
				cell = sheet.getRow(Nrow).getCell(Ncolumn);
				
				
				DataFormatter df = new DataFormatter();
				excelData[Nrow][Ncolumn] = df.formatCellValue(cell);
				
			

			}
				
		}
		
		
		}catch(Exception e) {}

		return excelData;
	}
	
	
	public static void SelectMethod(WebElement selectelement, String selectText) {
		
		Select select_element = new Select(selectelement);
		select_element.selectByVisibleText(selectText);
		
	}



}
