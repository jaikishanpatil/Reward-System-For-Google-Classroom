package Student_Screens;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Database.Connect;

public class TimeTableUpdate {
	public String path;
	String name;
	String year,course;
	FileOutputStream outpute;
	public TimeTableUpdate(){
		
		File f=new File("./WWW.txt");
		Scanner sc;
		
			try {
				sc = new Scanner(f);
				sc.useDelimiter("\\Z");
				name=sc.next();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			// Database fetching for getting details of the students ###################################
			Connect ct=new Connect();
			ct.cLogin();
			String cquery="select * from student_registration where std_username='"+name+"'";
			Statement st;
			try {
				st = ct.conn.createStatement();
				ct.rs=st.executeQuery(cquery);
				if(ct.rs.next()){
					year=ct.rs.getString("std_year");
					course=ct.rs.getString("std_course");
					
					
				}
				InputStream input;
				Connect co=new Connect();
				co.cLogin();
				String qur="select * from student_timetable where tt_year='"+year+"' and tt_course='"+course+"' ";
				PreparedStatement pst=co.conn.prepareStatement(qur);
				ResultSet rs=pst.executeQuery();
				File thefile=new File("myImages.png");
				outpute=new FileOutputStream(thefile);
				if(rs.next()){
					
					input=rs.getBinaryStream("tt_image");
					byte[] buffer=new byte[input.available()];
					while(input.read(buffer)>0){
						outpute.write(buffer);
					}
					path=thefile.getAbsolutePath();
				}
			
			}catch(SQLException | IOException  e1 ){
				e1.printStackTrace();
			}
	}
}
