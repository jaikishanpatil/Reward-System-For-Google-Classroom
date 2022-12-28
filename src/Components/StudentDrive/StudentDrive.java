package Components.StudentDrive;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class StudentDrive {

	private JFrame frame;

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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentDrive.class.getResource("/Assets/Images/minimize_30px.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(969, 0, 30, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
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
	}

}
