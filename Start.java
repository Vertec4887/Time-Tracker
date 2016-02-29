import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Start {
	static String title = "Time Tracker";
	
	static int width = 400;
	static int height = 400;
	
	static int timerSec = 0;
	static int timerMin = 0;
	static int timerHr = 0;
	static int secValue = 0;
	static int minValue = 0;
	static int hrValue = 0;
	
	static JLabel timerLb1;
	static JLabel timerLb2;
	static JLabel sec;
	static JLabel min;
	static JLabel hr;
	
	static JButton secUp;
	static JButton secDown;
	static JButton minUp;
	static JButton minDown;
	static JButton hrUp;
	static JButton hrDown;
	
	static JFrame frameEditor;
	static JFrame mainFrame;
	
	boolean timerOn = false;
	
	static Icon arrow = new ImageIcon("res/up.png");
	
	
	
	public static void setUp() {
		frameEditor = new JFrame(title);
		frameEditor.setSize(width, height);
		frameEditor.setVisible(true);
		frameEditor.setDefaultCloseOperation(frameEditor.EXIT_ON_CLOSE);
		
		mainFrame = new JFrame();
		mainFrame.setSize(192, 108);
		mainFrame.setUndecorated(true);
		mainFrame.setVisible(true);
		mainFrame.getContentPane().setBackground(Color.BLACK);
		mainFrame.setLayout(new FlowLayout());
		
		timerLb1 = new JLabel(Integer.toString(timerHr) + ":" + Integer.toString(timerMin) + ":" + Integer.toString(timerSec), SwingConstants.CENTER);
		timerLb2 = new JLabel(Integer.toString(timerHr) + ":" + Integer.toString(timerMin) + ":" + Integer.toString(timerSec), SwingConstants.CENTER);
		timerLb2.setForeground(Color.RED);
		timerLb2.setFont(new Font("Serif", Font.BOLD, 50));
		
		sec = new JLabel(Integer.toString(secValue));
		min = new JLabel(Integer.toString(minValue));
		hr = new JLabel(Integer.toString(hrValue));
		
		secUp = new JButton(arrow);
		secUp.setSize(30, 30);
		secDown = new JButton(arrow);
		minUp = new JButton(arrow);
		minDown = new JButton(arrow);
		hrUp = new JButton(arrow);
		hrDown =  new JButton(arrow);
		
		frameEditor.add(timerLb1);
		frameEditor.add(secUp);
		mainFrame.add(timerLb2);
		
		
		
	}
	
	public static void main(String args[]) {
		setUp();
		System.out.println("Hello World");
		
		
		Start start = new Start();
	}
	
	Start() {
		timer();
	}
	
	public void timer() {
		long timeStart = System.currentTimeMillis();
		while (true) {
			long timeNow = System.currentTimeMillis();
			if(timeNow - timeStart > 1000) {
				//System.out.println("One Second");
				timeStart = System.currentTimeMillis();
				tick();
			}
		}
	}
	
	public void tick() {
		
		if(timerOn){
			timerSec ++;
			
			if (timerSec >= 60) {
				timerSec = 0;
				timerMin ++;
				if (timerMin >= 60) {
					timerMin = 0;
					timerHr ++;
				}
			}
			
			timerLb1.setText(Integer.toString(timerHr) + ":" + Integer.toString(timerMin) + ":" + Integer.toString(timerSec));
			timerLb2.setText(Integer.toString(timerHr) + ":" + Integer.toString(timerMin) + ":" + Integer.toString(timerSec));
			//SwingUtilities.updateComponentTreeUI(frameEditor);
		}
	}

}
