package Admin_Screens;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import Database.Connect;
import Student_Screens.Login_Window;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_Login {

	public JFrame frame;
	private JPasswordField password;
	private JTextField username;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login window = new Admin_Login();
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
	public Admin_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Login_Window lw=new Login_Window();
				lw.frame.setVisible(true);
			}
		});
		
		frame.setBounds(100, 100, 879, 481);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 861, 434);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblAdminLogin.setBounds(307, 13, 242, 44);
		panel.add(lblAdminLogin);
		
		JLabel label = new JLabel("");
		label.setBounds(77, 81, 193, 166);
		label.setIcon(new ImageIcon(Admin_Login.class.getResource("/Assets/Images/classroom_img_200px.png")));
		panel.add(label);
		
		JLabel label_1 = new JLabel("Reward System");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_1.setBounds(87, 260, 180, 35);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("For");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_2.setBounds(90, 295, 180, 35);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Google Classroom");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_3.setBounds(90, 326, 180, 35);
		panel.add(label_3);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(307, 101, 2, 290);
		panel.add(separator);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(345, 114, 45, 35);
		label_4.setIcon(new ImageIcon(Admin_Login.class.getResource("/Assets/Images/user_40px.png")));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(345, 212, 45, 35);
		label_5.setIcon(new ImageIcon(Admin_Login.class.getResource("/Assets/Images/password_40px.png")));
		panel.add(label_5);
		
		password = new JPasswordField();
		password.setFont(new Font("Segoe UI", Font.BOLD, 16));
		password.setEchoChar('*');
		password.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		password.setBounds(407, 212, 253, 35);
		panel.add(password);
		
		username = new JTextField("");
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Segoe UI", Font.BOLD, 16));
		username.setColumns(10);
		username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		username.setBounds(407, 114, 253, 35);
		panel.add(username);
		
		JLabel label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(672, 227, 27, 20);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co=new Connect();
				co.cLogin();
				String qr="select * from admin_table where admin_username='"+username.getText()+"' and admin_password='"+password.getText()+"'";
				try {
					Statement st=co.conn.createStatement();
					 co.rs=st.executeQuery(qr);
					 if(co.rs.next()){
						 JOptionPane.showMessageDialog(null, "Login Successfull..!");
						 frame.dispose();
						 Admin_Screen as=new Admin_Screen();
						 as.frame.setVisible(true);
						 
					 }
					 else{
						 JOptionPane.showMessageDialog(null, "Somthing is wrong in Username or password ");
					 }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		label_7.setIcon(new ImageIcon(Admin_Login.class.getResource("/Assets/Images/login_btn.JPG")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_7.setBackground((Color) null);
		label_7.setBounds(407, 295, 253, 35);
		panel.add(label_7);
		
		JLabel lblBackToLogin = new JLabel("Back to Login");
		lblBackToLogin.setBounds(757, 13, 92, 30);
		panel.add(lblBackToLogin);
		lblBackToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				Login_Window lw=new Login_Window();
				lw.frame.setVisible(true);
			}
		});
		lblBackToLogin.setForeground(Color.BLUE);
		lblBackToLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	}
}
