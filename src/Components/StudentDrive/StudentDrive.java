package Components.StudentDrive;

import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.cj.jdbc.Blob;

import Database.Connect;
import Student_Screens.Main_Dashbord;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;

class ButtonRender extends JButton implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row,
			int col) {
		setText((obj == null) ? "" : obj.toString());
		return this;
	}
}

class ButtonEdior extends DefaultCellEditor {

	protected JButton btn;
	private String lbl;
	private Boolean clicked;
	private String rowIndexId;

	public ButtonEdior(JTextField txt) {
		super(txt);
		btn = new JButton();
		btn.setOpaque(true);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fireEditingStopped();
			}
		});
	}

	// Override some methodes
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {

		lbl = (obj == null) ? "" : obj.toString();
		btn.setText(lbl);
		clicked = true;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		row = table.getSelectedRow();
        col = table.getSelectedColumn();
		rowIndexId=(String) model.getValueAt(row, 0);
		return btn;
	}

	@Override
	public Object getCellEditorValue() {
		if (clicked) {
			int reply=JOptionPane.showConfirmDialog(
		            null,
		            "Are you sure to download this File?",
		            "",
		            JOptionPane.YES_NO_OPTION);
			if(reply == JOptionPane.YES_OPTION){
				StudentDrive.downloadById(Integer.parseInt(rowIndexId));				
			}else{
				
			}
		}
		clicked = false;
		return new String(lbl);
	}

	@Override
	public boolean stopCellEditing() {
		clicked = false;
		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}

}

public class StudentDrive {

	public JFrame frame;
	private JTable driveTable;
	File[] files;
	private int xMouse, yMouse;
	LocalDate currentdate = java.time.LocalDate.now();
	LocalTime currenttime = java.time.LocalTime.now();
	String date = currentdate.toString();
	String time = currenttime.toString();
	Random rand = new Random();
	String name, username, stName;
	String userEmail;
	JTextPane path;
	ArrayList<String> filePaths = new ArrayList<>();

	// Table strings valuee variables
	String fname, fsize, fext, ftype, uploadDate, uploadTime,filID;

