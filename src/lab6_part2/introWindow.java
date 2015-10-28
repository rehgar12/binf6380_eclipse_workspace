package lab6_part2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class introWindow extends JFrame
{
	private static final long serialVersionUID = -348528394792123L;
	
	private JTextArea instructions = new JTextArea();
	private JLabel practiceTime = new JLabel();
	private JTextField enterTime = new JTextField();
	private JButton startButton = new JButton("Start Quiz");
	private JButton quitButton = new JButton("Close");
	
	private void updateText()
	{
		instructions.setText("This is a quiz to drill your knowledge of the single letter codes for the 20 amino acids.\nHow long would you like to practice? (Default is 30 seconds)");
		instructions.setLineWrap(true);
		instructions.setEditable(false);
		
		practiceTime.setText("Enter number of seconds:");
		validate();
	}
	private JPanel getTimePanel()
	{
		JPanel tpanel = new JPanel();
		tpanel.setLayout(new GridLayout(0,2));
		tpanel.add(practiceTime);
		tpanel.add(enterTime);
		
		return tpanel;
	}
	private JPanel getBottomPanel()
	{
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new GridLayout(0,2));
		bpanel.add(startButton);	//tooltip, click or press Enter to start the quiz. 
		bpanel.add(quitButton);
		
		return bpanel;
	}
	
	public introWindow(String title)
	{
		super(title);
		//sets frame to middle of the screen / alt quizFrame.setLocation(x,y);
		setLocationRelativeTo(null);
		setSize(500,100);
		
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
	public static void main(String[] args)
	{
		new introWindow("Amino Acid Quiz: Welcome!");
	}
}
