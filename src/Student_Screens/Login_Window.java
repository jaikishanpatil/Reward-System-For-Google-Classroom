package Student_Screens;
/*################## login Window ###################*/

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Admin_Screens.Admin_Login;
import Admin_Screens.NeedHelp;
import Database.Connect;


public class Login_Window {

	public JFrame frame;
	
	LocalDate currentdate=java.time.LocalDate.now();
	LocalTime currenttime=java.time.LocalTime.now();
	
	String date=currentdate.toString();
	String time=currenttime.toString();
	
	private int xMouse,yMouse;
	String str;
	
	private JTextField login_user;
	private JPasswordField login_password;
	 //public String user1,pass1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Window window = new Login_Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 933, 700);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				
				System.exit(0);
			}
		});
		frame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse=e.getX();
				yMouse=e.getY();
			}
		});
		panel_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				frame.setLocation(x-xMouse,y-yMouse);
			}
		});
		
		login_password = new JPasswordField();
		login_password.setFont(new Font("Segoe UI", Font.BOLD, 16));
		login_password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Student_ragister window=new Student_ragister();
				window.frame.setVisible(true);
			}
		});
		label_3.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/singup_btn_login.JPG")));
		//label_3.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\signup 1.JPG"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_3.setBackground((Color) null);
		label_3.setBounds(457, 550, 253, 35);
		frame.getContentPane().add(label_3);
		
		JLabel lblGoogleClassroom = new JLabel("Google Classroom");
		lblGoogleClassroom.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoogleClassroom.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblGoogleClassroom.setBounds(139, 474, 180, 35);
		frame.getContentPane().add(lblGoogleClassroom);
		
		JLabel lblFor = new JLabel("For");
		lblFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFor.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblFor.setBounds(139, 443, 180, 35);
		frame.getContentPane().add(lblFor);
		
		JLabel lblNewLabel_4 = new JLabel("Reward System");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_4.setBounds(136, 408, 180, 35);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/classroom_img_200px.png")));
		//lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-google-classroom-200.png"));
		lblNewLabel_3.setBounds(126, 229, 193, 166);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblForgetPassword = new JLabel("Forgot password ?");
		lblForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgetPass f=new ForgetPass();
				f.frame.setVisible(true);
				
			}
		});
		lblForgetPassword.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(153, 51, 153)));
		lblForgetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgetPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblForgetPassword.setBounds(457, 431, 116, 30);
		frame.getContentPane().add(lblForgetPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Need help?");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NeedHelp nh=new NeedHelp();
				nh.frame.setVisible(true);
			}
		});
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(767, 80, 77, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel login_btn = new JLabel("");
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
/*################## Database connection for new register user ###################*/
				
		        Connect co=new Connect();
		        co.cLogin();
		        
		        
		        try {
					
					Statement st=co.conn.createStatement();
					String qr="select * from student_registration where std_username='"+login_user.getText()+"' and std_password='"+login_password.getText()+"'";
					 co.rs=st.executeQuery(qr);
					 if(co.rs.next()){
							JOptionPane.showMessageDialog(null,"Login Succesfully Done");
							
//######################### logger info retrive #########################
							
							File f1=new File("./WWW.txt");
							f1.createNewFile();
							FileOutputStream fout=new FileOutputStream(f1);
							String a=login_user.getText();
							char arr[]=a.toCharArray();
							for(int i=0;i<a.length();i++)
							{
								fout.write(arr[i]);
							}
							fout.close();
							
							
//##################### Exit ######################
							
							
							
							Main_Dashbord window = new Main_Dashbord();
							window.frame.setVisible(true);
							
// Student log gose from here#####################
							InetAddress stdIP=InetAddress.getLocalHost();
							
							String logQury="insert into student_log(session_id,std_username,std_status,std_ipaddress,date,login_time,logout_time)values(?,?,?,?,?,?,?)";
							PreparedStatement ps=co.conn.prepareStatement(logQury);
							
							Random rand=new Random();
							int numbers = rand.nextInt(999);
							String sessionId=Integer.toString(numbers);
							
							ps.setString(1, sessionId);
							ps.setString(2,login_user.getText());
							ps.setString(3, "ACTIVE");
							ps.setString(4, stdIP.toString());
							ps.setString(5, date);
							ps.setString(6, time);
							ps.setString(7, "");
							ps.executeUpdate();
							
//getting current session id##########################################
							try{
								File f11=new File("./session.txt");
								f11.createNewFile();
								FileOutputStream fout1=new FileOutputStream(f11);
								String a1=sessionId;
								char arr1[]=a1.toCharArray();
								for(int i=0;i<a1.length();i++)
								{
									fout1.write(arr1[i]);
								}
								fout1.close();
							}catch(IOException i){
								i.printStackTrace();
							}
							
// session data ends here############################################
							
							frame.dispose();
						}
						else{
							JOptionPane.showMessageDialog(null,"Login could not Succesfully Done");	
						}
					
					
					
					

					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        

			}

			
		});
		login_btn.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/login_btn.JPG")));
		//login_btn.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\login_btn1.JPG"));
		login_btn.setBackground(Color(23, 236, 186));
		login_btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
		login_btn.setHorizontalAlignment(SwingConstants.CENTER);
		
		login_btn.setBounds(457, 474, 253, 35);
		frame.getContentPane().add(login_btn);
		login_password.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		login_password.setBounds(457, 360, 253, 35);
		login_password.setEchoChar('*');
		frame.getContentPane().add(login_password);
		
		login_user = new JTextField("");
		login_user.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		login_user.setColumns(10);
		login_user.setForeground(Color.BLACK);
		login_user.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		login_user.setBounds(457, 262, 253, 35);
		
		frame.getContentPane().add(login_user);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/password_40px.png")));
		//label_2.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-password-40.png"));
		label_2.setBounds(395, 360, 45, 35);
		frame.getContentPane().add(label_2);
		
		JLabel login_show_pass = new JLabel("");
		login_show_pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				login_password.setEchoChar((char)0);
				login_show_pass.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/eye_open20px.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login_password.setEchoChar('*');
				login_show_pass.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/eye_close20px.png")));
			}
		});
		login_show_pass.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/eye_close20px.png")));
		//login_show_pass.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\eye close.png"));
		login_show_pass.setHorizontalAlignment(SwingConstants.CENTER);
		login_show_pass.setBounds(722, 375, 27, 20);
		frame.getContentPane().add(login_show_pass);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/user_40px.png")));
		//label_1.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-user-male-40.png"));
		label_1.setBounds(395, 262, 45, 35);
		frame.getContentPane().add(label_1);
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(0, 0, 933, 30);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/minimize_30px.png")));
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-subtract-30.png"));
		lblNewLabel.setBounds(864, 0, 30, 30);
		panel_3.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/close_30px.png")));
		//label.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-close-30.png"));
		label.setBounds(903, 0, 30, 30);
		panel_3.add(label);
		
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblLoginScreen.setBounds(52, 0, 145, 30);
		panel_3.add(lblLoginScreen);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		//label_4.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-google-classroom-30.png"));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 0, 30, 30);
		panel_3.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JLabel lblAdminLogin = new JLabel("Click here for Admin Login");
		lblAdminLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Admin_Login al=new Admin_Login();
				al.frame.setVisible(true);
			}
		});
		lblAdminLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdminLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblAdminLogin.setBounds(664, 620, 180, 30);
		frame.getContentPane().add(lblAdminLogin);
		lblNewLabel_1.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/login2.jpg")));
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\login2.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 30, 933, 670);
		frame.getContentPane().add(lblNewLabel_1);
	}

	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
}
