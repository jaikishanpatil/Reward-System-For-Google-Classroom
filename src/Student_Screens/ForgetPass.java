package Student_Screens;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Database.Connect;
import Database.SendEmailVerification;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ForgetPass {

	JFrame frame;
	public int xMouse,yMouse;
	private JTextField forPassword;
	private JTextField forEmailId;
	private JTextField forConPass;
	private JTextField forOTP;
	SendEmailVerification sev=new SendEmailVerification();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPass window = new ForgetPass();
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
	public ForgetPass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 761, 599);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 761, 30);
		
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse=e.getX();
				yMouse=e.getY();
			}
		});
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				frame.setLocation(x-xMouse,y-yMouse);
			}
		});
		
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(192, 192, 192));
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*Login_Window lw=new Login_Window();
				lw.frame.setVisible(true);*/
				frame.dispose();
			
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(731, 0, 30, 30);
		label.setIcon(new ImageIcon(ForgetPass.class.getResource("/Assets/Images/close_30px.png")));
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(692, 0, 30, 30);
		label_1.setIcon(new ImageIcon(ForgetPass.class.getResource("/Assets/Images/minimize_30px.png")));
		
		panel_1.add(label_1);
		
		JLabel lblLoginScreen = new JLabel("Login Screen ");
		lblLoginScreen.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblLoginScreen.setBounds(52, 0, 102, 30);
		panel_1.add(lblLoginScreen);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 0, 30, 30);
		label_3.setIcon(new ImageIcon(ForgetPass.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		panel_1.add(label_3);
		
		JLabel lblForgetPassword = new JLabel("/ Forgot Password");
		lblForgetPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblForgetPassword.setBounds(154, 0, 168, 30);
		panel_1.add(lblForgetPassword);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 30, 761, 569);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel forgetlable = new JLabel("");
		forgetlable.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		forgetlable.setBounds(0, 0, 761, 569);
		Image forgetimg=new ImageIcon(this.getClass().getResource("/forgetpass.jpg")).getImage();
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ForgetPass.class.getResource("/Assets/Images/classroom_img_200px.png")));
		
		label_2.setBounds(41, 127, 193, 166);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("Reward System");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_4.setBounds(51, 306, 180, 35);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("For");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_5.setBounds(54, 342, 180, 35);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Google Classroom");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_6.setBounds(54, 378, 180, 35);
		panel.add(label_6);
		
		forPassword = new JTextField("");
		forPassword.setForeground(Color.BLACK);
		forPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
		forPassword.setColumns(10);
		forPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		forPassword.setBounds(367, 229, 219, 25);
		panel.add(forPassword);
		
		JLabel lblUsername = new JLabel("Password");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblUsername.setBounds(367, 199, 87, 25);
		panel.add(lblUsername);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblConfirmPassword.setForeground(Color.BLACK);
		lblConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblConfirmPassword.setBounds(367, 277, 145, 25);
		panel.add(lblConfirmPassword);
		
		forEmailId = new JTextField("");
		forEmailId.setForeground(Color.BLACK);
		forEmailId.setFont(new Font("Segoe UI", Font.BOLD, 16));
		forEmailId.setColumns(10);
		forEmailId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		forEmailId.setBounds(367, 118, 219, 25);
		panel.add(forEmailId);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailId.setForeground(Color.BLACK);
		lblEmailId.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblEmailId.setBounds(367, 92, 81, 25);
		panel.add(lblEmailId);
		
		JLabel forgetPass = new JLabel("");
		forgetPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(forOTP.getText().equals(SendEmailVerification.str1)){
					if(forPassword.getText().equals(forConPass.getText())){
						Connect co=new Connect();
						co.cLogin();
						
						try{
							
							String query="UPDATE student_registration SET std_password='"+forPassword.getText()+"' WHERE std_mailid='"+forEmailId.getText()+"'";
							Statement st=null;
							st=co.conn.createStatement();
							 //co.rs=st.executeQuery(query);
							st.executeUpdate(query);
								 JOptionPane.showMessageDialog(null, "Password Reset Successfully");
								 forEmailId.setText("");
								 forConPass.setText("");
								 forPassword.setText("");
								 forOTP.setText("");
								 Thread.sleep(10);
								 Login_Window lw=new Login_Window();
								 lw.frame.setVisible(true);
								 frame.dispose();
							 
						}catch(Exception e){
							e.printStackTrace();
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Your Password Dosent match with Confirm password");
					}
				}else{
					JOptionPane.showMessageDialog(null, "You have Entered Wrong OTP");
				}
				
			}
		});
		forgetPass.setHorizontalAlignment(SwingConstants.CENTER);
		forgetPass.setIcon(new ImageIcon(ForgetPass.class.getResource("/Assets/Images/forgotpassword.JPG")));
		forgetPass.setFont(new Font("Segoe UI", Font.BOLD, 18));
		forgetPass.setBackground((Color) null);
		forgetPass.setBounds(367, 438, 253, 35);
		panel.add(forgetPass);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String temp1=forEmailId.getText();
					SendEmailVerification.sendmail(temp1);
					System.out.println("MailSend " + SendEmailVerification.str1);
				} catch (Exception ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
			}
		});
		label_7.setBounds(599, 118, 95, 25);
		label_7.setIcon(new ImageIcon(ForgetPass.class.getResource("/Assets/Images/send_forget.JPG")));
		panel.add(label_7);
		
		forConPass = new JTextField("");
		forConPass.setForeground(Color.BLACK);
		forConPass.setFont(new Font("Segoe UI", Font.BOLD, 16));
		forConPass.setColumns(10);
		forConPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		forConPass.setBounds(367, 306, 219, 25);
		panel.add(forConPass);
		
		forOTP = new JTextField("");
		forOTP.setForeground(Color.BLACK);
		forOTP.setFont(new Font("Segoe UI", Font.BOLD, 16));
		forOTP.setColumns(10);
		forOTP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		forOTP.setBounds(367, 380, 110, 25);
		panel.add(forOTP);
		
		JLabel lblOtp = new JLabel("OTP");
		lblOtp.setHorizontalAlignment(SwingConstants.LEFT);
		lblOtp.setForeground(Color.BLACK);
		lblOtp.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblOtp.setBounds(367, 348, 40, 25);
		panel.add(lblOtp);
		forgetlable.setIcon(new ImageIcon(forgetimg));
		panel.add(forgetlable);
		
		
	}
}
