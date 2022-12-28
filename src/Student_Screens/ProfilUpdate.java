package Student_Screens;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ImageIcon;

import Database.Connect;

public class ProfilUpdate {
	// ################# Profile Data Pass from hear ############3
	
		String pname,pemail,pdob,paddress,proll,pprn,ppnum,pusername,pyear,pcourse,pbyear;
		String name;
		FileOutputStream outpute;
		InputStream input;
		String path;
		public ProfilUpdate(String pname, String pemail, String pdob, String paddress, String proll, String pprn,
				String ppnum, String pusername, String pyear, String pcourse, String pbyear) {
			super();
			this.pname = pname;
			this.pemail = pemail;
			this.pdob = pdob;
			this.paddress = paddress;
			this.proll = proll;
			this.pprn = pprn;
			this.ppnum = ppnum;
			this.pusername = pusername;
			this.pyear = pyear;
			this.pcourse = pcourse;
			this.pbyear = pbyear;
			
			File f=new File("./WWW.txt");
			Scanner sc;
			try {
				sc = new Scanner(f);
				sc.useDelimiter("\\Z");
				name=sc.next();
				// Database fetching for getting details of the students ###################################
				Connect ct=new Connect();
				ct.cLogin();
				String cquery="select * from student_registration where std_username='"+name+"'";
				Statement st;
				
					st = ct.conn.createStatement();
					ct.rs=st.executeQuery(cquery);
					if(ct.rs.next()){
						setPname(ct.rs.getString("std_name"));
						setPemail(ct.rs.getString("std_mailid"));
						setPdob(ct.rs.getString("std_dob"));
						setPaddress(ct.rs.getString("std_address"));
						setProll(ct.rs.getString("std_rollnumber"));
						setPprn(ct.rs.getString("std_prn"));
						setPpnum(ct.rs.getString("std_phonenumber"));
						setPusername(ct.rs.getString("std_username"));
						setPyear(ct.rs.getString("std_year"));
						setPcourse(ct.rs.getString("std_course"));
						setPbyear(ct.rs.getString("std_batchyear"));
						
						File thefile=new File("myImages.png");
						outpute=new FileOutputStream(thefile);
						input=ct.rs.getBinaryStream("std_profile");
						byte[] buffer=new byte[input.available()];
						while(input.read(buffer)>0){
							outpute.write(buffer);
					}
						path=thefile.getAbsolutePath();
						
					}
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
		}

		public String getPname() {
			return pname;
		}

		public void setPname(String pname) {
			this.pname = pname;
		}

		public String getPemail() {
			return pemail;
		}

		public void setPemail(String pemail) {
			this.pemail = pemail;
		}

		public String getPdob() {
			return pdob;
		}

		public void setPdob(String pdob) {
			this.pdob = pdob;
		}

		public String getPaddress() {
			return paddress;
		}

		public void setPaddress(String paddress) {
			this.paddress = paddress;
		}

		public String getProll() {
			return proll;
		}

		public void setProll(String proll) {
			this.proll = proll;
		}

		public String getPprn() {
			return pprn;
		}

		public void setPprn(String pprn) {
			this.pprn = pprn;
		}

		public String getPpnum() {
			return ppnum;
		}

		public void setPpnum(String ppnum) {
			this.ppnum = ppnum;
		}

		public String getPusername() {
			return pusername;
		}

		public void setPusername(String pusername) {
			this.pusername = pusername;
		}

		public String getPyear() {
			return pyear;
		}

		public void setPyear(String pyear) {
			this.pyear = pyear;
		}

		public String getPcourse() {
			return pcourse;
		}

		public void setPcourse(String pcourse) {
			this.pcourse = pcourse;
		}

		public String getPbyear() {
			return pbyear;
		}

		public void setPbyear(String pbyear) {
			this.pbyear = pbyear;
		}
		
		// #################### END #############################
		
		void showUpdateProfile(){
		
		}
		
}
