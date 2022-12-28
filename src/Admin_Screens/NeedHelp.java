package Admin_Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class NeedHelp {

	public JFrame frame;
	private int xMouse,yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NeedHelp window = new NeedHelp();
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
	public NeedHelp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 200, 500, 700);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 700);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
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
				frame.setLocation(x-xMouse, y-yMouse);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setBounds(0, 30, 499, 669);
		panel.add(scrollPane);
		
		JTextPane txtpnEasyToUse = new JTextPane();
		txtpnEasyToUse.setEditable(false);
		txtpnEasyToUse.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setViewportView(txtpnEasyToUse);
		txtpnEasyToUse.setText("EASY TO USE\nSave time and simplify everyday tasks\nFree edition\nSwitch from class to assignment to student in just a few clicks\n\nTrack student progress in your gradebook and export scores to your school\u2019s student information system (SIS)\n\nKeep grading consistent and transparent with rubrics displayed alongside student work\n\nStore frequently used phrases in a customizable comment bank\n\nPrepare and schedule tasks, assignments, and quizzes across multiple classes\n\nENRICH\nEnhance student learning experiences\nFree edition\nGive students the ability to adjust accessibility settings so they can learn in the way that works best for them \u2014 even in multiple languages\n\nKeep everyone on track with student to-do and teacher to-review pages, and due dates that automatically appear on student calendars when classwork is created\n\nUpload coursework documents automatically as templates to give each student their own copy of an assignment when it is created\n\nEnable students to check their own work for recommended citations by scanning it against hundreds of billions of web pages and over 40 million books with originality reports\n\nAllow students to snap and submit a picture of their paper homework quickly and easily with improved image capturing\n\nMANAGE\nOperate with ease using tools for visibility, insights, and control\nFree edition\nAccess Classroom audit logs right from the Admin console to investigate events in depth and pinpoint performance or security issues\n\nUse reports to investigate issues \u2014 like who deleted a student or class \u2014 and bring learning back online quickly and easily\n\nServe educational communities of any size\n\nSECURE\nStay secure and compliant\nRely on our global network built with multilayered, full-stack security that can handle extreme shifts in demand, and a guaranteed 99.9% uptime\n\nUpholds the most rigorous global education standards for security and privacy \u2014 and is regularly audited by third-party organizations\n\nUse Classroom 100% ad-free, plus students\u2019 personal information will not be used to create ad profiles for targeting\n\nEnsure only account holders with a unique sign-in can access a Google for Education domain, plus restrict all class activity to class members only\n\n\u201COf all the technology solutions I have used within education, Google Classroom and it Reward System has had the most dramatic impact on teaching and learning from the very moment I used it in my education.\u201D");
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Image needhelimg=new ImageIcon(this.getClass().getResource("/helpbg.jpg")).getImage();
		label_2.setIcon(new ImageIcon(needhelimg));
		//label_2.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\helpbg.JPG"));
		label_2.setBounds(0, 30, 500, 670);
		panel.add(label_2);
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 500, 30);
		panel.add(panel_1);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		Image needminimizeimg=new ImageIcon(this.getClass().getResource("/minimize_30px.png")).getImage();
		label.setIcon(new ImageIcon(needminimizeimg));
		//label.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-subtract-30.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(431, 0, 30, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		Image needcloseimg=new ImageIcon(this.getClass().getResource("/close_30px.png")).getImage();
		label_1.setIcon(new ImageIcon(needcloseimg));
		//label_1.setIcon(new ImageIcon("C:\\Users\\JAIKISHAN\\workspace\\Reward System For Google Classroom (Final year Project)\\Images\\loginScreen\\icons8-close-30.png"));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(470, 0, 30, 30);
		panel_1.add(label_1);
		
		JLabel lblNeedHelp = new JLabel("Need Help ?");
		lblNeedHelp.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNeedHelp.setBounds(52, 0, 112, 30);
		panel_1.add(lblNeedHelp);
		
		JLabel label_3 = new JLabel("");
		Image needtopimg=new ImageIcon(this.getClass().getResource("/Classrom_img_20px.png")).getImage();
		label_3.setIcon(new ImageIcon(needtopimg));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 0, 30, 30);
		panel_1.add(label_3);
	}
}
