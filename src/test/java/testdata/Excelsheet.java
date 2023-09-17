package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheet {
	 public static Workbook book;
	 public static Sheet sheet;
//create method that will return object array which will be used to fetch data from excelsheet
	public static Object[][]readdata (String sheetname){
		FileInputStream file=null;
		try
		{file=new FileInputStream("C:\\Users\\gurpr\\eclipse-workspace\\newguru\\OCT_TDD\\src\\test\\java\\testdata\\datadriven.xlsx");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		//create workbook
		try {
		 book	=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		} catch (IOException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		}
		//extracting sheet from workbook
		 Sheet sheet=book.getSheet(sheetname);
		//create 2d object array
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			data [i][k]	=sheet.getRow(i+1).getCell(k).toString();
			}
		}
	return data;	
	}
	
}
