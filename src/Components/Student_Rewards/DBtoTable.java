package Components.Student_Rewards;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Assets.Animation_Work.ShortMessage.Notification;
import Assets.Animation_Work.SweetAlart.MessageForRewardRevoke;
import Database.ConfirmationMailToUser;
import Database.Connect;
import Database.Credentials;
import Database.SendEmailConfirmation;
import Student_Screens.Main_Dashbord;
import Student_Screens.UpdaterClass;

import javax.swing.JScrollPane;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;


public class DBtoTable {

	public JFrame frame;
	private JTable table;
	private int xMouse,yMouse;
	private JTextField rdName;
	private JTextField rdPoints;
	private JTextField rdId;
	FileOutputStream outpute;
	String path;
	JLabel rdImage ;
	JLabel showPoints;
	JTextArea rdDescription;
	String rewardCategory,global_username,global_password;
	static StringBuilder returnValue;
	static int remainingPoint;
	UpdaterClass ud=new UpdaterClass();
	static UpdaterClass uc=new UpdaterClass();
	static String rewardId,rewardname;
	static String vendorCategory;
	
	private void errorActionPerformed(MouseEvent arg0) {//GEN-FIRST:event_jButton1ActionPerformed
		Assets.Animation_Work.SweetAlart.Message me = new Assets.Animation_Work.SweetAlart.Message(frame, true);
        me.showAlert();
    }
	
	//######################### Animation ###################
	
	 private void registerActionPerformed(MouseEvent e) {//GEN-FIRST:event_jButton4ActionPerformed
	        Notification panel = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Reward Redeem Successful");
	        panel.showNotification();
	    }
	
	
	//########################## End #########################
	
	
	
	//#########################################################
		// Confirmation message through mail id 
	

//		private static Message prepareMessage(Session session, String myAccountEmail ,String recepient){
//			try{
//				Message message=new MimeMessage(session);
//				message.setFrom(new InternetAddress(myAccountEmail));
//				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//				message.setSubject("Reward Redeem");
//				message.setText("Your reward redeem successfully\n"+"Your current point= "+remainingPoint+"\n Your reward id= "+rewardId+"\nReward name= "+rewardname+"\n"+"\nYour Reward Unique Coupan for redeem reward= "+returnValue);
//				return message;
//				
//			}catch(Exception ex){
//				Logger.getLogger(SendEmailConfirmation.class.getName()).log(Level.SEVERE,null,ex);
//				
//			}
//			return null;
//		}
		
