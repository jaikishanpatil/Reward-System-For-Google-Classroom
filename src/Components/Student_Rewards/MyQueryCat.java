package Components.Student_Rewards;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyQueryCat {
	public ArrayList<Product2> BindTable(String category) {
		ArrayList<Product2> list = new ArrayList<Product2>();

		String driver = "com.mysql.cj.jdbc.Driver";
		String db = "reward_system";
		String url = "jdbc:mysql://localhost/" + db;
		String user = "root";
		String pass = "";
		String gender = "";
		Connection conn = null;
		InputStream input;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);

			String qur = "select * from student_rewards where rd_category='"+category+"'"; // selest * from
														// photoupload where
														// username="something";
			PreparedStatement pst = conn.prepareStatement(qur);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Product2 p = new Product2(rs.getString("rd_id"), rs.getString("rd_name"), rs.getString("rd_points"),
						rs.getString("rd_description"), rs.getBytes("rd_img"), rs.getString("rd_category"));
				list.add(p);
			}

		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		}

		return list;
	}
}
