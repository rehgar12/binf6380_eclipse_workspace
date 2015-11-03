package TheQuiz_badVersion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ReportFunctions extends JFrame
{
	private static final long serialVersionUID = 4746592123L;
	
	
//RUNNABLES************************************************************************************************
	public class RedoRunnable implements Runnable
	{
		public void run()
		{
			try
			{
				new IntroShell();
				IntroShell.enterTime.requestFocus();
				dispose();
				//variable resets
				//Intro time
				IntroShell.enterTime.setText("");
				//Quiz counters and report hashmap
				QuizFunctions.rightCount = 0;
				QuizFunctions.wrongCount = 0;
				QuizFunctions.total = 0;
				QuizFunctions.answer_Hash.clear();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	
//ACTION LISTENERS*****************************************************************************************
	public class RedoActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new Thread(new RedoRunnable()).start();
		}
	}
	public class CloseActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}	
}
