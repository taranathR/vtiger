package GenericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	public String getValueinString(String absPath,String sheetName,int rowNumber,int cellNumber) throws Exception{
		File file=new File(absPath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheetname=workbook.getSheet(sheetName);
		Row row = sheetname.getRow(rowNumber);
		String value = row.getCell(cellNumber).toString();
		return value;
	}
	public String getStringcellvalue(String absPath,String sheetName,int rowNumber,int cellNumber) throws Exception{
		File file=new File(absPath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheetname=workbook.getSheet(sheetName);
		Row row = sheetname.getRow(rowNumber);
		String value = row.getCell(cellNumber).getStringCellValue();
		return value;
	}
	public double getNumericCellValue(String absPath,String sheetName,int rowNumber,int cellNumber) throws Exception{
		File file=new File(absPath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheetname=workbook.getSheet(sheetName);
		Row row = sheetname.getRow(rowNumber);
		double value = row.getCell(cellNumber).getNumericCellValue();
		return value;
	}
	public Date getDateCellValue(String absPath,String sheetName,int rowNumber,int cellNumber) throws Exception{
		File file=new File(absPath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheetname=workbook.getSheet(sheetName);
		Row row = sheetname.getRow(rowNumber);
		Date value = row.getCell(cellNumber).getDateCellValue();
		return value;
	}
	public boolean getBooleanCellValue(String absPath,String sheetName,int rowNumber,int cellNumber) throws Exception{
		File file=new File(absPath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheetname=workbook.getSheet(sheetName);
		Row row = sheetname.getRow(rowNumber);
		boolean value = row.getCell(cellNumber).getBooleanCellValue();
		return value;
	}
	public String[][] getValues(String absPath,String sheetName) throws Exception{
		File file=new File(absPath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] sarr=new String[rowCount][cellCount];
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<cellCount;j++){
				sarr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}

		return sarr;
	}

}
