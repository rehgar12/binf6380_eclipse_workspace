package TheQuiz_badVersion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import javax.swing.JFrame;

public class QuizFunctions extends JFrame
{
	private static final long serialVersionUID = -348263453392123L;
	private TimerRunnable tr = null;

//gate variables
	
//RUNNABLES************************************************************************************************
	public class TimerRunnable implements Runnable
	{
		private volatile boolean cancel = false;
		
		public void setCancel()
		{
			cancel = true;
		}
		
		public void run()
		{
			try
			{
				int defaultTime = 30;
				int counts = 0;
				while( counts>0 && ! cancel );
				{
					if( IntroShell.enterTime.getText().equals("") )
					{
						counts = defaultTime;
						for( int x=defaultTime; x>0; x-- )
						{
							QuizShell.timer.setText(x+" seconds remaining");
							Thread.sleep(1000);
							counts--;
						}
					}
					else
					{
						counts = Integer.parseInt(IntroShell.enterTime.getText());
						for( int x=Integer.parseInt(IntroShell.enterTime.getText()); x>0; x-- )
						{
							QuizShell.timer.setText(x+" seconds remaining");
							Thread.sleep(1000);
							counts--;
						}
					}
				}
				new ReportShell();
				dispose();
	/*			if( cancel == false )
				{
					new ReportShell();
					dispose();
				}
				else
				{
					
				}*/
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	private static final Random RANDOM = new Random();
	public static final String[] SHORT_NAMES = {
		"A","R", "N", "D", "C", "Q", "E",
		"G",  "H", "I", "L", "K", "M", "F",
		"P", "S", "T", "W", "Y", "V" };
	public static final String[] FULL_NAMES = {
		"alanine","arginine", "asparagine",
		"aspartic acid", "cysteine",
		"glutamine",  "glutamic acid",
		"glycine" ,"histidine","isoleucine",
		"leucine",  "lysine", "methionine",
		"phenylalanine", "proline",
		"serine","threonine","tryptophan",
		"tyrosine", "valine" };
	HashMap<String, String> aa_Hash = new HashMap<>();
	{
		for( int x=0; x<SHORT_NAMES.length; x++)
		{
			aa_Hash.put(SHORT_NAMES[x], FULL_NAMES[x]);
		}
	}
	//COUNTERS
	public static int rightCount = 0;
	public static int wrongCount = 0;
	public static int total = rightCount+wrongCount;
	//hashmap for storing answers
	public static LinkedHashMap<String, String> answer_Hash = new LinkedHashMap<>();
	int rand = RANDOM.nextInt(20);
	
	public class QuizRunnable implements Runnable
	{
		public void run()
		{
			try
			{
				if( FULL_NAMES[rand].equals(aa_Hash.get(QuizShell.enterAnswer.getText().toUpperCase())))
				{
					rightCount++;
					total = rightCount+wrongCount;
					QuizShell.result.setText("  Correct! The code for "+FULL_NAMES[rand]+" is "+QuizShell.enterAnswer.getText().toUpperCase()+".");
					QuizShell.result.setForeground(Color.GREEN);
					answer_Hash.put("\nQuestion#"+total, "What is the code for: "+FULL_NAMES[rand]+"?\n	You answered:	"+QuizShell.enterAnswer.getText().toUpperCase()+"\n	Result:	Correct!");
				}
				else
				{
					wrongCount++;
					total = rightCount+wrongCount;
					QuizShell.result.setText("  WRONG! The single letter code for "+FULL_NAMES[rand]+" is "+SHORT_NAMES[rand]+".");
					QuizShell.result.setForeground(Color.RED);
					answer_Hash.put("\nQuestion#"+total, "What is the code for: "+FULL_NAMES[rand]+"?\n	You answered:	"+QuizShell.enterAnswer.getText().toUpperCase()+"\n	Result:	WRONG! The code for "+FULL_NAMES[rand]+" is "+SHORT_NAMES[rand]);
				}
				rand = RANDOM.nextInt(20);
				QuizShell.longName.setText(FULL_NAMES[rand]);
				QuizShell.enterAnswer.setText("");
				QuizShell.enterAnswer.requestFocus();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	
	
//ACTION LISTENERS*****************************************************************************************


	public class SubmitActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new Thread(new QuizRunnable()).start();
		}
	}

	public class CancelActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if( tr != null )
			{
				
			}
			new ReportShell();
			dispose();
		}
	}
}
