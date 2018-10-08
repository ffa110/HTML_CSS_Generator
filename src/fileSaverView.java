import java.io.FileFilter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class fileSaverView 
{
	JFileChooser fc = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("html file", "html"); // show only html files
	
	fileSaverCntrl sfc = new fileSaverCntrl();
	
	
	public void saveFile(JTextArea a) throws IOException
	{
		
		fc.setFileFilter(filter); 
		int response = fc.showSaveDialog(null);
		String fileName = "";
		
		if(response == JFileChooser.APPROVE_OPTION)
		{
		fileName = fc.getSelectedFile().toString();
		sfc.saveFile(a, fileName); // save html file 
		
		}
	}
	
	public void viewFile(JTextArea a) throws IOException
	{
		
		fc.setFileFilter(filter);
		int response = fc.showSaveDialog(null);
		String fileName = "";
		
		if(response == JFileChooser.APPROVE_OPTION)
		{
		fileName = fc.getSelectedFile().toString();
		sfc.saveFile(a, fileName); // save html file
		sfc.viewResult(a, fileName); // open the html file using the browser
		
		}
	}
	
	
}