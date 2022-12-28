package Admin_Screens;

import java.sql.SQLException;
import java.sql.Statement;

import Database.Connect;

public class updateData {
	
	String totalCount,fecount,secount,tecount,becount;
	String feedCount;
	String feedpending="0",feedread="0";
	
	public updateData(){
		Connect co=new Connect();
		co.cLogin();
		String qury="select count(*) from student_registration";
		String qury1="select count(*) from student_registration where std_year='First Year'";
		String qury2="select count(*) from student_registration where std_year='Second Year'";
		String qury3="select count(*) from student_registration where std_year='Third Year'";
		String qury4="select count(*) from student_registration where std_year='Fourth Year'";
		String qury5="select count(*) from feedback where feed_status='Pending'";
		String qury6="select count(*) from feedback where feed_status='Read'";
		String qury7="select count(*) from feedback";
		Statement st;
		try {
			st = co.conn.createStatement();
			co.rs=st.executeQuery(qury);
			if(co.rs.next()){
				int count=co.rs.getInt(1);
				totalCount=String.valueOf(count);
			}
			co.rs=st.executeQuery(qury1);
			if(co.rs.next()){
				int count=co.rs.getInt(1);
				fecount=String.valueOf(count);
			}
			co.rs=st.executeQuery(qury2);
			if(co.rs.next()){
				int count=co.rs.getInt(1);
				secount=String.valueOf(count);
			}
			co.rs=st.executeQuery(qury3);
			if(co.rs.next()){
				int count=co.rs.getInt(1);
				tecount=String.valueOf(count);
			}
			co.rs=st.executeQuery(qury4);
			if(co.rs.next()){
				int count=co.rs.getInt(1);
				becount=String.valueOf(count);
			}
			co.rs=st.executeQuery(qury5);
			if(co.rs.next()){
				int count=co.rs.getInt(1);
				feedpending=String.valueOf(count);
			}
			co.rs=st.executeQuery(qury6);
			if(co.rs.next()){
				int count=co.rs.getInt(1);
				feedread=String.valueOf(count);
			}
			co.rs=st.executeQuery(qury7);
			if(co.rs.next()){
				int count=co.rs.getInt(1);
				feedCount=String.valueOf(count);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
