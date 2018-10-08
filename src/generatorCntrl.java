import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jsoup.Jsoup;


public class generatorCntrl 
{
	generatorModel gm = new generatorModel();
	
	
	/**
	 * This method uses the generatorModel to retrieve HTML tags and alter them to generate HTML codes based on user's requirement
	 * @param row
	 * @param text
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String htmlTag(int row, String text) throws FileNotFoundException, IOException
	{		
		
		String test = gm.readExcel(row, 1, "HTML tags.xls");	
		String strCode = "";
		boolean bFound = false;
		
		for(int i = 0; i < test.length(); i++)
		{
			
			if(bFound == false)
			{		
				if(test.charAt(i) == '>') // find '>' then add text after it
				{
					bFound = true;	// if the arrow was found, set bFound to true
					strCode = test.substring(0, i+1) + text + test.substring(i+1);	// add the text after the arrow and paste the rest of the html tag
				}
			}
		}
		
		return strCode; 
	}

/*************************
 * Pass code under <head>*	
 * @param a				 *
 * @param b				 *
 * @param htmlCode		 *
 *************************/
	public void insertUnderHead(JTextField a, JTextArea b,  String htmlCode)
	{
		String strCaptureCode = b.getText().toString();	// get the entire code 
		String strAddToCode = "";
		
		strAddToCode = strCaptureCode.substring(0, 32) + "\n\n"+ htmlCode + "\n\n" + strCaptureCode.substring(32); // add the generated text after the 32nd index
		
		b.setText(strAddToCode);
		a.setText(null);
	}
	
	/**
	 * this method inserts the generated HTML code under the <Style>
	 * @param a
	 * @param b
	 * @param htmlCode
	 */
	public void insertUnderStyle(JTextArea a, JTextArea b,  String htmlCode)
	{
		String strCaptureCode = b.getText().toString(); // store the text of the text area of the full html code in this string
		String strAddToCode = "";
		
		strAddToCode = strCaptureCode.substring(0, 32) + "\n\n"+ htmlCode + "\n\n" + strCaptureCode.substring(32); // add the generated text after the 32nd index
		
		b.setText(strAddToCode);
		a.setText(null);
	}
	
	
	/**
	 * Pass code under <body>
	 * @param a
	 * @param b
	 * @param htmlCode
	 */
	public void insertUnderBody(JTextArea a, JTextArea b,  String htmlCode)
	{
		int length = b.getText().length();
		String strCaptureCode = b.getText().toString();
		String strAdd = "";
		
		strAdd = strCaptureCode.toString().substring(0, length - 17) + "\n" + htmlCode + "\n" + strCaptureCode.substring(length - 16); // starting from the bottom of the code, add the generated code after the (Length -17) 
		
		b.setText(strAdd);
		a.setText(null);	
	}
	
	
	/**
	 * This method reads the code and adds the appropriate direction to the code such as 'left' or 'right' alignment
	 * @param a
	 * @param direction
	 */
	public void addToCode(JTextArea a, String direction)
	{
		
		int nLength = a.getText().length();
		boolean bFound = false;
		String strAddedString = "";
		
		for(int i = 0; i < nLength; i++)
		{
			if(bFound  == false)
			{
			if(a.getText().toString().charAt(i) == '>')
			{
				bFound = true;
				
				strAddedString = a.getText().subSequence(0, i) + " align=\"" + direction + "\"" + a.getText().substring(i);
				
				a.setText(strAddedString);
				
			}
			
			}
		}
	}
	
	
	/**
	 * Ignore html language and just get the regular text
	 * @param html
	 * @return
	 */
	public static String html2text(String html) {
	    return Jsoup.parse(html).text();
	}

	
	
	/**************************************
	 * Change Font, size, or Color of text*
	 **************************************/
	
	/*****************
	 **Text features**
	 *****************/
	public void changeFont(JTextArea a, String font) throws FileNotFoundException, IOException
	{
		String strHtmlCode = "";
		String addFont = "";
		
		strHtmlCode = this.htmlTag(27, a.getText().toString());	// retrieve the tag and add the text after the first arrow
		int nFontIndex = strHtmlCode.indexOf("<font");
		
		addFont = strHtmlCode.substring(0, nFontIndex + 5) + " face=\"" + font + "\"" + strHtmlCode.substring(nFontIndex + 5);
		a.setText(addFont);
		
	}
	
	public void changeSize(JTextArea a, String Size) throws FileNotFoundException, IOException
	{
		String strHtmlCode = "";
		String addSize = "";
		
		strHtmlCode = this.htmlTag(27, a.getText().toString());
		int nFontIndex = strHtmlCode.indexOf("<font");
		
		addSize = strHtmlCode.substring(0, nFontIndex + 5) + " size=\"" + Size +  "\"" + strHtmlCode.substring(nFontIndex + 5);
		a.setText(addSize);
		
	}
	 
	public void changeColor(JTextArea a, String color) throws FileNotFoundException, IOException
	{
		String strHtmlCode = "";
		String addColor = "";
		
		strHtmlCode = this.htmlTag(27, a.getText().toString());
		int nFontIndex = strHtmlCode.indexOf("<font");
		
		addColor = strHtmlCode.substring(0, nFontIndex + 5) + " color=\""  + color + "\"" + strHtmlCode.substring(nFontIndex + 5);
		a.setText(addColor);
	}
	
	
	/********************
	 * Change Background*
	 ********************/
	public void changeBackground(String url, String color, JTextArea a)
	{
		String backgroundCode = "<style>\nbody {\nbackground-image: url(\"" + url + "\");\nbackground-color:#" + color + ";\n}\n</style>";  // store the CSS code and pass the parameters to it
		a.setText(backgroundCode); // sets text area to backgroundCode string 
	}
	
	/*****************
	 * Text Alignment*
	 *****************/
	public void alignement(JTextArea a, String strLocation) throws FileNotFoundException, IOException
	{
		
		String strHtmlCode = "";
		String strHasDiv = "";
		strHtmlCode = htmlTag(22,"");
		strHtmlCode = strHtmlCode.substring(0, 4) + " style=\"text-align:" + strLocation + ";\"" + strHtmlCode.substring(4, 5) + a.getText().toString() + strHtmlCode.substring(5);
		
		int nDivIndex = a.getText().indexOf("<div"); // get the index of <div
		boolean bFound = false;
		
		
		if(nDivIndex >= 0)
		{
		bFound = true;	
		}else{
			bFound = false;
		}
		
		if(bFound == false)
		{
			bFound = true;
			a.setText(strHtmlCode);
		}
		else
		{
			bFound = true;
			
			for(int i = 0; i < a.getText().toString().length(); i++)
			{
				if(a.getText().toString().charAt(i) == ';')
				{
					strHasDiv = a.getText().toString().substring(0, i+1) + " text-align:" + strLocation + ";" + a.getText().toString().substring(i+1);
					
				}
				else{
					System.out.println("Not Found");
				}
				
			}
			a.setText(strHasDiv);
		}

	} // end of alignment
		
	/************
	 * Generator*
	 ************/

	public void generateHtml(JTextArea a, int row) throws FileNotFoundException, IOException
	{
		
		String strHtmlCode = "";
		
		strHtmlCode = htmlTag(row, a.getText().toString());
		a.setText(strHtmlCode);
		
		
	}

	
}
