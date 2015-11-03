package TheQuiz_badVersion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class IntroShell extends IntroFunctions
{
	private static final long serialVersionUID = -43628394792123L;
	
	public static JTextArea instructions = new JTextArea();
	public static JLabel practiceTime = new JLabel();
	public static JTextField enterTime = new JTextField("");
	public static JButton startButton = new JButton("Start Quiz");
	private static JButton closeButton = new JButton("Close");
	
	private void updateText()
	{
		instructions.setText("This is a quiz to drill your knowledge of the single letter codes for the 20 amino acids.\nHow long would you like to practice? (Default is 30 seconds)");
		instructions.setLineWrap(true);
		instructions.setEditable(false);
		
		practiceTime.setText("Enter number of seconds:");
		practiceTime.setHorizontalAlignment(JLabel.CENTER);
		practiceTime.setForeground(Color.BLACK);
		validate();
	}
	private JPanel getTimePanel()
	{
		JPanel tpanel = new JPanel();
		tpanel.setLayout(new GridLayout(1,2));
		tpanel.add(practiceTime);
		tpanel.add(enterTime);
		
		return tpanel;
	}
	private JPanel getBottomPanel()
	{
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new GridLayout(1,2));
		bpanel.add(startButton); 
		bpanel.add(closeButton);
		
		startButton.addActionListener(new StartActionListener());
		startButton.setMnemonic(KeyEvent.VK_ENTER);
		closeButton.addActionListener(new CloseActionListener());
		
		return bpanel;
	}
	
	//constructor
	public IntroShell()
	{
		setTitle("Amino Acid Quiz: Welcome");
		//sets frame to middle of the screen / alt quizFrame.setLocation(x,y);
		setLocationRelativeTo(null);
		setSize(500,150);
		
		//adding content
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(instructions, BorderLayout.NORTH);
		getContentPane().add(getTimePanel(), BorderLayout.CENTER);
		getContentPane().add(getBottomPanel(), BorderLayout.SOUTH);		
		
		updateText();
		setVisible(true);
		//force VM to kill frame in memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}