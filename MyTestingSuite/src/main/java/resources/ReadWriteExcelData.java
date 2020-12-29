package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelData extends base{
	
	private static final int STRING = 0;
	private static final int NUMERIC = 0;
	private static final int FORMULA = 0;
	private static final String BLANK = null;
	public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
    public ReadWriteExcelData(String xlFilePath) throws Exception
    {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
        
        //fos.close();
    }
 
	public String getCellData(String sheetName, String colName, int rowNum)
    {
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
                	
            }
 
            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(col_Num);
            String cellData= cell.getStringCellValue();
            return cellData;
        }
 
  /*          if(cell.getCellType() == STRING) {
            	return cell.getStringCellValue();
            }
                
            else if(cell.getCellType() == NUMERIC || cell.getCellType() == FORMULA)
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                if(DateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                return cellValue;
            }
  //        else (cell.getCellType() == BLANK)
            else
                return "";
    //      else
   //            return String.valueOf(cell.getBooleanCellValue());
        }
        */
        catch(Exception e)
        {
            e.printStackTrace();
            //return "In row number "+rowNum+" or column "+colName +" value does not exist in Excel";
            
            	return "";
        }
    }
	
	//Method to write data on Excel 
	@SuppressWarnings({ "deprecation", "resource" })
	public void getWriteStringToExcel(int rownum, int colnum, String outdata) throws IOException{
		//create an object of Workbook and pass the FileInputStream object into it to create a pipeline between the sheet and eclipse.
		//FileInputStream fis = new FileInputStream("/MyTestingSuite/testData/TestOutput.xlsx");
		//XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
		XSSFSheet sheet = workbook.getSheet("TestData");
		
        Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(colnum);
		
		//cell.setCellType(CellType.STRING);
		cell.setCellValue(outdata);
		//FileOutputStream fos = new FileOutputStream(getDataFromProperty("testOutputExcel"));
		FileOutputStream fos = new FileOutputStream(getDataFromProperty("testOutputExcel"));
		workbook.write(fos);
		fos.close();
	
	}
	@SuppressWarnings("deprecation")
	public void getWriteNumberToExcel(int rowNum, int colNum, double outnumData) throws IOException{
		//create an object of Workbook and pass the FileInputStream object into it to create a pipeline between the sheet and eclipse.
		//FileInputStream fis = new FileInputStream("/MyTestingSuite/testData/TestOutput.xlsx");
		//XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
		XSSFSheet sheet = workbook.getSheet("TestData");
		
        Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(colNum);
		
		
		//cell.setCellType(NUMERIC);
		cell.setCellValue(outnumData);
		//FileOutputStream fos = new FileOutputStream(getDataFromProperty("testOutputExcel"));
		FileOutputStream fos = new FileOutputStream(getDataFromProperty("testOutputExcel"));
		workbook.write(fos);
		fos.close();
	
	}

}
