package db_Test.DataBaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.postman.objects.Postman_Objects;
import com.postman.objects.Religare_Rest_CreatePolicyIPG;

import junit.framework.Assert;

public class Data_Access extends Religare_Rest_CreatePolicyIPG
{
	
	static List<String>expectedList = new ArrayList<String>();
	/*public static String POLICYNUM;
	public static String TOTMODALPREMIUM;*/
	static Connection con = null; 
	static Statement st =null;
	static ResultSet r=null;
	public static String TOTMODALPREMIUM;
	public static String PROPOSALNUM;
	public static String POLICYNUM;
	@BeforeClass
	public static void TestVerifyDB() throws SQLException, ClassNotFoundException, Exception
	{
		try{
			String databaseURL = "jdbc:oracle:thin:@10.216.30.112:1521:PROPDEV";
            String user = "rhqc";
            String password = "rhqc#059";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			con= DriverManager.getConnection(databaseURL, user, password);
			if (con != null) {
                System.out.println("Connected to the Database...");
            }
		}
	catch(SQLException e){
		System.out.println(e.getMessage());
	}
		catch(ClassNotFoundException e1)
		{
		    e1.getMessage();
		}
	}
	
	@Test
	public static void getDBData()throws SQLException {
	//PreparedStatement preStatement = null;
	//Connection connection = null;
	

	{
		try{
			String appendQuery="";
			if(Religare_Rest_CreatePolicyIPG.RespVal!=null)
			{
			appendQuery=" where PROPOSALNUM = "+"'" +Religare_Rest_CreatePolicyIPG.RespVal +"'";
			String query = "select UWDECISIONCD,TOTMODALPREMIUM,POLICYNUM,PROPOSALNUM from Policy"+appendQuery;
			System.out.println(query);
			//preStatement = con.prepareStatement(query);			
			//preStatement.setString(3,Religare_Rest_CreatePolicyIPG.Actual_Respvalue);
			//System.out.println("value of Prepared Stmt:" +Religare_Rest_CreatePolicyIPG.RespVal);
			//preStatement.setString(1,Religare_Rest_CreatePolicyIPG.RespVal);
			//preStatement.setString(1, "1120000359875");
			//st = con.createStatement();
			//System.out.println("SQL Query after PS"+ preStatement.toString());
			Statement stmt=con.createStatement();
			
            r = stmt.executeQuery(query);
           //System.out.println("Resultant Set:" +r.next());
			//System.out.println("Resultant Data for Query " +query +"Executed is:");
			while(r.next()){
			String	STAGECD = r.getString("UWDECISIONCD");
			String TOTMODALPREMIUM = r.getString("TOTMODALPREMIUM");
			String POLICYNUM = r.getString("POLICYNUM");
			String PROPOSALNUM= r.getString("PROPOSALNUM");
			System.out.println(STAGECD+"\t"+TOTMODALPREMIUM+"\t"+POLICYNUM+"\t"+PROPOSALNUM);
			//String BASEAGENTID = r.getString("BASEAGENTID");
			
			expectedList.add(STAGECD);
			expectedList.add(TOTMODALPREMIUM);
			expectedList.add(POLICYNUM);
			expectedList.add(PROPOSALNUM);
			System.out.println("DB Values Fetched are:" +expectedList);
			//Assert.assertEquals(expectedList, Actual_Respvalue);
			//System.out.println("Assertion Failed Values Doesnt Match" );
			}
			
		} 
		}
	catch(SQLException e){
		System.out.println(e.getMessage());
	}
		finally {
			try {
				if(r !=null )
				{
					r.close();
				}
					
			if (con != null) {
				con.close();
			}
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
		
	
		}
	
	@AfterTest	
	public static void Test_DBData(){		

		//Verifying DB with Proposal num in Response:
		
			//String Proposal_Num= Postman_Objects.responseValues.get(1);
		String Prop_DBvalue= expectedList.get(3);
			//String Prop_DBvalue= expectedList.get(1);
			System.out.println("Proposal Num Extracted from db Test:" +Prop_DBvalue);
			System.out.println("Proposal Num Obtained from Response is:" +RespVal);
			Assert.assertEquals(RespVal, Prop_DBvalue);
			System.out.println("Assertion Passed Proposal_Num Values Verified in DB:");
			
			
			//Verifying DB With Premium value in Response:
			String amt =Postman_Objects.responseValues.get(0);
			String Premium= expectedList.get(1);
			System.out.println("Amount Extracted from db Test:" +Premium );
			System.out.println("Amount Obtained from Response:" +amt);
			Assert.assertEquals(Premium, amt );
			System.out.println("Assertion Passed Premium Values Verified in DB:");

			
			
		
//Verifying DB With Premium value in Response:
		//String Premium= Postman_Objects.Amount();		
		/*String Amount= expectedList.get(2);
		System.out.println("Premium Values are:" +Amount);*/
		/*System.out.println("Actaul Premium Values:" +);*/
		
	
	/*	if(PROPOSALNUM.equals(RespVal))
		{
			System.out.println("Assertion Successful Data Found in DB:");	
		}
		else{
			System.out.println("Assertion Failed Data Not Found in DB:");
			String status = PROPOSALNUM.toString();
			Assert.assertEquals(status.contains("RespVal") , true);
		}*/
		
	}
		
		/*List<String> Response_Data= new ArrayList();
		//String[] Response= Data_Access.Assertion;
		//Response_Data.add("Data_Access.Test_DBData()");
		
		
		Response_Data.
		for(String Dummy: Response_Data ){
			System.out.println(Dummy);
		String Data = Assertion.Test_DBData();
		Assert.assertEquals(Assertion.length , true);
			if(RespVal.equals(Assertion)){
				System.out.println("Assertion Successful Data Found in DB:");
			}
			else{
				System.out.println("Assertion Failed Data Not Found in DB:");
			}	
		
			*/
		

	/*@AfterClass
	public static void tearDown()
	{
		if(con!= null){
			try{
				System.out.println("Closing Database Connection...");
                con.close();	
			} catch (SQLException ex) {
                ex.printStackTrace();
            }
			
		}
	}*/
	
	}

	


