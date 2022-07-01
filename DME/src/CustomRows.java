import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomRows {

	private JPanel parentPanel;
	private DataBeanList dbl;
	
	private JPanel panel 			= new JPanel();
	
	private JLabel lb_Anzahl	 	= new JLabel("Anzahl");
	private JLabel lb_Seriennummer 	= new JLabel("Seriennummer");
	private JLabel lb_Gerät 		= new JLabel("Gerät");
	private JLabel lb_Bemerkung 	= new JLabel("Bemerkung");

	private JTextField tf_Anzahl 		= new JTextField();
	private JTextField tf_Seriennummer 	= new JTextField();
	private JTextField tf_Gerät 		= new JTextField();
	private JTextField tf_Bemerkung 	= new JTextField();

	CustomRows(JPanel parentPanel, DataBeanList dbl){
		this.parentPanel = parentPanel;
		this.dbl = dbl;
	}
	
	public void displayGUI() {
		int result = JOptionPane.showInternalConfirmDialog(parentPanel, getPanel(), "Eigenen Reihe hinzufügen: ", JOptionPane.DEFAULT_OPTION);
		if(result == JOptionPane.OK_OPTION) addDataBean();
	}
	
	private JPanel getPanel() {		
		panel.setLayout(new GridLayout(0,4));
				
		panel.add(lb_Anzahl);
		panel.add(lb_Seriennummer);
		panel.add(lb_Gerät);
		panel.add(lb_Bemerkung);
		
		panel.add(tf_Anzahl);
		panel.add(tf_Seriennummer);
		panel.add(tf_Gerät);
		panel.add(tf_Bemerkung);
		
		return panel;
	}
	
	public void addDataBean(){
		//Anzahl: Buchstaben löschen und x am Ende hinzufügen.
		String anz = tf_Anzahl.getText();
		StringBuilder sb = new StringBuilder(anz);
		for(int i = anz.length()-1; i >= 0; i--) 
			if(!Character.isDigit(anz.charAt(i))) 
				sb.deleteCharAt(i);
		sb.append("x");
		anz= sb.toString();
		
		dbl.add(anz, "", "", "", tf_Gerät.getText(), "", tf_Seriennummer.getText(), null, null, tf_Bemerkung.getText());
	}
	
}
