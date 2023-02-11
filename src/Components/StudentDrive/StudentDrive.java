package Components.StudentDrive;

import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Database.Connect;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentDrive {

	private JFrame frame;
	private JTable table;
	private int xMouse, yMouse;
	private JTextField path;
	LocalDate currentdate = java.time.LocalDate.now();
	LocalTime currenttime = java.time.LocalTime.now();
	String date = currentdate.toString();
	String time = currenttime.toString();
	Random rand = new Random();
	int fileId = rand.nextInt(9999);
	String rFileId = Integer.toString(fileId);
	String name;
	String userEmail;
	ArrayList<String> filePaths = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDrive window = new StudentDrive();
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
	public StudentDrive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1038, 659);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1038, 659);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 0, 1038, 30);
		panel.add(panel_1);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x - xMouse, y - yMouse);
			}
		});
		
		// retrive current user name
		
		File f = new File("./WWW.txt");
		Scanner sc;
		try {
			sc = new Scanner(f);
			sc.useDelimiter("\\Z");
			name = sc.next();
			// Database fetching for getting details of the students
			// ###################################
			Connect ct = new Connect();
			ct.cLogin();
			String cquery = "select * from student_registration where std_username='" + name + "'";
			Statement st;

			st = ct.conn.createStatement();
			ct.rs = st.executeQuery(cquery);
			if (ct.rs.next()) {
				ct.rs.getString("std_name");
				userEmail = ct.rs.getString("std_mailid");
				ct.rs.getString("std_dob");
				ct.rs.getString("std_address");
				ct.rs.getString("std_rollnumber");
				ct.rs.getString("std_prn");
				ct.rs.getString("std_phonenumber");
				ct.rs.getString("std_username");
				ct.rs.getString("std_year");
				ct.rs.getString("std_course");
				ct.rs.getString("std_batchyear");

				// File thefile = new File("myImages.png");
				// outpute = new FileOutputStream(thefile);
				// input = ct.rs.getBinaryStream("std_profile");
				// byte[] buffer = new byte[input.available()];
				// while (input.read(buffer) > 0) {
				// outpute.write(buffer);
				// }
				// path = thefile.getAbsolutePath();

			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		label.setIcon(new ImageIcon(StudentDrive.class.getResource("/Assets/Images/minimize_30px.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(969, 0, 30, 30);
		panel_1.add(label);

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		label_1.setIcon(new ImageIcon(StudentDrive.class.getResource("/Assets/Images/close_30px.png")));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(1008, 0, 30, 30);
		panel_1.add(label_1);

		JLabel lblStudentDrive = new JLabel("Student Drive");
		lblStudentDrive.setForeground(Color.WHITE);
		lblStudentDrive.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStudentDrive.setBounds(52, 0, 145, 30);
		panel_1.add(lblStudentDrive);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(StudentDrive.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 0, 30, 30);
		panel_1.add(label_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(0, 30, 258, 629);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblUsername.setBounds(12, 13, 234, 40);
		panel_2.add(lblUsername);

		JButton upload = new JButton("Upload");
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect co = new Connect();
				co.cLogin();
				long fileInKb;
				String query = "insert into student_drive (fileId,fileName,fileContent,fileSize,fileExtension,fileUserEmail,fileUploadDate,fileUploadTime) values(?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pstmt = co.conn.prepareStatement(query);

					for (String filepath : filePaths) {
						File file = new File(filepath);
						FileInputStream fis = new FileInputStream(file);
						byte[] content = new byte[(int) file.length()];
						fis.read(content);
						fis.close();
						fileInKb = file.length() / 1024;
						pstmt.setString(1, rFileId);
						pstmt.setString(2, file.getName());
						pstmt.setBytes(3, content);
						pstmt.setLong(4, fileInKb);
						pstmt.setString(5, file.getName().substring(file.getName().lastIndexOf(".") + 1));
						pstmt.setString(6, userEmail);
						pstmt.setString(7, date);
						pstmt.setString(8, time);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Upload Successfully");
					}

				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		upload.setBounds(74, 407, 72, 40);
		panel_2.add(upload);

		path = new JTextField();
		path.setBounds(41, 346, 98, 22);
		panel_2.add(path);
		path.setColumns(10);

		JLabel lblFiles = new JLabel("files");
		lblFiles.setBounds(175, 349, 56, 16);
		panel_2.add(lblFiles);

		JButton brows = new JButton("brows");
		brows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// code for selecting multiple files

				JFileChooser filechooser = new JFileChooser();
				filechooser.setMultiSelectionEnabled(true);
				int returnValue = filechooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File[] files = filechooser.getSelectedFiles();
					for (File file : files) {
						filePaths.add(file.getAbsolutePath());
					}
					path.setText(filePaths.toString());
				}
			}
		});
		brows.setBounds(74, 230, 97, 25);
		panel_2.add(brows);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 93, 756, 492);
		panel.add(scrollPane);

		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 139, 139)));
		table.setFont(new Font("Segoe UI", Font.BOLD, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "File Name", "File Type", "File Size", "Upload Date" }) {
			boolean[] columnEditables = new boolean[] { true, true, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(146);
		table.getColumnModel().getColumn(1).setPreferredWidth(113);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		scrollPane.setViewportView(table);
	}
}
