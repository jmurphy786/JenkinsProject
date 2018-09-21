package com.qa.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.google.common.collect.Table.Cell;

import gherkin.formatter.model.Row;



public class MakeExcel {
	
	public static void useExcel(String str) {
	try {
	FileInputStream file = new FileInputStream(new File("C:\\spread.xlsx"));
	HSSFWorkbook workbook = new HSSFWorkbook(file);
	HSSFSheet sheet = workbook.getSheetAt(0);
	Cell cell = null;
	cell = (Cell) sheet.getRow(1).getCell(0);
	((HSSFCell) cell).setCellValue(str);
	file.close();
	
	FileOutputStream output = new FileOutputStream(new File("C:\\spread.xlsx"));
	workbook.write();
	output.close();

	
	}
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch (IOException ex)
	{
		ex.printStackTrace();
	}
	
}
}
