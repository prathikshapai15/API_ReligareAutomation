package com.postman.objects;
import java.util.ArrayList;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.ICell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.StaleElementReferenceException;
 
public class Postman_Objects extends Functions  {

	public static ArrayList<String> responseValues = new ArrayList<String>();
	public static String Prem_value;
	public static String Proposal_Num;

	public static void collection_link() {

		WebElement collection_element = driver.findElement(By.xpath("//a[contains(text(),'Collections')]"));
		collection_element.click();
	}

	public static void addNewCollection_folder() {
		WebElement addNewCollection_element = driver.findElement(By.xpath("//div[@id=\"collections-options\"]/a[1]"));
		addNewCollection_element.click();

	}

	public static void collectionName(String newCollectionName) {

		WebElement newCollectionName_element = driver.findElement(By.xpath("//input[@id=\"new-collection-blank\"]"));
		newCollectionName_element.sendKeys(newCollectionName);

	}
	public static void collectionName_click() {
		WebElement newCollectionnameClick_element = driver.findElement(By.xpath("//div[@id=\"modal-new-collection\"]/div[3]/a[1]"));
		newCollectionnameClick_element.click();
	}
	public static void URL(String URL) {

		WebElement enterURL_element = driver.findElement(By.xpath("//input[@id=\"url\"]"));
		enterURL_element.sendKeys(URL);

	}
	public static void methodSelection(String methods) {
		WebElement methosdselector_element = driver.findElement(By.id("request-method-selector"));

		Select methodselector = new Select(methosdselector_element);
		methodselector.selectByVisibleText(methods);
	}
	public static void URLParams_btn() {

		WebElement urlParamsBtn_element = driver.findElement(By.xpath("//button[@id=\"url-keyvaleditor-actions-open\"]"));
		urlParamsBtn_element.click();
	}
	public static void URLparams_keys(String URLParmsKey) {

		WebElement URLParameterKey_elements = driver.findElement(By.xpath("//div[@id=\"url-keyvaleditor\"]/div[1]/input[1]"));
		URLParameterKey_elements.sendKeys(URLParmsKey);
	}
	public static void URLparams_values(String URLParamValue) {
		WebElement URLparamsValue_element = driver.findElement(By.xpath("//*[@id=\"url-keyvaleditor\"]/div[1]/input[2]"));
		URLparamsValue_element.sendKeys(URLParamValue);
	}
	public static void headersBtn() {

		WebElement headerBtn_element = driver.findElement(By.id("headers-keyvaleditor-actions-open"));
		headerBtn_element.click();

	}
	public static void headerName(String Contenttype, String ContentValue) {
		WebElement headertext_element = null;
		WebElement headervalue_element=null;
		int i=0, j=0;




		String[] values2 = Contenttype.split(",");
		String[] values3= ContentValue.split(",");
		for(String hName:values2) {
			values2[i] = values2[i].trim() + "\n";


			values3[i] = values3[i].trim() + "\n";

			j = i+1;
			headertext_element = driver.findElement(By.xpath("//div[@id=\"headers-keyvaleditor\"]/div["+j+"]/input[1]"));


			headertext_element.sendKeys(values2[i]);

			headertext_element.sendKeys(Keys.TAB);

			headervalue_element = driver.findElement(By.xpath("//div[@id=\"headers-keyvaleditor\"]/div["+j+"]/input[2]"));


			headervalue_element.sendKeys(values3[i]);

			headervalue_element.sendKeys(Keys.TAB);


			i++;
		}





	}
	//	public static void headerValue(String headerContentType) {
	//
	//		WebElement headervalue_element=null;
	//		for(int j=0; j<excelData[1][3].length();j++){
	//		headervalue_element = driver.findElement(By.xpath("//div[@id=\"headers-keyvaleditor\"]/div["+j+"]/input[2]"));
	//		headervalue_element.sendKeys(excelData[1][3]);
	//		}
	//		
	//		
	//	}
	public static void send_btn() {
		WebElement send_element = driver.findElement(By.xpath("//*[@id=\"submit-request\"]"));
		send_element.click();
	}
	public static void preview_btn() {
		WebElement previewBtn_element = driver.findElement(By.xpath("//button[@id=\"preview-request\"]"));
		previewBtn_element.click();
	}

