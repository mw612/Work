import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	private JPanel callingPanel;
	
	private String jasperFolder = "R:\\Vordrucke\\Jasper\\";
	private String reparaturschein = "reparaturschein.jrxml";
	private String uebergabeschein = "uebergabeschein.jrxml";
	
	private String pdfExportReparatur = "R:\\Technik\\Digitale Alarmierung\\Reparaturschein.pdf";
	private String pdfExportUebergabe = "R:\\Technik\\Digitale Alarmierung\\Uebergabeschein.pdf";
	
	JasperReport jasperReport = null;
	JasperPrint printFileName = null;
	
	PrintJasper(JPanel callingPanel){ this.callingPanel = callingPanel;}

	
	public void printReparaturSchein(DataBeanList List) {
		
		try {
			JasperDesign jasperDesign = JRXmlLoader.load(jasperFolder+reparaturschein);
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
		}
		catch (JRException e) {
			JOptionPane.showInternalMessageDialog(null, "Das Jasper Formular Reparaturschein.jrxml konnte nicht geladen werden.", "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
        	return;
		}	


		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(List.getDataBeanArrayList());
		HashMap<String, Object>	hm = new HashMap<String, Object>();
		
		System.out.print("Export: ");
		try {
			System.out.println("ReportFile");
			printFileName = JasperFillManager.fillReport(jasperReport, hm, beanColDataSource);
			
			System.out.println("PDFFile");
			JasperExportManager.exportReportToPdfFile(printFileName, pdfExportReparatur);
		} 
		catch (JRException e) {
			JOptionPane.showInternalMessageDialog(callingPanel, "Jasper konnte kein PDF erstellen!", "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
		}
	}
	
	public void printDmeUebergabeSchein(DataBeanList List) {
		
		try {
			JasperDesign jasperDesign = JRXmlLoader.load(jasperFolder+uebergabeschein);
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
		}
		catch (JRException e) {
			JOptionPane.showInternalMessageDialog(callingPanel, "Das Jasper Formular Übergabeschein.jrxml konnte nicht geladen werden.", "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
        	return;
		}	


		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(List.getDataBeanArrayList());
		HashMap<String, Object>	hm = new HashMap<String, Object>();
		
		System.out.print("Export: ");
		try {
			System.out.println("ReportFile");
			printFileName = JasperFillManager.fillReport(jasperReport, hm, beanColDataSource);
			
			System.out.println("PDFFile");
			JasperExportManager.exportReportToPdfFile(printFileName, pdfExportUebergabe);
		} 
		catch (JRException e) {
			JOptionPane.showInternalMessageDialog(callingPanel, "Jasper konnte kein PDF erstellen!.", "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
        	return;
		}
	}
	
	public String getPdfExportReparatur() {
		return pdfExportReparatur;
	}
	public String getPdfExportUebergabe() {  
		return pdfExportUebergabe;
	}
}
