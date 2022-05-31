package excelAutomation;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelReader(String filePath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(filePath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int getColcount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	public static double getCellDataNumericType(int rowNo, int colNo) {
		try {
			return sheet.getRow(rowNo).getCell(colNo).getNumericCellValue();
		} catch (Exception e) {
			System.out.println("There is no numeric value, so returing 0");
			return 0;
		}
	}

	public static String getCellDataStringType(int rowNo, int colNo) {
		try {
			return sheet.getRow(rowNo).getCell(colNo).toString();
		} catch (Exception e) {
			System.out.println("There is no string value, so returing null");
			return null;
		}
	}

}
