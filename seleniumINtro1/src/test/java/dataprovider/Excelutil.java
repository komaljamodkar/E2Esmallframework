package dataprovider;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {

	public static String[][] excelRead(String fileName,String sheetName)throws Exception{
		
		FileInputStream fis = new FileInputStream(fileName); // Read data file
		XSSFWorkbook wb = new XSSFWorkbook(fis); // Create workbook corresponding to the input file
		XSSFSheet sheet = wb.getSheet(sheetName); // Get the sheet from the workbook
		Row row0 = sheet.getRow(0); 
		
		int rowNum = sheet.getPhysicalNumberOfRows(); //Count number of rows
		int colNum = row0.getLastCellNum();
		
		String[][] data = new String[rowNum - 1][colNum]; //2X3 matrix or 2D array of Strings
		//data will have 2 rows
		//each row will have 3 columns
		//each column will have a string
		 DataFormatter formatter = new DataFormatter();
		System.out.println("num rows :: " + rowNum);
		
		for(int i = 0; i < rowNum - 1; i++) {
			Row row = sheet.getRow(i+1);
			for(int j = 0; j < colNum; j++) {
				if(row == null)
					data[i][j] = "";
				else {
					Cell cell = row.getCell(j);
					if(cell == null)
						data[i][j] = "";
					else {
						  if(j<colNum-1)
							data[i][j] = String.valueOf(formatter.formatCellValue(cell));
						  else 
							  data[i][j] = String.valueOf(formatter.formatCellValue(cell));
						  
					}
				}
			}
		}
		wb.close();
		 return data;
	

		}
}
