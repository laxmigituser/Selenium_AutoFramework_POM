package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//This class is to understand basic read write operation in excel
public class ExcelUtil {

	public static void main(String[] args) throws Exception {
		//readData();
		ExcelOperations op=new ExcelOperations("InsurancePremium");
		System.out.println(op.getRowCount());
		System.out.println(op.getColCount());
		
		

	}
	public static void readData() throws IOException {
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\util\\VehicleInsuranceCalculatorData.xlsx.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int noOfRows=sheet.getLastRowNum();
		for(int i=0;i<=noOfRows;i++) {
			Row row=sheet.getRow(i);
			int noOfCols = row.getLastCellNum();
			for(int j=0;j<noOfCols;j++) {
				Cell cell = row.getCell(j);
				if(cell.getCellType().equals(CellType.STRING)) {
					System.out.print("string value-"+row.getCell(j).getStringCellValue()+"  ");
				}else if(cell.getCellType().equals(CellType.NUMERIC)) {
					System.out.print("numeric value-"+row.getCell(j).getNumericCellValue()+"  ");
				}			
			}
			System.out.println();
		}
		//write
		Cell cell = sheet.getRow(0).createCell(2);
	    cell.setCellValue("Data");
	    FileOutputStream out = new FileOutputStream(new File(filePath));
	    wb.write(out);
	    out.close();
	        
	}

}
