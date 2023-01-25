package marathon_3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData_Salesforce_Question {

	public static String[][] readData() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./Data_salesforce/Salesforce_TestNG.xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");

		int lastRowNum = ws.getLastRowNum();
		//System.out.println(lastRowNum);
		int lastCellNum = ws.getRow(0).getLastCellNum();
		//System.out.println(lastCellNum);

		String[][] data = new String[lastRowNum][lastCellNum];

		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {

				String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = stringCellValue;
				//System.out.println(stringCellValue);

			}
		}
		wb.close();
		return data;
	}
}
