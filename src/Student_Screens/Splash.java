package Student_Screens;

/*################## Front splash window ###################*/

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class Splash {

	private JFrame frame;
	public JProgressBar load;
	public JLabel number;
	public JLabel label_1;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	//public Object loading;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash window2 = new Splash();
					window2.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setUndecorated(true);
		getFrame().setResizable(false);
		getFrame().setBounds(400, 200, 1138, 521);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1138, 521);
		//panel.setBackground(Color.DARK_GRAY);
		panel.setBackground(Color.WHITE);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		number = new JLabel("");
		number.setBackground(new Color(255, 255, 255));
		number.setForeground(new Color(255,83,73));
		number.setFont(new Font("Segoe UI", Font.BOLD, 20));
		number.setBounds(550, 441, 71, 38);
		panel.add(number);
		
		load = new JProgressBar();
		load.setBounds(0, 481, 1138, 40);
		load.setForeground(new Color(51, 255, 153));
		panel.add(load);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Splash.class.getResource("/Assets/Images/classroom_img_300px.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(430, 40, 300, 300);
		panel.add(label);
		
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(508, 353, 30, 30);
		panel.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(550, 353, 30, 30);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(592, 353, 30, 30);
		panel.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(634, 353, 30, 30);
		panel.add(label_4);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
