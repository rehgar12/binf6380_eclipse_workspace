package lab6_part2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class quizWindow extends JFrame
{
	private static final long serialVersionUID = -3485284893489L;
	
	private JLabel question = new JLabel();
	private JTextField enterAnswer = new JTextField();
	private JTextArea result = new JTextArea();
	private JButton cancelButton = new JButton("Cancel");
	private JLabel timer = new JLabel();
	
	private void updateText()
	{
		question.setText("long name of aminoacid here:"); //updates after result displays below
		result.setText("Show answer to last question here"); //Display correct or incorrect with correct aa letter.
		result.setEditable(false);
		
		validate();
	}
	private void updateTimer()
	{
		timer.setText("time remaing(s)");
		
		validate();
	}
	
	
	
	private JPanel getTopPanel()
	{
		JPanel tpanel = new JPanel();
		tpanel.setLayout(new GridLayout(0,2));
		tpanel.add(question);
		tpanel.add(enterAnswer);
		
		return tpanel;
	}
	private JPanel getBottomPanel()
	{
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new GridLayout(0,2));
		bpanel.add(timer);
		bpanel.add(cancelButton);
		return bpanel;
	}
	
	public quizWindow(String title)
	{
		super(title);
		setLocationRelativeTo(null);
		setSize(500,100);
		
		//content
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(getTopPanel(), BorderLayout.NORTH);
		getContentPane().add(result, BorderLayout.CENTER);
		getContentPane().add(getBottomPanel(), BorderLayout.SOUTH);
		
		updateText();
		updateTimer();
		setVisible(true);
		//force VM to kill frame in memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new quizWindow("Amino Acid Quiz: Goodluck!");
	}
}
