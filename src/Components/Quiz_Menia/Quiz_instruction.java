package Components.Quiz_Menia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Student_Screens.Main_Dashbord;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Quiz_instruction {

	public JFrame frame;
	int xMouse,yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz_instruction window = new Quiz_instruction();
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
	public Quiz_instruction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 964, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
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
				frame.setLocation(x-xMouse, y-yMouse);
				
			}
		});
		
		
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(0, 0, 964, 597);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(64, 98, 820, 401);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 796, 375);
		panel_1.add(scrollPane);
		
		JTextPane txtpnDuringTheExam = new JTextPane();
		txtpnDuringTheExam.setEditable(false);
		scrollPane.setViewportView(txtpnDuringTheExam);
		txtpnDuringTheExam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtpnDuringTheExam.setText("During the Exam:\r\n\r\n1) The student may not use his/her notebook, course note, or recive help from proctor or any other outside source\r\n\r\n2) Student must complete 10 questions multiple choice exam within the 5 minute and also the each question have only 20 second of time, Time frame allocated for the exam\r\n\r\n3) Student must not stop the session and then return to it. This is important in online envornment where the system will \"time-out\" and not allow the student to re-enter the exam.\r\n\r\nNumber of question: 10\r\nTotal marks: 10\r\nReward points will be multiply by 10, eg. If student got 8 right answer means 8 marks and then 8*10 = 80 will be reward points\r\nExam Duration: 5 min\r\nAll the best....!");
		
		JLabel lblInstruction = new JLabel("* INSTRUCTION");
		lblInstruction.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblInstruction.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstruction.setBounds(69, 55, 191, 30);
		panel.add(lblInstruction);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Student_Quiz sq=new Student_Quiz();
				sq.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton.setBounds(314, 525, 178, 37);
		panel.add(btnNewButton);
		
		JLabel lblQuizMenia = new JLabel("Quiz Mania");
		lblQuizMenia.setForeground(new Color(0, 139, 139));
		lblQuizMenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuizMenia.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblQuizMenia.setBounds(364, 13, 191, 30);
		panel.add(lblQuizMenia);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Main_Dashbord md=new Main_Dashbord();
				md.frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnBack.setBounds(504, 525, 191, 37);
		panel.add(btnBack);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Quiz_instruction.class.getResource("/Assets/Images/close_30px.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setFont(new Font("Segoe UI", Font.BOLD, 16));
		button.setBounds(922, 13, 30, 30);
		panel.add(button);
	}
}
