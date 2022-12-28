package Student_Screens;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class Student_Profile {

	JFrame frame;
	int xMouse,yMouse;
	private JTextField profileName;
	private JTextField profileEmail;
	private JTextField profileDob;
	private JTextField profileRollNum;
	private JTextField profilePRN;
	private JTextField txtProfile;
	private JTextField profileNumber;
	private JTextField profileUsername;
	private JTextField profileYear;
	private JTextField profileCourse;
	private JTextField profileBatchYear;
	private JTextField txtPoints;
	private JTextField textField_5;
	JLabel profileImg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Profile window = new Student_Profile();
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
	public Student_Profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ProfilUpdate pu=new ProfilUpdate(null, null, null, null, null, null, null, null, null, null, null);
		UpdaterClass ud=new UpdaterClass();
		ud.update();
		frame = new JFrame();
		frame.setBounds(100, 130, 369, 600);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse=e.getX();
				yMouse=e.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				frame.setLocation(x-xMouse, y-yMouse);
			}
		});
		panel.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 369, 30);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		label.setIcon(new ImageIcon(Student_Profile.class.getResource("/Assets/Images/minimizebutton.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(307, 0, 30, 30);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		label_1.setIcon(new ImageIcon(Student_Profile.class.getResource("/Assets/Images/closebutton.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(338, 0, 30, 30);
		panel.add(label_1);
		
		JLabel lblProfile = new JLabel("Main Dashboard / Profile");
		lblProfile.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblProfile.setBounds(52, 0, 199, 30);
		panel.add(lblProfile);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Student_Profile.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 0, 30, 30);
		panel.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 30, 369, 570);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		Image dellbl=new ImageIcon(this.getClass().getResource("/profilebox.png")).getImage();
		
		profileImg = new JLabel("");
		profileImg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 255), new Color(192, 192, 192)));
		profileImg.setHorizontalAlignment(SwingConstants.CENTER);
		profileImg.setBounds(137, 79, 100, 99);
		panel_1.add(profileImg);
		
		ImageIcon myimg=new ImageIcon(pu.path);
		Image img=myimg.getImage();
		Image newImg=img.getScaledInstance(profileImg.getWidth(), profileImg.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(newImg);
		profileImg.setIcon(image);
		
		
		profileName = new JTextField();
		profileName.setText(pu.getPname());
		profileName.setHorizontalAlignment(SwingConstants.CENTER);
		profileName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		profileName.setForeground(new Color(0, 0, 0));
		profileName.setBackground(Color.WHITE);
		profileName.setEditable(false);
		profileName.setBorder(null);
		profileName.setBounds(85, 191, 207, 22);
		panel_1.add(profileName);
		profileName.setColumns(10);
		
		profileEmail = new JTextField();
		profileEmail.setText(pu.getPemail());
		profileEmail.setHorizontalAlignment(SwingConstants.CENTER);
		profileEmail.setForeground(Color.BLACK);
		profileEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileEmail.setEditable(false);
		profileEmail.setColumns(10);
		profileEmail.setBorder(null);
		profileEmail.setBackground(Color.WHITE);
		profileEmail.setBounds(85, 218, 207, 22);
		panel_1.add(profileEmail);
		
		profileDob = new JTextField();
		profileDob.setText(pu.getPdob());
		profileDob.setHorizontalAlignment(SwingConstants.CENTER);
		profileDob.setForeground(Color.BLACK);
		profileDob.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileDob.setEditable(false);
		profileDob.setColumns(10);
		profileDob.setBorder(null);
		profileDob.setBackground(Color.WHITE);
		profileDob.setBounds(85, 245, 207, 22);
		panel_1.add(profileDob);
		
		JTextArea profileAddress = new JTextArea();
		profileAddress.setEditable(false);
		profileAddress.append(pu.getPaddress());
		profileAddress.setBackground(Color.WHITE);
		profileAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileAddress.setBounds(85, 290, 207, 57);
		panel_1.add(profileAddress);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setForeground(Color.GRAY);
		separator.setBounds(38, 355, 298, 2);
		panel_1.add(separator);
		
		profileRollNum = new JTextField();
		profileRollNum.setText(pu.getProll());
		profileRollNum.setForeground(Color.BLACK);
		profileRollNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileRollNum.setEditable(false);
		profileRollNum.setColumns(10);
		profileRollNum.setBorder(null);
		profileRollNum.setBackground(Color.WHITE);
		profileRollNum.setBounds(48, 367, 114, 22);
		panel_1.add(profileRollNum);
		
		profilePRN = new JTextField();
		profilePRN.setText(pu.getPprn());
		profilePRN.setForeground(Color.BLACK);
		profilePRN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profilePRN.setEditable(false);
		profilePRN.setColumns(10);
		profilePRN.setBorder(null);
		profilePRN.setBackground(Color.WHITE);
		profilePRN.setBounds(48, 392, 114, 22);
		panel_1.add(profilePRN);
		
		txtProfile = new JTextField();
		txtProfile.setText("My Profile");
		txtProfile.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfile.setForeground(Color.BLACK);
		txtProfile.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txtProfile.setEditable(false);
		txtProfile.setColumns(10);
		txtProfile.setBorder(null);
		txtProfile.setBackground(Color.WHITE);
		txtProfile.setBounds(85, 37, 207, 22);
		panel_1.add(txtProfile);
		
		profileNumber = new JTextField();
		profileNumber.setText(pu.getPpnum());
		profileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		profileNumber.setForeground(Color.BLACK);
		profileNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileNumber.setEditable(false);
		profileNumber.setColumns(10);
		profileNumber.setBorder(null);
		profileNumber.setBackground(Color.WHITE);
		profileNumber.setBounds(85, 270, 207, 22);
		panel_1.add(profileNumber);
		
		profileUsername = new JTextField();
		profileUsername.setText(pu.getPusername());
		profileUsername.setForeground(Color.BLACK);
		profileUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileUsername.setEditable(false);
		profileUsername.setColumns(10);
		profileUsername.setBorder(null);
		profileUsername.setBackground(Color.WHITE);
		profileUsername.setBounds(48, 417, 114, 22);
		panel_1.add(profileUsername);
		
		profileYear = new JTextField();
		profileYear.setText(pu.getPyear());
		profileYear.setForeground(Color.BLACK);
		profileYear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileYear.setEditable(false);
		profileYear.setColumns(10);
		profileYear.setBorder(null);
		profileYear.setBackground(Color.WHITE);
		profileYear.setBounds(48, 442, 114, 22);
		panel_1.add(profileYear);
		
		profileCourse = new JTextField();
		profileCourse.setText(pu.getPcourse());
		profileCourse.setForeground(Color.BLACK);
		profileCourse.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileCourse.setEditable(false);
		profileCourse.setColumns(10);
		profileCourse.setBorder(null);
		profileCourse.setBackground(Color.WHITE);
		profileCourse.setBounds(48, 466, 141, 22);
		panel_1.add(profileCourse);
		
		profileBatchYear = new JTextField();
		profileBatchYear.setText(pu.getPbyear());
		profileBatchYear.setForeground(Color.BLACK);
		profileBatchYear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		profileBatchYear.setEditable(false);
		profileBatchYear.setColumns(10);
		profileBatchYear.setBorder(null);
		profileBatchYear.setBackground(Color.WHITE);
		profileBatchYear.setBounds(48, 491, 141, 22);
		panel_1.add(profileBatchYear);
		
		txtPoints = new JTextField();
		txtPoints.setText("Reward Points");
		txtPoints.setForeground(Color.BLACK);
		txtPoints.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPoints.setEditable(false);
		txtPoints.setColumns(10);
		txtPoints.setBorder(null);
		txtPoints.setBackground(Color.WHITE);
		txtPoints.setBounds(222, 368, 114, 22);
		panel_1.add(txtPoints);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setText(ud.points);
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(222, 393, 90, 22);
		panel_1.add(textField_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(201, 374, 2, 151);
		panel_1.add(separator_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(new MatteBorder(1, 2, 2, 2, (Color) new Color(0, 0, 0)));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(dellbl));
		label_2.setBounds(0, 0, 369, 570);
		panel_1.add(label_2);
		
	}
}
