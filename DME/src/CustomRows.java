import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomRows {

	private JPanel parentPanel;
	private DataBeanList dbl;
	
	private JPanel panel 			= new JPanel();
	
	private JLabel lb_Anzahl	 	= new JLabel("Anzahl");
	private JLabel lb_Location		= new JLabel("Standort");
	private JLabel lb_Seriennummer 	= new JLabel("Seriennummer");
	private JLabel lb_Gerät 		= new JLabel("Gerät");
	private JLabel lb_Bemerkung 	= new JLabel("Bemerkung");

	private JTextField tf_Anzahl 		= new JTextField();
	private JTextField tf_Seriennummer 	= new JTextField();
	private JTextField tf_Gerät 		= new JTextField();
	private JTextField tf_Bemerkung 	= new JTextField();
	
	
	private JComboBox<String> cb_Location  = new JComboBox<String>(GUI.cb_location_content);

	//Empfängt Das ParentPanel zur Fehlerausgabe und eine DataBeanList zur Übergabe der Custom Liste aus dem Panel. 
	CustomRows(JPanel parentPanel, DataBeanList dbl){
		this.parentPanel = parentPanel;
		this.dbl = dbl;
	}
	
	public void displayGUI() {
		int result = JOptionPane.showInternalConfirmDialog(parentPanel, getPanel(), "Eigenen Reihe hinzufügen: ", JOptionPane.DEFAULT_OPTION);
		if(result == JOptionPane.OK_OPTION) addDataBean();
	}
	
	private JPanel getPanel() {		
		panel.setLayout(new GridLayout(0,2));
				
		panel.add(lb_Anzahl);
		panel.add(tf_Anzahl);
		
		panel.add(lb_Location);
		panel.add(cb_Location);
		
		panel.add(lb_Seriennummer);
		panel.add(tf_Seriennummer);
		
		panel.add(lb_Gerät);
		panel.add(tf_Gerät);
		
		panel.add(lb_Bemerkung);
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
		
		if(tf_Anzahl.getText().length() > 0 || tf_Seriennummer.getText().length() > 0 || tf_Gerät.getText().length() > 0 || tf_Bemerkung.getText().length() > 0 ) {
			dbl.add(anz, "", "", "", tf_Gerät.getText(), "", tf_Seriennummer.getText(), cb_Location.getSelectedItem().toString(), null, tf_Bemerkung.getText());
		}
	}
	
}
