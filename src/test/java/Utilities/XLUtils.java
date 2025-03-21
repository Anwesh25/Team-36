package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	// Row Count, cell count,cell data, retrieve
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public  static XSSFRow row;
	public static XSSFCell cell;
	
	//get the row count of the excell sheet
	public static int getRowCount(String Xlfile, String Xlsheet) throws IOException {
		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(Xlsheet);
		int rowcount = sheet.getLastRowNum(); // last row number
		wb.close();
		fi.close();
		return rowcount;
	}
	
	//get the cell count
	public static int getcellcount(String Xlfile,String Xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(Xlsheet);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		return cellcount;
		
	}
	
	//get the cell data
	public static String getcelldata(String Xlfile,String Xlsheet, int rownum, int cellnum) throws IOException {
		fi = new FileInputStream(Xlfile);
		
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(Xlsheet);
		row = sheet.getRow(rownum); 
		cell = row.getCell(cellnum);
		String data;
		
		try {
		DataFormatter format = new DataFormatter();
		String celldata = format.formatCellValue(cell);
		return celldata;
		}catch(Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
		
	}
	
	public void setcelldata(String Xlfile,String Xlsheet, int rownum, int cellnum, String data) throws IOException {
		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(Xlsheet);
		row = sheet.getRow(rownum); 
		cell = row.getCell(cellnum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(Xlfile); //writing the data
		wb.write(fo);
		fi.close();
		fo.close();
	}

}
