package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.PropertiesOperation;
import com.qa.base.TestBase;

public class ExcelOperations extends TestBase{
	
	private String filePath;
	private FileInputStream file;
	private Sheet sheet;
	private Workbook wb;
	private String sheetName="";
	
	public ExcelOperations(String sheetName) throws Exception {
		super();
		filePath = System.getProperty("user.dir")+PropertiesOperation.getPropertyValueByKey("testDataLocation");
		this.sheetName = sheetName;
	}
	
	public HashMap<String, String> getTestTataInMap(int rowNum) {
		try {
			 file=new FileInputStream(filePath);//open file in read mode
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			 wb = WorkbookFactory.create(file); //create workbook object//workbookfactory works with both HSSF (xls) ans XSSF(xlsx)
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);//get sheet
		//put data in map
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<sheet.getRow(0).getLastCellNum();i++) {
			//set the celltype as string so that no error while reading
			sheet.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			map.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNum).getCell(i).toString());
		}
		return map;
	}
	
	public int getRowCount() {
		try {
			 file=new FileInputStream(filePath);//open file in read mode
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			 wb = WorkbookFactory.create(file); //create workbook object//workbookfactory works with both HSSF (xls) ans XSSF(xlsx)
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);//get sheet
		
		return sheet.getLastRowNum();
		
	}
	public int getColCount() {
		try {
			 file=new FileInputStream(filePath);//open file in read mode
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			 wb = WorkbookFactory.create(file); //create workbook object//workbookfactory works with both HSSF (xls) ans XSSF(xlsx)
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);//get sheet
		return sheet.getRow(0).getLastCellNum();
	}
	

}
