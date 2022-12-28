package Admin_Screens;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Database.Connect;
import Student_Screens.TimeTableUpdate;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.EtchedBorder;

public class Stdunt_Timetable {

	public JFrame frame;
	FileOutputStream outpute;
	JLabel ttimg;
	int xMouse,yMouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stdunt_Timetable window = new Stdunt_Timetable();
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
	public Stdunt_Timetable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TimeTableUpdate ttu=new TimeTableUpdate();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 948, 594);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 948, 30);
		frame.getContentPane().add(panel);
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
		
		JLabel lblMainDashbord = new JLabel("Main Dashbord");
		lblMainDashbord.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblMainDashbord.setBounds(40, 0, 122, 30);
		panel.add(lblMainDashbord);
		
		JLabel lblTimeTable = new JLabel("/ Time Table");
		lblTimeTable.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTimeTable.setBounds(164, 0, 166, 30);
		panel.add(lblTimeTable);
		
		JLabel label_2 = new JLabel("");
		Image smallmainimg=new ImageIcon(this.getClass().getResource("/Classrom_img_20px.png")).getImage();
		label_2.setIcon(new ImageIcon(smallmainimg));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(0, 0, 30, 30);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		Image mainminimizeimg=new ImageIcon(this.getClass().getResource("/minimize_30px.png")).getImage();
		label_3.setIcon(new ImageIcon(mainminimizeimg));
		label_3.setBounds(877, 0, 30, 30);
		panel.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		Image maincloseimg=new ImageIcon(this.getClass().getResource("/close_30px.png")).getImage();
		label_4.setIcon(new ImageIcon(maincloseimg));
		label_4.setBounds(916, 0, 30, 30);
		panel.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(0, 30, 947, 562);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_5 = new JLabel("Time Table");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_5.setBounds(380, 13, 176, 30);
		panel_1.add(label_5);
		
		ttimg = new JLabel("");
		ttimg.setBounds(58, 56, 830, 448);
		panel_1.add(ttimg);
		ImageIcon myimg=new ImageIcon(ttu.path);
		Image img=myimg.getImage();
		Image newImg=img.getScaledInstance(ttimg.getWidth(), ttimg.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(newImg);
		ttimg.setIcon(image);
		JLabel label = new JLabel("");
		label.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		Image bgimg=new ImageIcon(this.getClass().getResource("/timetable_bg.png")).getImage();
		label.setIcon(new ImageIcon(bgimg));
		label.setBounds(0, 0, 947, 562);
		panel_1.add(label);
		
		
		
	}
}
