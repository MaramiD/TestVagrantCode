package frameworkUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import frameworkBase.TestBotBase;

public class ExcelUtils extends TestBotBase{
	/** The Constant currentDir. */
	// Main Directory of the project
	public static final String currentDir = System.getProperty("user.dir");

	

	/** The test data excel file. */
	private static InputStream testData_ExcelFile;


	/** The excel W book. */
	// Excel WorkBook
	private static XSSFWorkbook excelWBook;

	/** The excel W sheet. */
	// Excel Sheet
	private static XSSFSheet excelWSheet;

	/** The cell. */
	// Excel cell
	private static XSSFCell cell;

	/** The row. */
	// Excel row
	public static XSSFRow row;

	/** The row number. */
	// Row Number
	public static int rowNumber;

	/** The column number. */
	// Column Number
	public static int columnNumber;

	static {

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		testData_ExcelFile = classloader.getResourceAsStream(getProperty("TestDataExcelFileName"));
		Log.info("Test file name" + testData_ExcelFile);
		try {
			excelWBook = new XSSFWorkbook(testData_ExcelFile);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * Sets the row number.
	 *
	 * @param pRowNumber
	 *            the new row number
	 */
	// Setter and Getters of row and columns
	public static void setRowNumber(int pRowNumber) {
		rowNumber = pRowNumber;
	}

	/**
	 * Gets the row number.
	 *
	 * @return the row number
	 */
	public static int getRowNumber() {
		return rowNumber;
	}

	/**
	 * Sets the column number.
	 *
	 * @param pColumnNumber
	 *            the new column number
	 */
	public static void setColumnNumber(int pColumnNumber) {
		columnNumber = pColumnNumber;
	}

	/**
	 * Gets the column number.
	 *
	 * @return the column number
	 */
	public static int getColumnNumber() {
		return columnNumber;
	}

	// This method has two parameters: "Test data excel file name" and "Excel sheet
	// name"
	/**
	 * Sets the excel file sheet.
	 *
	 * @param sheetName
	 *            the new excel file sheet
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	// It creates FileInputStream and set excel file and excel sheet to excelWBook
	// and excelWSheet variables.
	public static void setExcelFileSheet(String sheetName) throws IOException {
		try {
			for (int sheetIndex = excelWBook.getNumberOfSheets() - 1; sheetIndex >= 0; sheetIndex--) {
				XSSFSheet sheetIndexInstance = excelWBook.getSheetAt(sheetIndex);
				if (sheetIndexInstance.getSheetName().equals(sheetName)) {
					excelWSheet = excelWBook.getSheet(sheetName);
				}
			}

		} catch (Exception e) {
			throw (e);
		}
	}

	// This method reads the test data from the Excel cell.
	/**
	 * Gets the cell data.
	 *
	 * @param RowNum
	 *            the row num
	 * @param ColNum
	 *            the col num
	 * @return the cell data
	 * @throws Exception
	 */
	// We are passing row number and column number as parameters.
	public static String getCellDataWithSheetName(int RowNum, int ColNum, String sheetName) throws Exception {
		try {

			setExcelFileSheet(sheetName);

			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}
	// We are passing row number and column number as parameters.
		public static String getCellDataWithRandomNumber(int RowNum, int ColNum, String sheetName) throws Exception {
			try {
				 Random rand = new Random(); 
				 double rand_dub = rand.nextDouble();
				setExcelFileSheet(sheetName);

				cell = excelWSheet.getRow(RowNum).getCell(ColNum);
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(cell);
				return cellData+rand_dub;
			} catch (Exception e) {
				throw (e);
			}
		}
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {

			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}

	/**
	 * Gets the row data.
	 *
	 * @param RowNum
	 *            the row num
	 * @return the row data
	 */
	// This method takes row number as a parameter and returns the data of given row
	// number.
	public static XSSFRow getRowData(int RowNum) {
		try {

			row = excelWSheet.getRow(RowNum);
			return row;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static XSSFRow getRowDataWithSheetName(int RowNum, String sheetName) throws Exception {
		try {
			setExcelFileSheet(sheetName);
			XSSFRow	row = excelWSheet.getRow(RowNum);
			return row;
		} catch (Exception e) {
			throw (e);
		}
	}
	public static XSSFRow getDataOfAvailableRowWithSheetName(String sheetName) throws Exception {
		int RowCount=excelWSheet.getLastRowNum();
		try {for(int RowNum=1;RowNum<RowCount;RowNum++) {
		     String data=excelWSheet.getRow(RowNum).getCell(0).toString();	     
		     if(data!="")
		     {
		    	 
		     }
		     
		     RowNum++;
		}
			
		}catch (Exception e) {
			throw (e);
		}
		
		return row;
		
	}
	
}
