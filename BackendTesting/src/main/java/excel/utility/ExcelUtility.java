package excel.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	FileInputStream fis;
	Workbook wb;
	public String path="./testdata/Project.xlsx";
public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws Exception
{
	fis=new FileInputStream(path);
	wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	wb.close();
	return data;
	
}


public int getRowCount(String sheetname) throws Exception {
	fis=new FileInputStream(path);
	wb=WorkbookFactory.create(fis);
	int rowcount=wb.getSheet(sheetname).getLastRowNum();
	wb.close();
	return rowcount;
}

public void setDataIntoExcel(String sheetname, int rownum, int cellnum, String data) throws Exception {
	wb.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream(path);
	wb.write(fos);
	wb.close();
}
}
