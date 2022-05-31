package excelAutomation;

public class FetchData {

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir")+"\\testData\\testUserNames.xlsx";
		ExcelReader excelReader = new ExcelReader(filePath, "Sheet1");
		System.out.println(excelReader.getRowCount());
		System.out.println(excelReader.getColcount());
		System.out.println(excelReader.getCellDataNumericType(0, 0));

	}

}
