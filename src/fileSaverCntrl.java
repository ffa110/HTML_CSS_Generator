import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextArea;

public class fileSaverCntrl 
{

	BufferedWriter bw = null;
	File file = null;
	
	public void saveFile(JTextArea a, String fileName) throws IOException
	{
		fileName += ".html";
		file = new File(fileName); // locate the file 
		
		
		bw = new BufferedWriter(new FileWriter(file)); // set the file to overwrite it
		bw.write(a.getText()); // write on the file 
		
		bw.close(); // close the buffer
		
	}
	
	public void viewResult(JTextArea a, String dir) throws IOException
	{
		saveFile(a, dir);
		File file = new File(dir+".html"); // add the extension ".html" to the directory to save it as an HTML file
		
		Desktop dp = Desktop.getDesktop();
		dp.open(file); // open the file using the default browser
	}
	
}
