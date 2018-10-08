import java.io.FileNotFoundException;
import java.io.IOException;

import javax.accessibility.Accessible;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOpenerView 
{

	JFileChooser chooser = new JFileChooser();
	
	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt & html files", "txt", "html"); // specify the file extensions 
	String strDirectory = "";
		
	public FileOpenerView() throws FileNotFoundException, IOException
	{
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{

			strDirectory = chooser.getSelectedFile().toString();	// get the selected directory
			
			generatorView gv = new generatorView(); 
			gv.setVisible(true);
			FileOpenerCntrl fc = new FileOpenerCntrl();		// 
			fc.openFile(strDirectory, gv.generatedText);	// paste the code to the JTextArea
			
		}
			
	}
	
}
	

