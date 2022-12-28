package Student_Screens;
/*################## Main Class to run project ###################*/
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import Student_Screens.Login_Window;
import Student_Screens.Splash;

public class Index {

	public static void main(String[] args) {
		Splash window2 = new Splash();
		window2.getFrame().setVisible(true);
		Login_Window window1 = new Login_Window();
		
		for(int i=0;i<=100;i++)
		{
			try {
				Thread.sleep(15);
				window2.number.setText(Integer.toString(i)+"%");
				window2.load.setValue(i);
				if(i==15){
					window2.label_1.setIcon(new ImageIcon(Splash.class.getResource("/Assets/Images/blue_dot.png")));
					
				}
				if(i==30){
					window2.label_2.setIcon(new ImageIcon(Splash.class.getResource("/Assets/Images/red_dot.png")));
					
				}
				if(i==45){
					
					window2.label_3.setIcon(new ImageIcon(Splash.class.getResource("/Assets/Images/yellow_dot.png")));
					
				}
				if(i==60){
					window2.label_4.setIcon(new ImageIcon(Splash.class.getResource("/Assets/Images/green_dot.png")));
				}
				if(i==100)
				{
					
					window1.frame.setVisible(true);
					window2.getFrame().setVisible(false);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

	}

}
