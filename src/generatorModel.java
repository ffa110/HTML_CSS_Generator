import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class generatorModel 
{

	
	/**
	 * this method is responsible for reading the excel sheet 
	 * @param nRow
	 * @param nCell
	 * @param Dirctory
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readExcel(int nRow, int nCell, String Dirctory) throws FileNotFoundException, IOException
	{
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(Dirctory));	// open the excel sheet in the buffer
		HSSFSheet sheet = workbook.getSheetAt(0);	// open sheet 0
		HSSFRow row = sheet.getRow(nRow);	// get the specific row
		
		String cell = row.getCell(nCell).toString(); // store the specific cell in this string
		
		workbook.close();
		return cell; 
	}
	
	/**
	 * this method detects the number of rows in the excel sheet
	 * @param Dirctory
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int lengthExcel(String Dirctory) throws FileNotFoundException, IOException
	{
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(Dirctory));
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		
		int length = sheet.getLastRowNum(); // get the number of the last row and use it as the number of rows 
		
		workbook.close();
		return length;
	}
	
	/**
	 * this method helps to fill an ArryList with the font names
	 * @param a
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void fileFonts(ArrayList<String> a) throws FileNotFoundException, IOException
	{
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("fonts.xls"));
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		
		int nLength = sheet.getLastRowNum(); //get the length
		
		for(int i = 1; i < nLength; i++) // loop until the last row
		{
			a.add(sheet.getRow(i).getCell(1).toString()); // store the names of the fonts in the arraylist
		}
		
		workbook.close(); // close the buffer
	}
	
	
	/**
	 * this method helps to detect the number of rows the font excel sheet
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int fontsLength() throws FileNotFoundException, IOException
	{
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("fonts.xls"));
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		
		int nLength = sheet.getLastRowNum();
		
		workbook.close();
		
		return nLength;
	}
	
	
	
}
