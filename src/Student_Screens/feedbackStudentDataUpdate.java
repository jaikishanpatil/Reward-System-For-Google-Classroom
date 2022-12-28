package Student_Screens;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import Database.Connect;

public class feedbackStudentDataUpdate {
	public String name, path,fname,femail;
	FileOutputStream outpute;
	InputStream input;

	public feedbackStudentDataUpdate() {
		Connect co = new Connect();
		co.cLogin();
		

		// Database fetching for getting details of the students
		// ###################################
		
		try {
			File f = new File("./WWW.txt");
			Scanner sc;
			sc = new Scanner(f);
			sc.useDelimiter("\\Z");
			name = sc.next();
			Connect ct = new Connect();
			ct.cLogin();
			String cquery = "select * from student_registration where std_username='" + name + "'";
			Statement st;
			st = ct.conn.createStatement();
			ct.rs = st.executeQuery(cquery);
			if (ct.rs.next()) {
				fname = ct.rs.getString("std_name");
				femail = ct.rs.getString("std_mailid");
			}
		} catch (SQLException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
