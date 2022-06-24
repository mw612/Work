import java.util.ArrayList;
import java.util.HashMap;

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
	
	JasperReport jasperReport = null;
	JasperPrint printFileName = null;
	
	PrintJasper(){}

	
	public void reparaturSchein() {
		
		try {
			JasperDesign jasperDesign = JRXmlLoader.load(jasperFolder+reparaturschein);
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
		}
		catch (JRException e) {
			e.printStackTrace();
		}	

		DataBeanList DataBeanList = new DataBeanList();
		ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		HashMap<String, Object>	hm = new HashMap<String, Object>();
		
		System.out.print("Export: ");
		try {
			System.out.println("ReportFile");
			printFileName = JasperFillManager.fillReport(jasperReport, hm, beanColDataSource);
			
			System.out.println("PDFFile");
			JasperExportManager.exportReportToPdfFile(printFileName,"C:\\Users\\admin-wirtz\\Desktop\\Reparaturschein.pdf");
		} 
		catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

					

		
	}
}
