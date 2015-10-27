package lab6_part2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class quizWindow extends JFrame
{
	private static final long serialVersionUID = -3485284893489L;
	
	private JTextArea question = new JTextArea();
	private JTextArea answer = new JTextArea();
	private JTextArea result = new JTextArea();
	private JButton timerButton = new JButton("timer goes here");
	
	private void updateQuestion()
	{
		question.setText("What is the single letter code for 'aminoacid'? \n**updates after result displays**");
		question.setEditable(false);
		validate();
	}
	private void updateAnswer()
	{
		answer.setText("Enter Answer Here: \n**type a letter, press enter to get quick-result (below)**");
		validate();
	}
	private void updateResult()
	{
		result.setText("Show answer to last question.\nDisplay correct or incorrect with correct aa letter.");
		result.setEditable(false);
		validate();
	}
	
	public quizWindow(String title)
	{
		super(title);
		setLocationRelativeTo(null);
		setSize(500,200);
		
		//content
		getContentPane().setLayout(new GridLayout(4,1));
		getContentPane().add(question);
		getContentPane().add(answer);
		getContentPane().add(result);
		getContentPane().add(timerButton);
		
		updateQuestion();
		updateAnswer();
		updateResult();
		setVisible(true);
		//force VM to kill frame in memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new quizWindow("Amino Acid Quiz: Goodluck!");
	}
}
