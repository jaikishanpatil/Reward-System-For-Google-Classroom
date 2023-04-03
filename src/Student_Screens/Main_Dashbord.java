package Student_Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import Admin_Screens.Feedback;
import Admin_Screens.NeedHelp;
import Admin_Screens.Stdunt_Timetable;
import Assets.Animation_Work.SweetAlart.Message;
import Database.Connect;
import Components.Notepad_1_0.Notepad;
import Components.Quiz_Menia.Quiz_instruction;
import Components.Quiz_Menia.Student_Quiz;
import Components.StudentDrive.StudentDrive;
import Components.Student_Rewards.DBtoTable;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
public class Main_Dashbord {
	
	
	LocalDate currentdate=java.time.LocalDate.now();
	LocalTime currenttime=java.time.LocalTime.now();
	
	String date=currentdate.toString();
	String time=currenttime.toString();
	
	// Session variable
	int min=0,sec=0;
	Timer time1;
	
	public JFrame frame;
	private int xMouse,yMouse;
	static String name,tyear,tcourse;
	JLabel showimg,maindashimg,std_points,secMin,secSec;
	FileOutputStream outpute;
	InputStream input;
	String path;
	int sessionId;
	JTextArea updateSoftwareNews,updateCurriculamNews,updateEventNews;
	/*public int day,month,year,second,minut,hour;
	public JLabel date;
	public JLabel time;
*/	
	synchronized void Timee(){
		time1 = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				secMin.setText(String.valueOf(min));
				secSec.setText(String.valueOf(sec));

				if (sec == 60) {
					sec = 0;
					min++;
					if (min == 30) {
						time1.stop();
						
						File f1=new File("./WWW.txt");
						try {
							f1.createNewFile();
							FileOutputStream fout=new FileOutputStream(f1);
							String a=" ";
							char arr[]=a.toCharArray();
							for(int i=0;i<a.length();i++)
							{
								fout.write(arr[i]);
							}
							fout.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Login_Window lw=new Login_Window();
						lw.frame.setVisible(true);
						
	//Disclose the student active loag when logout###########################
						
						Connect co=new Connect();
						co.cLogin();
						
						String sessionid=null;
						
						File f11=new File("./session.txt");
						Scanner sc;
						try {
							sc = new Scanner(f11);
							sc.useDelimiter("\\Z");
							sessionid=sc.next();
						}catch(Exception e){
							e.printStackTrace();
						}
						String Status="DEACTIVATE";
						
						String stdlog="UPDATE student_log SET std_status='"+Status+"' , logout_time='"+time+"' WHERE session_id='"+sessionid+"'";
						Statement st=null;
						try {
							st=co.conn.createStatement();
							st.executeUpdate(stdlog);
							
							
							try {
								f11.createNewFile();
								FileOutputStream fout=new FileOutputStream(f11);
								String a=" ";
								char arr[]=a.toCharArray();
								for(int i=0;i<a.length();i++)
								{
									fout.write(arr[i]);
								}
								fout.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 //co.rs=st.executeQuery(query);
						
						
						
						frame.dispose();
						
						
					}
				}
				sec++;
			}
			
		});
		time1.start();
		
	}
	
	
	//################################ Animation class #################333
	 private void errorActionPerformed(MouseEvent arg0) {//GEN-FIRST:event_jButton1ActionPerformed
	        Message me = new Message(frame, true);
	        me.showAlert();
	    }
	
	
	
	//################################ END ################
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Dashbord window = new Main_Dashbord();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	

