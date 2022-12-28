package Student_Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import Assets.Animation_Work.ShortMessage.Notification;
import Database.Connect;
import Database.SendEmailConfirmation;
import Database.SendEmailVerification;
import WorkingClasses.EmailValidation;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.CaretEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Student_ragister {
	
	EmailValidation validate = new EmailValidation();
	JFrame frame;
	String path;
	private int xMouse;
	JLabel stdProfImg, emailch;
	private int yMouse;
	private JTextField std_name;
	private JTextField std_prn;
	private JTextField std_mailid;
	private JPasswordField std_password;
	private JTextField std_phonenumber;
	private JTextField std_rollnumber;
	private JTextField std_batchYear;
	private JTextField std_username;
	JComboBox std_course, std_year;
	JLabel prnCheck, userCheck;
	public String temp;
	JTextArea std_address;
	public boolean registration = false;
	public boolean prnChecking = false;

	static String confirmUsername;
	static String confirmPassword;

	String myAccountEmail = "gclassrewardsystem@gmail.com";
	String password = "Gclass@11223344";

	SendEmailVerification sev = new SendEmailVerification();

	JLabel label_8;

	LocalDate currentdate = java.time.LocalDate.now();
	LocalTime currenttime = java.time.LocalTime.now();

	String date = currentdate.toString();
	String time = currenttime.toString();
	private JTextField otp;

	// #########################################################
	// Confirmation message through mail id

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Registration To Reward System");
			message.setText("Congratulation You have successfully registered to Reward system for google classroom \n"
					+ "Your Login crendiatiols are\n Username: " + confirmUsername + "\nPassword: " + confirmPassword
					+ "\n " + " You have get 100 reward point as singup bonus");
			return message;

		} catch (Exception ex) {
			Logger.getLogger(SendEmailConfirmation.class.getName()).log(Level.SEVERE, null, ex);

		}
		return null;
	}

	// ########################## END ############

	// ############################################### Methodes for the
	// animation ###########################
	private void registerActionPerformed(ActionEvent e) {// GEN-FIRST:event_jButton4ActionPerformed
		Notification panel = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER,
				"OTP Has been sent to your Mail id");
		panel.showNotification();
	}

	// ################################# END
	// #############################################

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_ragister window = new Student_ragister();
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
	public Student_ragister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 730);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel stu_topExit = new JPanel();
		stu_topExit.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));

		// ############################# Code for moving or drag screen
		// ##########################################
		stu_topExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		stu_topExit.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x - xMouse, y - yMouse);
			}
		});

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		// label_1.setIcon(new
		// ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google
		// Classroom (Final year
		// Project)\\Images\\loginScreen\\icons8-subtract-30.png"));
		label_1.setIcon(new ImageIcon(Student_ragister.class.getResource("/Assets/Images/minimize_30px.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(1211, 0, 30, 30);
		frame.getContentPane().add(label_1);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Login_Window lw = new Login_Window();
				lw.frame.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(Student_ragister.class.getResource("/Assets/Images/close_30px.png")));
		// label.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward
		// System For Google Classroom (Final year
		// Project)\\Images\\loginScreen\\icons8-close-30.png"));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(1250, 0, 30, 30);
		frame.getContentPane().add(label);
		stu_topExit.setBackground(new Color(0, 206, 209));
		stu_topExit.setBounds(0, 0, 1280, 30);
		frame.getContentPane().add(stu_topExit);
		stu_topExit.setLayout(null);

		JLabel label_2 = new JLabel("Login Screen");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				Login_Window lw = new Login_Window();
				lw.frame.setVisible(true);

			}
		});
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_2.setBounds(40, 0, 98, 30);
		stu_topExit.add(label_2);

		JLabel lblStudentRegistration = new JLabel("/ Student Registration");
		lblStudentRegistration.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStudentRegistration.setBounds(142, 0, 180, 30);
		stu_topExit.add(lblStudentRegistration);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(0, 0, 30, 30);
		Image img = new ImageIcon(this.getClass().getResource("/Classrom_img_20px.png")).getImage();
		label_5.setIcon(new ImageIcon(Student_ragister.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		stu_topExit.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setIcon(new ImageIcon(Student_ragister.class.getResource("/Assets/Images/classroom_img_100px.png")));
		// label_4.setIcon(new
		// ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google
		// Classroom (Final year
		// Project)\\Images\\Ragistration\\icons8-google-classroom-100.png"));
		label_4.setBounds(12, 597, 120, 120);
		frame.getContentPane().add(label_4);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(111, 119, 84, 30);
		frame.getContentPane().add(lblName);

		std_name = new JTextField();
		std_name.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_name.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		std_name.setBounds(207, 119, 210, 30);
		frame.getContentPane().add(std_name);
		std_name.setColumns(10);

		std_prn = new JTextField();
		std_prn.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				Connect co = new Connect();
				co.cLogin();
				temp = std_prn.getText();
				String qu = "select * from student_registration where std_prn='" + temp + "'";
				Statement st;

				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qu);
					if (co.rs.next()) {

						prnCheck.setText("PRN alredy present...");
						prnChecking = true;
					} else {
						prnCheck.setText("");
						prnChecking = false;
					}

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		std_prn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Action event for phone number limitation
				// ############################################################
				String prnnum = std_prn.getText();
				int length = prnnum.length();
				char c = e.getKeyChar();
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					if (length < 15) {
						std_prn.setEditable(true);
					} else {
						std_prn.setEditable(false);
					}
				} else {
					if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						std_prn.setEditable(true);
					} else {
						std_prn.setEditable(false);
					}
				}
			}
		});
		std_prn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_prn.setColumns(10);
		std_prn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		std_prn.setBounds(997, 332, 210, 30);
		frame.getContentPane().add(std_prn);

		JLabel lblPrn = new JLabel("PRN:");
		lblPrn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPrn.setBounds(910, 332, 75, 30);
		frame.getContentPane().add(lblPrn);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmail.setBounds(111, 188, 84, 30);
		frame.getContentPane().add(lblEmail);

		std_mailid = new JTextField();
		std_mailid.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {

				Connect co = new Connect();
				co.cLogin();
				temp = std_mailid.getText();
				String qu = "select * from email_verify where std_mailid='" + temp + "'";
				Statement st;
				if (validate.isValid(temp)) {
					try {
						st = co.conn.createStatement();
						co.rs = st.executeQuery(qu);
						if (co.rs.next()) {
							label_8.setIcon(
									new ImageIcon(Student_ragister.class.getResource("/Assets/Images/reject_30px.png")));
							registration = true;

						} else {
							label_8.setIcon(
									new ImageIcon(Student_ragister.class.getResource("/Assets/Images/approve_30px.png")));
							registration = false;
						}
						String qu1 = "select * from student_registration where std_mailid='" + temp + "'";
						st = co.conn.createStatement();
						co.rs = st.executeQuery(qu1);
						if (co.rs.next()) {
							emailch.setText("Email alredy ragistered..");

						} else {
							emailch.setText("");
						}

					} catch (SQLException e2) {
						e2.printStackTrace();
					}


				}
				else{
					emailch.setText("Enter Valid email.");
				}
			}
		});
		std_mailid.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_mailid.setColumns(10);
		std_mailid.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		std_mailid.setBounds(207, 188, 210, 30);
		frame.getContentPane().add(std_mailid);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPassword.setBounds(111, 332, 84, 30);
		frame.getContentPane().add(lblPassword);

		std_password = new JPasswordField();
		std_password.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_password.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		std_password.setBounds(207, 332, 210, 30);
		frame.getContentPane().add(std_password);

		std_phonenumber = new JTextField();
		std_phonenumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				// Action event for phone number limitation
				// ############################################################
				String phonenumber = std_phonenumber.getText();
				int length = phonenumber.length();
				char c = ke.getKeyChar();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					if (length < 10) {
						std_phonenumber.setEditable(true);
					} else {
						std_phonenumber.setEditable(false);
					}
				} else {
					if (ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						std_phonenumber.setEditable(true);
					} else {
						std_phonenumber.setEditable(false);
					}
				}
			}
		});
		std_phonenumber.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_phonenumber.setColumns(10);
		std_phonenumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		std_phonenumber.setBounds(207, 408, 210, 30);
		frame.getContentPane().add(std_phonenumber);

		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPhoneNo.setBounds(111, 408, 84, 30);
		frame.getContentPane().add(lblPhoneNo);

		std_rollnumber = new JTextField();
		std_rollnumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Action event for phone number limitation
				// ############################################################
				String rollnumm = std_rollnumber.getText();
				int length = rollnumm.length();
				char c = e.getKeyChar();
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					if (length < 4) {
						std_rollnumber.setEditable(true);
					} else {
						std_rollnumber.setEditable(false);
					}
				} else {
					if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						std_rollnumber.setEditable(true);
					} else {
						std_rollnumber.setEditable(false);
					}
				}
			}
		});
		std_rollnumber.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_rollnumber.setColumns(10);
		std_rollnumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		std_rollnumber.setBounds(997, 408, 210, 30);
		frame.getContentPane().add(std_rollnumber);

		JLabel lblRollNo = new JLabel("Roll No:");
		lblRollNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblRollNo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblRollNo.setBounds(910, 408, 75, 30);
		frame.getContentPane().add(lblRollNo);

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourse.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCourse.setBounds(910, 188, 75, 30);
		frame.getContentPane().add(lblCourse);

		JLabel lblBranch = new JLabel("Year:");
		lblBranch.setHorizontalAlignment(SwingConstants.LEFT);
		lblBranch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblBranch.setBounds(910, 119, 75, 30);
		frame.getContentPane().add(lblBranch);

		std_batchYear = new JTextField();
		std_batchYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// Action event for phone number limitation
				// ############################################################
				String btyear = std_batchYear.getText();
				int length = btyear.length();
				char c = arg0.getKeyChar();
				if (arg0.getKeyChar() >= '0' && arg0.getKeyChar() <= '9' || arg0.getKeyChar() <= '-') {
					if (length < 12) {
						std_batchYear.setEditable(true);
					} else {
						std_batchYear.setEditable(false);
					}
				} else {
					if (arg0.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| arg0.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						std_batchYear.setEditable(true);
					} else {
						std_batchYear.setEditable(false);
					}
				}
			}
		});
		std_batchYear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_batchYear.setColumns(10);
		std_batchYear.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		std_batchYear.setBounds(997, 260, 210, 30);
		frame.getContentPane().add(std_batchYear);

		JLabel lblCourseYear = new JLabel("Batch Year:");
		lblCourseYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourseYear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCourseYear.setBounds(885, 260, 100, 30);
		frame.getContentPane().add(lblCourseYear);

		JLabel lblDob = new JLabel("DOB:");
		lblDob.setHorizontalAlignment(SwingConstants.LEFT);
		lblDob.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDob.setBounds(523, 119, 75, 30);
		frame.getContentPane().add(lblDob);

		JDateChooser std_dob = new JDateChooser();
		std_dob.setDateFormatString("yyyy-MM-dd ");
		std_dob.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_dob.setBorder(null);
		std_dob.setBounds(610, 119, 210, 30);
		frame.getContentPane().add(std_dob);

		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_Window lw = new Login_Window();
				lw.frame.setVisible(true);
				frame.dispose();
			}
		});
		label_6.setIcon(new ImageIcon(Student_ragister.class.getResource("/Assets/Images/login_reg.JPG")));
		// label_6.setIcon(new
		// ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google
		// Classroom (Final year
		// Project)\\Images\\loginScreen\\login_reg.JPG"));
		label_6.setBounds(955, 597, 100, 35);
		frame.getContentPane().add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				std_name.setText("");
				std_prn.setText("");
				std_rollnumber.setText("");
				std_phonenumber.setText("");
				std_mailid.setText("");
				std_dob.setDate(null);
				std_username.setText("");
				std_password.setText("");
				std_year.setSelectedItem(null);
				std_course.setSelectedItem(null);
				std_batchYear.setText("");
				std_address.setText("");
				std_prn.setEditable(true);
				std_batchYear.setEnabled(true);
				std_rollnumber.setEnabled(true);
				std_phonenumber.setEnabled(true);
				stdProfImg.setIcon(null);

			}
		});
		label_7.setIcon(new ImageIcon(Student_ragister.class.getResource("/Assets/Images/clearall_reg.JPG")));
		// label_7.setIcon(new
		// ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google
		// Classroom (Final year
		// Project)\\Images\\loginScreen\\clearall_reg.JPG"));
		label_7.setBounds(1095, 597, 100, 35);
		frame.getContentPane().add(label_7);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 194, 210, 50);
		frame.getContentPane().add(scrollPane);

		std_address = new JTextArea();
		std_address.setFont(new Font("Segoe UI", Font.BOLD, 16));
		scrollPane.setViewportView(std_address);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAddress.setBounds(523, 188, 76, 30);
		frame.getContentPane().add(lblAddress);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUsername.setBounds(108, 260, 90, 30);
		frame.getContentPane().add(lblUsername);

		std_username = new JTextField();
		std_username.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				Connect co = new Connect();
				co.cLogin();
				temp = std_username.getText();
				String qu = "select * from student_registration where std_username='" + temp + "'";
				Statement st;

				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qu);
					if (co.rs.next()) {
						userCheck.setText("Username alredy taken..");

					} else {
						userCheck.setText("");
					}

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		std_username.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_username.setColumns(10);
		std_username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		std_username.setBounds(210, 260, 210, 30);
		frame.getContentPane().add(std_username);

		label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				String temp = std_mailid.getText();
				String qu = "select * from email_verify where std_mailid='" + temp + "'";
				Statement st;

				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qu);
					// System.out.println("Connection Successfull");
					if (co.rs.next()) {

						// Image verifyregimg=new
						// ImageIcon(this.getClass().getResource("/approve_30px.png")).getImage();
						// label_8.setIcon(new ImageIcon(verifyregimg));
						label_8.setIcon(
								new ImageIcon(Student_ragister.class.getResource("/Assets/Images/approve_30px.png")));
					}

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});

		// label_8.setIcon(new
		// ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google
		// Classroom (Final year
		// Project)\\Images\\Ragistration\\icons8-approval-30.png"));
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(429, 188, 30, 30);
		frame.getContentPane().add(label_8);

		String branch[] = { " ", "First Year", "Second Year", "Third Year", "Fourth Year" };

		std_year = new JComboBox(branch);
		std_year.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_year.setBackground(new Color(255, 255, 255));
		std_year.setBounds(997, 119, 210, 30);
		frame.getContentPane().add(std_year);

		String course[] = { " ", "Computer Engineering", "Mechanical Engineering", "Electrical Engineering",
				"IT Engineering", "Chemical Engineering" };

		std_course = new JComboBox(course);
		std_course.setFont(new Font("Segoe UI", Font.BOLD, 16));
		std_course.setBackground(Color.WHITE);
		std_course.setBounds(997, 188, 210, 30);
		frame.getContentPane().add(std_course);

		JLabel std_show_pass = new JLabel("");
		Image showpassreg = new ImageIcon(this.getClass().getResource("/eye_close20px.png")).getImage();
		std_show_pass.setIcon(new ImageIcon(showpassreg));
		// std_show_pass.setIcon(new
		// ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google
		// Classroom (Final year Project)\\Images\\loginScreen\\eye
		// close.png"));
		std_show_pass.setHorizontalAlignment(SwingConstants.CENTER);

		std_show_pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				std_password.setEchoChar((char) 0);
				std_show_pass.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/eye_open20px.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				std_password.setEchoChar('*');
				std_show_pass
						.setIcon(new ImageIcon(Login_Window.class.getResource("/Assets/Images/eye_close20px.png")));
			}
		});

		std_show_pass.setBounds(429, 340, 27, 20);
		frame.getContentPane().add(std_show_pass);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/Classrom20.png")).getImage();

		JLabel std_Sing_up = new JLabel("");
		std_Sing_up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*
				 * ################## Database connection for new register user
				 * ###################
				 */

				if (registration == true) {

					if (otp.getText().equals(sev.str1)) {
						Connect co = new Connect();
						co.cLogin();

						try {
							String query = "insert into student_registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement ps = co.conn.prepareStatement(query);
							FileInputStream fis = new FileInputStream(path);

							ps.setString(1, std_name.getText());
							ps.setString(2, std_prn.getText());
							ps.setString(3, std_rollnumber.getText());
							ps.setString(4, std_phonenumber.getText());
							ps.setString(5, std_mailid.getText());
							ps.setString(6, ((JTextField) std_dob.getDateEditor().getUiComponent()).getText());
							ps.setString(7, std_address.getText());
							ps.setString(8, std_username.getText());
							ps.setString(9, std_password.getText());
							ps.setString(10, (String) std_year.getSelectedItem());
							ps.setString(11, (String) std_course.getSelectedItem());
							ps.setString(12, std_batchYear.getText());
							ps.setBinaryStream(13, fis);
							ps.setString(14, date);
							ps.setString(15, time);
							ps.executeUpdate();

							// ########################### Sending 100 singup
							// bonus to the new Students
							// ###########################################
							String bonuspointQuery = "insert into student_reward_points values(?,?,?,?)";
							PreparedStatement bonus = co.conn.prepareStatement(bonuspointQuery);
							bonus.setString(1, std_name.getText());
							bonus.setString(2, std_mailid.getText());
							bonus.setString(3, std_prn.getText());
							bonus.setInt(4, 100);
							bonus.executeUpdate();
							JOptionPane.showMessageDialog(null, "You have been Registred successfully");
							// ######################################### END
							// #########################################

							// ########################### Sending 100 singup
							// bonus to the new Students
							// ###########################################
							String quizStatusinsert = "insert into quiz_status(qs_email,qs_std_name,qs_status,qs_lastdate,qs_newdate) values(?,?,?,?,?)";
							PreparedStatement quizstatus = co.conn.prepareStatement(quizStatusinsert);
							quizstatus.setString(1, std_mailid.getText());
							quizstatus.setString(2, std_name.getText());
							quizstatus.setString(3, "0");
							quizstatus.setString(4, "");
							quizstatus.setString(5, "");
							quizstatus.executeUpdate();
							// ######################################### END
							// #########################################

							// Sending mail for the confirmation of the student
							try {
								// SendEmailConfirmation.sendmail(std_mailid.getText());
								confirmUsername = std_username.getText();
								confirmPassword = std_password.getText();
								// ##################################################Sending
								// Username and password along with confirmation
								// message####################################################################

								Properties properties = new Properties();
								properties.put("mail.smtp.auth", "true");
								properties.put("mail.smtp.starttls.enable", "true");
								properties.put("mail.smtp.host", "smtp.gmail.com");
								properties.put("mail.smtp.port", "587");

								Session session = Session.getInstance(properties, new Authenticator() {
									@Override
									protected PasswordAuthentication getPasswordAuthentication() {
										return new PasswordAuthentication(myAccountEmail, password);
									}
								});

								Message message1 = prepareMessage(session, myAccountEmail, std_mailid.getText());
								Transport.send(message1);

							} catch (Exception ee) {
								// TODO Auto-generated catch block
								ee.printStackTrace();
							}
							std_name.setText("");
							std_prn.setText("");
							std_rollnumber.setText("");
							std_phonenumber.setText("");
							std_mailid.setText("");
							std_dob.setDate(null);
							std_username.setText("");
							std_password.setText("");
							std_year.setSelectedItem(null);
							std_course.setSelectedItem(null);
							std_batchYear.setText("");
							std_address.setText("");
							otp.setText("");
							stdProfImg.setIcon(null);

						} catch (SQLException | FileNotFoundException e) {

							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Incorret OTP");
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"You are not verified student for registration, Please contact to the admin using-------- mailid");
				}

			}
		});
		std_Sing_up.setIcon(new ImageIcon(Student_ragister.class.getResource("/Assets/Images/signup_reg.JPG")));
		// std_Sing_up.setIcon(new
		// ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google
		// Classroom (Final year
		// Project)\\Images\\loginScreen\\signup_reg.JPG"));
		std_Sing_up.setBounds(815, 597, 100, 35);
		frame.getContentPane().add(std_Sing_up);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Image mainregimg = new ImageIcon(this.getClass().getResource("/signup_bg.png")).getImage();

		JLabel lblOtp = new JLabel("OTP");
		lblOtp.setHorizontalAlignment(SwingConstants.LEFT);
		lblOtp.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblOtp.setBounds(910, 485, 75, 30);
		frame.getContentPane().add(lblOtp);

		otp = new JTextField();
		otp.setFont(new Font("Segoe UI", Font.BOLD, 16));
		otp.setColumns(10);
		otp.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		otp.setBounds(997, 485, 210, 30);
		frame.getContentPane().add(otp);

		JCheckBox checkBox = new JCheckBox("");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					// sending OTP from here
					try {
						registerActionPerformed(e);
						String temp1 = std_mailid.getText();
						SendEmailVerification.sendmail(temp1);

					} catch (Exception ee) {

						ee.printStackTrace();
					}
				} else {
					checkBox.setSelected(false);
				}
			}
		});
		checkBox.setBounds(1216, 490, 25, 25);
		frame.getContentPane().add(checkBox);

		prnCheck = new JLabel("");
		prnCheck.setForeground(new Color(255, 0, 0));
		prnCheck.setHorizontalAlignment(SwingConstants.LEFT);
		prnCheck.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		prnCheck.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(153, 51, 153)));
		prnCheck.setBounds(1076, 365, 135, 20);
		frame.getContentPane().add(prnCheck);

		userCheck = new JLabel("");
		userCheck.setHorizontalAlignment(SwingConstants.LEFT);
		userCheck.setForeground(Color.RED);
		userCheck.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		userCheck.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(153, 51, 153)));
		userCheck.setBounds(270, 291, 147, 20);
		frame.getContentPane().add(userCheck);

		JLabel lblProfile = new JLabel("Profile:");
		lblProfile.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfile.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblProfile.setBounds(523, 268, 76, 30);
		frame.getContentPane().add(lblProfile);

		stdProfImg = new JLabel("");
		stdProfImg.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		stdProfImg.setBounds(610, 274, 100, 99);
		frame.getContentPane().add(stdProfImg);

		JLabel selectImg = new JLabel("");
		selectImg.setIcon(new ImageIcon(Student_ragister.class.getResource("/Assets/Images/browse_button.PNG")));
		selectImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jc = new JFileChooser();
				jc.setCurrentDirectory(new File(System.getProperty("user.home")));

				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "png");
				jc.addChoosableFileFilter(filter);
				int Result = jc.showSaveDialog(null);

				File select = jc.getSelectedFile();
				String filename = select.getName();

				if (filename.endsWith(".jpg") || filename.endsWith(".JPG") || filename.endsWith(".JPEG")
						|| filename.endsWith(".jpeg") || filename.endsWith(".png") || filename.endsWith(".PNG")) {
					if (Result == JFileChooser.APPROVE_OPTION) {
						path = select.getAbsolutePath();
						ImageIcon myimg = new ImageIcon(path);
						Image img = myimg.getImage();
						Image newImg = img.getScaledInstance(stdProfImg.getWidth(), stdProfImg.getHeight(),
								Image.SCALE_SMOOTH);
						ImageIcon image = new ImageIcon(newImg);
						stdProfImg.setIcon(image);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select Image file format", "Try again", 1);
				}
			}
		});
		selectImg.setFont(new Font("Segoe UI", Font.BOLD, 16));
		selectImg.setHorizontalAlignment(SwingConstants.CENTER);
		selectImg.setBounds(722, 348, 70, 25);
		frame.getContentPane().add(selectImg);

		emailch = new JLabel("");
		emailch.setHorizontalAlignment(SwingConstants.LEFT);
		emailch.setForeground(Color.RED);
		emailch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		emailch.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(153, 51, 153)));
		emailch.setBounds(249, 219, 168, 20);
		frame.getContentPane().add(emailch);
		lblNewLabel.setIcon(new ImageIcon(mainregimg));
		// lblNewLabel.setIcon(new
		// ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google
		// Classroom (Final year Project)\\Images\\Ragistration\\signup
		// bg.png"));
		lblNewLabel.setBounds(0, 30, 1280, 699);
		frame.getContentPane().add(lblNewLabel);
	}

	protected void repaint() {
		// TODO Auto-generated method stub

	}
}
