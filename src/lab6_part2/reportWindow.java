package lab6_part2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class reportWindow extends JFrame
{
	private static final long serialVersionUID = 6543345678998L;
	
	private JTextArea report = new JTextArea();
	private JButton redoButton = new JButton("Try Again");	//re-runs quizWindow with previously set time
	private JButton quitButton = new JButton("Close");	//use quitButton from introWindow
	
	private void updateReport()
	{
		report.setText("prints report from amino_acid_drill_EC2.java");
		//probably want this area scrollable, report could be quite long
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
		getContentPane().add(report, BorderLayout.NORTH);
		getContentPane().add(getBottomPanel(), BorderLayout.SOUTH);
		
		updateReport();
		setVisible(true);
		//force VM to kill frame in memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new reportWindow("Amino Acid Quiz: Report");
	}
}
