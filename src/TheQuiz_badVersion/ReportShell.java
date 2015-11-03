package TheQuiz_badVersion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReportShell extends ReportFunctions
{
	private static final long serialVersionUID = 6543345678998L;
	
	private JLabel header = new JLabel("How did you do?");
	private JTextArea report = new JTextArea();
	JScrollPane scroll = new JScrollPane (report, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private JButton redoButton = new JButton("Try Again");	//re-runs quizWindow with previously set time
	private static JButton closeButton = new JButton("Close");
	
	private void updateText()
	{
		report.setText("Summary Report: You answered "+QuizFunctions.rightCount+" correct out of "+QuizFunctions.total+" attempted.\n");
		//REPORT
		Object[] keyArray = QuizFunctions.answer_Hash.keySet().toArray();
		for( Object key : keyArray )
		{
			report.append(key+"	"+QuizFunctions.answer_Hash.get(key));
		}
		report.setEditable(false);
		validate();
	}
	
	private JPanel getBottomPanel()
	{
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new GridLayout(0,2));
		bpanel.add(redoButton);	//tooltip, click or press Enter to re-start the quiz. 
		bpanel.add(closeButton);
		
		redoButton.addActionListener(new RedoActionListener());
		closeButton.addActionListener(new CloseActionListener());
		
		return bpanel;
	}
	
	public ReportShell()
	{
		setTitle("Amino Acid Quiz: Report");
		setLocationRelativeTo(null);
		setSize(500,450);
		
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
}

