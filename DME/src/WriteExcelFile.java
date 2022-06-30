import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	private JPanel callingPanel;
    File file;
    FileOutputStream fos;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    DataFormatter formatter = new DataFormatter();
    FormulaEvaluator evaluator;

    WriteExcelFile(String path, JPanel callingPanel){
    	this.callingPanel = callingPanel;
        try{
            file = new File(path);
            fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
        }
        catch(IOException ioEx){
        	JOptionPane.showInternalMessageDialog(callingPanel, "Excel-Datei konnte nicht geöffent werden!\nBitte schließen und erneut ausführen.\n\nDas Programm wird nach dem Bestätigen beendet.", "Error", JOptionPane.ERROR_MESSAGE);
        	ioEx.printStackTrace();
        	System.exit(11);
        }
    }

    public int searchSerialNumber(String serialNumber){
        //Falls Artikelnummern beim Scannen angehangen ist, Kürzen auf 13. Stelle
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
        //Anders als ReadExcelFile wird beim nicht Auffinden eine Reihe erstellt.
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
        
        //Aktuelles Datum als String
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        
        if(cell != null){
            cell.setCellValue(cellValue);
            //Bei jeder geshriebenen Celle wird für die Reihe das aktuelle Datum gesetzt.
            row.getCell(7).setCellValue(dateFormat.format(date));
        }
        try {
            fos = new FileOutputStream(file);
            wb.write(fos);
        } catch (IOException e) {
        	JOptionPane.showInternalMessageDialog(callingPanel, "Excel-Datei konnte nicht geöffent werden!\nBitte schließen und erneut ausführen.\n\nDas Programm wird nach dem Bestätigen beendet.", "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
        	System.exit(10);
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


