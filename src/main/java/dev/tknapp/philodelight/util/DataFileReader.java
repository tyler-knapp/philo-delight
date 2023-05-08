package dev.tknapp.philodelight.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFileReader {
    
    public void readFromFile() throws IOException {
        String filePath = "student.xlsx";
    
        // Create a file object with the file path
        File file = new File(filePath);
    
        // Create a FileInputStream object to read the file
        FileInputStream inputStream = new FileInputStream(file);
    
        // Create a Workbook object from the Excel file
        Workbook workbook = WorkbookFactory.create(inputStream);
    
        // Get the first sheet of the workbook
        Sheet sheet = workbook.getSheetAt(0);
    
        // Iterate over all the rows of the sheet
        for (Row row : sheet) {
            // Iterate over all the cells of the row
            for (Cell cell : row) {
                // Print the value of the cell
                System.out.print(cell.toString() + " ");
            }
            // Move to the next line after printing all cells of the row
            System.out.println();
        }
    
        // Close the input stream and the workbook
        inputStream.close();
        workbook.close();
    }
}

