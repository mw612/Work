/*
 * Main Java Class
 * EntryPoint for Application
 */


public class Main {

	public static void main(String[] args) {
		GUI mainGUI = new GUI("Inventur", "R:\\Technik\\Digitale Alarmierung\\DME-Test.xlsx");
        mainGUI.create();
        mainGUI.loadWindow();

        mainGUI.createListener();
	}

}
