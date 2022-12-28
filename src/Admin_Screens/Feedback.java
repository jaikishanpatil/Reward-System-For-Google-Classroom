package Admin_Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Database.Connect;
import Student_Screens.feedbackStudentDataUpdate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Feedback {

	public JFrame frame;
	private int xMouse,yMouse;
	private JTextField feed_name;
	private JTextField feed_email;
	LocalDate currentdate=java.time.LocalDate.now();
	LocalTime currenttime=java.time.LocalTime.now();
	JComboBox feed_subject;
	String feedstatus="Pending";
	String date=currentdate.toString();
	String time=currenttime.toString();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback window = new Feedback();
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
	public Feedback() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		feedbackStudentDataUpdate fsdu=new feedbackStudentDataUpdate();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 542);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
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
				frame.setLocation(x-xMouse,y-yMouse);
			}
		});
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 600, 30);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		Image feedminimizeimg=new ImageIcon(this.getClass().getResource("/minimize_30px.png")).getImage();
		label.setIcon(new ImageIcon(feedminimizeimg));
		//label.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-subtract-30.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(531, 0, 30, 30);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		Image feedcloseimg=new ImageIcon(this.getClass().getResource("/close_30px.png")).getImage();
		label_1.setIcon(new ImageIcon(feedcloseimg));
		//label_1.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-close-30.png"));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(570, 0, 30, 30);
		panel.add(label_1);
		
		JLabel lblFeedback = new JLabel("FeedBack");
		lblFeedback.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFeedback.setBounds(52, 0, 112, 30);
		panel.add(lblFeedback);
		
		JLabel label_3 = new JLabel("");
		Image feedmaintopimg=new ImageIcon(this.getClass().getResource("/Classrom_img_20px.png")).getImage();
		label_3.setIcon(new ImageIcon(feedmaintopimg));
		//label_3.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-google-classroom-30.png"));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 0, 30, 30);
		panel.add(label_3);
		
		JLabel lblFeedbackForm = new JLabel("FeedBack Form");
		lblFeedbackForm.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblFeedbackForm.setBackground(new Color(0, 0, 0));
		lblFeedbackForm.setBounds(254, 56, 139, 30);
		frame.getContentPane().add(lblFeedbackForm);
		
		feed_name = new JTextField("");
		feed_name.setBackground(Color.WHITE);
		feed_name.setEditable(false);
		feed_name.setText(fsdu.fname);
		feed_name.setFont(new Font("Segoe UI", Font.BOLD, 16));
		feed_name.setForeground(new Color(0, 0, 0));
		feed_name.setColumns(10);
		feed_name.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		feed_name.setBounds(183, 141, 253, 35);
		frame.getContentPane().add(feed_name);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblName.setBounds(183, 119, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmailId.setBounds(183, 189, 56, 16);
		frame.getContentPane().add(lblEmailId);
		
		feed_email = new JTextField("");
		feed_email.setBackground(Color.WHITE);
		feed_email.setEditable(false);
		feed_email.setText(fsdu.femail);
		feed_email.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		feed_email.setFont(new Font("Segoe UI", Font.BOLD, 16));
		feed_email.setForeground(new Color(0, 0, 0));
		feed_email.setColumns(10);
		feed_email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 51, 153)));
		feed_email.setBounds(183, 211, 253, 35);
		frame.getContentPane().add(feed_email);
		
		JLabel lblSubjecT = new JLabel("Subject");
		lblSubjecT.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSubjecT.setBounds(183, 259, 56, 16);
		frame.getContentPane().add(lblSubjecT);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMessage.setBounds(183, 329, 66, 16);
		frame.getContentPane().add(lblMessage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 356, 253, 70);
		frame.getContentPane().add(scrollPane);
		
		JTextArea feed_message = new JTextArea();
		feed_message.setFont(new Font("Segoe UI", Font.BOLD, 16));
		scrollPane.setViewportView(feed_message);
		
		JLabel label_2 = new JLabel("");
		Image feedclrimg=new ImageIcon(this.getClass().getResource("/clearall_reg.jpg")).getImage();
		label_2.setIcon(new ImageIcon(feedclrimg));
		//label_2.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\clearall_reg.JPG"));
		label_2.setBounds(330, 468, 100, 35);
		frame.getContentPane().add(label_2);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connect co=new Connect();
				co.cLogin();
				String query="insert into feedback values(?,?,?,?,?,?,?)";
				try {
					PreparedStatement ps=co.conn.prepareStatement(query);
					ps.setString(1, feed_name.getText());
					ps.setString(2, feed_email.getText());
					ps.setString(3, feed_subject.getSelectedItem().toString());
					ps.setString(4, feed_message.getText());
					ps.setString(5, feedstatus);
					ps.setString(6, date);
					ps.setString(7, time);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Feedback Send Successfully");
					Thread.sleep(10);
					frame.dispose();
					
				} catch (SQLException | InterruptedException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		Image feedsubmitimg=new ImageIcon(this.getClass().getResource("/submit_fb.jpg")).getImage();
		label_5.setIcon(new ImageIcon(feedsubmitimg));
		//label_5.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\submit_fb (1).JPG"));
		label_5.setBounds(196, 468, 100, 35);
		frame.getContentPane().add(label_5);
		Image feedmainimg=new ImageIcon(this.getClass().getResource("/feedback_bg.jpg")).getImage();
		
		feed_subject = new JComboBox(new Object[]{"Technical Issue","Update","Rating"});
		feed_subject.setFont(new Font("Segoe UI", Font.BOLD, 16));
		feed_subject.setBackground(Color.WHITE);
		feed_subject.setBounds(183, 288, 210, 30);
		frame.getContentPane().add(feed_subject);
		
		JLabel label_4 = new JLabel("");
		label_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		label_4.setIcon(new ImageIcon(feedmainimg));
		//label_4.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\feedback_bg.jpg"));
		label_4.setBounds(0, 31, 600, 511);
		frame.getContentPane().add(label_4);
	}
}
