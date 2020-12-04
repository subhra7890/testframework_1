package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	private String path;
	private XSSFWorkbook wb=null;
	private XSSFSheet sheet=null;
	private XSSFRow row=null;
	private XSSFCell cell=null;
	
	
	public ExcelUtilities(String path) throws IOException {

		this.path = path;
		try {
			FileInputStream fis=new FileInputStream(this.path);
			wb=new XSSFWorkbook(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int indexSheet(String sheetName)
	{
		int index=0;
		int sheetCount=wb.getNumberOfSheets();
		for(int i=0;i<sheetCount;i++)
		{
			sheet=wb.getSheetAt(i);
			if(sheet.getSheetName().equalsIgnoreCase(sheetName))
			{
				index=i;
				break;
			}
		}
		return index;
	}
	
	public int indexTestCase(int index,String testcase)
	{
		int tindex=0;
		sheet=wb.getSheetAt(index);
		int rowCount=sheet.getPhysicalNumberOfRows();
		for(int i=1;i<rowCount;i++)
		{
			row=sheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(testcase))
			{
				tindex=i;
				break;
			}
		}
		return tindex;
	}
	
	public int rowIndex(String testCaseName)
	{
		int i=0;
		switch (testCaseName) {
		case "ValidateFilterResult":
			i=9;		
			break;
		case "maxmValidationRule":
			i=4;
			break;
		case "validationOfFilter":
			i=7;
			break;
		case "suggestionListSelection":
			i=4;
			break;
		}
		return i;
	}
	
//	public void diffIndex(int index,String userTestCase,String defaultTest)
//	{
//		int b=0,c=0;
//		sheet=wb.getSheetAt(index);
//		int rowCount=sheet.getPhysicalNumberOfRows();
//		for(int i=1;i<rowCount;i++)
//		{
//			row=sheet.getRow(i);
//			String value=row.getCell(0).getStringCellValue();
//			if(value.equalsIgnoreCase(userTestCase))
//			{
//				b=i;
//			}
//			else if(value.equalsIgnoreCase("TestCaseName"))
//			{
//				c=i;
//				if(c<rowCount)
//				{
//					continue;
//				}
//				else
//				{
//					break;
//				}
//			}
//			
//		}
//	}
	
	public Object[][] readData(int index,int tindex,int rowIndex) throws IOException
	{
		sheet = wb.getSheetAt(index);
		int rowCount = sheet.getPhysicalNumberOfRows();
		//System.out.println("row count is :"+rowCount);
		row = sheet.getRow(tindex - 1);
		int colCount = row.getLastCellNum();
		//System.out.println("column number :"+colCount);
		Object[][] data=new Object [rowIndex][colCount-1];
		int rowData=0;
		for (int i = tindex; i < rowCount; i++) {
			row = sheet.getRow(i);
			String value = row.getCell(0).getStringCellValue();
			if (!value.equals("TestCaseName")) {
				int colData=0;
				for (int j = 1; j <colCount; j++) {
					cell = row.getCell(j);
					if (cell.getCellType() == CellType.NUMERIC) {
						int num = (int) cell.getNumericCellValue();
						String number = String.valueOf(num);
						data[rowData][colData]=number;
						colData++;					
					} else {
						String cellvalue=cell.getStringCellValue();
						data[rowData][colData]=cellvalue;
						colData++;						
					}
				}
			} else {
				break;
			}
			rowData++;
		}
		wb.close();
		return data;
	}
	
	
	

}
