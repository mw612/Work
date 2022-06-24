import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {

      File file;
      FileInputStream fis;
      XSSFWorkbook wb;
      XSSFSheet sheet;
      DataFormatter formatter = new DataFormatter();
      FormulaEvaluator evaluator;

      ReadExcelFile(String path){
        try{
          file = new File(path);
          fis = new FileInputStream(file);
          wb = new XSSFWorkbook(fis);
        }
        catch(IOException ioEx){
            ioEx.getStackTrace();
        }
      }

      public int searchSerialNumber(String serialNumber){
        serialNumber = serialNumber.substring(0, 13);
        sheet= wb.getSheetAt(0);

        String cellValue = "";
        for(Row row:sheet){
          for(Cell cell:row){
            cellValue = formatter.formatCellValue(cell, evaluator);
            if(cellValue.equals(serialNumber)){
              return row.getRowNum();
            }

          }
        }
        //not found
        return -1;
      }



      public String cellValue(int rowNumber, int cellNumber){
        sheet     = wb.getSheetAt(0);
        Row row   = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);


        return  formatter.formatCellValue(cell);
      }

      public void closeFIS(){
          if(fis != null){
              try {
                  fis.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
}