	public static void addToCollection_btn() {
		WebElement addToCollection_element = driver.findElement(By.xpath("//button[@id=\"add-to-collection\"]"));
		addToCollection_element.click();
	}
	public static void formdata_btn() {
		WebElement formdatabtn_element = driver.findElement(By.xpath("//div[@id=\"data-mode-selector\"]/a[1]"));
		formdatabtn_element.click();
	}
	public static void formdata_key() {
		WebElement formdatakey_element = driver.findElement(By.xpath("//div[@id=\"formdata-keyvaleditor\"]/div[1]/input[1]"));
	}
	public static void formdata_value() {
		WebElement formdatavalue_element = driver.findElement(By.xpath("//div[@id=\"formdata-keyvaleditor\"]/div[1]/input[2]"));
	}
	public static void formdataDropdown() {
		WebElement formdataDropdown_element = driver.findElement(By.xpath("//div[@id=\"formdata-keyvaleditor\"]/div[1]/input[2]"));
		Select methodselector = new Select(formdataDropdown_element);
		methodselector.selectByVisibleText("text");
	}
	public static void formdataurlencoded() {
		WebElement formdataurlencoded_element = driver.findElement(By.xpath("//div[@id=\"data-mode-selector\"]/a[2]"));


	}
	public static void rawBtn() {
		WebElement rqwbtn_element = driver.findElement(By.xpath("//div[@id=\"data-mode-selector\"]/a[3]"));
		rqwbtn_element.click();

	}
	public static void textEditor(String XMLRequest) {
		WebElement TextEditor_element = driver.findElement(By.xpath("//div[@id=\"body-data-container\"]/div/div[3]/div/div/div[2]"));
		//TextEditor_element.click();
		//TextEditor_element.sendKeys("test");
		Actions actions = new Actions(driver);
		
		actions.moveToElement(TextEditor_element);
		actions.click();	
		actions.sendKeys(XMLRequest);
		actions.build().perform();

	}
	public static void raw_dropdown(String rawdropdown) {
		WebElement rawDropdown_element = driver.findElement(By.xpath("//div[@id=\"body-editor-mode-selector\"]/div/a"));
		rawDropdown_element.click();

		for(int i=1; i<4; i++) {

			WebElement rawDropdown_elements = driver.findElement(By.xpath("//*[@id=\"body-editor-mode-selector\"]/div/ul/li["+i+"]/a"));
			String rawDropdown_elements_value = rawDropdown_elements.getText();
			if(rawDropdown_elements_value.equals(rawdropdown)) {

				rawDropdown_elements.click();

			}
		}
	}
	
	public static void reset_Btn() {
		WebElement resetBtn_element = driver.findElement(By.xpath("//span[@id=\"body-editor-mode-item-selected\"]"));
		resetBtn_element.click();
	}

	private static Function<WebDriver,WebElement> presenceOfElementLocated(final By locator)
	{
	     return new Function<WebDriver, WebElement>() {
	         public WebElement apply(WebDriver driver) {
	             return driver.findElement(locator);
	         }
	     };
	 }
	
	public static void responseTextArea(String splitWith, String valuesNeedsToPass ) throws Exception {
		//System.out.println("response Text Areas");
		Thread.sleep(20000);
		WebElement xmlText_element = driver.findElement(By.xpath("//*[@id='response-as-code']/div/div[3]/div/div/div[2]/div/div[3]"));
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(presenceOfElementLocated(By.xpath("//div[@id='response-as-code']/div/div[3]/div/div/div[2]/div/div[3]")));

		String xmlText = xmlText_element.getText();
		//System.out.println(xmlText);
		StringBuffer sb_xmlresponse = new StringBuffer(xmlText);
		//System.out.println(sb_xmlresponse.toString());
		//String sWith=splitWith.trim();
		String a[] = sb_xmlresponse.toString().split("\\["); 

		for(int i=0; i<a.length-1; i++) {
			//System.out.println(a[i]);
			String[] values4 = valuesNeedsToPass.split(",");
			int j=0;
			for(String splitValue : values4) {

				values4[j] = splitValue.trim();
				//System.out.println(values4[j]);
				//System.out.println("a values is : "+a[i].toString().trim());
				if(a[i].toString().trim().contains(values4[j])) {
					String value =null;
					//System.out.println("Value is matching" + a[i]);
					String [] splitExactValue=a[i].toString().split(",");
					for(String exactValue : splitExactValue) {
						if(exactValue.contains("\""+values4[j])){
							String [] values =exactValue.split(":");
							value=values[1].trim();
							System.out.println(" Result Set:" +value); //Values for Input of IPG Payment: Premium;Proposalno
						}
					}
					Thread.sleep(20000);
					responseValues.add(value);
					





				}

			}




		}

	}	

}




