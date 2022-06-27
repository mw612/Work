import java.util.HashMap;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PrintJasper {
	
	private String jasperFolder = "R:\\Vordrucke\\Jasper\\";
	private String reparaturschein = "reparaturschein.jrxml";
	
	private String pdfExport = "R:\\Technik\\Digitale Alarmierung\\Reparaturschein.pdf";
	
	JasperReport jasperReport = null;
	JasperPrint printFileName = null;
	
	PrintJasper(){}

	
	public void printReparaturSchein(DataBeanList List) {
		
		try {
			JasperDesign jasperDesign = JRXmlLoader.load(jasperFolder+reparaturschein);
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
		}
		catch (JRException e) {
			JOptionPane.showMessageDialog(null, "Das Jasper Formular konnte nicht geladen werden\\n\\nDas Programm wird nach Bestätigung beendet.", "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
        	System.exit(20);
		}	


		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(List.getDataBeanArrayList());
		HashMap<String, Object>	hm = new HashMap<String, Object>();
		
		System.out.print("Export: ");
		try {
			System.out.println("ReportFile");
			printFileName = JasperFillManager.fillReport(jasperReport, hm, beanColDataSource);
			
			System.out.println("PDFFile");
			JasperExportManager.exportReportToPdfFile(printFileName, pdfExport);
		} 
		catch (JRException e) {
			JOptionPane.showMessageDialog(null, "Jasper konnte kein PDF erstellen!\n\nDas Programm wird nach Bestätigung beendet.", "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
        	System.exit(30);
		}
	}
	
	public String getPdfExport() {
		return pdfExport;
	}
}