	public static void downloadById(int fileId) {
		Connect co=new Connect();
		co.cLogin();
		String filePath;
		String ids=String.valueOf(fileId);
		String sql1 = "SELECT fileName, fileContent,fileExtension,fileSize FROM student_drive WHERE fileId = ?";
		PreparedStatement statement;
		try {
			statement = co.conn.prepareStatement(sql1);
			statement.setString(1, ids);
			ResultSet resultSet = statement.executeQuery();
			filePath = "C:/Users/JAIKISHAN/Desktop/Test/";
			if (resultSet.next()) {
				String fileName = resultSet.getString("fileName");
				Blob fileBlob = (Blob) resultSet.getBlob("fileContent");
				String fsize = resultSet.getString("fileSize");
				String fextension = resultSet.getString("fileExtension");
				InputStream inputStream = fileBlob.getBinaryStream();
				OutputStream outputStream = new FileOutputStream(filePath + fileName);
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				statement.close();
				co.conn.close();
				JOptionPane.showMessageDialog(null, "File download to "+filePath);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private void getUserDriveData() {
		Connect co = new Connect();
		co.cLogin();
		String query = "select * from student_drive where fileUserEmail='" + userEmail + "'";
		Statement st;
		try {
			st = co.conn.createStatement();
			co.rs = st.executeQuery(query);
			while (co.rs.next()) {
				filID=String.valueOf(co.rs.getInt("fileId"));
				fname = co.rs.getString("fileName");
				fsize = String.valueOf(co.rs.getInt("fileSize"));
				fext = co.rs.getString("fileExtension");
				uploadDate = co.rs.getString("fileUploadDate");
				uploadTime = co.rs.getString("fileUploadTime");
				String todata[] = { filID,fname, fext, fsize, uploadDate, uploadTime };
				DefaultTableModel df = (DefaultTableModel) driveTable.getModel();
				df.addRow(todata);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
		getUserDriveData();
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
				stName = ct.rs.getString("std_name");
				userEmail = ct.rs.getString("std_mailid");
				ct.rs.getString("std_dob");
				ct.rs.getString("std_address");
				ct.rs.getString("std_rollnumber");
				ct.rs.getString("std_prn");
				ct.rs.getString("std_phonenumber");
				username = ct.rs.getString("std_username");
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
				Main_Dashbord md = new Main_Dashbord();
				frame.dispose();
				md.frame.setVisible(true);

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

		JLabel lblUsername = new JLabel(stName != null ? stName : "No User");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblUsername.setBounds(12, 184, 234, 40);
		panel_2.add(lblUsername);

		JButton upload = new JButton("Upload");
		upload.setFont(new Font("Segoe UI", Font.BOLD, 16));
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect co = new Connect();
				co.cLogin();
				boolean success = false;
				long fileInKb;
				String query = "insert into student_drive (fileId,fileName,fileContent,fileSize,fileExtension,fileUserEmail,fileUploadDate,fileUploadTime) values(?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pstmt = co.conn.prepareStatement(query);

					for (String filepath : filePaths) {
						File file = new File(filepath);
						FileInputStream fis = new FileInputStream(file);
						byte[] content = new byte[(int) file.length()];
						int fileId = rand.nextInt(9999);
						String rFileId = Integer.toString(fileId);
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
						success = true;
					}
					if (success) {
						JOptionPane.showMessageDialog(null, "Data Upload Successfully");
						studentDriveTable();
						getUserDriveData();
						path.setText("");
						filePaths.clear();
					} else {
						JOptionPane.showMessageDialog(null, "Something went wrong Please try again....");
					}

				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		upload.setBounds(132, 471, 105, 31);
		panel_2.add(upload);

		JLabel lblFiles = new JLabel("Files to be uploaded\r\n");
		lblFiles.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFiles.setBounds(29, 289, 134, 31);
		panel_2.add(lblFiles);

		JButton brows = new JButton("Brows");
		brows.setFont(new Font("Segoe UI", Font.BOLD, 14));
		brows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// code for selecting multiple files

				JFileChooser filechooser = new JFileChooser();
				filechooser.setMultiSelectionEnabled(true);
				int returnValue = filechooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					files = filechooser.getSelectedFiles();
					for (File file : files) {
						filePaths.add(file.getAbsolutePath());
					}
					path.setText(filePaths.toString());
				}
			}
		});
		brows.setBounds(161, 437, 76, 25);
		panel_2.add(brows);

		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(StudentDrive.class.getResource("/Assets/Images/google-drive-200.png")));
		label_2.setBounds(29, 13, 193, 166);
		panel_2.add(label_2);

		path = new JTextPane();
		path.setEditable(false);
		path.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		path.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		path.setBounds(29, 322, 208, 102);
		panel_2.add(path);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 154, 756, 492);
		panel.add(scrollPane);

		driveTable = new JTable();
		driveTable.setRowMargin(2);
		driveTable.setRowHeight(30);
		driveTable.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 139, 139)));
		driveTable.setFont(new Font("Segoe UI", Font.BOLD, 16));
		studentDriveTable();
		scrollPane.setViewportView(driveTable);

		JTextPane txtpnStudentCanUpload = new JTextPane();
		txtpnStudentCanUpload.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtpnStudentCanUpload.setText(
				"* Student can upload files only upto 4mb.\r\n* Try to upload only curriculam related files only.\r\n");
		txtpnStudentCanUpload.setBounds(270, 65, 365, 47);
		panel.add(txtpnStudentCanUpload);

		JLabel lblInstructions = new JLabel("Instructions: -\r\n");
		lblInstructions.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblInstructions.setBounds(277, 43, 112, 20);
		panel.add(lblInstructions);
	}

	private void studentDriveTable() {
		driveTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "File Id", "File Name",
				"File Type", "File Size", "Upload Date", "Upload Time", "Download" }) {
			boolean[] columnEditables = new boolean[] { false,false, false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		driveTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		driveTable.getColumnModel().getColumn(0).setMinWidth(20);
		driveTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		driveTable.getColumnModel().getColumn(1).setMinWidth(20);
		driveTable.getColumnModel().getColumn(2).setPreferredWidth(113);
		driveTable.getColumnModel().getColumn(3).setPreferredWidth(94);
		driveTable.getColumnModel().getColumn(4).setPreferredWidth(180);
		driveTable.getColumnModel().getColumn(5).setPreferredWidth(150);
		driveTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRender());
		driveTable.getColumnModel().getColumn(6).setCellEditor(new ButtonEdior(new JTextField("Download")));
	}
}
