package xLUtiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtiles 
{
	FileOutputStream fo;
	FileInputStream fi;
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String path=null;
	
	

	public ExcelUtiles(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fi= new FileInputStream(path);
		book= new XSSFWorkbook(fi);
		sheet=book.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		book.close();
		fi.close();
	    return rowCount;
		
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException
	{
		fi= new FileInputStream(path);
		book= new XSSFWorkbook(fi);
		sheet=book.getSheet(sheetName);
		int cellCount= sheet.getRow(rowNum).getLastCellNum();
		book.close();
		fi.close();
		return cellCount;
		
	}
	
	public String getData(String sheetName, int rowNum, int cellNum) throws IOException
	{
		fi= new FileInputStream(path);
		book= new XSSFWorkbook(fi);
		sheet=book.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		
		DataFormatter formatter= new DataFormatter();
		String data;
		
		try {
		data=formatter.formatCellValue(cell);//Returns the formatted value of the cell as a String regardless of the cell type
		}catch(Exception e)
		{
			data="";
		}
		book.close();
		fi.close();
		return data;
		
	}
	
	public void setData(String sheetName, int rowNum, int cellNum, String data) throws IOException
	{
		fi= new FileInputStream(path);
		book= new XSSFWorkbook(fi);
		sheet=book.getSheet(sheetName);
		
		row=sheet.getRow(rowNum);
		cell=row.createCell(cellNum);
		cell.setCellValue(data);
		
		fo= new FileOutputStream(path);
		book.write(fo);
		book.close();
		fi.close();
		fo.close();
		
		
	}
}
