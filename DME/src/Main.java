import javax.swing.JFrame;

/*
 * Main Java Class
 * EntryPoint for Application
 * 
 * Test C201503.05351
 */


/* Error Codes
 * 1 - Default
 * 10 - Excel File: couldn't open / write
 * 11 - Excel File: couldn't open
 * 
 * 
 */


public class Main {
	private 	static 	String 	pathDmeListe 	= "R:\\Technik\\Digitale Alarmierung\\DME-Inventar.xlsx";
	private 	static 	String 	pathBackup	 	= "R:\\Wirtz\\DME Backup\\";
	protected 	static 	JFrame 	mainWindow 		= new JFrame("DME-Liste");
	
	public static void main(String[] args) {
		GUI mainGUI = new GUI(pathDmeListe);
        mainGUI.create();
        mainGUI.loadWindow();
        mainGUI.createListener();
        
        FileBackup fileBackup = new FileBackup(pathDmeListe, pathBackup);
        fileBackup.backupFile();
	}
	
	
	
	
	public static String getPathDmeListe() {
		return pathDmeListe;
	}

}
