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

public class QuizShell extends QuizFunctions
{
private static final long serialVersionUID = -3485284893489L;
	
	public static JLabel question = new JLabel(" What is the code for:");
	public static JLabel longName = new JLabel();
	public static JTextField enterAnswer = new JTextField("");
	public static JTextArea result = new JTextArea();
	private static JButton cancelButton = new JButton("Cancel");
	private static JButton submitButton = new JButton("Submit");
	public static JLabel timer = new JLabel();
	
	private void updateText()
	{
		result.setText(" The answer to the previous question will display here");
		result.setForeground(Color.BLACK);
		result.setEditable(false);
		longName.setText(FULL_NAMES[rand]+"?");
		
		validate();
	}
	
	private JPanel getCenterPanel()
	{
		JPanel tpanel = new JPanel();
		tpanel.setLayout(new GridLayout(1,3));
		tpanel.add(question);
		tpanel.add(longName);
		tpanel.add(enterAnswer);
		
		return tpanel;
	}
	private JPanel getBottomPanel()
	{
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new GridLayout(1,3));
		bpanel.add(timer);
		bpanel.add(submitButton);
		bpanel.add(cancelButton);
		
		submitButton.addActionListener(new SubmitActionListener());
		submitButton.setMnemonic(KeyEvent.VK_ENTER);
		cancelButton.addActionListener(new CancelActionListener());
		
		return bpanel;
	}
	
	public QuizShell()
	{
		setTitle("Amino Acid Quiz: Goodluck!");
		setLocationRelativeTo(null);
		setSize(500,150);
		
		//content
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(result, BorderLayout.NORTH);
		getContentPane().add(getCenterPanel(), BorderLayout.CENTER);
		getContentPane().add(getBottomPanel(), BorderLayout.SOUTH);
		
		new Thread(new TimerRunnable()).start();
		
		updateText();
		setVisible(true);
		//force VM to kill frame in memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
