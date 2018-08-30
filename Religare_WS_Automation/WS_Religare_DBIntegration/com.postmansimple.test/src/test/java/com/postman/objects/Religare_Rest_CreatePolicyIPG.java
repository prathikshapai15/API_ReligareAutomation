package com.postman.objects;

import org.testng.annotations.Test;

import db_Test.DataBaseConnection.Data_Access;

import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
//import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Religare_Rest_CreatePolicyIPG extends Functions{

//public static final String Actual_Respvalue = null;
public static String RespVal;
public static String Actual_Respvalue;
String[][] excelData2;
ArrayList<String> arrayValues = new ArrayList<String>();
public static String Assertion=null;

@BeforeClass
public void beforeClass() throws Exception {

}

@AfterClass
public void afterClass() {

}

@BeforeTest()
public void beforeTest() throws Exception {
excelData2 = Functions.excel_Files("Religare_Inputs");
int iterater=1;
for(int c=0; c<colCount; c++) {

//System.out.println("Data is  :"+excelData2[iterater][c].toString());
arrayValues.add(excelData2[iterater][c].toString());


}

Functions.browserLaunchWithExtension();
Postman_Objects.URL(arrayValues.get(0));

Postman_Objects.methodSelection(arrayValues.get(1));

Postman_Objects.headersBtn();
Postman_Objects.headerName(arrayValues.get(2), arrayValues.get(3));
Postman_Objects.rawBtn();
Postman_Objects.textEditor(arrayValues.get(4));
Postman_Objects.raw_dropdown(arrayValues.get(5));
Postman_Objects.send_btn();

Thread.sleep(10000);
// String passed_validation=
/*Postman_Objects.Assertion();
System.out.println("Assert Vaue is : "+Postman_Objects.PassAssertion);
System.out.println("Assert Vaue is : "+Postman_Objects.failAssertion);*/

}


@Test()
public void IPGPayment() throws Exception {
// System.out.println("Test Started");
System.out.println("Values are  : "+arrayValues.get(6)+"----"+ arrayValues.get(7) );
String splitwith = arrayValues.get(6).toString().trim();
String PassValue = arrayValues.get(7).toString();
Postman_Objects.responseTextArea(splitwith, PassValue);
driver.close();

int iterater=2;
arrayValues.clear();
for(int c=0; c<colCount; c++) {
//System.out.println("Data is  :"+excelData2[iterater][c].toString());
arrayValues.add(excelData2[iterater][c].toString());
//System.out.println("Demotry of Iterator Loop arrayValues" +arrayValues.toString());

}

Functions.browserLaunchWithExtension();
Postman_Objects.URL(arrayValues.get(0));

Postman_Objects.methodSelection(arrayValues.get(1));

Postman_Objects.headersBtn();
Postman_Objects.headerName(arrayValues.get(2), arrayValues.get(3));
Postman_Objects.rawBtn();

String IPGrequest = arrayValues.get(4).toString();
//System.out.println("Demo0 list values of IPGrequest before are:"+IPGrequest);
for(int i=0; i<Postman_Objects.responseValues.size(); i++) {

RespVal = Postman_Objects.responseValues.get(i);
RespVal=RespVal.replaceAll("\"", "");
IPGrequest = IPGrequest.replaceAll("value"+i,RespVal);

}
System.out.println("Response List Values are:" +RespVal);
System.out.println("IPGresponse to Validate in DB after IPG:"+IPGrequest);
Postman_Objects.textEditor(IPGrequest);
Postman_Objects.raw_dropdown(arrayValues.get(5));
Postman_Objects.send_btn();
Thread.sleep(30000);
String valuesneedPass = arrayValues.get(7).toString();
Postman_Objects.responseTextArea("\\{", valuesneedPass); 



for(int j=0; j<Postman_Objects.responseValues.size(); j++) 
{ 
String [] values =valuesneedPass.split(",");
System.out.println("Response Values obtained post IPG:" +values[j].trim() +":"+Postman_Objects.responseValues.get(j));
//System.out.println("Printig values in Response"+values);
System.out.println("Printig values in Response:" +values[j].toString());
}
}




@AfterTest
public void afterTest() throws Exception {
	Data_Access.TestVerifyDB();
	Data_Access.getDBData();
	Data_Access.Test_DBData();
}
}




