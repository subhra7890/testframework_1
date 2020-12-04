package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.ExcelUtilities;

public class ExcelTest {
  @Test
  public void excelValue() throws IOException {
	  String location="C:\\Users\\HP\\eclipse-workspace\\Maven Project\\Testing\\src\\main\\java\\resources\\TestData.xlsx";
	  ExcelUtilities exe=new ExcelUtilities(location);
	  int sheetIndex=exe.indexSheet("FlightSearch");
	  System.out.println("sheet index is :"+sheetIndex);
	  int testIndex=exe.indexTestCase(sheetIndex,"ValidateFilterResult");
	  System.out.println("test case index is :"+testIndex);
	  int rowIndex=exe.rowIndex("ValidateFilterResult");
	  System.out.println("row index is :"+rowIndex);
	  Object[][] data=exe.readData(sheetIndex, testIndex, rowIndex);
	  System.out.println("array length is :"+data.length);
	  for(int i=0;i<data.length;i++)
	  {
		  for(int j=0;j<data[i].length;j++)
		  {
//			  System.out.println("column length is :"+data[i].length);
//			  System.out.println("***************");
			  System.out.println(data[i][j]);
			 // System.out.println("****************");
		  }
	  }
  }
}
