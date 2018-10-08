import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextArea;


public class FileOpenerCntrl 
{

	public void openFile(String dir, JTextArea b) throws FileNotFoundException
	{
		File file = new File(dir);
		Scanner fileScanner = new Scanner(file);
		ArrayList<String> htmlCode = new ArrayList<String>();
		String tempCode = "";
		
		while(fileScanner.hasNextLine())
		{
			htmlCode.add(fileScanner.nextLine()); // store each line in one element
		}
		
		b.setText(null); // set the text area to null
		
		for(int i = 0; i < htmlCode.size(); i++)
		{
			tempCode += htmlCode.get(i) + "\n"; // set string to element from 0 - n and jump to the next line after each element
		}
		
		b.setText(tempCode);	// set full HTML code text area to tempCode string
		
	}
	
	
}
