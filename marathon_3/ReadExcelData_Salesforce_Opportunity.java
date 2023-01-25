package marathon_3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData_Salesforce_Opportunity {

	public static String[][] opportunityData() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./Data_salesforce/Salesforce_TestNG.xlsx");
		XSSFSheet ws = wb.getSheet("Sheet2");
		
		int lastRowNum = ws.getLastRowNum();
		int lastCellNum = ws.getRow(0).getLastCellNum();
		String[][] str = new String[lastRowNum][lastCellNum];
		
		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {

				String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				str[i-1][j] = stringCellValue;
			}
		}
		wb.close();
		return str;

	}

}
