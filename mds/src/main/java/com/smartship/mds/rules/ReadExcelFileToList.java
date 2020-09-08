package com.smartship.mds.rules;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileToList {

	public static List<Tag> readExcelData(String fileName) {
		List<Tag> countriesList = new ArrayList<Tag>();
		
		try {
			//Create the input stream from the xlsx/xls file
			FileInputStream fis = new FileInputStream(fileName);
			
			//Create Workbook instance for xlsx/xls file input stream
			Workbook workbook = null;
			if(fileName.toLowerCase().endsWith("xlsx")){
				workbook = new XSSFWorkbook(fis);
			}else if(fileName.toLowerCase().endsWith("xls")){
				workbook = new HSSFWorkbook(fis);
			}
			
			//Get the number of sheets in the xlsx file
			int numberOfSheets = workbook.getNumberOfSheets();
			
			//loop through each of the sheets
			for(int i=0; i < numberOfSheets; i++){
				
				//Get the nth sheet from the workbook
				Sheet sheet = workbook.getSheetAt(i);
				
				//every sheet has rows, iterate over them
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) 
		        {
					String mTag = "";
					String sTag = "";
					
					//Get the row object
					Row row = rowIterator.next();
					
					//Every row has columns, get the column iterator and iterate over them
					Iterator<Cell> cellIterator = row.cellIterator();
		             
		            while (cellIterator.hasNext()) 
		            {
		            	//Get the Cell object
		            	Cell cell = cellIterator.next();
		            	
		            	//check the cell type and process accordingly
		            	
		            	switch(cell.getCellType()){
		            	case  STRING:
		            		if(mTag.equalsIgnoreCase("")){
		            			mTag = cell.getStringCellValue().trim();
		            		}else if(sTag.equalsIgnoreCase("")){
		            			//2nd column
		            			sTag = cell.getStringCellValue().trim();
		            		}else{
		            			//random data, leave it
		            			System.out.println("Random data::"+cell.getStringCellValue());
		            		}
		            		break;
		            	case NUMERIC:
		            		System.out.println("Random data::"+cell.getNumericCellValue());
		            	}
		            } //end of cell iterator
		            Tag c = new Tag(mTag, sTag);
		            countriesList.add(c);
		        } //end of rows iterator
				
				
			} //end of sheets for loop
			
			//close file input stream
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return countriesList;
	}

	public static void main(String args[]){
		List<Tag> list = readExcelData("src/main/resources/mds_test.xlsx");
		System.out.println("Tag List\n"+list);
	}

}