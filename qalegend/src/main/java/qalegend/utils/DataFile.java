package qalegend.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import common.functions.BrowserLaunch;

public class DataFile {
	public static Object[][] getDataFromExcel(String filePath, String sheetName)
			throws EncryptedDocumentException, InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		Object[][] data;
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		data = new Object[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j <= colCount - 1; j++) {

				if (!getCellValue(sheet, 0, j).equals("")) {

					data[i - 1][j] = getCellValue(sheet, i, j);

				}

			}

		}

		return data;

	}

	private static String getCellValue(Sheet sheetName, int rowNum, int colNum) {

		String value = "";

		if (sheetName.getRow(rowNum).getCell(colNum) == null) {

			value = "";

		} else if (sheetName.getRow(rowNum).getCell(colNum).getCellType() == Cell.CELL_TYPE_STRING) {

			value = sheetName.getRow(rowNum).getCell(colNum).getStringCellValue();

		} else {

			DataFormatter formatter = new DataFormatter();
			Cell cell = sheetName.getRow(rowNum).getCell(colNum);
			value = formatter.formatCellValue(cell);
			return value;

		}

		return value;

	}

}
