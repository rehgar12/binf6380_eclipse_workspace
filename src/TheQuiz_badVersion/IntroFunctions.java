package TheQuiz_badVersion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class IntroFunctions extends JFrame
{
	private static final long serialVersionUID = 3535145792123L;
	
	
	public static Integer tryParse(String text)
	{
		try
		{
			return Integer.parseInt(text);
		}
		catch(NumberFormatException e)
		{
			return null;
		}
	}
	
//RUNNABLES************************************************************************************************
	private class IsIntRunnable implements Runnable
	{
		public void run()
		{
			try
			{
				new QuizShell();
				QuizShell.enterAnswer.requestFocus();
				dispose();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	private class NotIntRunnable implements Runnable
	{
		public void run()
		{
			try
			{
				IntroShell.enterTime.requestFocus();
				IntroShell.practiceTime.setText("<html>Not an Integer!<br>(please use digits only)</html>");
				IntroShell.practiceTime.setForeground(Color.RED);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	
//ACTION LISTENERS*****************************************************************************************
	public class StartActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if( tryParse(IntroShell.enterTime.getText()) != null )
			{
				new Thread(new IsIntRunnable()).start();
			}
			else if( IntroShell.enterTime.getText().equals("") )
			{
				new Thread(new IsIntRunnable()).start();
			}
			else
			{
				new Thread(new NotIntRunnable()).start();
			}
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
