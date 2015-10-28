package lab6_part2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class reportWindow extends JFrame
{
	private static final long serialVersionUID = 6543345678998L;
	
	private JLabel header = new JLabel("How did you do?");
	private JTextArea report = new JTextArea();
	JScrollPane scroll = new JScrollPane (report, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private JButton redoButton = new JButton("Try Again");	//re-runs quizWindow with previously set time
	private JButton quitButton = new JButton("Close");	//use quitButton from introWindow
	
	private void updateText()
	{
		report.setText("prints report from amino_acid_drill_EC2.java.");
		report.setEditable(false);
		validate();
	}
	
	private JPanel getBottomPanel()
	{
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new GridLayout(0,2));
		bpanel.add(redoButton);	//tooltip, click or press Enter to re-start the quiz. 
		bpanel.add(quitButton);
		
		return bpanel;
	}
	
	public reportWindow(String title)
	{
		super(title);
		setLocationRelativeTo(null);
		setSize(500,200);
		
		//content
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(header, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);
		getContentPane().add(getBottomPanel(), BorderLayout.SOUTH);
		
		
		updateText();
		setVisible(true);
		//force VM to kill frame in memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new reportWindow("Amino Acid Quiz: Report");
	}
}