	public Main_Dashbord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UpdaterClass uc=new UpdaterClass();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Segoe UI", Font.BOLD, 18));
		frame.setBounds(100, 100, 1400, 770);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JPanel Main_top_exit = new JPanel();
		Main_top_exit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		
		Main_top_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse=e.getX();
				yMouse=e.getY();
			}
		});
		Main_top_exit.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				frame.setLocation(x-xMouse, y-yMouse);
				
			}
		});
		Main_top_exit.setBackground(new Color(240, 128, 128));
		Main_top_exit.setBounds(0, 0, 1400, 30);
		frame.getContentPane().add(Main_top_exit);
		Main_top_exit.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		
		secSec = new JLabel("");
		secSec.setBounds(1039, 0, 26, 28);
		Main_top_exit.add(secSec);
		secSec.setForeground(Color.RED);
		secSec.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		secMin = new JLabel("");
		secMin.setBounds(1016, 0, 26, 28);
		Main_top_exit.add(secMin);
		secMin.setForeground(Color.RED);
		secMin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		//label.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-subtract-30.png"));
		label.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/minimize_30px.png")));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(1323, 0, 40, 30);
		Main_top_exit.add(label);
		
		
		
		
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int reply=JOptionPane.showConfirmDialog(
			            null,
			            "Do You Want To Exit The Screen?",
			            "",
			            JOptionPane.YES_NO_OPTION);
				if(reply == JOptionPane.YES_OPTION){
					
					
					
					//Disclose the student active loag when logout###########################
					
					Connect co=new Connect();
					co.cLogin();
					
					String sessionid=null;
					
					File f11=new File("./session.txt");
					Scanner sc;
					try {
						sc = new Scanner(f11);
						sc.useDelimiter("\\Z");
						sessionid=sc.next();
					}catch(Exception e1){
						e1.printStackTrace();
					}
					String Status="DEACTIVATE";
					
					String stdlog="UPDATE student_log SET std_status='"+Status+"' , logout_time='"+time+"' WHERE session_id='"+sessionid+"'";
					Statement st=null;
					try {
						st=co.conn.createStatement();
						st.executeUpdate(stdlog);
						
						
						try {
							f11.createNewFile();
							FileOutputStream fout=new FileOutputStream(f11);
							String a=" ";
							char arr[]=a.toCharArray();
							for(int i=0;i<a.length();i++)
							{
								fout.write(arr[i]);
							}
							fout.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//######################### END ####################
					File f1=new File("./WWW.txt");
					File f2=new File("./session.txt");
					try {
						f1.createNewFile();
						f2.createNewFile();
						FileOutputStream fout=new FileOutputStream(f1);
						FileOutputStream fout1=new FileOutputStream(f2);
						String a=" ";
						char arr[]=a.toCharArray();
						for(int i=0;i<a.length();i++)
						{
							fout.write(arr[i]);
							fout1.write(arr[i]);
						}
						fout.close();
						fout1.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
					/*Login_Window lw=new Login_Window();
					lw.frame.setVisible(true);
					frame.dispose();*/
					
				}else{
					
				}
				time1.stop();
				 //co.rs=st.executeQuery(query);
				
			}
		});
		label_1.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/close_30px.png")));
		//label_1.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-close-30.png"));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(1360, 0, 40, 30);
		Main_top_exit.add(label_1);
		
		JLabel lblStudentDashbord = new JLabel("Student Dashboard");
		lblStudentDashbord.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStudentDashbord.setBounds(52, 0, 160, 30);
		Main_top_exit.add(lblStudentDashbord);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		//label_3.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-google-classroom-30.png"));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 0, 30, 30);
		Main_top_exit.add(label_3);
		
		JLabel lblStudentLoginSession = new JLabel("Student Login Session :");
		lblStudentLoginSession.setBounds(772, 0, 232, 33);
		Main_top_exit.add(lblStudentLoginSession);
		lblStudentLoginSession.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblStudentLoginSession.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel homePannel = new JPanel();
		homePannel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		homePannel.setBackground(new Color(217, 250, 243));
		homePannel.setBounds(302, 30, 1097, 740);
		frame.getContentPane().add(homePannel);
		homePannel.setLayout(null);
		
		homePannel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse=e.getX();
				yMouse=e.getY();
			}
		});
		homePannel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				frame.setLocation(x-xMouse,y-yMouse);
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(63, 43, 300, 170);
		homePannel.add(panel_3);
		panel_3.setLayout(null);
		uc.update();
		std_points = new JLabel("Points....");
		std_points.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DBtoTable dbBtoTable=new DBtoTable();
				dbBtoTable.frame.setVisible(true);
				frame.dispose();
			}
		});
		std_points.setText(uc.points);
		std_points.setForeground(Color.WHITE);
		std_points.setFont(new Font("Segoe UI", Font.BOLD, 22));
		std_points.setBounds(152, 100, 136, 38);
		panel_3.add(std_points);
		
		JLabel lblCurrentPoints = new JLabel("Current Points :");
		lblCurrentPoints.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DBtoTable dbBtoTable=new DBtoTable();
				dbBtoTable.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblCurrentPoints.setForeground(Color.WHITE);
		lblCurrentPoints.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblCurrentPoints.setBounds(26, 100, 136, 38);
		panel_3.add(lblCurrentPoints);
		
		JLabel lblRewards = new JLabel("Rewards");
		lblRewards.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DBtoTable dbBtoTable=new DBtoTable();
				dbBtoTable.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblRewards.setForeground(Color.WHITE);
		lblRewards.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRewards.setBounds(64, 26, 98, 38);
		panel_3.add(lblRewards);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/points_30px.png")));
		label_5.setBounds(12, 34, 40, 30);
		panel_3.add(label_5);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DBtoTable dbBtoTable=new DBtoTable();
				dbBtoTable.frame.setVisible(true);
				frame.dispose();
			}
		});
		label_2.setBounds(0, 0, 300, 170);
		panel_3.add(label_2);
		label_2.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/red_sdn.JPG")));
		
		
		JPanel newsPannel = new JPanel();
		newsPannel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		newsPannel.setBackground(Color.WHITE);
		newsPannel.setBounds(817, 0, 280, 740);
		homePannel.add(newsPannel);
		newsPannel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Updateing the news from hear and put into their respective textAreas 
				/*updateCurriculamNews.setText("");
				updateEventNews.setText("");
				updateSoftwareNews.setText("");
				try{
					Connect co=new Connect();
					co.cLogin();
					Statement st1=co.conn.createStatement();
					String query1="select curriculum_news from update_news";
					co.rs=st1.executeQuery(query1);
					if(co.rs.next()){
						updateCurriculamNews.append(co.rs.getString("curriculum_news"));
					}
					String query2="select event_news from update_news";
					co.rs=st1.executeQuery(query2);
					if(co.rs.next()){
						updateEventNews.append(co.rs.getString("event_news"));
					}
					String query3="select software_update from update_news";
					co.rs=st1.executeQuery(query3);
					if(co.rs.next()){
						updateSoftwareNews.append(co.rs.getString("software_update"));
					}
					
				}catch(Exception ee){
					ee.printStackTrace();
				}
				
				//Updating news ends hear
*/			}
		});
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Curriculum News", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(new Color(245, 255, 250));
		panel_4.setBounds(0, 0, 279, 270);
		newsPannel.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 17, 255, 240);
		panel_4.add(scrollPane);
		
		updateCurriculamNews = new JTextArea();
		updateCurriculamNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Updateing the news from hear and put into their respective textAreas 
				updateCurriculamNews.setText("");
				updateEventNews.setText("");
				updateSoftwareNews.setText("");
				try{
					Connect co=new Connect();
					co.cLogin();
					Statement st1=co.conn.createStatement();
					String query1="select curriculum_news from update_news";
					co.rs=st1.executeQuery(query1);
					if(co.rs.next()){
						updateCurriculamNews.append(co.rs.getString("curriculum_news"));
					}
					String query2="select event_news from update_news";
					co.rs=st1.executeQuery(query2);
					if(co.rs.next()){
						updateEventNews.append(co.rs.getString("event_news"));
					}
					String query3="select software_update from update_news";
					co.rs=st1.executeQuery(query3);
					if(co.rs.next()){
						updateSoftwareNews.append(co.rs.getString("software_update"));
					}
					
				}catch(Exception ee){
					ee.printStackTrace();
				}
				
				//Updating news ends hear
			}
		});
		updateCurriculamNews.setEditable(false);
		updateCurriculamNews.setForeground(new Color(255, 102, 153));
		scrollPane.setViewportView(updateCurriculamNews);
		updateCurriculamNews.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updateCurriculamNews.setBackground(new Color(245, 255, 250));
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Event News", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBackground(new Color(245, 255, 250));
		panel_5.setBounds(0, 269, 279, 270);
		newsPannel.add(panel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 19, 253, 238);
		panel_5.add(scrollPane_1);
		
		updateEventNews = new JTextArea();
		updateEventNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Updateing the news from hear and put into their respective textAreas 
				updateCurriculamNews.setText("");
				updateEventNews.setText("");
				updateSoftwareNews.setText("");
				try{
					Connect co=new Connect();
					co.cLogin();
					Statement st1=co.conn.createStatement();
					String query1="select curriculum_news from update_news";
					co.rs=st1.executeQuery(query1);
					if(co.rs.next()){
						updateCurriculamNews.append(co.rs.getString("curriculum_news"));
					}
					String query2="select event_news from update_news";
					co.rs=st1.executeQuery(query2);
					if(co.rs.next()){
						updateEventNews.append(co.rs.getString("event_news"));
					}
					String query3="select software_update from update_news";
					co.rs=st1.executeQuery(query3);
					if(co.rs.next()){
						updateSoftwareNews.append(co.rs.getString("software_update"));
					}
					
				}catch(Exception ee){
					ee.printStackTrace();
				}
				
				//Updating news ends hear
			}
		});
		updateEventNews.setEditable(false);
		updateEventNews.setForeground(new Color(255, 102, 255));
		scrollPane_1.setViewportView(updateEventNews);
		updateEventNews.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updateEventNews.setBackground(new Color(245, 255, 250));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Software Update", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBackground(new Color(245, 255, 250));
		panel_6.setBounds(0, 537, 279, 202);
		newsPannel.add(panel_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 17, 253, 172);
		panel_6.add(scrollPane_2);
		
		updateSoftwareNews = new JTextArea();
		updateSoftwareNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Updateing the news from hear and put into their respective textAreas 
				updateCurriculamNews.setText("");
				updateEventNews.setText("");
				updateSoftwareNews.setText("");
				try{
					Connect co=new Connect();
					co.cLogin();
					Statement st1=co.conn.createStatement();
					String query1="select curriculum_news from update_news";
					co.rs=st1.executeQuery(query1);
					if(co.rs.next()){
						updateCurriculamNews.append(co.rs.getString("curriculum_news"));
					}
					String query2="select event_news from update_news";
					co.rs=st1.executeQuery(query2);
					if(co.rs.next()){
						updateEventNews.append(co.rs.getString("event_news"));
					}
					String query3="select software_update from update_news";
					co.rs=st1.executeQuery(query3);
					if(co.rs.next()){
						updateSoftwareNews.append(co.rs.getString("software_update"));
					}
					
				}catch(Exception ee){
					ee.printStackTrace();
				}
				
				//Updating news ends hear
			}
		});
		updateSoftwareNews.setEditable(false);
		updateSoftwareNews.setForeground(new Color(204, 0, 153));
		scrollPane_2.setViewportView(updateSoftwareNews);
		updateSoftwareNews.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updateSoftwareNews.setBackground(new Color(245, 255, 250));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(416, 43, 300, 170);
		homePannel.add(panel_1);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				int flag=0;
				int reply=JOptionPane.showConfirmDialog(
			            null,
			            "Do You Want To Open Quiz",
			            "",
			            JOptionPane.YES_NO_OPTION);
				if(reply == JOptionPane.YES_OPTION){
					
					Connect co=new Connect();
					co.cLogin();
					
					UpdaterClass uc=new UpdaterClass();
					uc.update();
					
					SimpleDateFormat sdtf=new SimpleDateFormat("dd-MM-yyyy");
					Date date=new Date();
					String todaydate=sdtf.format(date);
					String usernewdate=uc.qsnewdate;
					
					//############ Check the date for compare #####
					
					 Date date1;
					
						date1 = sdtf.parse(todaydate);
						 Date date2 = sdtf.parse(usernewdate);
						 int result = date1.compareTo(date2);
						 if (result == 0) {
					          
					        } else if (result > 0) {
					            /*System.out.println("Date1 is after Date2");*/
					            flag=1;
					        } else if (result < 0) {
					           /* System.out.println("Date1 is before Date2");*/
					            
					        } 
					
					
					if(uc.qsstatus.equals("0")){
						frame.dispose();
						Quiz_instruction sq=new Quiz_instruction();
						sq.frame.setVisible(true);
					}
					if(uc.qsstatus.equals("1")){
						if(todaydate.equals(usernewdate) || flag==1 ){
							frame.dispose();
							Quiz_instruction sq=new Quiz_instruction();
							sq.frame.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(null, "You have last open this quiz on '"+uc.qslastdate+"' Try later after 2 days of given date, Next date of opening quiz is '"+uc.qsnewdate+"'");
						}
						
					}
			
				}
				
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		label_4.setBounds(0, 0, 300, 170);
		
		JLabel lblQuizMenia = new JLabel("Quiz Mania");
		lblQuizMenia.setForeground(Color.WHITE);
		lblQuizMenia.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQuizMenia.setBounds(86, 59, 136, 38);
		panel_1.add(lblQuizMenia);
		label_4.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/blue_sdn.JPG")));
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(0, 270, 817, 470);
		homePannel.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		maindashimg = new JLabel("");
		maindashimg.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Desktop d=Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.google.com/maps/place/A.+C.+Patil+College+of+Engineering/@19.030557,73.0593393,17z/data=!4m12!1m6!3m5!1s0x3be7c24052e100f3:0xb6e3e4259b43a898!2sA.+C.+Patil+College+of+Engineering!8m2!3d19.030557!4d73.061528!3m4!1s0x3be7c24052e100f3:0xb6e3e4259b43a898!8m2!3d19.030557!4d73.061528"));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel.setBounds(708, 97, 97, 67);
		panel_2.add(lblNewLabel);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop d=Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.acpce.org/"));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		label_7.setBounds(12, 348, 162, 109);
		panel_2.add(label_7);
		maindashimg.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/main_dashboard.png")));
		maindashimg.setBounds(0, 0, 817, 469);
		panel_2.add(maindashimg);
		
		Timee();
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 153, 255));
		panel.setBounds(1, 30, 300, 740);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_6 = new JLabel("");
		label_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		label_6.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/main_leftside_gread.jpg")));
		showimg = new JLabel("");
		showimg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student_Profile stf=new Student_Profile();
				stf.frame.setVisible(true);
			}
		});
		showimg.setHorizontalAlignment(SwingConstants.CENTER);
		showimg.setBounds(101, 13, 100, 99);
		showimg.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/male_profile.png")));
		panel.add(showimg);
		
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
			try {
				st = ct.conn.createStatement();
				ct.rs=st.executeQuery(cquery);
				
				// image setup
				File thefile=new File("myImages.png");
				outpute=new FileOutputStream(thefile);
				
				///
				if(ct.rs.next()){
					name=ct.rs.getString("std_name");
					tyear=ct.rs.getString("std_year");
					tcourse=ct.rs.getString("std_course");
					input=ct.rs.getBinaryStream("std_profile");
					byte[] buffer=new byte[input.available()];
					while(input.read(buffer)>0){
						outpute.write(buffer);
				}
					path=thefile.getAbsolutePath();
					ImageIcon myimg=new ImageIcon(path);
					Image img=myimg.getImage();
					Image newImg=img.getScaledInstance(showimg.getWidth(), showimg.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon image=new ImageIcon(newImg);
					showimg.setIcon(image);
				}
			} catch (SQLException | IOException e1) {
				e1.printStackTrace();
			}
			
			//Updateing the news from hear and put into their respective textAreas 
			try{
				Connect co=new Connect();
				co.cLogin();
				Statement st1=co.conn.createStatement();
				String query1="select curriculum_news from update_news";
				co.rs=st1.executeQuery(query1);
				if(co.rs.next()){
					updateCurriculamNews.append(co.rs.getString("curriculum_news"));
				}
				String query2="select event_news from update_news";
				co.rs=st1.executeQuery(query2);
				if(co.rs.next()){
					updateEventNews.append(co.rs.getString("event_news"));
				}
				String query3="select software_update from update_news";
				co.rs=st1.executeQuery(query3);
				if(co.rs.next()){
					updateSoftwareNews.append(co.rs.getString("software_update"));
				}
				
			}catch(Exception ee){
				ee.printStackTrace();
			}
			
			//Updating news ends hear
			
			
			
			
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel stdname = new JLabel(name);
		stdname.setForeground(new Color(255, 255, 204));
		stdname.setHorizontalAlignment(SwingConstants.CENTER);
		stdname.setFont(new Font("Segoe UI", Font.BOLD, 18));
		stdname.setBounds(12, 108, 276, 30);
		panel.add(stdname);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 151, 276, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 441, 276, 2);
		panel.add(separator_1);
		
		JLabel stdReward = new JLabel("Student Rewards");
		stdReward.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				stdReward.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				stdReward.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DBtoTable rs=new DBtoTable();
				rs.frame.setVisible(true);
				frame.dispose();