	//########################## END ############
		
		
//		private static Message prepareMessageForVender(Session session, String myAccountEmail ,String recepient){
//			try{
//				Message message=new MimeMessage(session);
//				message.setFrom(new InternetAddress(myAccountEmail));
//				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//				message.setSubject("Reward Redeem");
//				uc.update();
//				message.setText("Student Name= "+uc.pname+"\nReward category= "+vendorCategory+"\nThe Unique Code is= "+returnValue+"\n\n Instruction: You can delete this mail after it been used");
//				return message;
//				
//			}catch(Exception ex){
//				Logger.getLogger(SendEmailConfirmation.class.getName()).log(Level.SEVERE,null,ex);
//				
//			}
//			return null;
//		}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBtoTable window = new DBtoTable();
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
	public DBtoTable() {
		global_username=Credentials.username;
		global_password=Credentials.password;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ud.update();
		frame = new JFrame();
		frame.setBounds(100, 100, 1097, 730);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1097, 730);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 135, 1042, 354);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.BOLD, 16));
		table.setRowMargin(2);
		table.setRowHeight(50);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "Points", "Description", "image", "Categorie"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(123);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(176);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(148);
		table.getColumnModel().getColumn(3).setMinWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(161);
		table.getColumnModel().getColumn(4).setMinWidth(30);
		table.getColumnModel().getColumn(5).setMinWidth(25);
		
		
		//#############################  Rewards Shown from hear #################################
		
				MyQuery mq=new MyQuery();
				ArrayList<Product2> list=mq.BindTable();
				String[] columnName={"ID","Name","Points","Description","Image","Categorie"};
				Object[][] rows=new Object[list.size()][6];
				for(int i=0;i<list.size();i++){
					rows[i][0]=list.get(i).getId();
					rows[i][1]=list.get(i).getName();
					rows[i][2]=list.get(i).getQunt();
					rows[i][3]=list.get(i).getPrice();
					
					if(list.get(i).getMyImage()!=null){
						ImageIcon image=new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage().getScaledInstance(150,120,Image.SCALE_SMOOTH));
						rows[i][4]=image;
					}else{
						rows[i][4]=null;
					}
					
					
					rows[i][5]=list.get(i).getCatId();
					
				}
				TheModel model=new TheModel(rows,columnName);
				table.setModel(model);
				table.setRowHeight(120);
				table.getColumnModel().getColumn(4).setPreferredWidth(150);
				
				
				//############################################
		
		JButton btnGetImages = new JButton("get images");
		btnGetImages.setVisible(false);
		btnGetImages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MyQuery mq=new MyQuery();
				ArrayList<Product2> list=mq.BindTable();
				String[] columnName={"ID","Name","Points","Description","Image","Categorie"};
				Object[][] rows=new Object[list.size()][6];
				for(int i=0;i<list.size();i++){
					rows[i][0]=list.get(i).getId();
					rows[i][1]=list.get(i).getName();
					rows[i][2]=list.get(i).getQunt();
					rows[i][3]=list.get(i).getPrice();
					
					if(list.get(i).getMyImage()!=null){
						ImageIcon image=new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage().getScaledInstance(150,120,Image.SCALE_SMOOTH));
						rows[i][4]=image;
					}else{
						rows[i][4]=null;
					}
					
					
					rows[i][5]=list.get(i).getCatId();
					
				}
				TheModel model=new TheModel(rows,columnName);
				table.setModel(model);
				table.setRowHeight(120);
				table.getColumnModel().getColumn(4).setPreferredWidth(150);
			}
		});
		btnGetImages.setBounds(988, 36, 97, 25);
		panel.add(btnGetImages);
		
		JComboBox reward_categories = new JComboBox(new Object[]{"Learning","Canteen","Railway Pass"});
		reward_categories.setFont(new Font("Segoe UI", Font.BOLD, 16));
		reward_categories.setBackground(Color.WHITE);
		reward_categories.setBounds(12, 82, 210, 30);
		panel.add(reward_categories);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyQueryCat mq=new MyQueryCat();
				String itemCat=(String)reward_categories.getSelectedItem();
				ArrayList<Product2> list=mq.BindTable(itemCat);
				String[] columnName={"ID","Name","Points","Description","Image","Categorie"};
				Object[][] rows=new Object[list.size()][6];
				for(int i=0;i<list.size();i++){
					rows[i][0]=list.get(i).getId();
					rows[i][1]=list.get(i).getName();
					rows[i][2]=list.get(i).getQunt();
					rows[i][3]=list.get(i).getPrice();
					
					if(list.get(i).getMyImage()!=null){
						ImageIcon image=new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage().getScaledInstance(150,120,Image.SCALE_SMOOTH));
						rows[i][4]=image;
					}else{
						rows[i][4]=null;
					}
					rows[i][5]=list.get(i).getCatId();
					
				}
				TheModel model=new TheModel(rows,columnName);
				table.setModel(model);
				table.setRowHeight(120);
				table.getColumnModel().getColumn(4).setPreferredWidth(150);
			}
		});
		label.setIcon(new ImageIcon(DBtoTable.class.getResource("/Assets/Images/done_30px.png")));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(234, 82, 30, 30);
		panel.add(label);
		
		JPanel stud_reward_top = new JPanel();
		stud_reward_top.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse=e.getX();
				yMouse=e.getY();
			}
		});
		stud_reward_top.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				frame.setLocation(x-xMouse, y-yMouse);
			}
		});
		
		stud_reward_top.setLayout(null);
		stud_reward_top.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		stud_reward_top.setBackground(new Color(255, 215, 0));
		stud_reward_top.setBounds(0, 0, 1097, 30);
		panel.add(stud_reward_top);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(frame.ICONIFIED);
			}
		});
		label_1.setBorder(null);
		label_1.setIcon(new ImageIcon(DBtoTable.class.getResource("/Assets/Images/minimize_30px.png")));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(1032, 0, 30, 30);
		stud_reward_top.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				Main_Dashbord md=new Main_Dashbord();
				md.frame.setVisible(true);
			}
		});
		label_2.setBorder(null);
		label_2.setIcon(new ImageIcon(DBtoTable.class.getResource("/Assets/Images/close_30px.png")));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(1067, 0, 30, 30);
		stud_reward_top.add(label_2);
		
		JLabel lblStudentRewards = new JLabel("Student Rewards /");
		lblStudentRewards.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStudentRewards.setBounds(52, 0, 145, 30);
		stud_reward_top.add(lblStudentRewards);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(DBtoTable.class.getResource("/Assets/Images/Classrom_img_20px.png")));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 0, 30, 30);
		stud_reward_top.add(label_4);
		
		JLabel stdName = new JLabel("");
		
		stdName.setText(ud.pname);
		stdName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		stdName.setBounds(203, 0, 145, 30);
		stud_reward_top.add(stdName);
		Image bgimg=new ImageIcon(this.getClass().getResource("/rewards_bg.png")).getImage();
		
		JLabel lblRewards = new JLabel("Rewards");
		lblRewards.setBorder(null);
		lblRewards.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblRewards.setHorizontalAlignment(SwingConstants.CENTER);
		lblRewards.setBounds(444, 43, 210, 38);
		panel.add(lblRewards);
		
		rdName = new JTextField();
		rdName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		rdName.setColumns(10);
		rdName.setEditable(false);
		rdName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		rdName.setBackground(new Color(255, 212, 84));
		rdName.setBounds(147, 551, 210, 30);
		panel.add(rdName);
		
		JLabel label_5 = new JLabel("Name:");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_5.setBounds(22, 550, 84, 30);
		panel.add(label_5);
		
		rdPoints = new JTextField();
		rdPoints.setFont(new Font("Segoe UI", Font.BOLD, 16));
		rdPoints.setColumns(10);
		rdPoints.setEditable(false);
		rdPoints.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		rdPoints.setBackground(new Color(255, 212, 84));
		rdPoints.setBounds(147, 594, 210, 30);
		panel.add(rdPoints);
		
		JLabel label_6 = new JLabel("Points:");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_6.setBounds(22, 594, 84, 30);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Description:");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_7.setBounds(22, 634, 94, 30);
		panel.add(label_7);
		
		rdId = new JTextField();
		rdId.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(rdId.getText().length() !=0){
					if(rdName.getText().length() !=0){
						Connect co=new Connect();
						co.cLogin();
						String qur = "select * from student_rewards where rd_id='"+rdId.getText()+"'";
						InputStream input;
						
						try{
							PreparedStatement pst=co.conn.prepareStatement(qur);
							ResultSet rs=pst.executeQuery();
							File thefile=new File("myImages.png");
							outpute=new FileOutputStream(thefile);
							if(rs.next()){
								
								String id=rs.getString("rd_id");
								String name=rs.getString("rd_name");
								String points=rs.getString("rd_points");
								String description=rs.getString("rd_description");
								String category=rs.getString("rd_category");
								input=rs.getBinaryStream("rd_img");
								byte[] buffer=new byte[input.available()];
								while(input.read(buffer)>0){
									outpute.write(buffer);
								}
								path=thefile.getAbsolutePath();
								ImageIcon myimg=new ImageIcon(path);
								Image img=myimg.getImage();
								Image newImg=img.getScaledInstance(rdImage.getWidth(), rdImage.getHeight(), Image.SCALE_SMOOTH);
								ImageIcon image=new ImageIcon(newImg);
								rdImage.setIcon(image);
								rdName.setText(name);
								rdDescription.setText(description);
								rdPoints.setText(points);
								rewardCategory=category;
								
								
							}
						}catch(SQLException | IOException  e1){
							e1.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Please enter valid Id");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Please enter ID");
				}
			}
		});
		rdId.setFont(new Font("Segoe UI", Font.BOLD, 16));
		rdId.setColumns(10);
		rdId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		rdId.setBackground(new Color(255, 212, 84));
		rdId.setBounds(147, 508, 112, 30);
		panel.add(rdId);
		
		JLabel label_8 = new JLabel("ID:");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_8.setBounds(22, 507, 84, 30);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Reward Image:");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_9.setBounds(400, 522, 120, 30);
		panel.add(label_9);
		
		rdImage = new JLabel("");
		rdImage.setHorizontalAlignment(SwingConstants.CENTER);
		rdImage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		rdImage.setBounds(551, 522, 267, 195);
		panel.add(rdImage);
		
		JLabel lblRedeem = new JLabel("");
		lblRedeem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblRedeem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int curPoint=Integer.parseInt(rdPoints.getText());
				int uspoint=Integer.parseInt(ud.points);
				if(curPoint<=uspoint){
					int reply=JOptionPane.showConfirmDialog(
				            null,
				            "Confirm to Redeem reward?",
				            "",
				            JOptionPane.YES_NO_OPTION);
					if(reply == JOptionPane.YES_OPTION){
						
						String checkPass=JOptionPane.showInputDialog(frame, "Enter Password for redeem reward");
						if(checkPass.equals(ud.password)){
							
	// ##################### Unique code genration for the reward #######################
							final Random RANDOM = new SecureRandom();
						    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
						    int codeLength = 8;
					        returnValue = new StringBuilder(codeLength);
					        for (int i = 0; i < codeLength; i++) {
					            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
					        }
					        
					       int currentpoint=Integer.parseInt(ud.points);
					       int rewardpointtotal=Integer.parseInt(rdPoints.getText());
					       
					       remainingPoint=currentpoint-rewardpointtotal;
					       rewardId=rdId.getText();
					       rewardname=rdName.getText();
					       
			 // Update the points of user who have been using the reward
					       Connect co=new Connect();
					       co.cLogin();
					       String query="UPDATE student_reward_points SET reward_points='"+remainingPoint+"'  WHERE reward_email='"+ud.pemail+"'";
							Statement st=null;
							try {
								st=co.conn.createStatement();
								st.executeUpdate(query);
							} catch (SQLException e2) {
								
								e2.printStackTrace();
							}
					       // END
							ud.update();
							showPoints.setText(ud.points);
					        
					     // Sending mail for the confirmation of the student
							try {
								
								
								//Adding recod to the database for admin chech 
								
								String queryche="insert into reward_record values(?,?,?,?,?)";
								PreparedStatement bonus=co.conn.prepareStatement(queryche);
								bonus.setString(1, rdId.getText());
								bonus.setString(2, rewardCategory);
								bonus.setString(3, ud.pname);
								bonus.setString(4,ud.pemail);
								bonus.setString(5, returnValue.toString());
								bonus.executeUpdate();
								
								registerActionPerformed(e);
								
								//End
								
								//SendEmailConfirmation.sendmail(std_mailid.getText());
								/*confirmUsername=std_username.getText();
								confirmPassword=std_password.getText();*/
	//##################################################Sending Redeem reward msg from here####################################################################
								String subject="Reward Redeem";
								String messages="Your reward redeem successfully\n"+"Your current point= "+remainingPoint+"\n Your reward id= "+rewardId+"\nReward name= "+rewardname+"\n"+"\nYour Reward Unique Coupan for redeem reward= "+returnValue;
								ConfirmationMailToUser confirmationMailToUser= new ConfirmationMailToUser(ud.pemail,subject,messages);
								//// Reward same unique code for that perticular vendor
								
								if(rewardCategory.equals("Learning")){
									
									vendorCategory="Learning";
									uc.update();
									String subjectVend="Reward Redeem";
									String messagesVend="Student Name= "+uc.pname+"\nReward category= "+vendorCategory+"\nThe Unique Code is= "+returnValue+"\n\n Instruction: You can delete this mail after it been used";
									ConfirmationMailToUser confirmationMailToUserVend=new ConfirmationMailToUser("johnc1572@gmail.com",subjectVend,messagesVend);
								}else{
									
								}
								if (rewardCategory.equals("Canteen")) {
									vendorCategory="Canteen";
									uc.update();
									String subjectVend="Reward Redeem";
									String messagesVend="Student Name= "+uc.pname+"\nReward category= "+vendorCategory+"\nThe Unique Code is= "+returnValue+"\n\n Instruction: You can delete this mail after it been used";
									ConfirmationMailToUser confirmationMailToUserVend=new ConfirmationMailToUser("patiljaikishan1@gmail.com",subjectVend,messagesVend);

								} else {

								}
								if (rewardCategory.equals("Railway Pass")) {
									vendorCategory="Railway Pass";
									uc.update();
									String subjectVend="Reward Redeem";
									String messagesVend="Student Name= "+uc.pname+"\nReward category= "+vendorCategory+"\nThe Unique Code is= "+returnValue+"\n\n Instruction: You can delete this mail after it been used";
									ConfirmationMailToUser confirmationMailToUserVend=new ConfirmationMailToUser("johnc1572@gmail.com",subjectVend,messagesVend);

								} else {

								}
								
								
							}catch(Exception e1){
								
							}
							
							//animation popup for successfull redeem reward
							Assets.Animation_Work.ConfirmationMessage.Message me = new Assets.Animation_Work.ConfirmationMessage.Message(frame, true);
					        me.showAlert();
	// ############################################## END ############################
//							JOptionPane.showMessageDialog(null, "reward Redeemded");
					        rdImage.setIcon(null);
							rdName.setText("");
							rdDescription.setText("");
							rdPoints.setText("");
					        
						}else{
							JOptionPane.showMessageDialog(null, "Wrong password");
						}
						
						
					}else{
						
					}
					
				}else{
					MessageForRewardRevoke merr=new MessageForRewardRevoke(frame, true);
					merr.showAlert();
				}	
			}
		});
		lblRedeem.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedeem.setBounds(954, 499, 100, 38);
		
		lblRedeem.setIcon(new ImageIcon(DBtoTable.class.getResource("/Assets/Images/redeem_button.PNG")));
		
		panel.add(lblRedeem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(147, 640, 210, 77);
		panel.add(scrollPane_1);
		
		rdDescription = new JTextArea();
		rdDescription.setFont(new Font("Segoe UI", Font.BOLD, 16));
		rdDescription.setBackground(new Color(255, 212, 84));
		scrollPane_1.setViewportView(rdDescription);
		
		JLabel lblMyPoints = new JLabel("My Points:");
		lblMyPoints.setHorizontalAlignment(SwingConstants.LEFT);
		lblMyPoints.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblMyPoints.setBounds(826, 82, 84, 30);
		panel.add(lblMyPoints);
		
		showPoints = new JLabel("");
		showPoints.setText(ud.points);
		showPoints.setHorizontalAlignment(SwingConstants.LEFT);
		showPoints.setFont(new Font("Segoe UI", Font.BOLD, 16));
		showPoints.setBounds(911, 82, 84, 30);
		panel.add(showPoints);
		
		JLabel label_3 = new JLabel("");
		label_3.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon(bgimg));
		label_3.setBounds(0, 30, 1097, 700);
		panel.add(label_3);
	}
}
