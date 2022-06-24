import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
    File file;
    FileOutputStream fos;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    DataFormatter formatter = new DataFormatter();
    FormulaEvaluator evaluator;

    WriteExcelFile(String path){
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
        //Falls Artikelnummern beim Scannen angehangen ist. Kürzen auf 13. Stelle
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

        int newRowNum = sheet.getLastRowNum()+1;
        sheet.createRow(newRowNum);
        Row newRow =  sheet.getRow(newRowNum);
        for(int i = 0 ; i<=8; i++){
            newRow.createCell(i);
        }
       return newRowNum;

    }


    public void writeCell(int rowNumber, int cellNumber, String cellValue){
        sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        if(cell != null){
            cell.setCellValue(cellValue);
        }
        try {
            fos = new FileOutputStream(file);
            wb.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void closeFISFOS(){
        if(fis != null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fos != null){
            try {
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


