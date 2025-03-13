package rough;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.annotations.Test;

//@Test
public class Dbconnection {

	private WebDriver driver;
	private Connection con = null;
	private Statement stmt = null;
	String dataBaseName = "dbQaAutomation";
	String dbDriver = "jdbc:sqlserver://localhost:3306/";
	String user = "PETZENT\\ssreenivasan";
	String pass = "Saran&cross1";
	String Query;
	ResultSet res;
	String connectionUrl = "jdbc:sqlserver://localhost:3306;"
			+ "databaseName=dbQaAutomation;integratedSecurity=true;";

	public void DBConnection() throws Exception {
		}
	
	@Test
	private void testDB() throws SQLException {
		 try {
		        Class.forName(
		                "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        Connection con = DriverManager.getConnection(connectionUrl);
		               // dbDriver + dataBaseName, user, pass);
		      String SQL = "Select * from seleniumtry";
		        stmt = con.createStatement();
		        res = stmt.executeQuery(SQL);
		        
		        while(res.next())
		        {
		        	System.out.println(res.getString(1));
		        }
		        
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
		
	
	}
}

