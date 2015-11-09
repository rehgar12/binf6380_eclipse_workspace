package lab8_part1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import prefuse.util.ui.UILib;

public class RadialGraphView_addMenu
{
	
	
	
	//the reworked main method, adding the jmenu
    public static void main(String argv[]) {
        String infile = DATA_FILE;
        String label = "name";
        
        if ( argv.length > 1 ) {
            infile = argv[0];
            label = argv[1];
        }
        
        UILib.setPlatformLookAndFeel();
        
        JFrame frame = new JFrame("p r e f u s e  |  r a d i a l g r a p h v i e w");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //have to leave for initialization
        frame.setContentPane(demo(infile, label));

        //adding menu bar
        frame.setJMenuBar(getMyMenuBar(frame));
        		  
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
    //menuBar
    public static JMenuBar getMyMenuBar(final JFrame parentFrame)
    {
    	JMenuBar jmenuBar = new JMenuBar();
    	
    	JMenu fileMenu = new JMenu("File");
    	fileMenu.setMnemonic('F');
    	jmenuBar.add(fileMenu);
    	
    	JMenuItem openItem = new JMenuItem("Open");
    	openItem.setMnemonic('O');
    	fileMenu.add(openItem);
    	
    	//file chooser dialog and getting the filename as input for contentpane
    	openItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(jfc);
				File file = jfc.getSelectedFile();
				if( file != null )
				{
					parentFrame.setContentPane(demo(file.getAbsolutePath(), "name"));
					parentFrame.revalidate();
				}
		        
			}
		});
    	
    	return jmenuBar;
    }

    
    
    
    
}
