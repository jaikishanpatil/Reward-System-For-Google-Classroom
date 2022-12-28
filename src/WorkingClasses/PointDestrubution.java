package WorkingClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PointDestrubution {
	//public String path;

	public String line="";
	public String []value;
	int count=0;
	public void newData(String path){
		//String query="UPDATE test1 t1 , test2 t2 SET t1.points= t1.points + t2.points WHERE t1.email=t2.email";
		Connection  conn = null;
		try {
			BufferedReader br=new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null){
				 value=line.split(",");
				//System.out.println("Email= "+value[0]+", Points= "+value[1]);
				count++;
				
				String driver = "com.mysql.cj.jdbc.Driver";
				String db = "reward_system";
				String url = "jdbc:mysql://localhost/" + db;
				String user = "root";
				String pass = "";
				
					Class.forName(driver);
					conn = DriverManager.getConnection(url, user, pass);
					String query1="insert into temporytable(temp_email,temp_point) values(?,?)";
					PreparedStatement ps=conn.prepareStatement(query1);
					ps.setString(1, value[0]);
					ps.setInt(2, Integer.parseInt(value[1]));
					ps.executeUpdate();
					
			}
			String query="UPDATE student_reward_points t1 , temporytable t2 SET t1.reward_points= t1.reward_points + t2.temp_point WHERE t1.reward_email=t2.temp_email";
			Statement st=null;
			st=conn.createStatement();
			st.executeUpdate(query);
			
			String truncate="TRUNCATE TABLE  temporytable";
			st.executeUpdate(truncate);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
