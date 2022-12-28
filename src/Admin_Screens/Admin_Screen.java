package Admin_Screens;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Database.Connect;
import Components.Student_Rewards.MyQuery;
import Components.Student_Rewards.MyQueryCat;
import Components.Student_Rewards.Product2;
import Components.Student_Rewards.TheModel;
import Student_Screens.Login_Window;
import WorkingClasses.PointDestrubution;
import WorkingClasses.PointDestrubutionByApi;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class Admin_Screen {
	

	public JFrame frame;
	JTextArea urDescription, fmsg;
	JComboBox urCategory, rewardCat, ttcourse, ttyear, comboBox;
	FileOutputStream outpute;
	String reName, reDescription, rePoint, reCategory;
	JLabel reImg = new JLabel();
	JLabel urImg, ttimg, feCount, seCount, TeCount, BECount, stdCount, feedPending, feedRead, feedCount, queId;
	InputStream input;
	Connect co = new Connect();
	boolean pathSelect = false;
	String tid = null;

	JTabbedPane tabbedPane;

	private int xMouse, yMouse;
	private JTextField adminEmail;
	JComboBox logsortBy;
	JLabel lblHome, lblManageStudent, lblAddStudent, lblUpdateStudent, lblUpdateNews;
	private JTable table;
	Image searchlbl = new ImageIcon(this.getClass().getResource("/search_30px.png")).getImage();
	Image donelbl = new ImageIcon(this.getClass().getResource("/done_30px.png")).getImage();

	// Variables for table content for manage students
	String mname, memail, mprn, mdob, musername, macadi, mcourse, mbatch, mrdate, mrtime, madress;

	// variables for student loag
	String slogId, susername, sstatus, sdate, slogintime, sipaddress, slogouttime;
	// End
	private JTextField txtSearch;
	private JTextField updatesearch;
	private JTable updatetable;
	private JTextField uname;
	private JTextField uemail;
	private JTextField udob;
	private JTextField uprn;
	private JTextField uusername;
	private JTextField uayear;
	private JTextField ucourse;
	private JTextField ubatch;
	private JTextArea uaddress;
	private JTextField gettingPath;
	String path;
	private JTextField stdloguname;
	private JTable stdLog_table;
	private JTextField reward_name;
	private JTextField reward_point;
	private JTable update_reward_table;
	private JTextField urName;
	private JTextField urPoints;
	private JTextField urId;
	private JTable feedTable;
	private JTable reward_point_table;
	private JTable pointTable;
	private JTextField fname;
	private JTextField femail;
	private JTextField fsubject;

	// End

	// Variables

	String line = "";
	String[] value;

	ArrayList<String> array = new ArrayList<String>();
	ArrayList<String> array1 = new ArrayList<String>();
	ArrayList<String> arr = new ArrayList<String>();
	int count = 0;
	Object[] newArr;
	Object[] arrNew;
	String em, points1;
	private JTable redeem_record;
	private JTextField queName;
	private JTextField qopt1;
	private JTextField qopt3;
	private JTextField qopt2;
	private JTextField qanswer;
	private JTextField qopt4;
	private JTextField squename;
	private JTextField sopt1;
	private JTextField sopt2;
	private JTextField sopt3;
	private JTextField sopt4;
	private JTextField sans;
	private JTextField queidsearch;
	private JTable allquestiontable;
	
	// All tables method are here
	
	 void manageStudentTableConfig(){
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name", "Email Id", "PRN", "DOB", "Username", "Academic year", "Course", "Address",
						"Batch Year", "Registration Date", "Registration Time" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setMinWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setMinWidth(25);
		table.getColumnModel().getColumn(5).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setMinWidth(25);
		table.getColumnModel().getColumn(6).setPreferredWidth(170);
		table.getColumnModel().getColumn(6).setMinWidth(25);
		table.getColumnModel().getColumn(7).setPreferredWidth(180);
		table.getColumnModel().getColumn(7).setMinWidth(25);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setMinWidth(25);
		table.getColumnModel().getColumn(9).setPreferredWidth(110);
		table.getColumnModel().getColumn(9).setMinWidth(25);
		table.getColumnModel().getColumn(10).setPreferredWidth(115);
		table.getColumnModel().getColumn(10).setMinWidth(25);
	}
	 
	 void updateStudentDataTableConfig(){
		 updatetable.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Name", "Email Id", "PRN", "DOB", "Username", "Academic year", "Course", "Address",
							"Batch Year", "Registration Date", "Registration Time" }));
			updatetable.getColumnModel().getColumn(0).setPreferredWidth(120);
			updatetable.getColumnModel().getColumn(0).setMinWidth(40);
			updatetable.getColumnModel().getColumn(1).setPreferredWidth(120);
			updatetable.getColumnModel().getColumn(1).setMinWidth(25);
			updatetable.getColumnModel().getColumn(2).setPreferredWidth(120);
			updatetable.getColumnModel().getColumn(2).setMinWidth(25);
			updatetable.getColumnModel().getColumn(3).setPreferredWidth(120);
			updatetable.getColumnModel().getColumn(3).setMinWidth(25);
			updatetable.getColumnModel().getColumn(4).setPreferredWidth(120);
			updatetable.getColumnModel().getColumn(4).setMinWidth(25);
			updatetable.getColumnModel().getColumn(5).setPreferredWidth(110);
			updatetable.getColumnModel().getColumn(5).setMinWidth(25);
			updatetable.getColumnModel().getColumn(6).setPreferredWidth(170);
			updatetable.getColumnModel().getColumn(6).setMinWidth(25);
			updatetable.getColumnModel().getColumn(7).setPreferredWidth(122);
			updatetable.getColumnModel().getColumn(7).setMinWidth(25);
			updatetable.getColumnModel().getColumn(8).setPreferredWidth(90);
			updatetable.getColumnModel().getColumn(8).setMinWidth(25);
			updatetable.getColumnModel().getColumn(9).setPreferredWidth(110);
			updatetable.getColumnModel().getColumn(9).setMinWidth(25);
			updatetable.getColumnModel().getColumn(10).setPreferredWidth(115);
			updatetable.getColumnModel().getColumn(10).setMinWidth(25);
	 }
	 
	 void studentLogTableConfig(){
		 stdLog_table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Session Id", "Username",
					"IP Address", "Status", "Date", "Login Time", "Logout Time" }));
			stdLog_table.getColumnModel().getColumn(0).setPreferredWidth(109);
			stdLog_table.getColumnModel().getColumn(0).setMinWidth(25);
			stdLog_table.getColumnModel().getColumn(1).setPreferredWidth(129);
			stdLog_table.getColumnModel().getColumn(1).setMinWidth(25);
			stdLog_table.getColumnModel().getColumn(2).setPreferredWidth(180);
			stdLog_table.getColumnModel().getColumn(2).setMinWidth(25);
			stdLog_table.getColumnModel().getColumn(3).setPreferredWidth(116);
			stdLog_table.getColumnModel().getColumn(3).setMinWidth(25);
			stdLog_table.getColumnModel().getColumn(4).setPreferredWidth(130);
			stdLog_table.getColumnModel().getColumn(4).setMinWidth(25);
			stdLog_table.getColumnModel().getColumn(5).setPreferredWidth(130);
			stdLog_table.getColumnModel().getColumn(5).setMinWidth(25);
			stdLog_table.getColumnModel().getColumn(6).setPreferredWidth(123);
			stdLog_table.getColumnModel().getColumn(6).setMinWidth(25);
			stdLog_table.setFont(new Font("Segoe UI", Font.BOLD, 16));
	 }
	 
	 void updateRewardTableConfig(){
			update_reward_table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "id", "name", "Points", "Description", "image", "Categorie" }));
			update_reward_table.getColumnModel().getColumn(0).setPreferredWidth(123);
			update_reward_table.getColumnModel().getColumn(0).setMinWidth(30);
			update_reward_table.getColumnModel().getColumn(1).setPreferredWidth(176);
			update_reward_table.getColumnModel().getColumn(1).setMinWidth(30);
			update_reward_table.getColumnModel().getColumn(2).setMinWidth(25);
			update_reward_table.getColumnModel().getColumn(3).setPreferredWidth(148);
			update_reward_table.getColumnModel().getColumn(3).setMinWidth(25);
			update_reward_table.getColumnModel().getColumn(4).setPreferredWidth(161);
			update_reward_table.getColumnModel().getColumn(4).setMinWidth(30);
			update_reward_table.getColumnModel().getColumn(5).setMinWidth(25);
	 }
	
	 void redeemRecordTableConfig(){
		 redeem_record.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Reward Id", "Reward Category",
					"Reward User name", "Reward User Email Id", "Unique Codes" }));
			redeem_record.getColumnModel().getColumn(0).setPreferredWidth(98);
			redeem_record.getColumnModel().getColumn(0).setMinWidth(25);
			redeem_record.getColumnModel().getColumn(1).setPreferredWidth(152);
			redeem_record.getColumnModel().getColumn(1).setMinWidth(25);
			redeem_record.getColumnModel().getColumn(2).setPreferredWidth(202);
			redeem_record.getColumnModel().getColumn(2).setMinWidth(25);
			redeem_record.getColumnModel().getColumn(3).setPreferredWidth(201);
			redeem_record.getColumnModel().getColumn(3).setMinWidth(25);
			redeem_record.getColumnModel().getColumn(4).setPreferredWidth(139);
			redeem_record.getColumnModel().getColumn(4).setMinWidth(25);
			redeem_record.setBackground(new Color(240, 248, 255));
	 }
	 
	 void allQuestionDisplayForQuizTableConfig(){
		 allquestiontable.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Question Id", "Question", "Option 1", "Option 2", "Option 3", "Option 4", "Answer" }));
			allquestiontable.getColumnModel().getColumn(0).setPreferredWidth(86);
			allquestiontable.getColumnModel().getColumn(0).setMinWidth(25);
			allquestiontable.getColumnModel().getColumn(1).setPreferredWidth(185);
			allquestiontable.getColumnModel().getColumn(1).setMinWidth(25);
			allquestiontable.getColumnModel().getColumn(2).setPreferredWidth(150);
			allquestiontable.getColumnModel().getColumn(2).setMinWidth(25);
			allquestiontable.getColumnModel().getColumn(3).setPreferredWidth(150);
			allquestiontable.getColumnModel().getColumn(3).setMinWidth(25);
			allquestiontable.getColumnModel().getColumn(4).setPreferredWidth(150);
			allquestiontable.getColumnModel().getColumn(4).setMinWidth(25);
			allquestiontable.getColumnModel().getColumn(5).setPreferredWidth(150);
			allquestiontable.getColumnModel().getColumn(5).setMinWidth(25);
			allquestiontable.getColumnModel().getColumn(6).setPreferredWidth(150);
			allquestiontable.getColumnModel().getColumn(6).setMinWidth(25);
			allquestiontable.setBackground(new Color(255, 255, 153));
	 }
	 
	 void redeemPointsTableConfig(){
		 reward_point_table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Student Name", "Student Email", "Student PRN", "Reward Points" }));
			reward_point_table.getColumnModel().getColumn(0).setPreferredWidth(197);
			reward_point_table.getColumnModel().getColumn(0).setMinWidth(25);
			reward_point_table.getColumnModel().getColumn(1).setPreferredWidth(184);
			reward_point_table.getColumnModel().getColumn(1).setMinWidth(25);
			reward_point_table.getColumnModel().getColumn(2).setPreferredWidth(157);
			reward_point_table.getColumnModel().getColumn(2).setMinWidth(25);
			reward_point_table.getColumnModel().getColumn(3).setPreferredWidth(159);
			reward_point_table.getColumnModel().getColumn(3).setMinWidth(25);
			reward_point_table.setFont(new Font("Segoe UI", Font.BOLD, 16));
	 }
	
	 void pointsTableConfig(){
		 pointTable.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Student Email", "Marks", "Points" }));
			pointTable.getColumnModel().getColumn(0).setPreferredWidth(148);
			pointTable.getColumnModel().getColumn(0).setMinWidth(25);
			pointTable.getColumnModel().getColumn(1).setPreferredWidth(129);
			pointTable.getColumnModel().getColumn(1).setMinWidth(25);
			pointTable.getColumnModel().getColumn(2).setPreferredWidth(125);
			pointTable.getColumnModel().getColumn(2).setMinWidth(25);
	 }
	 
	 void feedBackTableConfig(){
		 feedTable.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Name", "Email Id", "Subject", "Message", "Status" }));
			feedTable.getColumnModel().getColumn(0).setPreferredWidth(152);
			feedTable.getColumnModel().getColumn(0).setMinWidth(25);
			feedTable.getColumnModel().getColumn(1).setPreferredWidth(181);
			feedTable.getColumnModel().getColumn(1).setMinWidth(25);
			feedTable.getColumnModel().getColumn(2).setPreferredWidth(127);
			feedTable.getColumnModel().getColumn(2).setMinWidth(25);
			feedTable.getColumnModel().getColumn(3).setPreferredWidth(311);
			feedTable.getColumnModel().getColumn(3).setMinWidth(25);
			feedTable.getColumnModel().getColumn(4).setPreferredWidth(100);
			feedTable.getColumnModel().getColumn(4).setMinWidth(25);
			feedTable.setFont(new Font("Segoe UI", Font.BOLD, 16));
	 }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Screen window = new Admin_Screen();
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
	public Admin_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		updateData udp = new updateData();
		frame = new JFrame();
		frame.setBounds(100, 100, 1400, 770);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel admin_main_top = new JPanel();
		admin_main_top.setLayout(null);
		admin_main_top.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		admin_main_top.setBackground(Color.DARK_GRAY);
		admin_main_top.setBounds(0, 0, 1400, 30);

		admin_main_top.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		admin_main_top.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x - xMouse, y - yMouse);

			}
		});

		frame.getContentPane().add(admin_main_top);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/minimizebutton.png")));
		label.setBounds(1323, 0, 40, 30);
		admin_main_top.add(label);

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Login_Window lw = new Login_Window();
				lw.frame.setVisible(true);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/closebutton.png")));
		label_1.setBounds(1360, 0, 40, 30);
		admin_main_top.add(label_1);

		JLabel lblAdminDashbord = new JLabel("Admin Dashboard");
		lblAdminDashbord.setForeground(Color.WHITE);
		lblAdminDashbord.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAdminDashbord.setBounds(52, 0, 145, 30);
		admin_main_top.add(lblAdminDashbord);

		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		label_3.setBounds(12, 0, 30, 30);
		admin_main_top.add(label_3);

		JPanel panel = new JPanel();
		panel.setBounds(0, 30, 300, 740);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		Image adminleft = new ImageIcon(this.getClass().getResource("/grey_admin_left_window.JPG")).getImage();

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblHome.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHome.setForeground(new Color(92, 84, 76));
			}
		});
		panel_9.setBounds(33, 57, 241, 40);
		panel.add(panel_9);
		panel_9.setLayout(null);

		lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblHome.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHome.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
				stdCount.setText(udp.totalCount);
				feCount.setText(udp.fecount);
				seCount.setText(udp.secount);
				TeCount.setText(udp.tecount);
				BECount.setText(udp.becount);
				feedCount.setText(udp.feedCount);
				feedRead.setText(udp.feedread);
				feedPending.setText(udp.feedpending);
			}
		});
		lblHome.setForeground(new Color(92, 84, 76));
		lblHome.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(58, 0, 121, 40);
		panel_9.add(lblHome);

		JPanel panel_11 = new JPanel();
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblUpdateStudent.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUpdateStudent.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		panel_11.setLayout(null);
		panel_11.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_11.setBackground(Color.LIGHT_GRAY);
		panel_11.setBounds(33, 240, 241, 40);
		panel.add(panel_11);

		lblUpdateStudent = new JLabel("Update Student");
		lblUpdateStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblUpdateStudent.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUpdateStudent.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		lblUpdateStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateStudent.setForeground(new Color(92, 84, 76));
		lblUpdateStudent.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUpdateStudent.setBounds(32, 0, 174, 40);
		panel_11.add(lblUpdateStudent);

		JPanel panel_10 = new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblManageStudent.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblManageStudent.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_10.setBackground(Color.LIGHT_GRAY);
		panel_10.setBounds(33, 108, 241, 40);
		panel.add(panel_10);

		lblManageStudent = new JLabel("Manage Student");
		lblManageStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblManageStudent.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblManageStudent.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);

				manageStudentTableConfig();

				Connect co = new Connect();
				co.cLogin();
				String qury = "select * from student_registration";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qury);

					while (co.rs.next()) {
						mname = co.rs.getString("std_name");
						memail = co.rs.getString("std_mailid");
						mprn = co.rs.getString("std_prn");
						mdob = co.rs.getString("std_dob");
						musername = co.rs.getString("std_username");
						macadi = co.rs.getString("std_year");
						mcourse = co.rs.getString("std_course");
						madress = co.rs.getString("std_address");
						mbatch = co.rs.getString("std_batchYear");
						mrdate = co.rs.getString("date");
						mrtime = co.rs.getString("time");

						String todata[] = { mname, memail, mprn, mdob, musername, macadi, mcourse, madress, mbatch,
								mrdate, mrtime };
						DefaultTableModel df = (DefaultTableModel) table.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		lblManageStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageStudent.setForeground(new Color(92, 84, 76));
		lblManageStudent.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblManageStudent.setBounds(44, 0, 156, 40);
		panel_10.add(lblManageStudent);

		JPanel panel_12 = new JPanel();
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddStudent.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAddStudent.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_12.setBackground(Color.LIGHT_GRAY);
		panel_12.setBounds(33, 189, 241, 40);
		panel.add(panel_12);

		lblAddStudent = new JLabel("Add Student");
		lblAddStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddStudent.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAddStudent.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStudent.setForeground(new Color(92, 84, 76));
		lblAddStudent.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAddStudent.setBounds(58, 0, 121, 40);
		panel_12.add(lblAddStudent);

		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_14.setBackground(Color.LIGHT_GRAY);
		panel_14.setBounds(33, 375, 241, 40);
		panel.add(panel_14);

		JLabel lblUserLog = new JLabel("Student Log");
		lblUserLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(5);

				studentLogTableConfig();

				Connect connect = new Connect();
				connect.cLogin();

				String str = "Select * from student_log";
				try {
					Statement st = connect.conn.createStatement();
					connect.rs = st.executeQuery(str);
					while (connect.rs.next()) {
						slogId = connect.rs.getString("session_id");
						susername = connect.rs.getString("std_username");
						sstatus = connect.rs.getString("std_status");
						sdate = connect.rs.getString("date");
						slogintime = connect.rs.getString("login_time");
						slogouttime = connect.rs.getString("logout_time");
						sipaddress = connect.rs.getString("std_ipaddress");

						String todata[] = { slogId, susername, sipaddress, sstatus, sdate, slogintime, slogouttime };
						DefaultTableModel df = (DefaultTableModel) stdLog_table.getModel();
						df.addRow(todata);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblUserLog.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUserLog.setForeground(new Color(92, 84, 76));
			}
		});
		lblUserLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLog.setForeground(new Color(92, 84, 76));
		lblUserLog.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUserLog.setBounds(58, 0, 121, 40);
		panel_14.add(lblUserLog);

		JPanel panel_13 = new JPanel();
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblUpdateNews.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUpdateNews.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		panel_13.setLayout(null);
		panel_13.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_13.setBackground(Color.LIGHT_GRAY);
		panel_13.setBounds(33, 290, 241, 40);
		panel.add(panel_13);

		lblUpdateNews = new JLabel("Update News");
		lblUpdateNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblUpdateNews.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUpdateNews.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		lblUpdateNews.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateNews.setForeground(new Color(92, 84, 76));
		lblUpdateNews.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUpdateNews.setBounds(47, 0, 143, 40);
		panel_13.add(lblUpdateNews);

		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_15.setBounds(33, 428, 241, 40);
		panel.add(panel_15);

		JLabel lblUpdateReward = new JLabel("Update Reward");
		lblUpdateReward.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblUpdateReward.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUpdateReward.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(6);

				MyQuery mq = new MyQuery();
				ArrayList<Product2> list = mq.BindTable();
				String[] columnName = { "ID", "Name", "Points", "Description", "Image", "Categorie" };
				Object[][] rows = new Object[list.size()][6];
				for (int i = 0; i < list.size(); i++) {
					rows[i][0] = list.get(i).getId();
					rows[i][1] = list.get(i).getName();
					rows[i][2] = list.get(i).getQunt();
					rows[i][3] = list.get(i).getPrice();

					if (list.get(i).getMyImage() != null) {
						ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
								.getScaledInstance(150, 120, Image.SCALE_SMOOTH));
						rows[i][4] = image;
					} else {
						rows[i][4] = null;
					}

					rows[i][5] = list.get(i).getCatId();

				}
				TheModel model = new TheModel(rows, columnName);
				update_reward_table.setModel(model);
				update_reward_table.setRowHeight(120);
				update_reward_table.getColumnModel().getColumn(4).setPreferredWidth(150);

				// Data of reward redeem record
				redeemRecordTableConfig();

				Connect co = new Connect();
				co.cLogin();
				try {
					Statement st = co.conn.createStatement();
					String Query = "select * from reward_record";

					co.rs = st.executeQuery(Query);

					while (co.rs.next()) {
						String rmname = co.rs.getString("reward_id");
						String rmemail = co.rs.getString("reward_category");
						String rmprn = co.rs.getString("user_name");
						String rmdob = co.rs.getString("user_email");
						String rmusername = co.rs.getString("reward_unique_code");

						String todata[] = { rmname, rmemail, rmprn, rmdob, rmusername };
						DefaultTableModel df = (DefaultTableModel) redeem_record.getModel();
						df.addRow(todata);

					}

				} catch (Exception e1) {

				}
			}
		});
		lblUpdateReward.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateReward.setForeground(new Color(92, 84, 76));
		lblUpdateReward.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUpdateReward.setBounds(45, 0, 158, 40);
		panel_15.add(lblUpdateReward);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(33, 481, 241, 40);
		panel.add(panel_3);

		JLabel lblUpdateTimetable = new JLabel("Update Timetable");
		lblUpdateTimetable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblUpdateTimetable.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUpdateTimetable.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(7);
			}
		});
		lblUpdateTimetable.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTimetable.setForeground(new Color(92, 84, 76));
		lblUpdateTimetable.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUpdateTimetable.setBounds(33, 0, 181, 40);
		panel_3.add(lblUpdateTimetable);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(33, 562, 241, 40);
		panel.add(panel_4);

		JLabel lblUpdateQuize = new JLabel("Update Quiz");
		lblUpdateQuize.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblUpdateQuize.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUpdateQuize.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(8);

				allQuestionDisplayForQuizTableConfig();

				Connect co = new Connect();
				co.cLogin();
				String qury = "select * from quiz_questions";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qury);

					while (co.rs.next()) {

						String id = co.rs.getString(1);
						String que = co.rs.getString(2);
						String op1 = co.rs.getString(3);
						String op2 = co.rs.getString(4);
						String op3 = co.rs.getString(5);
						String op4 = co.rs.getString(6);
						String ans = co.rs.getString(7);

						String todata[] = { id, que, op1, op2, op3, op4, ans };
						DefaultTableModel df = (DefaultTableModel) allquestiontable.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		lblUpdateQuize.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateQuize.setForeground(new Color(92, 84, 76));
		lblUpdateQuize.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUpdateQuize.setBounds(33, 0, 181, 40);
		panel_4.add(lblUpdateQuize);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(33, 615, 241, 40);
		panel.add(panel_2);

		JLabel lblDistrubutePoints = new JLabel("Distribute points");
		lblDistrubutePoints.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblDistrubutePoints.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDistrubutePoints.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(9);

				// click on show the table

				redeemPointsTableConfig();

				Connect co = new Connect();
				co.cLogin();
				String query = "select * from student_reward_points";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(query);

					while (co.rs.next()) {
						String rdname = co.rs.getString("reward_name");
						String rdemail = co.rs.getString("reward_email");
						String rdprn = co.rs.getString("reward_prn");
						int rdpoints = co.rs.getInt("reward_points");
						String points = String.valueOf(rdpoints);

						String todata[] = { rdname, rdemail, rdprn, points };
						DefaultTableModel df = (DefaultTableModel) reward_point_table.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		lblDistrubutePoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistrubutePoints.setForeground(new Color(92, 84, 76));
		lblDistrubutePoints.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblDistrubutePoints.setBounds(33, 0, 181, 40);
		panel_2.add(lblDistrubutePoints);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(33, 668, 241, 40);
		panel.add(panel_5);

		JLabel lblFeedbacks = new JLabel("FeedBacks");
		lblFeedbacks.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblFeedbacks.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFeedbacks.setForeground(new Color(92, 84, 76));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(10);
				feedBackTableConfig();
				Connect co = new Connect();
				co.cLogin();
				String qury = "select * from feedback";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qury);

					while (co.rs.next()) {
						String fdname = co.rs.getString("feed_name");
						String fdemail = co.rs.getString("feed_email");
						String fdsub = co.rs.getString("feed_subject");
						String fdmsg = co.rs.getString("feed_message");
						String fdstatus = co.rs.getString("feed_status");

						String todata[] = { fdname, fdemail, fdsub, fdmsg, fdstatus };
						DefaultTableModel df = (DefaultTableModel) feedTable.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		lblFeedbacks.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbacks.setForeground(new Color(92, 84, 76));
		lblFeedbacks.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblFeedbacks.setBounds(33, 0, 181, 40);
		panel_5.add(lblFeedbacks);

		JLabel lblnd = new JLabel("");
		lblnd.setBorder(new MatteBorder(1, 2, 2, 1, (Color) new Color(0, 0, 0)));
		lblnd.setForeground(Color.WHITE);
		lblnd.setBounds(0, 0, 300, 740);
		lblnd.setIcon(new ImageIcon(adminleft));
		panel.add(lblnd);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 0, 0)));
		tabbedPane.setBounds(300, -31, 1097, 801);
		frame.getContentPane().add(tabbedPane);

		JPanel adminHome = new JPanel();
		adminHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {

				tabbedPane.setSelectedIndex(0);
				updateData udp = new updateData();
				stdCount.setText(udp.totalCount);
				feCount.setText(udp.fecount);
				seCount.setText(udp.secount);
				TeCount.setText(udp.tecount);
				BECount.setText(udp.becount);
				feedCount.setText(udp.feedCount);
				feedRead.setText(udp.feedread);
				feedPending.setText(udp.feedpending);
			}
		});
		adminHome.setBackground(new Color(0, 204, 153));
		tabbedPane.addTab("New tab", null, adminHome, null);
		adminHome.setLayout(null);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(555, 470, 2, 266);
		adminHome.add(separator_3);

		JLabel lblWelcomeToAdmin = new JLabel("  Admin Area  ");
		lblWelcomeToAdmin.setBorder(null);
		lblWelcomeToAdmin.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblWelcomeToAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAdmin.setBounds(387, 58, 375, 50);
		adminHome.add(lblWelcomeToAdmin);

		JLabel lblGuidlines = new JLabel("Guidelines:");
		lblGuidlines.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblGuidlines.setBorder(null);
		lblGuidlines.setBounds(81, 136, 127, 40);
		adminHome.add(lblGuidlines);

		JLabel lblDontHideAnything = new JLabel("* Dont Hide anything stupid ");
		lblDontHideAnything.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDontHideAnything.setBounds(175, 177, 424, 30);
		adminHome.add(lblDontHideAnything);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 428, 1065, 2);
		adminHome.add(separator_2);

		JLabel lblNewLabel = new JLabel("Student Enrolled ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setBounds(177, 519, 182, 30);
		adminHome.add(lblNewLabel);

		stdCount = new JLabel("");
		stdCount.setForeground(Color.RED);
		stdCount.setText(udp.totalCount);
		stdCount.setHorizontalAlignment(SwingConstants.CENTER);
		stdCount.setVerticalAlignment(SwingConstants.BOTTOM);
		stdCount.setFont(new Font("Segoe UI", Font.BOLD, 24));
		stdCount.setBounds(236, 486, 62, 30);
		adminHome.add(stdCount);

		feCount = new JLabel("");
		feCount.setForeground(Color.RED);
		feCount.setText(udp.fecount);
		feCount.setFont(new Font("Segoe UI", Font.BOLD, 24));
		feCount.setHorizontalAlignment(SwingConstants.CENTER);
		feCount.setBounds(103, 545, 62, 30);
		adminHome.add(feCount);

		JLabel lblFirstYearCount = new JLabel("First Year ");
		lblFirstYearCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstYearCount.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFirstYearCount.setBounds(41, 588, 182, 30);
		adminHome.add(lblFirstYearCount);

		JLabel lblSecondYearCount = new JLabel("Second Year");
		lblSecondYearCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondYearCount.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSecondYearCount.setBounds(296, 588, 182, 30);
		adminHome.add(lblSecondYearCount);

		seCount = new JLabel("");
		seCount.setForeground(Color.RED);
		seCount.setText(udp.secount);
		seCount.setFont(new Font("Segoe UI", Font.BOLD, 24));
		seCount.setHorizontalAlignment(SwingConstants.CENTER);
		seCount.setBounds(365, 545, 62, 30);
		adminHome.add(seCount);

		JLabel lblThirdYearCount = new JLabel("Third Year");
		lblThirdYearCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdYearCount.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblThirdYearCount.setBounds(41, 666, 182, 40);
		adminHome.add(lblThirdYearCount);

		TeCount = new JLabel("");
		TeCount.setForeground(Color.RED);
		TeCount.setText(udp.tecount);
		TeCount.setFont(new Font("Segoe UI", Font.BOLD, 24));
		TeCount.setHorizontalAlignment(SwingConstants.CENTER);
		TeCount.setBounds(103, 631, 62, 30);
		adminHome.add(TeCount);

		JLabel lblFourthYearCount = new JLabel("Fourth Year");
		lblFourthYearCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblFourthYearCount.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFourthYearCount.setBounds(296, 671, 182, 30);
		adminHome.add(lblFourthYearCount);

		BECount = new JLabel("");
		BECount.setForeground(Color.RED);
		BECount.setText(udp.becount);
		BECount.setFont(new Font("Segoe UI", Font.BOLD, 24));
		BECount.setHorizontalAlignment(SwingConstants.CENTER);
		BECount.setBounds(365, 635, 62, 30);
		adminHome.add(BECount);

		JLabel lblTotalFeedback = new JLabel("All Feedback");
		lblTotalFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalFeedback.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTotalFeedback.setBounds(712, 519, 182, 30);
		adminHome.add(lblTotalFeedback);

		feedCount = new JLabel("8");
		feedCount.setForeground(Color.RED);
		feedCount.setText(udp.feedCount);
		feedCount.setVerticalAlignment(SwingConstants.BOTTOM);
		feedCount.setHorizontalAlignment(SwingConstants.CENTER);
		feedCount.setFont(new Font("Segoe UI", Font.BOLD, 24));
		feedCount.setBounds(776, 486, 62, 30);
		adminHome.add(feedCount);

		JLabel lblFeedbackRead = new JLabel("Read");
		lblFeedbackRead.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbackRead.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFeedbackRead.setBounds(612, 588, 182, 30);
		adminHome.add(lblFeedbackRead);

		feedRead = new JLabel("1");
		feedRead.setForeground(Color.RED);
		feedRead.setText(udp.feedread);
		feedRead.setHorizontalAlignment(SwingConstants.CENTER);
		feedRead.setFont(new Font("Segoe UI", Font.BOLD, 24));
		feedRead.setBounds(673, 549, 62, 30);
		adminHome.add(feedRead);

		JLabel lblFeedbackPending = new JLabel("Pending");
		lblFeedbackPending.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbackPending.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFeedbackPending.setBounds(817, 588, 182, 30);
		adminHome.add(lblFeedbackPending);

		feedPending = new JLabel("1");
		feedPending.setForeground(Color.RED);
		feedPending.setText(udp.feedpending);
		feedPending.setHorizontalAlignment(SwingConstants.CENTER);
		feedPending.setFont(new Font("Segoe UI", Font.BOLD, 24));
		feedPending.setBounds(880, 549, 62, 30);
		adminHome.add(feedPending);

		JLabel lblNewLabel_1 = new JLabel("Student Data");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblNewLabel_1.setBounds(175, 443, 184, 30);
		adminHome.add(lblNewLabel_1);

		JLabel lblFeedbackData = new JLabel("FeedBack Data");
		lblFeedbackData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbackData.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblFeedbackData.setBounds(702, 443, 184, 30);
		adminHome.add(lblFeedbackData);

		JLabel lblAdminHave = new JLabel("* Admin have all privilage");
		lblAdminHave.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAdminHave.setBounds(175, 212, 424, 30);
		adminHome.add(lblAdminHave);

		JLabel lblAdminCan = new JLabel("* Admin can access all the data");
		lblAdminCan.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAdminCan.setBounds(175, 247, 424, 30);
		adminHome.add(lblAdminCan);

		JLabel lblAdminCheck = new JLabel("* Admin check and update all information");
		lblAdminCheck.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAdminCheck.setBounds(175, 282, 424, 30);
		adminHome.add(lblAdminCheck);

		JLabel lblAboveScreen = new JLabel("* Above Screen Admin can check all record");
		lblAboveScreen.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAboveScreen.setBounds(175, 314, 424, 30);
		adminHome.add(lblAboveScreen);

		JPanel Manage_Student = new JPanel();
		tabbedPane.addTab("New tab", null, Manage_Student, null);
		Manage_Student.setLayout(null);
		Manage_Student.setBackground(new Color(153, 255, 204));

		JLabel textSearch = new JLabel("");
		textSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = txtSearch.getText();

				manageStudentTableConfig();

				Connect co = new Connect();
				co.cLogin();
				try {
					Statement st = co.conn.createStatement();
					String Query = "select * from student_registration where std_prn='" + text + "' or std_mailid='"
							+ text + "'";

					co.rs = st.executeQuery(Query);

					while (co.rs.next()) {
						mname = co.rs.getString("std_name");
						memail = co.rs.getString("std_mailid");
						mprn = co.rs.getString("std_prn");
						mdob = co.rs.getString("std_dob");
						musername = co.rs.getString("std_username");
						macadi = co.rs.getString("std_year");
						mcourse = co.rs.getString("std_course");
						mbatch = co.rs.getString("std_batchYear");
						madress = co.rs.getString("std_address");
						mrdate = co.rs.getString("date");
						mrtime = co.rs.getString("time");

						String todata[] = { mname, memail, mprn, mdob, musername, macadi, mcourse, madress, mbatch,
								mrdate, mrtime };
						DefaultTableModel df = (DefaultTableModel) table.getModel();
						df.addRow(todata);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		textSearch.setHorizontalAlignment(SwingConstants.RIGHT);

		textSearch.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/search_30px.png")));
		textSearch.setBounds(1035, 51, 30, 30);
		Manage_Student.add(textSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBackground(new Color(153, 255, 204));
		scrollPane.setBounds(12, 143, 1065, 569);
		Manage_Student.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(153, 255, 204));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowMargin(2);
		table.setRowHeight(30);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		manageStudentTableConfig();

		JLabel lblSearchBy = new JLabel("Sort By");
		lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBy.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSearchBy.setBounds(12, 54, 80, 27);
		Manage_Student.add(lblSearchBy);

		String branch[] = { " ", "First Year", "Second Year", "Third Year", "Fourth Year" };

		JComboBox yearSerch = new JComboBox(branch);
		yearSerch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		yearSerch.setBackground(new Color(153, 255, 204));
		yearSerch.setBounds(93, 52, 172, 30);
		Manage_Student.add(yearSerch);

		String course[] = { " ", "Computer Engineering", "Mechanical Engineering", "Electrical Engineering",
				"IT Engineering", "Chemical Engineering" };

		JComboBox courseSearch = new JComboBox(course);
		courseSearch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		courseSearch.setBackground(new Color(153, 255, 204));
		courseSearch.setBounds(277, 51, 210, 30);
		Manage_Student.add(courseSearch);

		txtSearch = new JTextField();
		txtSearch.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				String text = txtSearch.getText();

				manageStudentTableConfig();

				Connect co = new Connect();
				co.cLogin();
				try {
					Statement st = co.conn.createStatement();
					String Query = "select * from student_registration where std_prn='" + text + "' or std_mailid='"
							+ text + "'";

					co.rs = st.executeQuery(Query);

					while (co.rs.next()) {
						mname = co.rs.getString("std_name");
						memail = co.rs.getString("std_mailid");
						mprn = co.rs.getString("std_prn");
						mdob = co.rs.getString("std_dob");
						musername = co.rs.getString("std_username");
						macadi = co.rs.getString("std_year");
						mcourse = co.rs.getString("std_course");
						mbatch = co.rs.getString("std_batchYear");
						madress = co.rs.getString("std_address");
						mrdate = co.rs.getString("date");
						mrtime = co.rs.getString("time");

						String todata[] = { mname, memail, mprn, mdob, musername, macadi, mcourse, madress, mbatch,
								mrdate, mrtime };
						DefaultTableModel df = (DefaultTableModel) table.getModel();
						df.addRow(todata);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		txtSearch.setBackground(new Color(153, 255, 204));
		txtSearch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtSearch.setColumns(10);
		txtSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtSearch.setBounds(823, 51, 210, 30);
		Manage_Student.add(txtSearch);

		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String course, year;
				course = (String) courseSearch.getSelectedItem();
				year = (String) yearSerch.getSelectedItem();
				manageStudentTableConfig();
				Connect co = new Connect();
				co.cLogin();
				try {
					Statement st = co.conn.createStatement();
					String Query = "select * from student_registration where std_year='" + year + "' and std_course='"
							+ course + "'";

					co.rs = st.executeQuery(Query);

					while (co.rs.next()) {
						mname = co.rs.getString("std_name");
						memail = co.rs.getString("std_mailid");
						mprn = co.rs.getString("std_prn");
						mdob = co.rs.getString("std_dob");
						musername = co.rs.getString("std_username");
						macadi = co.rs.getString("std_year");
						mcourse = co.rs.getString("std_course");
						mbatch = co.rs.getString("std_batchYear");
						madress = co.rs.getString("std_address");
						mrdate = co.rs.getString("date");
						mrtime = co.rs.getString("time");

						String todata[] = { mname, memail, mprn, mdob, musername, macadi, mcourse, madress, mbatch,
								mrdate, mrtime };
						DefaultTableModel df = (DefaultTableModel) table.getModel();
						df.addRow(todata);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		label_4.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/done_30px.png")));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(494, 50, 30, 30);
		Manage_Student.add(label_4);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(572, 51, 30, 30);
		Manage_Student.add(separator);

		JLabel lblSearchByPrn = new JLabel("Search by PRN or Mail id");
		lblSearchByPrn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSearchByPrn.setBounds(630, 54, 179, 27);
		Manage_Student.add(lblSearchByPrn);

		JPanel addStudent = new JPanel();
		addStudent.setBackground(new Color(0, 153, 153));
		tabbedPane.addTab("New tab", null, addStudent, null);
		addStudent.setLayout(null);

		JLabel lblAddingNewUser = new JLabel("Add Student");
		lblAddingNewUser.setForeground(Color.WHITE);
		lblAddingNewUser.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblAddingNewUser.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblAddingNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingNewUser.setBounds(445, 50, 213, 34);
		addStudent.add(lblAddingNewUser);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 153, 153));
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_8.setBounds(44, 351, 484, 326);
		addStudent.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmailId.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEmailId.setBounds(59, 173, 80, 35);
		panel_8.add(lblEmailId);

		adminEmail = new JTextField("");
		adminEmail.setBackground(new Color(0, 153, 153));
		adminEmail.setForeground(Color.WHITE);
		adminEmail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		adminEmail.setColumns(10);
		adminEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		adminEmail.setBounds(154, 173, 253, 35);
		panel_8.add(adminEmail);

		JLabel adminAddStud = new JLabel("");
		adminAddStud.setHorizontalAlignment(SwingConstants.CENTER);
		adminAddStud.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/add_button1.PNG")));
		adminAddStud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connect co = new Connect();
				co.cLogin();
				String query = "insert into email_verify values(?)";
				try {
					PreparedStatement ps = co.conn.prepareStatement(query);
					ps.setString(1, adminEmail.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Student Added Successfully");
					adminEmail.setText("");
					Thread.sleep(10);

				} catch (SQLException | InterruptedException e1) {

					e1.printStackTrace();
				}

			}
		});
		adminAddStud.setFont(new Font("Segoe UI", Font.BOLD, 16));
		adminAddStud.setBounds(302, 221, 100, 35);
		panel_8.add(adminAddStud);

		JLabel lblSingleStudent = new JLabel("Add Single Student");
		lblSingleStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingleStudent.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblSingleStudent.setForeground(Color.WHITE);
		lblSingleStudent.setBounds(165, 25, 182, 35);
		panel_8.add(lblSingleStudent);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(new Color(0, 153, 153));
		panel_1.setBounds(559, 351, 484, 326);
		addStudent.add(panel_1);

		gettingPath = new JTextField();
		gettingPath.setEditable(false);
		gettingPath.setForeground(Color.WHITE);
		gettingPath.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(199, 21, 133)));
		gettingPath.setFont(new Font("Segoe UI", Font.BOLD, 14));
		gettingPath.setBackground(new Color(0, 153, 153));
		gettingPath.setBounds(111, 173, 253, 35);
		panel_1.add(gettingPath);
		gettingPath.setColumns(10);

		JLabel label_18 = new JLabel("");
		label_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser jf = new JFileChooser();
				jf.showSaveDialog(null);
				path = jf.getSelectedFile().getAbsolutePath();
				gettingPath.setText(path);
			}
		});
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/browse_button.PNG")));
		label_18.setBounds(372, 183, 70, 25);
		panel_1.add(label_18);

		JLabel lblAddBulk = new JLabel("");
		lblAddBulk.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/add_button1.PNG")));
		lblAddBulk.setBounds(342, 221, 100, 35);
		panel_1.add(lblAddBulk);
		lblAddBulk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connect co = new Connect();
				co.cLogin();
				try {
					Statement st = co.conn.createStatement();
					String query = "insert into email_verify(std_mailid) values(?)";
					int batchsize = 20;

					PreparedStatement statment = co.conn.prepareStatement(query);
					BufferedReader lineread = new BufferedReader(new FileReader(path));
					String linetxt = null;
					int count = 0;
					lineread.readLine();
					while ((linetxt = lineread.readLine()) != null) {
						String data[] = linetxt.split(",");
						String std_mail = data[0];
						statment.setString(1, std_mail);
						statment.addBatch();
						if (count % batchsize == 0) {
							statment.executeBatch();
						}
					}
					lineread.close();
					statment.executeBatch();
					JOptionPane.showMessageDialog(null, "Student Batch Added Successfully");
					gettingPath.setText("");

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		lblAddBulk.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBulk.setFont(new Font("Segoe UI", Font.BOLD, 16));

		JLabel lblCsvFile_1 = new JLabel("CSV File");
		lblCsvFile_1.setForeground(Color.WHITE);
		lblCsvFile_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCsvFile_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCsvFile_1.setBounds(29, 173, 80, 35);
		panel_1.add(lblCsvFile_1);

		JLabel lblAddMultipleStudent = new JLabel("Add Multiple Student");
		lblAddMultipleStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMultipleStudent.setForeground(Color.WHITE);
		lblAddMultipleStudent.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAddMultipleStudent.setBounds(136, 23, 211, 35);
		panel_1.add(lblAddMultipleStudent);

		JLabel lblOnlyAuthorized = new JLabel("* Only authorized student can enroll in our System.\r\n\r\n");
		lblOnlyAuthorized.setForeground(Color.WHITE);
		lblOnlyAuthorized.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblOnlyAuthorized.setBounds(71, 106, 929, 34);
		addStudent.add(lblOnlyAuthorized);

		JLabel lblInThis = new JLabel("* In this section we have two type of adding student method\r\n\r\n");
		lblInThis.setForeground(Color.WHITE);
		lblInThis.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblInThis.setBounds(71, 141, 929, 34);
		addStudent.add(lblInThis);

		JLabel lblndIs = new JLabel("* 2nd is to add the bulk or multiple student at a time \r\n\r\n\r\n");
		lblndIs.setForeground(Color.WHITE);
		lblndIs.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblndIs.setBounds(71, 211, 929, 34);
		addStudent.add(lblndIs);

		JLabel lblstIs = new JLabel(
				"* 1st is to add single student at a time, In case of any student have to be enrolled in between the curriculam\r\n\r\n");
		lblstIs.setForeground(Color.WHITE);
		lblstIs.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblstIs.setBounds(71, 176, 929, 34);
		addStudent.add(lblstIs);

		JLabel lblForMultiplebulk = new JLabel(
				"* For multiple/Bulk adding the student You have to import the CSV file for that\r\n\r\n\r\n");
		lblForMultiplebulk.setForeground(Color.WHITE);
		lblForMultiplebulk.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblForMultiplebulk.setBounds(71, 245, 929, 34);
		addStudent.add(lblForMultiplebulk);

		JLabel lblCsvFile = new JLabel("* CSV file contains only one column like \"email_id\"\r\n\r\n\r\n");
		lblCsvFile.setForeground(Color.WHITE);
		lblCsvFile.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCsvFile.setBounds(71, 280, 929, 34);
		addStudent.add(lblCsvFile);

		JPanel Update_student = new JPanel();
		Update_student.setBackground(new Color(204, 255, 204));
		tabbedPane.addTab("New tab", null, Update_student, null);
		Update_student.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(204, 255, 204));
		scrollPane_1.setBounds(35, 119, 1029, 74);
		Update_student.add(scrollPane_1);

		updatetable = new JTable();
		updatetable.setBackground(new Color(204, 255, 204));
		updatetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) updatetable.getModel();
				int selectrowindex = updatetable.getSelectedRow();

				uname.setText((String) model.getValueAt(selectrowindex, 0));
				uemail.setText((String) model.getValueAt(selectrowindex, 1));
				uprn.setText((String) model.getValueAt(selectrowindex, 2));
				udob.setText((String) model.getValueAt(selectrowindex, 3));
				uusername.setText((String) model.getValueAt(selectrowindex, 4));
				uayear.setText((String) model.getValueAt(selectrowindex, 5));
				ucourse.setText((String) model.getValueAt(selectrowindex, 6));
				ubatch.setText((String) model.getValueAt(selectrowindex, 8));
				uaddress.setText((String) model.getValueAt(selectrowindex, 7));
				/*
				 * udate.setText((String) model.getValueAt(selectrowindex, 8));
				 * utime.setText((String) model.getValueAt(selectrowindex, 9));
				 */
			}
		});
		updatetable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		updatetable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		updatetable.setRowMargin(2);
		updatetable.setRowHeight(30);
		scrollPane_1.setViewportView(updatetable);
		updateStudentDataTableConfig();

		updatesearch = new JTextField();
		updatesearch.setBackground(new Color(204, 255, 204));
		updatesearch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		updatesearch.setColumns(10);
		updatesearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		updatesearch.setBounds(823, 56, 210, 30);
		Update_student.add(updatesearch);

		JLabel label_2 = new JLabel("Search by PRN or Mail id");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_2.setBounds(630, 59, 179, 27);
		Update_student.add(label_2);

		JLabel label_5 = new JLabel("");

		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String text = updatesearch.getText();

				updateStudentDataTableConfig();

				Connect co = new Connect();
				co.cLogin();
				try {
					Statement st = co.conn.createStatement();
					String Query = "select * from student_registration where std_prn='" + text + "' or std_mailid='"
							+ text + "'";

					co.rs = st.executeQuery(Query);

					while (co.rs.next()) {
						mname = co.rs.getString("std_name");
						memail = co.rs.getString("std_mailid");
						mprn = co.rs.getString("std_prn");
						mdob = co.rs.getString("std_dob");
						musername = co.rs.getString("std_username");
						macadi = co.rs.getString("std_year");
						mcourse = co.rs.getString("std_course");
						mbatch = co.rs.getString("std_batchYear");
						mrdate = co.rs.getString("date");
						mrtime = co.rs.getString("time");
						madress = co.rs.getString("std_address");

						String todata[] = { mname, memail, mprn, mdob, musername, macadi, mcourse, madress, mbatch,
								mrdate, mrtime };
						DefaultTableModel df = (DefaultTableModel) updatetable.getModel();
						df.addRow(todata);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/search_30px.png")));
		label_5.setBounds(1034, 56, 30, 30);
		Update_student.add(label_5);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(209, 243, 86, 30);
		Update_student.add(lblName);

		uname = new JTextField();
		uname.setBackground(new Color(204, 255, 204));
		uname.setEditable(false);
		uname.setFont(new Font("Segoe UI", Font.BOLD, 16));
		uname.setColumns(10);
		uname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		uname.setBounds(210, 276, 210, 30);
		Update_student.add(uname);

		uemail = new JTextField();
		uemail.setBackground(new Color(204, 255, 204));
		uemail.setEditable(false);
		uemail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		uemail.setColumns(10);
		uemail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		uemail.setBounds(210, 350, 210, 30);
		Update_student.add(uemail);

		JLabel lblEmailId_1 = new JLabel("Email Id");
		lblEmailId_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailId_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmailId_1.setBounds(209, 317, 86, 30);
		Update_student.add(lblEmailId_1);

		udob = new JTextField();
		udob.setBackground(new Color(204, 255, 204));
		udob.setEditable(false);
		udob.setFont(new Font("Segoe UI", Font.BOLD, 16));
		udob.setColumns(10);
		udob.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		udob.setBounds(210, 500, 210, 30);
		Update_student.add(udob);

		JLabel lblDob = new JLabel("DOB");
		lblDob.setHorizontalAlignment(SwingConstants.LEFT);
		lblDob.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDob.setBounds(209, 467, 86, 30);
		Update_student.add(lblDob);

		JLabel lblPrn = new JLabel("PRN");
		lblPrn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPrn.setBounds(209, 393, 86, 30);
		Update_student.add(lblPrn);

		uprn = new JTextField();
		uprn.setBackground(new Color(204, 255, 204));
		uprn.setEditable(false);
		uprn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		uprn.setColumns(10);
		uprn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		uprn.setBounds(210, 426, 210, 30);
		Update_student.add(uprn);

		uusername = new JTextField();
		uusername.setBackground(new Color(204, 255, 204));
		uusername.setEditable(false);
		uusername.setFont(new Font("Segoe UI", Font.BOLD, 16));
		uusername.setColumns(10);
		uusername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		uusername.setBounds(535, 276, 210, 30);
		Update_student.add(uusername);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUsername.setBounds(534, 243, 86, 30);
		Update_student.add(lblUsername);

		JLabel lblAcademicYear = new JLabel("Academic Year");
		lblAcademicYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcademicYear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAcademicYear.setBounds(534, 317, 121, 30);
		Update_student.add(lblAcademicYear);

		uayear = new JTextField();
		uayear.setBackground(new Color(204, 255, 204));
		uayear.setEditable(false);
		uayear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		uayear.setColumns(10);
		uayear.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		uayear.setBounds(535, 350, 210, 30);
		Update_student.add(uayear);

		JLabel Course = new JLabel("Course");
		Course.setHorizontalAlignment(SwingConstants.LEFT);
		Course.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Course.setBounds(534, 393, 86, 30);
		Update_student.add(Course);

		ucourse = new JTextField();
		ucourse.setBackground(new Color(204, 255, 204));
		ucourse.setEditable(false);
		ucourse.setFont(new Font("Segoe UI", Font.BOLD, 16));
		ucourse.setColumns(10);
		ucourse.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ucourse.setBounds(535, 426, 210, 30);
		Update_student.add(ucourse);

		JLabel lblBatchYear = new JLabel("Batch Year");
		lblBatchYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblBatchYear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblBatchYear.setBounds(534, 467, 86, 30);
		Update_student.add(lblBatchYear);

		ubatch = new JTextField();
		ubatch.setBackground(new Color(204, 255, 204));
		ubatch.setEditable(false);
		ubatch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		ubatch.setColumns(10);
		ubatch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ubatch.setBounds(535, 500, 210, 30);
		Update_student.add(ubatch);

		JLabel lblUpdate = new JLabel("");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/update_button.PNG")));
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Connect co = new Connect();
				co.cLogin();

				try {

					String query = "UPDATE student_registration SET std_name='" + uname.getText() + "',std_mailid='"
							+ uemail.getText() + "',std_dob='" + udob.getText() + "',std_prn='" + uprn.getText()
							+ "',std_username='" + uusername.getText() + "',std_year='" + uayear.getText()
							+ "',std_course='" + ucourse.getText() + "',std_batchYear='" + ubatch.getText()
							+ "',std_address='" + uaddress.getText() + "' WHERE std_prn='" + uprn.getText() + "'";
					Statement st = null;
					st = co.conn.createStatement();
					// co.rs=st.executeQuery(query);
					st.executeUpdate(query);

					JOptionPane.showMessageDialog(null, "Student update successfully...!");
					// Data updated to the table
					String text = updatesearch.getText();

					updateStudentDataTableConfig();

					Connect co1 = new Connect();
					co1.cLogin();
					try {
						Statement s1 = co.conn.createStatement();
						String Query1 = "select * from student_registration where std_prn='" + text
								+ "' or std_mailid='" + text + "'";

						co1.rs = st.executeQuery(Query1);

						while (co1.rs.next()) {
							mname = co1.rs.getString("std_name");
							memail = co1.rs.getString("std_mailid");
							mprn = co1.rs.getString("std_prn");
							mdob = co1.rs.getString("std_dob");
							musername = co1.rs.getString("std_username");
							macadi = co1.rs.getString("std_year");
							mcourse = co1.rs.getString("std_course");
							mbatch = co1.rs.getString("std_batchYear");
							mrdate = co1.rs.getString("date");
							mrtime = co1.rs.getString("time");
							madress = co1.rs.getString("std_address");

							String todata[] = { mname, memail, mprn, mdob, musername, macadi, mcourse, madress, mbatch,
									mrdate, mrtime };
							DefaultTableModel df = (DefaultTableModel) updatetable.getModel();
							df.addRow(todata);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		lblUpdate.setBounds(382, 590, 100, 35);
		Update_student.add(lblUpdate);

		JLabel lblDelete = new JLabel("");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/delete_button.PNG")));
		lblDelete.setBounds(520, 590, 100, 35);
		Update_student.add(lblDelete);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAddress.setBounds(803, 243, 86, 30);
		Update_student.add(lblAddress);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(803, 281, 234, 99);
		Update_student.add(scrollPane_2);

		uaddress = new JTextArea();
		uaddress.setBackground(new Color(204, 255, 204));
		uaddress.setEditable(false);
		uaddress.setFont(new Font("Segoe UI", Font.BOLD, 16));
		scrollPane_2.setViewportView(uaddress);

		JCheckBox unameCheck = new JCheckBox("");
		unameCheck.setBackground(new Color(204, 255, 204));
		unameCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (unameCheck.isSelected()) {
					uname.setEditable(true);
				} else {
					uname.setEditable(false);
				}
			}
		});
		unameCheck.setBounds(422, 280, 25, 25);
		Update_student.add(unameCheck);

		JCheckBox uemailCheck = new JCheckBox("");
		uemailCheck.setBackground(new Color(204, 255, 204));
		uemailCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (uemailCheck.isSelected()) {
					uemail.setEditable(true);
				} else {
					uemail.setEditable(false);
				}
			}
		});
		uemailCheck.setBounds(422, 354, 25, 25);
		Update_student.add(uemailCheck);

		JCheckBox uprnCheck = new JCheckBox("");
		uprnCheck.setBackground(new Color(204, 255, 204));
		uprnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (uprnCheck.isSelected()) {
					uprn.setEditable(true);
				} else {
					uprn.setEditable(false);
				}
			}
		});
		uprnCheck.setBounds(422, 430, 25, 25);
		Update_student.add(uprnCheck);

		JCheckBox udobCheck = new JCheckBox("");
		udobCheck.setBackground(new Color(204, 255, 204));
		udobCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (udobCheck.isSelected()) {
					udob.setEditable(true);
				} else {
					udob.setEditable(false);
				}
			}
		});
		udobCheck.setBounds(422, 504, 25, 25);
		Update_student.add(udobCheck);

		JCheckBox ubatchCheck = new JCheckBox("");
		ubatchCheck.setBackground(new Color(204, 255, 204));
		ubatchCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ubatchCheck.isSelected()) {
					ubatch.setEditable(true);
				} else {
					ubatch.setEditable(false);
				}
			}
		});
		ubatchCheck.setBounds(745, 505, 25, 25);
		Update_student.add(ubatchCheck);

		JCheckBox ucourseCheck = new JCheckBox("");
		ucourseCheck.setBackground(new Color(204, 255, 204));
		ucourseCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ucourseCheck.isSelected()) {
					ucourse.setEditable(true);
				} else {
					ucourse.setEditable(false);
				}
			}
		});
		ucourseCheck.setBounds(745, 431, 25, 25);
		Update_student.add(ucourseCheck);

		JCheckBox uayCheck = new JCheckBox("");
		uayCheck.setBackground(new Color(204, 255, 204));
		uayCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (uayCheck.isSelected()) {
					uayear.setEditable(true);
				} else {
					uayear.setEditable(false);
				}
			}
		});
		uayCheck.setBounds(745, 355, 25, 25);
		Update_student.add(uayCheck);

		JCheckBox uusernameCheck = new JCheckBox("");
		uusernameCheck.setBackground(new Color(204, 255, 204));
		uusernameCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (uusernameCheck.isSelected()) {
					uusername.setEditable(true);
				} else {
					uusername.setEditable(false);
				}
			}
		});
		uusernameCheck.setBounds(745, 281, 25, 25);
		Update_student.add(uusernameCheck);

		JCheckBox uaddressCheck = new JCheckBox("");
		uaddressCheck.setBackground(new Color(204, 255, 204));
		uaddressCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (uaddressCheck.isSelected()) {
					uaddress.setEditable(true);
				} else {
					uaddress.setEditable(false);
				}
			}
		});
		uaddressCheck.setBounds(1039, 354, 25, 25);
		Update_student.add(uaddressCheck);

		JPanel Update_News = new JPanel();
		Update_News.setBackground(new Color(204, 204, 255));
		tabbedPane.addTab("New tab", null, Update_News, null);
		Update_News.setLayout(null);

		JLabel lblCurriculumNews = new JLabel("Curriculum News");
		lblCurriculumNews.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCurriculumNews.setBounds(402, 70, 500, 33);
		Update_News.add(lblCurriculumNews);

		JLabel lblEventNews = new JLabel("Event News");
		lblEventNews.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEventNews.setBounds(402, 295, 500, 33);
		Update_News.add(lblEventNews);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(403, 328, 499, 179);
		Update_News.add(scrollPane_4);

		JTextArea eventTxt = new JTextArea();
		eventTxt.setBackground(new Color(204, 204, 255));
		eventTxt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane_4.setViewportView(eventTxt);

		JLabel lblCurriculumNews_1 = new JLabel("Software Update News");
		lblCurriculumNews_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCurriculumNews_1.setBounds(402, 518, 500, 33);
		Update_News.add(lblCurriculumNews_1);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(403, 551, 499, 179);
		Update_News.add(scrollPane_5);

		JTextArea softwareTxt = new JTextArea();
		softwareTxt.setBackground(new Color(204, 204, 255));
		softwareTxt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane_5.setViewportView(softwareTxt);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(402, 103, 500, 179);
		Update_News.add(scrollPane_3);

		JTextArea curriculum_news = new JTextArea();
		curriculum_news.setBackground(new Color(204, 204, 255));
		curriculum_news.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane_3.setViewportView(curriculum_news);

		JLabel curriculumUpdate = new JLabel("");
		curriculumUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		curriculumUpdate.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/send_button.PNG")));
		curriculumUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				try {

					Statement st = co.conn.createStatement();
					String query = "UPDATE update_news SET curriculum_news='" + curriculum_news.getText()
							+ "' WHERE id= 1 ";
					Statement st1 = null;
					st1 = co.conn.createStatement();
					// co.rs=st.executeQuery(query);
					st1.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "News update successfully");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		curriculumUpdate.setBounds(914, 247, 100, 35);
		Update_News.add(curriculumUpdate);

		JLabel eventUpdate = new JLabel("");
		eventUpdate.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/send_button.PNG")));
		eventUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		eventUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				try {

					Statement st = co.conn.createStatement();
					String query = "UPDATE update_news SET event_news='" + eventTxt.getText() + "' WHERE id= 1 ";
					Statement st1 = null;
					st1 = co.conn.createStatement();
					// co.rs=st.executeQuery(query);
					st1.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "News update successfully");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		eventUpdate.setBounds(914, 465, 100, 35);
		Update_News.add(eventUpdate);

		JLabel sodtwareUpdate = new JLabel("");
		sodtwareUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		sodtwareUpdate.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/send_button.PNG")));
		sodtwareUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				try {

					Statement st = co.conn.createStatement();
					String query = "UPDATE update_news SET software_update='" + softwareTxt.getText()
							+ "' WHERE id= 1 ";
					Statement st1 = null;
					st1 = co.conn.createStatement();
					// co.rs=st.executeQuery(query);
					st1.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "News update successfully");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		sodtwareUpdate.setBounds(914, 695, 100, 35);
		Update_News.add(sodtwareUpdate);

		JLabel curriculumClr = new JLabel("Update");
		curriculumClr.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/clearall_reg.JPG")));
		curriculumClr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				curriculum_news.setText("");
			}
		});
		curriculumClr.setBounds(914, 199, 100, 35);
		Update_News.add(curriculumClr);

		JLabel eventClr = new JLabel("Update");
		eventClr.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/clearall_reg.JPG")));
		eventClr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eventTxt.setText("");
			}
		});
		eventClr.setBounds(914, 417, 100, 35);
		Update_News.add(eventClr);

		JLabel softwareClr = new JLabel("Update");
		softwareClr.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/clearall_reg.JPG")));
		softwareClr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				softwareTxt.setText("");
			}
		});
		softwareClr.setBounds(914, 647, 100, 35);
		Update_News.add(softwareClr);

		JTextPane txtpnCurriculamNews = new JTextPane();
		txtpnCurriculamNews.setEditable(false);
		txtpnCurriculamNews.setBackground(new Color(204, 204, 255));
		txtpnCurriculamNews.setText(
				"* Curriculam news is for sending news to the students about whats the latest thing is happining in the college.\r\n");
		txtpnCurriculamNews.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtpnCurriculamNews.setBounds(47, 103, 326, 86);
		Update_News.add(txtpnCurriculamNews);

		JTextPane txtpnEventNews = new JTextPane();
		txtpnEventNews.setEditable(false);
		txtpnEventNews.setBackground(new Color(204, 204, 255));
		txtpnEventNews.setText("* Event news is for sending news about new events, That happening in the college\r\n");
		txtpnEventNews.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtpnEventNews.setBounds(47, 328, 326, 86);
		Update_News.add(txtpnEventNews);

		JTextPane txtpnSoftwareUpdate = new JTextPane();
		txtpnSoftwareUpdate.setEditable(false);
		txtpnSoftwareUpdate.setBackground(new Color(204, 204, 255));
		txtpnSoftwareUpdate
				.setText("* Software update news. Any type of software news can be deliver from this section.\r\n\r\n");
		txtpnSoftwareUpdate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtpnSoftwareUpdate.setBounds(47, 551, 326, 86);
		Update_News.add(txtpnSoftwareUpdate);

		JPanel Student_Log = new JPanel();
		Student_Log.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, Student_Log, null);
		Student_Log.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(572, 65, 30, 30);
		Student_Log.add(separator_1);

		JLabel stdlogSort = new JLabel("");
		stdlogSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentLogTableConfig();

				Connect connect = new Connect();
				connect.cLogin();

				String getcomponent = (String) logsortBy.getSelectedItem();
				String str = "Select * from student_log where std_status='" + getcomponent + "'";
				try {
					Statement st = connect.conn.createStatement();
					connect.rs = st.executeQuery(str);
					while (connect.rs.next()) {
						slogId = connect.rs.getString("session_id");
						susername = connect.rs.getString("std_username");
						sstatus = connect.rs.getString("std_status");
						sdate = connect.rs.getString("date");
						slogintime = connect.rs.getString("login_time");
						slogouttime = connect.rs.getString("logout_time");
						sipaddress = connect.rs.getString("std_ipaddress");

						String todata[] = { slogId, susername, sipaddress, sstatus, sdate, slogintime, slogouttime };
						DefaultTableModel df = (DefaultTableModel) stdLog_table.getModel();
						df.addRow(todata);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (getcomponent.equals("All")) {
					studentLogTableConfig();

					String str1 = "Select * from student_log";
					try {
						Statement st = connect.conn.createStatement();
						connect.rs = st.executeQuery(str1);
						while (connect.rs.next()) {
							slogId = connect.rs.getString("session_id");
							susername = connect.rs.getString("std_username");
							sstatus = connect.rs.getString("std_status");
							sdate = connect.rs.getString("date");
							slogintime = connect.rs.getString("login_time");
							slogouttime = connect.rs.getString("logout_time");
							sipaddress = connect.rs.getString("std_ipaddress");

							String todata[] = { slogId, susername, sipaddress, sstatus, sdate, slogintime,
									slogouttime };
							DefaultTableModel df = (DefaultTableModel) stdLog_table.getModel();
							df.addRow(todata);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		stdlogSort.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/done_30px.png")));
		stdlogSort.setHorizontalAlignment(SwingConstants.RIGHT);
		stdlogSort.setBounds(257, 65, 30, 30);
		Student_Log.add(stdlogSort);

		JLabel label_7 = new JLabel("Sort By");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_7.setBounds(30, 68, 80, 27);
		Student_Log.add(label_7);

		logsortBy = new JComboBox(new Object[] { "All", "ACTIVE", "DEACTIVATE" });
		logsortBy.setFont(new Font("Segoe UI", Font.BOLD, 16));
		logsortBy.setBackground(Color.WHITE);
		logsortBy.setBounds(111, 66, 140, 30);
		Student_Log.add(logsortBy);

		JLabel lblSearchByUsername = new JLabel("Search by Username");
		lblSearchByUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearchByUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSearchByUsername.setBounds(630, 68, 179, 27);
		Student_Log.add(lblSearchByUsername);

		stdloguname = new JTextField();
		stdloguname.setFont(new Font("Segoe UI", Font.BOLD, 16));
		stdloguname.setColumns(10);
		stdloguname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		stdloguname.setBounds(823, 65, 210, 30);
		Student_Log.add(stdloguname);

		JLabel label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentLogTableConfig();

				Connect connect = new Connect();
				connect.cLogin();

				String str = "Select * from student_log where std_username='" + stdloguname.getText() + "'";
				try {
					Statement st = connect.conn.createStatement();
					connect.rs = st.executeQuery(str);
					while (connect.rs.next()) {
						slogId = connect.rs.getString("session_id");
						susername = connect.rs.getString("std_username");
						sstatus = connect.rs.getString("std_status");
						sdate = connect.rs.getString("date");
						slogintime = connect.rs.getString("login_time");
						slogouttime = connect.rs.getString("logout_time");
						sipaddress = connect.rs.getString("std_ipaddress");

						String todata[] = { slogId, susername, sipaddress, sstatus, sdate, slogintime, slogouttime };
						DefaultTableModel df = (DefaultTableModel) stdLog_table.getModel();
						df.addRow(todata);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		label_10.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/search_30px.png")));
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(1035, 65, 30, 30);
		Student_Log.add(label_10);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(30, 137, 1047, 604);
		Student_Log.add(scrollPane_6);

		stdLog_table = new JTable();
		stdLog_table.setRowMargin(2);
		stdLog_table.setRowHeight(30);
		scrollPane_6.setViewportView(stdLog_table);
		studentLogTableConfig();

		JPanel reward_pannel = new JPanel();
		reward_pannel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		reward_pannel.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, reward_pannel, null);
		reward_pannel.setLayout(null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(31, 72, 1046, 683);
		reward_pannel.add(tabbedPane_1);

		JPanel update_reward = new JPanel();
		update_reward.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane_1.addTab("Update Reward", null, update_reward, null);
		update_reward.setLayout(null);

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(51, 107, 908, 292);
		update_reward.add(scrollPane_8);

		update_reward_table = new JTable();
		/*
		 * update_reward_table.addMouseListener(new MouseAdapter() {
		 * 
		 * @Overridex public void mouseClicked(MouseEvent e) { DefaultTableModel
		 * model=(DefaultTableModel)update_reward_table.getModel(); int
		 * selectrowindex=update_reward_table.getSelectedRow();
		 * urId.setText((String) model.getValueAt(selectrowindex, 0));
		 * urName.setText((String) model.getValueAt(selectrowindex, 1));
		 * urPoints.setText((String) model.getValueAt(selectrowindex, 2));
		 * urDescription.setText((String) model.getValueAt(selectrowindex, 3));
		 * reImg=(JLabel) model.getValueAt(selectrowindex, 4); ImageIcon
		 * imageicon=(ImageIcon) reImg.getIcon(); Image
		 * imgfit=imageicon.getImage().getScaledInstance(urImg.getWidth(),
		 * urImg.getHeight(), Image.SCALE_SMOOTH); urImg.setIcon(imageicon);
		 * //urCategory.setSelectedItem((String)
		 * model.getValueAt(selectrowindex, 5)); urCategory1.setText((String)
		 * model.getValueAt(selectrowindex, 5));
		 * 
		 * } });
		 */
		update_reward_table.setFont(new Font("Segoe UI", Font.BOLD, 16));
		update_reward_table.setRowMargin(2);
		update_reward_table.setRowHeight(50);
		updateRewardTableConfig();
		scrollPane_8.setViewportView(update_reward_table);

		urName = new JTextField();
		urName.setBackground(SystemColor.inactiveCaptionBorder);
		urName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		urName.setColumns(10);
		urName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		urName.setBounds(191, 461, 210, 30);
		update_reward.add(urName);

		JLabel label_6 = new JLabel("Name:");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_6.setBounds(51, 460, 84, 30);
		update_reward.add(label_6);

		urPoints = new JTextField();
		urPoints.setBackground(SystemColor.inactiveCaptionBorder);
		urPoints.setFont(new Font("Segoe UI", Font.BOLD, 16));
		urPoints.setColumns(10);
		urPoints.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		urPoints.setBounds(191, 504, 210, 30);
		update_reward.add(urPoints);

		JLabel label_8 = new JLabel("Points:");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_8.setBounds(51, 504, 84, 30);
		update_reward.add(label_8);

		JLabel label_12 = new JLabel("Description:");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_12.setBounds(51, 544, 94, 30);
		update_reward.add(label_12);

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(192, 546, 206, 63);
		update_reward.add(scrollPane_9);

		urDescription = new JTextArea();
		urDescription.setBackground(SystemColor.inactiveCaptionBorder);
		scrollPane_9.setViewportView(urDescription);
		urDescription.setFont(new Font("Segoe UI", Font.BOLD, 16));

		urImg = new JLabel("");
		urImg.setHorizontalAlignment(SwingConstants.CENTER);
		urImg.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		urImg.setBounds(580, 432, 150, 99);
		update_reward.add(urImg);

		JLabel label_14 = new JLabel("Reward Image:");
		label_14.setHorizontalAlignment(SwingConstants.LEFT);
		label_14.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_14.setBounds(429, 432, 120, 30);
		update_reward.add(label_14);

		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/browse_button.PNG")));
		label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
						pathSelect = true;
						ImageIcon myimg = new ImageIcon(path);
						Image img = myimg.getImage();
						Image newImg = img.getScaledInstance(urImg.getWidth(), urImg.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon image = new ImageIcon(newImg);
						urImg.setIcon(image);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select Image file format", "Try again", 1);
				}
			}
		});
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_15.setBounds(742, 506, 70, 25);
		update_reward.add(label_15);

		urCategory = new JComboBox(new Object[] { "Learning", "Canteen", "Railway Pass" });
		urCategory.setFont(new Font("Segoe UI", Font.BOLD, 16));
		urCategory.setBackground(Color.WHITE);
		urCategory.setBounds(566, 544, 210, 30);
		update_reward.add(urCategory);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCategory.setBounds(426, 544, 75, 30);
		update_reward.add(lblCategory);

		JLabel lblUpdate_1 = new JLabel("");
		lblUpdate_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();

				if (pathSelect == true) {
					try {
						FileInputStream fis = new FileInputStream(path);

						// String query="UPDATE student_rewards SET
						// rd_id='"+urId.getText()+"',rd_name='"+urName.getText()+"',rd_points='"+urPoints.getText()+"',rd_description='"+urDescription.getText()+"',rd_img='"+fis+"',rd_category='"+urCategory.getSelectedItem()+"'
						// WHERE rd_id='"+urId.getText()+"'";
						String quer = "UPDATE student_rewards SET rd_id=? ,rd_name=?, rd_points=?, rd_description=?, rd_img=?, rd_category=? WHERE rd_id='"
								+ urId.getText() + "'";
						PreparedStatement pst1 = co.conn.prepareStatement(quer);
						pst1.setString(1, urId.getText());
						pst1.setString(2, urName.getText());
						pst1.setString(3, urPoints.getText());
						pst1.setString(4, urDescription.getText());
						pst1.setBinaryStream(5, fis);
						pst1.setString(6, urCategory.getSelectedItem().toString());
						pst1.executeUpdate();
						JOptionPane.showMessageDialog(null, "Reward Update Successfully...!");
						/*
						 * st = co.conn.createStatement();
						 * st.executeUpdate(quer);
						 */
						// #####################################Table update
						// #######################################
						MyQuery mq = new MyQuery();
						ArrayList<Product2> list = mq.BindTable();
						String[] columnName = { "ID", "Name", "Points", "Description", "Image", "Categorie" };
						Object[][] rows = new Object[list.size()][6];
						for (int i = 0; i < list.size(); i++) {
							rows[i][0] = list.get(i).getId();
							rows[i][1] = list.get(i).getName();
							rows[i][2] = list.get(i).getQunt();
							rows[i][3] = list.get(i).getPrice();

							if (list.get(i).getMyImage() != null) {
								ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
										.getScaledInstance(150, 120, Image.SCALE_SMOOTH));
								rows[i][4] = image;
							} else {
								rows[i][4] = null;
							}

							rows[i][5] = list.get(i).getCatId();

						}
						TheModel model = new TheModel(rows, columnName);
						update_reward_table.setModel(model);
						update_reward_table.setRowHeight(120);
						update_reward_table.getColumnModel().getColumn(4).setPreferredWidth(150);
						// ################################## END
						// ############################

					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					}
					// co.rs=st.executeQuery(query);
				} else {
					/// ################## get image first #######
					String qur = "select * from student_rewards where rd_id='" + urId.getText() + "'";
					PreparedStatement pst;
					try {
						pst = co.conn.prepareStatement(qur);
						ResultSet rs = pst.executeQuery();
						File thefile = new File("myImages.png");
						outpute = new FileOutputStream(thefile);
						if (rs.next()) {
							input = rs.getBinaryStream("rd_img");
							byte[] buffer = new byte[input.available()];
							while (input.read(buffer) > 0) {
								outpute.write(buffer);
							}
							path = thefile.getAbsolutePath();
						}
					} catch (SQLException | IOException e2) {
						JOptionPane.showMessageDialog(null, "Please enter the reward ID");
					}

					// ################## END ##################
					Statement st = null;
					try {

						FileInputStream fis = new FileInputStream(path);

						// String query="UPDATE student_rewards SET
						// rd_id='"+urId.getText()+"',rd_name='"+urName.getText()+"',rd_points='"+urPoints.getText()+"',rd_description='"+urDescription.getText()+"',rd_img='"+fis+"',rd_category='"+urCategory.getSelectedItem()+"'
						// WHERE rd_id='"+urId.getText()+"'";
						String quer = "UPDATE student_rewards SET rd_id=? ,rd_name=?, rd_points=?, rd_description=?, rd_img=?, rd_category=? WHERE rd_id='"
								+ urId.getText() + "'";
						PreparedStatement pst1 = co.conn.prepareStatement(quer);
						pst1.setString(1, urId.getText());
						pst1.setString(2, urName.getText());
						pst1.setString(3, urPoints.getText());
						pst1.setString(4, urDescription.getText());
						pst1.setBinaryStream(5, fis);
						pst1.setString(6, urCategory.getSelectedItem().toString());
						pst1.executeUpdate();
						JOptionPane.showMessageDialog(null, "Reward Update Successfully...!");
						/*
						 * st = co.conn.createStatement();
						 * st.executeUpdate(quer);
						 */
						// #####################################Table update
						// #######################################
						MyQuery mq = new MyQuery();
						ArrayList<Product2> list = mq.BindTable();
						String[] columnName = { "ID", "Name", "Points", "Description", "Image", "Categorie" };
						Object[][] rows = new Object[list.size()][6];
						for (int i = 0; i < list.size(); i++) {
							rows[i][0] = list.get(i).getId();
							rows[i][1] = list.get(i).getName();
							rows[i][2] = list.get(i).getQunt();
							rows[i][3] = list.get(i).getPrice();

							if (list.get(i).getMyImage() != null) {
								ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
										.getScaledInstance(150, 120, Image.SCALE_SMOOTH));
								rows[i][4] = image;
							} else {
								rows[i][4] = null;
							}

							rows[i][5] = list.get(i).getCatId();

						}
						TheModel model = new TheModel(rows, columnName);
						update_reward_table.setModel(model);
						update_reward_table.setRowHeight(120);
						update_reward_table.getColumnModel().getColumn(4).setPreferredWidth(150);
						// ################################## END
						// ############################

					} catch (SQLException | IOException e1) {
						JOptionPane.showMessageDialog(null, "Please enter the reward ID");
					}
					// co.rs=st.executeQuery(query);
				}

			}
		});
		lblUpdate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate_1.setBounds(859, 412, 100, 35);
		lblUpdate_1.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/update_button.PNG")));
		update_reward.add(lblUpdate_1);

		urId = new JTextField();
		urId.setBackground(SystemColor.inactiveCaptionBorder);
		urId.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				Connect co = new Connect();
				co.cLogin();
				String qur = "select * from student_rewards where rd_id='" + urId.getText() + "'";
				InputStream input;

				try {
					PreparedStatement pst = co.conn.prepareStatement(qur);
					ResultSet rs = pst.executeQuery();
					File thefile = new File("myImages.png");
					outpute = new FileOutputStream(thefile);
					if (rs.next()) {

						String id = rs.getString("rd_id");
						String name = rs.getString("rd_name");
						String points = rs.getString("rd_points");
						String description = rs.getString("rd_description");
						String category = rs.getString("rd_category");
						input = rs.getBinaryStream("rd_img");
						byte[] buffer = new byte[input.available()];
						while (input.read(buffer) > 0) {
							outpute.write(buffer);
						}
						path = thefile.getAbsolutePath();
						ImageIcon myimg = new ImageIcon(path);
						Image img = myimg.getImage();
						Image newImg = img.getScaledInstance(urImg.getWidth(), urImg.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon image = new ImageIcon(newImg);
						urImg.setIcon(image);
						urName.setText(name);
						urDescription.setText(description);
						urPoints.setText(points);

					}
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		urId.setFont(new Font("Segoe UI", Font.BOLD, 16));
		urId.setColumns(10);
		urId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		urId.setBounds(191, 418, 112, 30);
		update_reward.add(urId);

		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyQueryCat mq = new MyQueryCat();
				String itemCat = (String) rewardCat.getSelectedItem();
				ArrayList<Product2> list = mq.BindTable(itemCat);
				String[] columnName = { "ID", "Name", "Points", "Description", "Image", "Categorie" };
				Object[][] rows = new Object[list.size()][6];
				for (int i = 0; i < list.size(); i++) {
					rows[i][0] = list.get(i).getId();
					rows[i][1] = list.get(i).getName();
					rows[i][2] = list.get(i).getQunt();
					rows[i][3] = list.get(i).getPrice();

					if (list.get(i).getMyImage() != null) {
						ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
								.getScaledInstance(150, 120, Image.SCALE_SMOOTH));
						rows[i][4] = image;
					} else {
						rows[i][4] = null;
					}

					rows[i][5] = list.get(i).getCatId();

				}
				TheModel model = new TheModel(rows, columnName);
				update_reward_table.setModel(model);
				update_reward_table.setRowHeight(120);
				update_reward_table.getColumnModel().getColumn(4).setPreferredWidth(150);
			}
		});
		label_9.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/done_30px.png")));
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(273, 53, 30, 30);
		update_reward.add(label_9);

		rewardCat = new JComboBox(new Object[] { "Learning", "Canteen", "Railway Pass" });
		rewardCat.setFont(new Font("Segoe UI", Font.BOLD, 16));
		rewardCat.setBackground(Color.WHITE);
		rewardCat.setBounds(51, 53, 210, 30);
		update_reward.add(rewardCat);

		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblId.setBounds(51, 417, 84, 30);
		update_reward.add(lblId);

		JLabel label_17 = new JLabel("");
		label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int reply = JOptionPane.showConfirmDialog(null, "Confierm to delete Reward?", "",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					co.cLogin();
					String query = "Delete from student_rewards where rd_id='" + urId.getText() + "'";
					try {
						Statement st = co.conn.createStatement();
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Reward Delete Successfully.../");

						urId.setText("");
						urName.setText("");
						urDescription.setText("");
						urImg.setIcon(null);
						urPoints.setText("");

						// #####################################Table update
						// #######################################
						MyQuery mq = new MyQuery();
						ArrayList<Product2> list = mq.BindTable();
						String[] columnName = { "ID", "Name", "Points", "Description", "Image", "Categorie" };
						Object[][] rows = new Object[list.size()][6];
						for (int i = 0; i < list.size(); i++) {
							rows[i][0] = list.get(i).getId();
							rows[i][1] = list.get(i).getName();
							rows[i][2] = list.get(i).getQunt();
							rows[i][3] = list.get(i).getPrice();

							if (list.get(i).getMyImage() != null) {
								ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
										.getScaledInstance(150, 120, Image.SCALE_SMOOTH));
								rows[i][4] = image;
							} else {
								rows[i][4] = null;
							}

							rows[i][5] = list.get(i).getCatId();

						}
						TheModel model = new TheModel(rows, columnName);
						update_reward_table.setModel(model);
						update_reward_table.setRowHeight(120);
						update_reward_table.getColumnModel().getColumn(4).setPreferredWidth(150);
						// ################################## END
						// ############################
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				} else {

				}

			}
		});
		label_17.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/delete_button.PNG")));
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(859, 456, 100, 35);
		update_reward.add(label_17);

		JPanel add_reward = new JPanel();
		add_reward.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane_1.addTab("Add Reward", null, add_reward, null);
		add_reward.setLayout(null);

		reward_name = new JTextField();
		reward_name.setBackground(SystemColor.inactiveCaptionBorder);
		reward_name.setFont(new Font("Segoe UI", Font.BOLD, 16));
		reward_name.setColumns(10);
		reward_name.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		reward_name.setBounds(679, 95, 210, 30);
		add_reward.add(reward_name);

		reward_point = new JTextField();
		reward_point.setBackground(SystemColor.inactiveCaptionBorder);
		reward_point.setFont(new Font("Segoe UI", Font.BOLD, 16));
		reward_point.setColumns(10);
		reward_point.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		reward_point.setBounds(679, 138, 210, 30);
		add_reward.add(reward_point);

		JLabel reward_image = new JLabel("");
		reward_image.setHorizontalAlignment(SwingConstants.CENTER);
		reward_image.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		reward_image.setBounds(679, 290, 150, 99);
		add_reward.add(reward_image);

		JLabel reward_browse = new JLabel("");
		reward_browse.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/browse_button.PNG")));
		reward_browse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
						Image newImg = img.getScaledInstance(reward_image.getWidth(), reward_image.getHeight(),
								Image.SCALE_SMOOTH);
						ImageIcon image = new ImageIcon(newImg);
						reward_image.setIcon(image);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select Image file format", "Try again", 1);
				}
			}
		});
		reward_browse.setHorizontalAlignment(SwingConstants.CENTER);
		reward_browse.setFont(new Font("Segoe UI", Font.BOLD, 16));
		reward_browse.setBounds(841, 364, 75, 25);
		add_reward.add(reward_browse);

		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setHorizontalAlignment(SwingConstants.LEFT);
		lblPoints.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPoints.setBounds(539, 138, 84, 30);
		add_reward.add(lblPoints);

		JLabel label_11 = new JLabel("Name:");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_11.setBounds(539, 95, 84, 30);
		add_reward.add(label_11);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(679, 198, 208, 65);
		add_reward.add(scrollPane_7);

		JTextArea reward_description = new JTextArea();
		reward_description.setBackground(SystemColor.inactiveCaptionBorder);
		scrollPane_7.setViewportView(reward_description);
		reward_description.setFont(new Font("Segoe UI", Font.BOLD, 16));

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDescription.setBounds(539, 197, 94, 30);
		add_reward.add(lblDescription);

		JLabel lblRewardImage = new JLabel("Reward Image:");
		lblRewardImage.setHorizontalAlignment(SwingConstants.LEFT);
		lblRewardImage.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblRewardImage.setBounds(528, 290, 120, 30);
		add_reward.add(lblRewardImage);

		JComboBox reward_category = new JComboBox(new Object[] { "Learning", "Canteen", "Railway Pass" });
		reward_category.setFont(new Font("Segoe UI", Font.BOLD, 16));
		reward_category.setBackground(Color.WHITE);
		reward_category.setBounds(679, 418, 210, 30);
		add_reward.add(reward_category);

		JLabel lblCategory_1 = new JLabel("Category:");
		lblCategory_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCategory_1.setBounds(539, 418, 75, 30);
		add_reward.add(lblCategory_1);

		JLabel lblAdd = new JLabel("");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				try {
					FileInputStream fis = new FileInputStream(path);
					String query = "insert into student_rewards(rd_id,rd_name,rd_points,rd_description,rd_img,rd_category) values(?,?,?,?,?,?)";
					PreparedStatement ps = co.conn.prepareStatement(query);
					Random rand = new Random();
					int num = rand.nextInt(99999);
					String rdid = Integer.toString(num);

					ps.setString(1, rdid);
					ps.setString(2, reward_name.getText());
					ps.setString(3, reward_point.getText());
					ps.setString(4, reward_description.getText());
					ps.setBinaryStream(5, fis);
					ps.setString(6, (String) reward_category.getSelectedItem());
					ps.executeUpdate();

					JOptionPane.showMessageDialog(null, "Reward Inserted Successfully");

					rdid = null;
					reward_name.setText("");
					reward_point.setText("");
					reward_description.setText("");
					reward_image.setIcon(null);
					reward_category.setSelectedIndex(0);

				} catch (FileNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}
				// update table from the database
				MyQuery mq = new MyQuery();
				ArrayList<Product2> list = mq.BindTable();
				String[] columnName = { "ID", "Name", "Points", "Description", "Image", "Categorie" };
				Object[][] rows = new Object[list.size()][6];
				for (int i = 0; i < list.size(); i++) {
					rows[i][0] = list.get(i).getId();
					rows[i][1] = list.get(i).getName();
					rows[i][2] = list.get(i).getQunt();
					rows[i][3] = list.get(i).getPrice();

					if (list.get(i).getMyImage() != null) {
						ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
								.getScaledInstance(150, 120, Image.SCALE_SMOOTH));
						rows[i][4] = image;
					} else {
						rows[i][4] = null;
					}

					rows[i][5] = list.get(i).getCatId();

				}
				TheModel model = new TheModel(rows, columnName);
				update_reward_table.setModel(model);
				update_reward_table.setRowHeight(120);
				update_reward_table.getColumnModel().getColumn(4).setPreferredWidth(150);
			}
		});
		lblAdd.setBounds(679, 512, 100, 35);
		lblAdd.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/add_button1.PNG")));
		add_reward.add(lblAdd);

		JLabel lblClr = new JLabel("");
		lblClr.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/clearall_reg.JPG")));
		lblClr.setHorizontalAlignment(SwingConstants.CENTER);
		lblClr.setBounds(801, 512, 100, 35);
		add_reward.add(lblClr);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(451, 62, 4, 545);
		add_reward.add(separator_4);

		JLabel lblAddRewards = new JLabel("Add rewards Guidlines\r\n");
		lblAddRewards.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddRewards.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAddRewards.setBounds(89, 87, 226, 38);
		add_reward.add(lblAddRewards);

		JTextPane txtpnYouCanAdd = new JTextPane();
		txtpnYouCanAdd.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		txtpnYouCanAdd.setText(
				"* You can add the reward from here\r\n\r\n* You have to put name on name section\r\n\r\n* Point will in between range of 100 to 1000\r\n\r\n* Description of reward\r\n\r\n* Select reward coupan Image\r\n\r\n* Select category of reward \r\n\r\n* Then Add the reward\r\n");
		txtpnYouCanAdd.setBounds(33, 138, 382, 361);
		txtpnYouCanAdd.setBackground(SystemColor.inactiveCaptionBorder);
		add_reward.add(txtpnYouCanAdd);

		JPanel RedeemRecord = new JPanel();
		RedeemRecord.setBackground(new Color(240, 248, 255));
		tabbedPane_1.addTab("Redeem Record", null, RedeemRecord, null);
		RedeemRecord.setLayout(null);

		JScrollPane scrollPane_14 = new JScrollPane();
		scrollPane_14.setBounds(56, 117, 936, 474);
		RedeemRecord.add(scrollPane_14);

		redeem_record = new JTable();
		redeem_record.setRowHeight(30);
		redeem_record.setFont(new Font("Segoe UI", Font.BOLD, 16));
		scrollPane_14.setViewportView(redeem_record);
		redeemRecordTableConfig();

		comboBox = new JComboBox(new Object[] { "Learning", "Canteen", "Railway Pass" });
		comboBox.setFont(new Font("Segoe UI", Font.BOLD, 16));
		comboBox.setBackground(new Color(240, 248, 255));
		comboBox.setBounds(213, 51, 172, 30);
		RedeemRecord.add(comboBox);

		JLabel label_16 = new JLabel("");
		label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				redeemRecordTableConfig();

				Connect co = new Connect();
				co.cLogin();
				try {
					Statement st = co.conn.createStatement();
					String Query = "select * from reward_record where reward_category='"
							+ comboBox.getSelectedItem().toString() + "'";

					co.rs = st.executeQuery(Query);

					while (co.rs.next()) {
						String rmname = co.rs.getString("reward_id");
						String rmemail = co.rs.getString("reward_category");
						String rmprn = co.rs.getString("user_name");
						String rmdob = co.rs.getString("user_email");
						String rmusername = co.rs.getString("reward_unique_code");

						String todata[] = { rmname, rmemail, rmprn, rmdob, rmusername };
						DefaultTableModel df = (DefaultTableModel) redeem_record.getModel();
						df.addRow(todata);

					}

				} catch (Exception e1) {

				}
			}
		});
		label_16.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/done_30px.png")));
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setBounds(397, 51, 30, 30);
		RedeemRecord.add(label_16);

		JLabel lblSortByCategory = new JLabel("Sort By Category :");
		lblSortByCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblSortByCategory.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSortByCategory.setBounds(56, 55, 147, 27);
		RedeemRecord.add(lblSortByCategory);
		scrollPane.setViewportView(table);

		JPanel UpdateTimetable = new JPanel();
		UpdateTimetable.setBackground(SystemColor.info);
		tabbedPane.addTab("New tab", null, UpdateTimetable, null);
		UpdateTimetable.setLayout(null);

		JLabel lblUpdateTt = new JLabel("Time Table Update");
		lblUpdateTt.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTt.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblUpdateTt.setBounds(421, 58, 323, 40);
		UpdateTimetable.add(lblUpdateTt);

		ttimg = new JLabel("");
		ttimg.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		ttimg.setBounds(141, 140, 830, 448);
		UpdateTimetable.add(ttimg);

		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/update_button.PNG")));
		label_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ttid = 0;

				Connect co = new Connect();
				co.cLogin();

				if (pathSelect == true) {
					try {
						FileInputStream fis = new FileInputStream(path);

						String quer = "UPDATE student_timetable SET tt_id=?, tt_year=?, tt_course=?, tt_image=? WHERE tt_id='"
								+ tid + "'";
						PreparedStatement pst1 = co.conn.prepareStatement(quer);
						pst1.setString(1, tid);
						pst1.setString(2, ttyear.getSelectedItem().toString());
						pst1.setString(3, ttcourse.getSelectedItem().toString());
						pst1.setBinaryStream(4, fis);
						pst1.executeUpdate();
						JOptionPane.showMessageDialog(null, "Reward Update Successfully...!");
						/*
						 * st = co.conn.createStatement();
						 * st.executeUpdate(quer);
						 */

					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					}

				} else {
					/// ################## get image first #######
					String qur = "select * from student_timetable where tt_id='" + tid + "'";
					PreparedStatement pst;
					try {
						pst = co.conn.prepareStatement(qur);
						ResultSet rs = pst.executeQuery();
						File thefile = new File("myImages.PNG");
						outpute = new FileOutputStream(thefile);
						if (rs.next()) {
							ttid = rs.getInt("tt_id");
							input = rs.getBinaryStream("tt_image");
							byte[] buffer = new byte[input.available()];
							while (input.read(buffer) > 0) {
								outpute.write(buffer);
							}
							path = thefile.getAbsolutePath();
						}
						FileInputStream fis = new FileInputStream(path);

						String quer = "UPDATE student_timetable SET tt_id=?, tt_year=?, tt_course=?,tt_image=? WHERE tt_id='"
								+ ttid + "'";
						PreparedStatement pst1 = co.conn.prepareStatement(quer);
						pst1.setString(1, tid);
						pst1.setString(2, ttyear.getSelectedItem().toString());
						pst1.setString(3, ttcourse.getSelectedItem().toString());
						pst1.setBinaryStream(4, fis);
						pst1.executeUpdate();
						JOptionPane.showMessageDialog(null, "Reward Update Successfully...!");
					} catch (SQLException | IOException e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(649, 666, 100, 35);
		UpdateTimetable.add(label_20);

		JLabel label_21 = new JLabel("");
		label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
						pathSelect = true;
						ImageIcon myimg = new ImageIcon(path);
						Image img = myimg.getImage();
						Image newImg = img.getScaledInstance(ttimg.getWidth(), ttimg.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon image = new ImageIcon(newImg);
						ttimg.setIcon(image);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select Image file format", "Try again", 1);
				}
			}
		});
		label_21.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/browse_button.PNG")));
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_21.setBounds(537, 607, 70, 25);
		UpdateTimetable.add(label_21);

		ttyear = new JComboBox(new Object[] { "First Year", "Second Year", "Third Year", "Fourth Year" });
		ttyear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		ttyear.setBackground(Color.WHITE);
		ttyear.setBounds(278, 602, 210, 30);
		UpdateTimetable.add(ttyear);

		ttcourse = new JComboBox(new Object[] { "Computer Engineering", "Mechanical Engineering",
				"Electrical Engineering", "IT Engineering", "Chemical Engineering" });
		ttcourse.setFont(new Font("Segoe UI", Font.BOLD, 16));
		ttcourse.setBackground(Color.WHITE);
		ttcourse.setBounds(278, 671, 210, 30);
		UpdateTimetable.add(ttcourse);

		JLabel lblStudentYear = new JLabel("Student Year:");
		lblStudentYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentYear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStudentYear.setBounds(141, 602, 122, 30);
		UpdateTimetable.add(lblStudentYear);

		JLabel lblStudentCourse = new JLabel("Student Course:");
		lblStudentCourse.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentCourse.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStudentCourse.setBounds(141, 671, 122, 30);
		UpdateTimetable.add(lblStudentCourse);

		JLabel lblAdd_1 = new JLabel("");
		lblAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				try {
					FileInputStream fis = new FileInputStream(path);
					String query = "insert into student_timetable(tt_id,tt_year,tt_course,tt_image) values(?,?,?,?)";
					PreparedStatement ps = co.conn.prepareStatement(query);
					Random rand = new Random();
					int OTP = rand.nextInt(99);
					String str1 = Integer.toString(OTP);
					ps.setString(1, str1);
					ps.setString(2, ttyear.getSelectedItem().toString());
					ps.setString(3, ttcourse.getSelectedItem().toString());
					ps.setBinaryStream(4, fis);
					ps.executeUpdate();

					JOptionPane.showMessageDialog(null, "Time Tabel Inserted Successfully");
					ttimg.setIcon(null);
					path = null;

				} catch (FileNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		lblAdd_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_1.setBounds(537, 666, 100, 35);
		lblAdd_1.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/add_button1 (1).PNG")));
		UpdateTimetable.add(lblAdd_1);

		JLabel lblGetTt = new JLabel("");
		lblGetTt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				co.cLogin();

				InputStream input;
				try {

					String qur = "select * from student_timetable where tt_year='" + ttyear.getSelectedItem().toString()
							+ "' and tt_course='" + ttcourse.getSelectedItem().toString() + "' ";
					PreparedStatement pst = co.conn.prepareStatement(qur);
					ResultSet rs = pst.executeQuery();
					File thefile = new File("myImages.png");
					outpute = new FileOutputStream(thefile);
					if (rs.next()) {
						tid = rs.getString("tt_id");
						input = rs.getBinaryStream("tt_image");
						byte[] buffer = new byte[input.available()];
						while (input.read(buffer) > 0) {
							outpute.write(buffer);
						}
						path = thefile.getAbsolutePath();
						ImageIcon myimg = new ImageIcon(path);
						Image img = myimg.getImage();
						Image newImg = img.getScaledInstance(ttimg.getWidth(), ttimg.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon image = new ImageIcon(newImg);
						ttimg.setIcon(image);
					}

				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblGetTt.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetTt.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblGetTt.setBounds(619, 607, 70, 25);
		lblGetTt.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/get_tt_button.PNG")));
		UpdateTimetable.add(lblGetTt);

		JPanel UpdateQuize = new JPanel();
		UpdateQuize.setBackground(new Color(255, 255, 102));
		tabbedPane.addTab("New tab", null, UpdateQuize, null);
		UpdateQuize.setLayout(null);

		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(63, 143, 965, 586);
		UpdateQuize.add(tabbedPane_3);

		JPanel addQuizQuestions = new JPanel();
		addQuizQuestions.setBackground(new Color(255, 255, 153));
		tabbedPane_3.addTab("Add Questions", null, addQuizQuestions, null);
		addQuizQuestions.setLayout(null);

		JLabel lblQuestionId = new JLabel("Question Id:");
		lblQuestionId.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQuestionId.setBounds(63, 57, 124, 30);
		addQuizQuestions.add(lblQuestionId);

		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblQuestion.setBounds(63, 117, 96, 30);
		addQuizQuestions.add(lblQuestion);

		JLabel lblOption = new JLabel("Option 1:");
		lblOption.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblOption.setBounds(63, 166, 96, 30);
		addQuizQuestions.add(lblOption);

		JLabel lblOption_1 = new JLabel("Option 2:");
		lblOption_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblOption_1.setBounds(63, 209, 96, 30);
		addQuizQuestions.add(lblOption_1);

		JLabel lblOption_2 = new JLabel("Option 3:");
		lblOption_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblOption_2.setBounds(63, 256, 96, 30);
		addQuizQuestions.add(lblOption_2);

		JLabel lblOption_3 = new JLabel("Option 4:");
		lblOption_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblOption_3.setBounds(63, 299, 96, 30);
		addQuizQuestions.add(lblOption_3);

		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAnswer.setBounds(63, 346, 96, 30);
		addQuizQuestions.add(lblAnswer);

		queName = new JTextField();
		queName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		queName.setBounds(171, 120, 777, 30);
		addQuizQuestions.add(queName);
		queName.setColumns(10);

		qopt1 = new JTextField();
		qopt1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		qopt1.setColumns(10);
		qopt1.setBounds(171, 167, 777, 30);
		addQuizQuestions.add(qopt1);

		qopt3 = new JTextField();
		qopt3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		qopt3.setColumns(10);
		qopt3.setBounds(171, 257, 777, 30);
		addQuizQuestions.add(qopt3);

		qopt2 = new JTextField();
		qopt2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		qopt2.setColumns(10);
		qopt2.setBounds(171, 210, 777, 30);
		addQuizQuestions.add(qopt2);

		qanswer = new JTextField();
		qanswer.setFont(new Font("Segoe UI", Font.BOLD, 16));
		qanswer.setColumns(10);
		qanswer.setBounds(171, 347, 777, 30);
		addQuizQuestions.add(qanswer);

		qopt4 = new JTextField();
		qopt4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		qopt4.setColumns(10);
		qopt4.setBounds(171, 300, 777, 30);
		addQuizQuestions.add(qopt4);

		JLabel qsubmit = new JLabel("");
		qsubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connect co = new Connect();
				co.cLogin();
				String insertQuestion = "insert into quiz_questions(q_name,q_opt1,q_opt2,q_opt3,q_opt4,q_answer) values(?,?,?,?,?,?,?)";
				try {
					PreparedStatement ps = co.conn.prepareStatement(insertQuestion);
					ps.setString(1, queName.getText());
					ps.setString(2, qopt1.getText());
					ps.setString(3, qopt2.getText());
					ps.setString(4, qopt3.getText());
					ps.setString(5, qopt4.getText());
					ps.setString(6, qanswer.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Question added successfully...!");
					queName.setText("");
					qopt1.setText("");
					qopt2.setText("");
					qopt3.setText("");
					qopt4.setText("");
					qanswer.setText("");

				} catch (SQLException e) {

					e.printStackTrace();
				}

				// Update Id of the question after adding new questions
				try {

					co.cLogin();
					String qu = "Select count(q_id) from quiz_questions";
					Statement st;
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qu);
					if (co.rs.first()) {
						int id = co.rs.getInt(1);
						id = id + 1;
						queId.setText(String.valueOf(id));
					} else {
						queId.setText("1");
					}
				} catch (Exception e) {

				}

				// Update table after the adding the question
				allQuestionDisplayForQuizTableConfig();
				co.cLogin();
				String qury = "select * from quiz_questions";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qury);

					while (co.rs.next()) {

						String id = co.rs.getString(1);
						String que = co.rs.getString(2);
						String op1 = co.rs.getString(3);
						String op2 = co.rs.getString(4);
						String op3 = co.rs.getString(5);
						String op4 = co.rs.getString(6);
						String ans = co.rs.getString(7);

						String todata[] = { id, que, op1, op2, op3, op4, ans };
						DefaultTableModel df = (DefaultTableModel) allquestiontable.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		qsubmit.setHorizontalAlignment(SwingConstants.CENTER);
		qsubmit.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/submit_fb.JPG")));
		qsubmit.setBounds(177, 427, 100, 35);
		addQuizQuestions.add(qsubmit);

		JLabel qclear = new JLabel("");
		qclear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				queName.setText("");
				qopt1.setText("");
				qopt2.setText("");
				qopt3.setText("");
				qopt4.setText("");
				qanswer.setText("");
			}
		});
		qclear.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/clearall_reg.JPG")));
		qclear.setBounds(311, 427, 100, 35);
		addQuizQuestions.add(qclear);

		queId = new JLabel("");
		queId.setForeground(new Color(255, 0, 0));
		queId.setHorizontalAlignment(SwingConstants.CENTER);
		queId.setFont(new Font("Segoe UI", Font.BOLD, 22));
		queId.setBounds(181, 57, 49, 30);
		addQuizQuestions.add(queId);

		JLabel quizbrows = new JLabel("");
		quizbrows.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jf = new JFileChooser();
				jf.showSaveDialog(null);
				path = jf.getSelectedFile().getAbsolutePath();
				gettingPath.setText(path);
			}
		});
		quizbrows.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/browse_button.PNG")));
		quizbrows.setHorizontalAlignment(SwingConstants.CENTER);
		quizbrows.setFont(new Font("Segoe UI", Font.BOLD, 16));
		quizbrows.setBounds(878, 437, 70, 25);
		addQuizQuestions.add(quizbrows);

		JLabel label_34 = new JLabel("");
		label_34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					BufferedReader br = new BufferedReader(new FileReader(path));
					while ((line = br.readLine()) != null) {
						value = line.split(",");
						// System.out.println("Question= "+value[0]+"\n, Opt1=
						// "+value[1]+"\nopt2= "+value[2]+", \nOpt3=
						// "+value[3]+" \nopt4= "+value[4]+",\nAnswer=
						// "+value[5]);
						count++;

						Connect co = new Connect();
						co.cLogin();

						String insertQuestion = "insert into quiz_questions(q_name,q_opt1,q_opt2,q_opt3,q_opt4,q_answer) values(?,?,?,?,?,?)";

						PreparedStatement ps = co.conn.prepareStatement(insertQuestion);

						ps.setString(1, value[0]);
						ps.setString(2, value[1]);
						ps.setString(3, value[2]);
						ps.setString(4, value[3]);
						ps.setString(5, value[4]);
						ps.setString(6, value[5]);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Question Added Successfully......");
					}

				} catch (Exception e) {

				}
			}
		});
		label_34.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/add_button1 (1).PNG")));
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		label_34.setBounds(848, 475, 100, 35);
		addQuizQuestions.add(label_34);
		// Question id will be genrated from database
		try {
			Connect co = new Connect();
			co.cLogin();
			String qu = "Select count(q_id) from quiz_questions";
			Statement st;
			st = co.conn.createStatement();
			co.rs = st.executeQuery(qu);
			if (co.rs.first()) {
				int id = co.rs.getInt(1);
				id = id + 1;
				queId.setText(String.valueOf(id));
			} else {
				queId.setText("1");
			}
		} catch (Exception e) {

		}

		JPanel updateQuziQuestions = new JPanel();
		updateQuziQuestions.setBackground(new Color(255, 255, 153));
		tabbedPane_3.addTab("Update/Delete Questions", null, updateQuziQuestions, null);
		updateQuziQuestions.setLayout(null);

		JLabel label_24 = new JLabel("Question Id:");
		label_24.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_24.setBounds(31, 53, 124, 30);
		updateQuziQuestions.add(label_24);

		JLabel label_26 = new JLabel("Question:");
		label_26.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_26.setBounds(31, 113, 96, 30);
		updateQuziQuestions.add(label_26);

		squename = new JTextField();
		squename.setFont(new Font("Segoe UI", Font.BOLD, 16));
		squename.setColumns(10);
		squename.setBounds(139, 116, 777, 30);
		updateQuziQuestions.add(squename);

		JLabel label_27 = new JLabel("Option 1:");
		label_27.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_27.setBounds(31, 162, 96, 30);
		updateQuziQuestions.add(label_27);

		sopt1 = new JTextField();
		sopt1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sopt1.setColumns(10);
		sopt1.setBounds(139, 163, 777, 30);
		updateQuziQuestions.add(sopt1);

		JLabel label_28 = new JLabel("Option 2:");
		label_28.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_28.setBounds(31, 205, 96, 30);
		updateQuziQuestions.add(label_28);

		sopt2 = new JTextField();
		sopt2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sopt2.setColumns(10);
		sopt2.setBounds(139, 206, 777, 30);
		updateQuziQuestions.add(sopt2);

		JLabel label_29 = new JLabel("Option 3:");
		label_29.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_29.setBounds(31, 252, 96, 30);
		updateQuziQuestions.add(label_29);

		sopt3 = new JTextField();
		sopt3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sopt3.setColumns(10);
		sopt3.setBounds(139, 253, 777, 30);
		updateQuziQuestions.add(sopt3);

		JLabel label_30 = new JLabel("Option 4:");
		label_30.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_30.setBounds(31, 295, 96, 30);
		updateQuziQuestions.add(label_30);

		sopt4 = new JTextField();
		sopt4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sopt4.setColumns(10);
		sopt4.setBounds(139, 296, 777, 30);
		updateQuziQuestions.add(sopt4);

		JLabel label_31 = new JLabel("Answer:");
		label_31.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_31.setBounds(31, 342, 96, 30);
		updateQuziQuestions.add(label_31);

		sans = new JTextField();
		sans.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sans.setColumns(10);
		sans.setBounds(139, 343, 777, 30);
		updateQuziQuestions.add(sans);

		JLabel label_32 = new JLabel("");
		label_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				String queryupdate = "update quiz_questions set q_name='" + squename.getText() + "' , q_opt1='"
						+ sopt1.getText() + "', q_opt2='" + sopt2.getText() + "', q_opt3='" + sopt3.getText()
						+ "', q_opt4='" + sopt4.getText() + "', q_answer='" + sans.getText() + "' where q_id='"
						+ queidsearch.getText() + "' ";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					st.executeUpdate(queryupdate);
					JOptionPane.showMessageDialog(null, "Question updated successfully...!");
					squename.setText("");
					sopt1.setText("");
					sopt2.setText("");
					sopt3.setText("");
					sopt4.setText("");
					sans.setText("");
					queidsearch.setEditable(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// co.rs=st.executeQuery(query);

				// Update the table after the update or delet the question
				allQuestionDisplayForQuizTableConfig();

				co.cLogin();
				String qury = "select * from quiz_questions";

				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qury);

					while (co.rs.next()) {

						String id = co.rs.getString(1);
						String que = co.rs.getString(2);
						String op1 = co.rs.getString(3);
						String op2 = co.rs.getString(4);
						String op3 = co.rs.getString(5);
						String op4 = co.rs.getString(6);
						String ans = co.rs.getString(7);

						String todata[] = { id, que, op1, op2, op3, op4, ans };
						DefaultTableModel df = (DefaultTableModel) allquestiontable.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		// Image updatelbl=new
		// ImageIcon(this.getClass().getResource("/update_button.png")).getImage();
		label_32.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/update_button.PNG")));
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setBounds(145, 423, 100, 35);
		updateQuziQuestions.add(label_32);

		JLabel label_33 = new JLabel("");
		label_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				squename.setText("");
				sopt1.setText("");
				sopt2.setText("");
				sopt3.setText("");
				sopt4.setText("");
				sans.setText("");
				queidsearch.setText("");
				queidsearch.setEditable(true);
			}
		});
		label_33.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/clearall_reg.JPG")));
		label_33.setBounds(279, 423, 100, 35);
		updateQuziQuestions.add(label_33);

		JLabel searchid = new JLabel("");
		searchid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				String searchque = "select * from quiz_questions where q_id='" + queidsearch.getText() + "'";

				Statement st;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(searchque);
					if (co.rs.next()) {
						squename.setText(co.rs.getString("q_name"));
						sopt1.setText(co.rs.getString("q_opt1"));
						sopt2.setText(co.rs.getString("q_opt2"));
						sopt3.setText(co.rs.getString("q_opt3"));
						sopt4.setText(co.rs.getString("q_opt4"));
						sans.setText(co.rs.getString("q_answer"));
						queidsearch.setEditable(false);
					} else {
						JOptionPane.showMessageDialog(null, "Question not found...");
						queidsearch.setEditable(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		// Image searchupdate=new
		// ImageIcon(this.getClass().getResource("/search_30px.png")).getImage();
		searchid.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/search_30px.png")));
		searchid.setHorizontalAlignment(SwingConstants.RIGHT);
		searchid.setBounds(232, 53, 30, 30);
		updateQuziQuestions.add(searchid);

		queidsearch = new JTextField();
		queidsearch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		queidsearch.setBounds(149, 53, 71, 30);
		updateQuziQuestions.add(queidsearch);
		queidsearch.setColumns(10);

		JLabel label_25 = new JLabel("");
		label_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co = new Connect();
				co.cLogin();
				String deletequestion = "DELETE FROM quiz_questions WHERE q_id='" + queidsearch.getText() + "'";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					st.executeUpdate(deletequestion);
					JOptionPane.showMessageDialog(null, "Question Deleted successfully...!");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// update the table after delete the question
				allQuestionDisplayForQuizTableConfig();

				co.cLogin();
				String qury = "select * from quiz_questions";

				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qury);

					while (co.rs.next()) {

						String id = co.rs.getString(1);
						String que = co.rs.getString(2);
						String op1 = co.rs.getString(3);
						String op2 = co.rs.getString(4);
						String op3 = co.rs.getString(5);
						String op4 = co.rs.getString(6);
						String ans = co.rs.getString(7);

						String todata[] = { id, que, op1, op2, op3, op4, ans };
						DefaultTableModel df = (DefaultTableModel) allquestiontable.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/delete_button.PNG")));
		label_25.setBounds(414, 423, 100, 35);
		updateQuziQuestions.add(label_25);

		JPanel all_Questions = new JPanel();
		all_Questions.setBackground(new Color(255, 255, 153));
		tabbedPane_3.addTab("All Questions", null, all_Questions, null);
		all_Questions.setLayout(null);

		JScrollPane scrollPane_15 = new JScrollPane();
		scrollPane_15.setFont(new Font("Segoe UI", Font.BOLD, 16));
		scrollPane_15.setBounds(41, 68, 882, 441);
		all_Questions.add(scrollPane_15);

		allquestiontable = new JTable();
		allquestiontable.setFont(new Font("Segoe UI", Font.BOLD, 16));
		scrollPane_15.setViewportView(allquestiontable);
		allquestiontable.setRowMargin(2);
		allquestiontable.setRowHeight(30);
		allQuestionDisplayForQuizTableConfig();

		JPanel pointDistrubation = new JPanel();
		pointDistrubation.setLayout(null);
		pointDistrubation.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, pointDistrubation, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(12, 95, 1065, 660);
		pointDistrubation.add(tabbedPane_2);

		JPanel allRecords = new JPanel();
		allRecords.setBackground(Color.WHITE);
		tabbedPane_2.addTab("All Records", null, allRecords, null);
		allRecords.setLayout(null);

		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(63, 83, 941, 518);
		allRecords.add(scrollPane_11);

		reward_point_table = new JTable();
		reward_point_table.setBackground(Color.WHITE);
		reward_point_table.setRowMargin(2);
		reward_point_table.setRowHeight(30);
		scrollPane_11.setViewportView(reward_point_table);
		redeemPointsTableConfig();

		JPanel studentPointDistrubation = new JPanel();
		studentPointDistrubation.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Point Distrubution", null, studentPointDistrubation, null);
		studentPointDistrubation.setLayout(null);

		JScrollPane scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(48, 193, 1000, 300);
		studentPointDistrubation.add(scrollPane_12);

		pointTable = new JTable();
		pointTable.setFont(new Font("Segoe UI", Font.BOLD, 16));
		pointTable.setRowMargin(2);
		pointTable.setRowHeight(30);
		scrollPane_12.setViewportView(pointTable);
		pointsTableConfig();

		JLabel label_13 = new JLabel("");
		label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jf = new JFileChooser();
				jf.showSaveDialog(null);
				path = jf.getSelectedFile().getAbsolutePath();
				gettingPath.setText(path);

				// Showing Content into the tabel

				pointsTableConfig();
				String line = "";
				int count = 0;
				try {
					BufferedReader br = new BufferedReader(new FileReader(path));
					while ((line = br.readLine()) != null) {
						String[] value = line.split(",");
						/*
						 * System.out.println("Email= "+value[0]+", Points= "
						 * +value[1]);
						 */
						count++;

						String todata[] = { value[0], value[1], value[1] };
						DefaultTableModel df = (DefaultTableModel) pointTable.getModel();
						df.addRow(todata);

						if (count == 8) {
							break;
						}
					}
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		});
		label_13.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/browse_button.PNG")));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_13.setBounds(48, 506, 70, 25);
		studentPointDistrubation.add(label_13);

		JLabel addPoints = new JLabel("");
		addPoints.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//uncomment the below part for getting data added by csv file 
//				PointDestrubution pd = new PointDestrubution();
//				pd.newData(path);
//				pointsTableConfig();
				
//				Reward points added from api 
				PointDestrubutionByApi pdapi=new PointDestrubutionByApi();
				pdapi.pointDestrubutionThroughDatabase();
				JOptionPane.showMessageDialog(null, "Reward points added Successfully into the student Accounts...!");
				
				// From here data is reflacting to the record table
				redeemPointsTableConfig();
				Connect co = new Connect();
				co.cLogin();
				String query = "select * from student_reward_points";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(query);

					while (co.rs.next()) {
						String rdname = co.rs.getString("reward_name");
						String rdemail = co.rs.getString("reward_email");
						String rdprn = co.rs.getString("reward_prn");
						int rdpoints = co.rs.getInt("reward_points");
						String points = String.valueOf(rdpoints);
						String todata[] = { rdname, rdemail, rdprn, points };
						DefaultTableModel df = (DefaultTableModel) reward_point_table.getModel();
						df.addRow(todata);
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}				
				
				
			}
		});
		addPoints.setHorizontalAlignment(SwingConstants.CENTER);
		addPoints.setBounds(948, 506, 100, 35);
		addPoints.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/add_button1.PNG")));
		studentPointDistrubation.add(addPoints);

		JTextPane txtpnGuidlines = new JTextPane();
		txtpnGuidlines.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtpnGuidlines.setText(
				"1) Select file from the system using \" Browse \" button.\r\n2) Use CSV file only. \r\n3) Click on \" Add \" button to calculate and destrubute the points ");
		txtpnGuidlines.setBounds(135, 63, 625, 82);
		studentPointDistrubation.add(txtpnGuidlines);

		JLabel lblGuidlines_1 = new JLabel("Guidlines :");
		lblGuidlines_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblGuidlines_1.setBounds(48, 33, 112, 25);
		studentPointDistrubation.add(lblGuidlines_1);

		JLabel lblRewardPoints = new JLabel("Reward Points");
		lblRewardPoints.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRewardPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblRewardPoints.setBounds(429, 49, 238, 41);
		pointDistrubation.add(lblRewardPoints);

		JPanel feedback = new JPanel();
		tabbedPane.addTab("New tab", null, feedback, null);
		feedback.setLayout(null);
		feedback.setBackground(Color.WHITE);

		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(78, 156, 948, 395);
		feedback.add(scrollPane_10);

		feedTable = new JTable();
		feedTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) feedTable.getModel();
				int selectrowindex = feedTable.getSelectedRow();

				fname.setText((String) model.getValueAt(selectrowindex, 0));
				femail.setText((String) model.getValueAt(selectrowindex, 1));
				fsubject.setText((String) model.getValueAt(selectrowindex, 2));
				fmsg.setText((String) model.getValueAt(selectrowindex, 3));
			}
		});

		feedTable.setRowMargin(2);
		feedTable.setRowHeight(30);
		scrollPane_10.setViewportView(feedTable);
		feedBackTableConfig();

		JComboBox feedcategory = new JComboBox(new Object[] { "Technical Issue", "Update", "Rating" });
		feedcategory.setFont(new Font("Segoe UI", Font.BOLD, 16));
		feedcategory.setBackground(Color.WHITE);
		feedcategory.setBounds(626, 88, 210, 30);
		feedback.add(feedcategory);

		JComboBox feedStatus = new JComboBox(new Object[] { "Pending", "Read" });
		feedStatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		feedStatus.setBackground(Color.WHITE);
		feedStatus.setBounds(217, 88, 160, 30);
		feedback.add(feedStatus);

		JLabel label_19 = new JLabel("");
		label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				feedBackTableConfig();

				Connect co = new Connect();
				co.cLogin();
				String qury = "select * from feedback where feed_status='" + feedStatus.getSelectedItem().toString()
						+ "'";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qury);

					while (co.rs.next()) {
						String fdname = co.rs.getString("feed_name");
						String fdemail = co.rs.getString("feed_email");
						String fdsub = co.rs.getString("feed_subject");
						String fdmsg = co.rs.getString("feed_message");
						String fdstatus = co.rs.getString("feed_status");

						String todata[] = { fdname, fdemail, fdsub, fdmsg, fdstatus };
						DefaultTableModel df = (DefaultTableModel) feedTable.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		label_19.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/done_30px.png")));
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		label_19.setBounds(389, 88, 30, 30);
		feedback.add(label_19);

		JLabel lblSortByStatus = new JLabel("Sort By Status :");
		lblSortByStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblSortByStatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSortByStatus.setBounds(78, 90, 127, 27);
		feedback.add(lblSortByStatus);

		JLabel label_23 = new JLabel("");
		label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				feedBackTableConfig();

				Connect co = new Connect();
				co.cLogin();
				String qury = "select * from feedback where feed_subject='" + feedcategory.getSelectedItem().toString()
						+ "'";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					co.rs = st.executeQuery(qury);

					while (co.rs.next()) {
						String fdname = co.rs.getString("feed_name");
						String fdemail = co.rs.getString("feed_email");
						String fdsub = co.rs.getString("feed_subject");
						String fdmsg = co.rs.getString("feed_message");
						String fdstatus = co.rs.getString("feed_status");

						String todata[] = { fdname, fdemail, fdsub, fdmsg, fdstatus };
						DefaultTableModel df = (DefaultTableModel) feedTable.getModel();
						df.addRow(todata);

					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		label_23.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/done_30px.png")));
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setBounds(848, 88, 30, 30);
		feedback.add(label_23);

		JLabel lblSortBySubject = new JLabel("Sort By Subject :");
		lblSortBySubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSortBySubject.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSortBySubject.setBounds(486, 91, 128, 27);
		feedback.add(lblSortBySubject);

		fname = new JTextField();
		fname.setFont(new Font("Segoe UI", Font.BOLD, 16));
		fname.setColumns(10);
		fname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		fname.setBounds(174, 574, 210, 30);
		feedback.add(fname);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblName_1.setBounds(78, 573, 84, 30);
		feedback.add(lblName_1);

		JLabel lblEmailId_2 = new JLabel("Email Id :");
		lblEmailId_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailId_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmailId_2.setBounds(78, 616, 84, 30);
		feedback.add(lblEmailId_2);

		femail = new JTextField();
		femail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		femail.setColumns(10);
		femail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		femail.setBounds(174, 617, 210, 30);
		feedback.add(femail);

		JLabel lblSubject = new JLabel("Subject :");
		lblSubject.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubject.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSubject.setBounds(78, 660, 84, 30);
		feedback.add(lblSubject);

		fsubject = new JTextField();
		fsubject.setFont(new Font("Segoe UI", Font.BOLD, 16));
		fsubject.setColumns(10);
		fsubject.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		fsubject.setBounds(174, 660, 210, 30);
		feedback.add(fsubject);

		JScrollPane scrollPane_13 = new JScrollPane();
		scrollPane_13.setBounds(520, 575, 241, 90);
		feedback.add(scrollPane_13);

		fmsg = new JTextArea();
		scrollPane_13.setViewportView(fmsg);
		fmsg.setFont(new Font("Segoe UI", Font.BOLD, 16));

		JLabel lblMessage = new JLabel("Message :");
		lblMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessage.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblMessage.setBounds(414, 574, 94, 30);
		feedback.add(lblMessage);

		JComboBox feedupdatestatus = new JComboBox(new Object[] { "Pending", "Read" });
		feedupdatestatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		feedupdatestatus.setBackground(Color.WHITE);
		feedupdatestatus.setBounds(520, 678, 160, 30);
		feedback.add(feedupdatestatus);

		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStatus.setBounds(414, 680, 94, 27);
		feedback.add(lblStatus);

		JLabel label_22 = new JLabel("");
		label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				co.cLogin();
				String query = "UPDATE feedback SET feed_name='" + fname.getText() + "',feed_email='" + femail.getText()
						+ "',feed_subject='" + fsubject.getText() + "',feed_message='" + fmsg.getText()
						+ "',feed_status='" + feedupdatestatus.getSelectedItem().toString() + "' WHERE feed_email='"
						+ femail.getText() + "'";
				Statement st = null;
				try {
					st = co.conn.createStatement();
					st.executeUpdate(query);

					// Update Table from hear

					feedBackTableConfig();

					Connect co = new Connect();
					co.cLogin();
					String qury = "select * from feedback";

					try {
						st = co.conn.createStatement();
						co.rs = st.executeQuery(qury);

						while (co.rs.next()) {
							String fdname = co.rs.getString("feed_name");
							String fdemail = co.rs.getString("feed_email");
							String fdsub = co.rs.getString("feed_subject");
							String fdmsg = co.rs.getString("feed_message");
							String fdstatus = co.rs.getString("feed_status");

							String todata[] = { fdname, fdemail, fdsub, fdmsg, fdstatus };
							DefaultTableModel df = (DefaultTableModel) feedTable.getModel();
							df.addRow(todata);

						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					// END
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// co.rs=st.executeQuery(query);

				JOptionPane.showMessageDialog(null, "Student update successfully...!");
			}
		});
		label_22.setIcon(new ImageIcon(Admin_Screen.class.getResource("/Assets/Images/update_button.PNG")));
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBounds(926, 564, 100, 35);
		feedback.add(label_22);
		
		JPanel studentDrive = new JPanel();
		studentDrive.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, studentDrive, null);
		studentDrive.setLayout(null);
		
		JLabel lblYetToAdded = new JLabel("YET to ADDED");
		lblYetToAdded.setBounds(334, 227, 315, 114);
		studentDrive.add(lblYetToAdded);
	}
}