//				frame.setVisible(false);
				
				
			}
		});
		stdReward.setHorizontalAlignment(SwingConstants.LEFT);
		stdReward.setForeground(Color.BLACK);
		stdReward.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		stdReward.setBackground(Color.BLACK);
		stdReward.setBounds(112, 164, 176, 45);
		panel.add(stdReward);
		
		JLabel label_16 = new JLabel("");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/reward.png")));
		label_16.setBounds(56, 164, 50, 45);
		panel.add(label_16);
		
		JLabel mainTimeTable = new JLabel("Time Table");
		mainTimeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainTimeTable.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainTimeTable.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Stdunt_Timetable st=new Stdunt_Timetable();
				st.frame.setVisible(true);
			}
		});
		mainTimeTable.setHorizontalAlignment(SwingConstants.LEFT);
		mainTimeTable.setForeground(Color.BLACK);
		mainTimeTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mainTimeTable.setBackground(Color.BLACK);
		mainTimeTable.setBounds(112, 240, 176, 45);
		panel.add(mainTimeTable);
		
		JLabel label_17 = new JLabel("");
		label_17.setForeground(Color.DARK_GRAY);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/timetable.png")));
		label_17.setBounds(56, 240, 50, 45);
		panel.add(label_17);
		
		JLabel label_12 = new JLabel("");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Notepad np=new Notepad();
			}
		});
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/google-drive-42.png")));
		label_12.setBounds(56, 312, 50, 45);
		panel.add(label_12);
		
		JLabel mainNotePad = new JLabel("Student Drive\r\n");
		mainNotePad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainNotePad.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainNotePad.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				Notepad np=new Notepad();
				StudentDrive st=new StudentDrive();
				frame.dispose();
				st.frame.setVisible(true);
				
				
			}
		});
		mainNotePad.setHorizontalAlignment(SwingConstants.LEFT);
		mainNotePad.setForeground(Color.BLACK);
		mainNotePad.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mainNotePad.setBackground(Color.BLACK);
		mainNotePad.setBounds(112, 312, 176, 45);
		panel.add(mainNotePad);
		
		JLabel label_19 = new JLabel("");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/quiz.png")));
		label_19.setBounds(56, 383, 50, 45);
		panel.add(label_19);
		
		JLabel mainQuize = new JLabel("Quiz Compition");
		mainQuize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainQuize.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainQuize.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int flag=0;
					int reply=JOptionPane.showConfirmDialog(
				            null,
				            "Do You Want To Open Quiz",
				            "",
				            JOptionPane.YES_NO_OPTION);
					if(reply == JOptionPane.YES_OPTION){
						
						Connect co=new Connect();
						co.cLogin();
						
						UpdaterClass uc=new UpdaterClass();
						uc.update();
						
						SimpleDateFormat sdtf=new SimpleDateFormat("dd-MM-yyyy");
						Date date=new Date();
						String todaydate=sdtf.format(date);
						String usernewdate=uc.qsnewdate;
						
						//############ Check the date for compare #####
						
						 Date date1;
						
							date1 = sdtf.parse(todaydate);
							 Date date2 = sdtf.parse(usernewdate);
							 int result = date1.compareTo(date2);
							 if (result == 0) {
						          
						        } else if (result > 0) {
						            /*System.out.println("Date1 is after Date2");*/
						            flag=1;
						        } else if (result < 0) {
						           /* System.out.println("Date1 is before Date2");*/
						            
						        } 
						
						
						if(uc.qsstatus.equals("0")){
							frame.dispose();
							Quiz_instruction sq=new Quiz_instruction();
							sq.frame.setVisible(true);
						}
						if(uc.qsstatus.equals("1")){
							if(todaydate.equals(usernewdate) || flag==1 ){
								frame.dispose();
								Quiz_instruction sq=new Quiz_instruction();
								sq.frame.setVisible(true);
							}
							else{
								JOptionPane.showMessageDialog(null, "You have last open this quiz on '"+uc.qslastdate+"' Try later after 2 days of given date, Next date of opening quiz is '"+uc.qsnewdate+"'");
							}
							
						}
				
					}
					
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
			}
		});
		mainQuize.setHorizontalAlignment(SwingConstants.LEFT);
		mainQuize.setForeground(Color.BLACK);
		mainQuize.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mainQuize.setBackground(Color.BLACK);
		mainQuize.setBounds(112, 383, 176, 45);
		panel.add(mainQuize);
		
		JLabel mainSetting = new JLabel("");
		mainSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				errorActionPerformed(arg0);
			}
		});
		mainSetting.setToolTipText("Settings\r\n");
		mainSetting.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/setting.png")));
		mainSetting.setHorizontalAlignment(SwingConstants.CENTER);
		mainSetting.setBounds(183, 486, 60, 60);
		panel.add(mainSetting);
		
		JLabel mainNeedHelp = new JLabel("");
		mainNeedHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NeedHelp nh=new NeedHelp();
				nh.frame.setVisible(true);
				
			}
		});
		mainNeedHelp.setToolTipText("Need Help");
		mainNeedHelp.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/help.png")));
		mainNeedHelp.setHorizontalAlignment(SwingConstants.CENTER);
		mainNeedHelp.setBounds(51, 591, 60, 60);
		panel.add(mainNeedHelp);
		
		JLabel mainLogout = new JLabel("");
		mainLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int reply=JOptionPane.showConfirmDialog(
			            null,
			            "Do You Want To Logout?",
			            "",
			            JOptionPane.YES_NO_OPTION);
				if(reply == JOptionPane.YES_OPTION){
					File f1=new File("./WWW.txt");
					try {
						f1.createNewFile();
						FileOutputStream fout=new FileOutputStream(f1);
						String a=" ";
						char arr[]=a.toCharArray();
						for(int i=0;i<a.length();i++)
						{
							fout.write(arr[i]);
						}
						fout.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Login_Window lw=new Login_Window();
					lw.frame.setVisible(true);
					
//Disclose the student active loag when logout###########################
					
					Connect co=new Connect();
					co.cLogin();
					
					String sessionid=null;
					
					File f11=new File("./session.txt");
					Scanner sc;
					try {
						sc = new Scanner(f11);
						sc.useDelimiter("\\Z");
						sessionid=sc.next();
					}catch(Exception e){
						e.printStackTrace();
					}
					String Status="DEACTIVATE";
					
					String stdlog="UPDATE student_log SET std_status='"+Status+"' , logout_time='"+time+"' WHERE session_id='"+sessionid+"'";
					Statement st=null;
					try {
						st=co.conn.createStatement();
						st.executeUpdate(stdlog);
						
						
						try {
							f11.createNewFile();
							FileOutputStream fout=new FileOutputStream(f11);
							String a=" ";
							char arr[]=a.toCharArray();
							for(int i=0;i<a.length();i++)
							{
								fout.write(arr[i]);
							}
							fout.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 //co.rs=st.executeQuery(query);
					
					
					
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "Logout Fail...");
				}
				time1.stop();
				
			}
		});
		mainLogout.setToolTipText("Logout");
		mainLogout.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/logout.png")));
		mainLogout.setHorizontalAlignment(SwingConstants.CENTER);
		mainLogout.setBounds(183, 591, 60, 60);
		panel.add(mainLogout);
		
		JLabel mainFeedback = new JLabel("");
		mainFeedback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Feedback fb=new Feedback();
				fb.frame.setVisible(true);
			}
		});
		mainFeedback.setToolTipText("FeedBack");
		mainFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		mainFeedback.setIcon(new ImageIcon(Main_Dashbord.class.getResource("/Assets/Images/feedback.png")));
		mainFeedback.setBounds(51, 486, 60, 60);
		panel.add(mainFeedback);
		
		//label_6.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\Dashbord\\gradient_panel1.jpg"));
		label_6.setBounds(1, 0, 300, 740);
		panel.add(label_6);
		
	}
}
