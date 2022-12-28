package Student_Screens;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Database.Connect;

public class UpdaterClass {
	public String points,name,pname,pemail,pprn,password,proll;
	
	public String qsemail,qsname,qsstatus,qslastdate,qsnewdate;
	
	Connect ct=new Connect();
	public void update(){
		
		ct.cLogin();
		try {
			File f = new File("./WWW.txt");
			Scanner sc;
			sc = new Scanner(f);
			sc.useDelimiter("\\Z");
			name = sc.next();
			
			String cquery = "select * from student_registration where std_username='" + name + "'";
			Statement st;
			st = ct.conn.createStatement();
			ct.rs = st.executeQuery(cquery);
			if (ct.rs.next()) {
				pname = ct.rs.getString("std_name");
				pemail = ct.rs.getString("std_mailid");
				pprn=ct.rs.getString("std_prn");
				proll=ct.rs.getString("std_rollnumber");
				password=ct.rs.getString("std_password");
			}
			
			String pointsQuery="select reward_points from student_reward_points where reward_email='"+pemail+"'";
			ct.rs = st.executeQuery(pointsQuery);
			
			if(ct.rs.next()){
				points=String.valueOf(ct.rs.getInt("reward_points"));
			}
			
			String quizstatusQuery="select * from quiz_status where qs_email='"+pemail+"'";
			ct.rs = st.executeQuery(quizstatusQuery);
			while(ct.rs.next()){
				qsemail=ct.rs.getString(1);
				qsname=ct.rs.getString(2);
				qsstatus=ct.rs.getString(3);
				qslastdate=ct.rs.getString(4);
				qsnewdate=ct.rs.getString(5);
			}
			
			
		} catch (SQLException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
