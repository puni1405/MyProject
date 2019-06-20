package org.testleaf.leaftaps.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public String[][] excelRead(String excelFileName) throws IOException {
		// To open an workbook from a particular location
		XSSFWorkbook wBook = new XSSFWorkbook("./data/" + excelFileName + ".xlsx");
		System.out.println(wBook);

		// To enter a particular sheet either using sheet name or index
		XSSFSheet sheet = wBook.getSheet("Sheet1");
		// for finding the number of active row in the sheet
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count " + rowCount);
		// for finding the number of columns from header row
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Column Count " + colCount);

		String[][] data = new String[rowCount][colCount];

		// Iterating loop for rows
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);

			// Iteration loop for columns
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				// Reading data from a particular cell
				String value = cell.getStringCellValue();
				data[i - 1][j] = value;
			}

		}
		return data;

	}

}
