/*
 * Main Java Class
 * EntryPoint for Application
 */


/* Error Codes
 * 1 - Default
 * 10 - Excel File: couldn't open / write
 * 11 - Excel File: couldn't open
 * 20 - Jasper File: couldn't open
 * 30 - Jasper Export: couldn't create PDF
 * 
 * 
 */


public class Main {
	private static String pathDmeListe = "R:\\Technik\\Digitale Alarmierung\\DME-Test.xlsx";
	
	
	public static void main(String[] args) {
		GUI mainGUI = new GUI("DME-Liste", pathDmeListe);
        mainGUI.create();
        mainGUI.loadWindow();

        mainGUI.createListener();
	}

}
