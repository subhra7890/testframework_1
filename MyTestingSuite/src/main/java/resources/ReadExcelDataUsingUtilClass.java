package resources;

public class ReadExcelDataUsingUtilClass
{
    public static void main(String args[]) throws Exception
    {
        //ExcelApiTest eat = new ExcelApiTest("/Volumes/Krishna/Jar Files/poi-3.16-beta1/TestData.xlsx"); F:\data       
        ReadExcelData eat = new ReadExcelData("F:\\data\\TestData.xlsx");
        
        	System.out.println("UserName: " +eat.getCellData("Credentials","UserName",4));
            System.out.println("PassWord: " +eat.getCellData("Credentials","PassWord",4));
            System.out.println("DateCreated: " +eat.getCellData("Credentials","DateCreated",2));
            System.out.println("NoOfAttempts: " +eat.getCellData("Credentials","NoOfAttempts",3));
			
		
        
    }
}