package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	String log;
	public Connection conn = null;
	public ResultSet rs = null;
	public void cLogin(){
		String driver   = "com.mysql.cj.jdbc.Driver";
        String db       = "reward_system";
        String url      = "jdbc:mysql://localhost/" + db;
        String user     = "root";
        String pass     = "";
        try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
			
			Statement st=conn.createStatement();
            
        }catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
