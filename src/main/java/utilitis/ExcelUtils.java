package utilitis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String[][] userData;
	
	public static String[][] signUpData(String fileName, String sheetName){
		
		try {
			fi = new FileInputStream(fileName);
			wb = new XSSFWorkbook(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ws = wb.getSheet(sheetName);
		
		int row_cnt = ws.getLastRowNum();
		int cell_cnt = ws.getRow(0).getLastCellNum();
		userData = new String[row_cnt][cell_cnt];
		DataFormatter df = new DataFormatter();
		
		for(int r=1; r<=row_cnt; r++) {
			row = ws.getRow(r);
			for(int c=0; c<cell_cnt; c++) {
				cell = row.getCell(c);
				userData[r-1][c] =  df.formatCellValue(cell);
			}
		}
		
		return userData;
	}
	
}
