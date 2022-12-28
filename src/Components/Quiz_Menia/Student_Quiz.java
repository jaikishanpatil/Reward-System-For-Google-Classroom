package Components.Quiz_Menia;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Database.Connect;
import Student_Screens.Main_Dashbord;
import Student_Screens.UpdaterClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Student_Quiz {

	public JFrame frame;
	JLabel runmin,runsec,questionNumber,quemin,quesec,label;
	private int yMouse,xMouse;
	public String QuestionId="1";
	String answer;
	int min=0,sec=0,marks=0;
	int min1=0,sec1=0;
	JButton btnSubmit,btnNext;
	JTextPane question;
	JRadioButton optionA,optionB,optionC,optionD;
	SimpleDateFormat sdtf=new SimpleDateFormat("dd-MM-yyyy");
	Date date=new Date();
	JLabel yourMarks;
	UpdaterClass uc=new UpdaterClass();
	ButtonGroup btn=new ButtonGroup();
	Timer time,time1;
	int rightans=0;
	int count=0;
	int Quenumlbl=1;
	Random r=new Random();
	int randomvalue=r.nextInt(3)+1;
	
	public void answerCheck(){
		String studentanswer=null;
		if(optionA.isSelected()){
			studentanswer=optionA.getText();
		}
		else if(optionB.isSelected()){
			studentanswer=optionB.getText();
		}
		else if(optionC.isSelected()){
			studentanswer=optionC.getText();
		}
		else if(optionD.isSelected()){
			studentanswer=optionD.getText();
		}
		if(studentanswer.equals(answer)){
			marks=marks+1;
			rightans++;
			String mark1=String.valueOf(marks);
			yourMarks.setText(mark1);
		}
		int questionid=Integer.parseInt(QuestionId);
		questionid=questionid+randomvalue;
		QuestionId=String.valueOf(questionid);
		questionNumber.setText(String.valueOf(Quenumlbl));
		Quenumlbl++;
		count++;
		sec1 = 0;
		if(count==10){
			btnNext.setVisible(false);
		}
	}
	
	public void question(){
		try{
			Connect co=new Connect();
			co.cLogin();
			Random rd=new Random();
			// Randome value genrate and then check the double value of random
			// Randome value range will be deside by the range value of the current quiz table question count
			String query="select * from quiz_questions where q_id='"+QuestionId+"'";
			
			Statement st;
			st = co.conn.createStatement();
			co.rs=st.executeQuery(query);
			while(co.rs.next()){
				//JOptionPane.showMessageDialog(null, "Connected");
				question.setText(co.rs.getString("q_name"));
				optionA.setText(co.rs.getString("q_opt1"));
				optionB.setText(co.rs.getString("q_opt2"));
				optionC.setText(co.rs.getString("q_opt3"));
				optionD.setText(co.rs.getString("q_opt4"));
				answer=co.rs.getString("q_answer");
				
			}
		}catch(Exception e){
			
		}
	}
	
	public void submit(){
		answerCheck();
		try{
			Connect co=new Connect();
			co.cLogin();
			uc.update();
			int oldpoint=Integer.parseInt(uc.points);
			int newpoint=marks*10;
			int total=oldpoint+newpoint;
			String query="update student_reward_points set reward_points='"+String.valueOf(total)+"' where reward_email='"+uc.pemail+"'";
			Statement st=null;
			st=co.conn.createStatement();
			st.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Successfully Completed the quiz");
			frame.dispose();
			Main_Dashbord md=new Main_Dashbord();
			md.frame.setVisible(true);
			
			// new date of privous date ######################################
			final long ONE_DAY_MILLI_SECONDS = 48 * 60 * 60 * 1000;
			Date dt=sdtf.parse(sdtf.format(date));
			long nextDayMilliSeconds = date.getTime() + ONE_DAY_MILLI_SECONDS;
			Date nextDate = new Date(nextDayMilliSeconds);
			String nextDateStr = sdtf.format(nextDate);
			
			// jeva submit karel teva ek database create karila lagel ane tyt nntr ek email and ek date takun mag tyla fetch karila lagel teva samjel ke tyne te open kely ke nahe 
			String updatequizstatus="update quiz_status set qs_lastdate='"+sdtf.format(date)+"' , qs_status='1' , qs_newdate='"+nextDateStr+"' where qs_email='"+uc.pemail+"'";
			st=co.conn.createStatement();
			st.executeUpdate(updatequizstatus);
			
			label.setVisible(true);
			JOptionPane.showInternalMessageDialog(null, "You have successfully complete the quiz with "+rightans+" Questions and total marks is "+marks);
		}catch(Exception e){
			
		}
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Quiz window = new Student_Quiz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Student_Quiz() {
		initialize();
	
	}
	private void initialize() {
	
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1191, 624);
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
		uc.update();
	
		
		
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 1191, 30);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentDashboard = new JLabel("Student Dashboard");
		lblStudentDashboard.setBounds(52, 0, 164, 30);
		lblStudentDashboard.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panel.add(lblStudentDashboard);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(12, 0, 30, 30);
		label_3.setIcon(new ImageIcon(Student_Quiz.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label_3);
		
		label = new JLabel("");
		label.setBounds(1161, 1, 30, 30);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Main_Dashbord md=new Main_Dashbord();
				md.frame.setVisible(true);
				
				
			}
		});
		label.setVisible(false);
		label.setIcon(new ImageIcon(Student_Quiz.class.getResource("/Assets/Images/close_30px.png")));
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(1129, 0, 30, 30);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		label_1.setIcon(new ImageIcon(Student_Quiz.class.getResource("/Assets/Images/minimize_30px.png")));
		panel.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(0, 31, 1191, 593);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(152, 251, 152));
		panel_2.setBounds(0, 0, 1191, 113);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME TO QUIZ ");
		lblWelcome.setFont(new Font("Segoe Script", Font.BOLD, 28));
		lblWelcome.setBounds(43, 31, 343, 46);
		panel_2.add(lblWelcome);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDate.setBounds(540, 40, 46, 28);
		panel_2.add(lblDate);
		
		
		
		
		JLabel quizdate = new JLabel(sdtf.format(date));
		quizdate.setFont(new Font("Segoe UI", Font.BOLD, 16));
		quizdate.setBounds(597, 41, 145, 28);
		panel_2.add(quizdate);
		
		JLabel lblTotalTime = new JLabel("Total time:");
		lblTotalTime.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTotalTime.setBounds(945, 13, 82, 28);
		panel_2.add(lblTotalTime);
		
		JLabel lblMin = new JLabel("5 Min");
		lblMin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblMin.setBounds(1048, 13, 101, 28);
		panel_2.add(lblMin);
		
		JLabel lblTimeTaken = new JLabel("Time Taken:");
		lblTimeTaken.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTimeTaken.setBounds(945, 49, 92, 28);
		panel_2.add(lblTimeTaken);
		
		runmin = new JLabel("");
		runmin.setForeground(Color.RED);
		runmin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		runmin.setBounds(1048, 49, 26, 28);
		panel_2.add(runmin);
		
		runsec = new JLabel("");
		runsec.setForeground(Color.RED);
		runsec.setFont(new Font("Segoe UI", Font.BOLD, 16));
		runsec.setBounds(1071, 49, 26, 28);
		panel_2.add(runsec);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(152, 251, 152));
		panel_3.setBounds(0, 113, 290, 480);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll Number:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 51, 95, 25);
		panel_3.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblName.setBounds(12, 85, 46, 25);
		panel_3.add(lblName);
		
		JLabel lblTotalQuestions = new JLabel("Total Questions:");
		lblTotalQuestions.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTotalQuestions.setBounds(12, 162, 107, 25);
		panel_3.add(lblTotalQuestions);
		
		JLabel lblYourMarks = new JLabel("Your Marks:");
		lblYourMarks.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblYourMarks.setBounds(12, 238, 95, 25);
		panel_3.add(lblYourMarks);
		
		JLabel lblQuestionNumber = new JLabel("Question Number:");
		lblQuestionNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblQuestionNumber.setBounds(12, 200, 122, 25);
		panel_3.add(lblQuestionNumber);
		
		JLabel label_4 = new JLabel("46");
		label_4.setText(uc.proll);
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_4.setBounds(107, 51, 171, 25);
		panel_3.add(label_4);
		
		JLabel lblJaikishanDhanajiPatil = new JLabel("Jaikishan Dhanaji Patil");
		lblJaikishanDhanajiPatil.setText(uc.name);
		lblJaikishanDhanajiPatil.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblJaikishanDhanajiPatil.setBounds(60, 85, 218, 25);
		panel_3.add(lblJaikishanDhanajiPatil);
		
		questionNumber = new JLabel("00");
		questionNumber.setText(QuestionId);
		
		questionNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		questionNumber.setBounds(137, 200, 122, 25);
		panel_3.add(questionNumber);
		
		JLabel label_8 = new JLabel("10");
		label_8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_8.setBounds(137, 161, 122, 25);
		panel_3.add(label_8);
		
		yourMarks = new JLabel("00");
		yourMarks.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yourMarks.setBounds(137, 238, 122, 25);
		panel_3.add(yourMarks);
		
		JLabel lblPrnNumber = new JLabel("PRN Number:");
		lblPrnNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPrnNumber.setBounds(12, 13, 95, 25);
		panel_3.add(lblPrnNumber);
		
		JLabel label_7 = new JLabel("191042002");
		label_7.setText(uc.pprn);
		label_7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_7.setBounds(107, 13, 171, 25);
		panel_3.add(label_7);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmail.setBounds(12, 123, 46, 25);
		panel_3.add(lblEmail);
		
		JLabel label_9 = new JLabel((String) null);
		label_9.setText(uc.pemail);
		label_9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_9.setBounds(60, 123, 218, 25);
		panel_3.add(label_9);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(new Color(255, 165, 0));
		panel_4.setBounds(290, 113, 901, 480);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblQuestions = new JLabel("Question");
		lblQuestions.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQuestions.setBounds(12, 13, 92, 44);
		panel_4.add(lblQuestions);
		
		question = new JTextPane();
		question.setEditable(false);
		question.setBackground(new Color(255, 165, 0));
		question.setFont(new Font("Segoe UI", Font.BOLD, 16));
		question.setBounds(12, 75, 877, 64);
		panel_4.add(question);
		
		optionA = new JRadioButton("");
		optionA.setFont(new Font("Segoe UI", Font.BOLD, 16));
		optionA.setBackground(new Color(255, 165, 0));
		optionA.setBounds(82, 173, 784, 30);
		panel_4.add(optionA);
		
		optionB = new JRadioButton("");
		optionB.setFont(new Font("Segoe UI", Font.BOLD, 16));
		optionB.setBackground(new Color(255, 165, 0));
		optionB.setBounds(82, 217, 784, 30);
		panel_4.add(optionB);
		
		optionC = new JRadioButton("");
		optionC.setFont(new Font("Segoe UI", Font.BOLD, 16));
		optionC.setBackground(new Color(255, 165, 0));
		optionC.setBounds(82, 264, 784, 30);
		panel_4.add(optionC);
		
		optionD = new JRadioButton("");
		optionD.setFont(new Font("Segoe UI", Font.BOLD, 16));
		optionD.setBackground(new Color(255, 165, 0));
		optionD.setBounds(82, 310, 784, 30);
		panel_4.add(optionD);
		btn.add(optionA);
		btn.add(optionB);
		btn.add(optionC);
		btn.add(optionD);
		
		try{
			Connect co=new Connect();
			co.cLogin();
			String query="select * from quiz_questions where q_id='"+QuestionId+"'";
			
			Statement st;
			st = co.conn.createStatement();
			co.rs=st.executeQuery(query);
			while(co.rs.next()){
				//JOptionPane.showMessageDialog(null, "Connected");
				question.setText(co.rs.getString("q_name"));
				optionA.setText(co.rs.getString("q_opt1"));
				optionB.setText(co.rs.getString("q_opt2"));
				optionC.setText(co.rs.getString("q_opt3"));
				optionD.setText(co.rs.getString("q_opt4"));
				answer=co.rs.getString("q_answer");
				questionNumber.setText(String.valueOf(Quenumlbl));
				Quenumlbl++;
			}
		}catch(Exception e){
			
		}
		
		// set Timer to the time bar
		
		
		time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				runmin.setText(String.valueOf(min));
				runsec.setText(String.valueOf(sec));

				if (sec == 60) {
					sec = 0;
					min++;
					if (min == 5) {
						time.stop();
						answerCheck();
						submit();
					}
				}
				sec++;
			}

		});
		time.start();

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				answerCheck();
				question();

			}
		});
		//btnNext.setIcon(new ImageIcon(Student_Quiz.class.getResource("/Classrom_img_20px.png")));
		btnNext.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNext.setBounds(264, 367, 108, 35);
		panel_4.add(btnNext);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to submit?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0){
					answerCheck();
					submit();
				}
			}
		});
		//btnSubmit.setIcon(new ImageIcon(Student_Quiz.class.getResource("/icons8-submit-58")));
		btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnSubmit.setBounds(491, 367, 108, 35);
		panel_4.add(btnSubmit);
		
		quesec = new JLabel("");
		quesec.setForeground(Color.RED);
		quesec.setFont(new Font("Segoe UI", Font.BOLD, 16));
		quesec.setBounds(863, 13, 26, 28);
		panel_4.add(quesec);
		
		quemin = new JLabel("");
		quemin.setForeground(Color.RED);
		quemin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		quemin.setBounds(840, 13, 26, 28);
		panel_4.add(quemin);
		
		JLabel lblsecTimeFor = new JLabel("20 sec Time for each question");
		lblsecTimeFor.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblsecTimeFor.setBounds(598, 13, 230, 28);
		panel_4.add(lblsecTimeFor);
		
		// set Timer to the time bar
		
		
		time1 = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				quemin.setText(String.valueOf(min1));
				quesec.setText(String.valueOf(sec1));

				if (sec1 == 20) {
					sec1 = 0;
					answerCheck();
					question();
					if(QuestionId.equals("10")){
						btnNext.setVisible(false);
						time1.stop();
					}
				}
				sec1++;
			}

		});
		time1.start();

	}
}
