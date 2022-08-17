
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class GUI {
	// *********************************************************************************
	//
	//  GUI Elements
    //
	// *********************************************************************************
	private String path;
    
    private JPanel mainPanel;
    private JPanel dmeMainButtonPanel;
    private JPanel dmeButtonPanel;
    private JPanel dmeContentPanel;
    private JPanel dmeContainerPanel;
    private JPanel dmeAusgabeListePanel;

    private JButton     bt_save;
    private JButton 	bt_repair;
    private JButton     bt_handingover;
    private JButton		bt_customRow;

    private JLabel      lb_scanner;
    private JLabel      lb_beschaffungsdatum;
    private JLabel      lb_beschaffer;
    private JLabel      lb_preis;
    private JLabel      lb_melderTyp;
    private JLabel      lb_barcode;
    private JLabel      lb_seriennummer;
    private JLabel      lb_datum;
    private JLabel      lb_bemerkung;
    private JLabel      lb_location;
    private JLabel		lb_dmeAusgabeListe;

    private JTextField  tf_scannerInput;
    private JTextField  tf_beschaffungsdatum;
    private JTextField  tf_beschaffer;
    private JTextField  tf_preis;

    private JTextField  tf_barcode;
    private JTextField  tf_seriennummer;
    private JTextField  tf_datum;
    private JTextField  tf_bemerkung;
    
    private JList<String>		li_dmeAusgabeListe;
    private JScrollPane sp_dmeListScroller;

    private JComboBox<String>   cb_melderTyp;
    private String cb_melderTyp_content[] = {	"BOSS 910", 
    											"BOSS 915", 
    											"BOSS 915V", 
    											"BOSS 925",
    											"BOSS 925V",
    											"S-Quad X15",
    											"S-Quad X15V",
    											""};

    //ComboBoxenInhalt wird anderen Klassen des Projektes zur Verfügung gestellt.
    protected static JComboBox<String>   cb_location;
    protected static String cb_location_content[] =  {   "Lager",
    											"Reparatur - Ausgang",
    											"Reparatur - in Bearbeitung",
                                                "DN RTW 20",
                                                "Dr. Kowalzik",
                                                "DRK Düren EE 01",
                                                "DRK Düren EE 02",
                                                "DRK Jülich EE 03",
                                                "DRK KV Düren TZ-B50",
                                                "DÜR KTW 03",
                                                "DÜR KTW 04",
                                                "DÜR NEF 03",
                                                "DÜR NEF 04",
                                                "DÜR NEF 05",
                                                "DÜR RTW 08",
                                                "DÜR RTW 09",
                                                "DÜR RTW 10",
                                                "DÜR RTW 11",
                                                "DÜR RTW 12",
                                                "F. Pütz / Bootstrupp Nord",
                                                "F. Pütz / Bootstrupp Süd",
                                                "FTZ Azubi",
                                                "FTZ Bergs",
                                                "FTZ Da. Kuck",
                                                "FTZ Dennis Kuck",
                                                "FTZ M. Meier",
                                                "FTZ Oster",
                                                "FTZ Reserver",
                                                "Guido Kühler",
                                                "HGW RTW 15",
                                                "HMB RTW 20",
                                                "JÜL KTW 01",
                                                "JÜL NEF 02",
                                                "JÜL RTW 02",
                                                "JÜL RTW 03",
                                                "JÜL RTW 04",
                                                "Katastrophenschutz DLRG",
                                                "Katastrophenschutz EE DN 01 & DN 02",
                                                "Katastrophenschutz EE DN 03",
                                                "Katastrophenschutz EE DN 04",
                                                "KTW 05",
                                                "LGW RTW 13",
                                                "LGW RTW 14",
                                                "LIN NEF 01",
                                                "LIN RTW 01",
                                                "LST DAU Alarm",
                                                "LST ELP 01",
                                                "LST ELP 02",
                                                "LST ELP 03",
                                                "LST ELP 04",
                                                "LST ELP 05",
                                                "LST ELP 06",
                                                "LST ELP 07",
                                                "MHD Eschweiler EE 04",
                                                "NDG NEF 06",
                                                "NDG RTW 18",
                                                "NDG RTW 19",
                                                "NDZ RTW 05",
                                                "NDZ RTW 06",
                                                "NDZ RTW 07",
                                                "NEF 21",
                                                "NRV RTW 16",
                                                "NRV RTW 17",
                                                "OrgL Nord",
                                                "OrgL Süd",
                                                "RTW 03",
                                                "RTW 21",
                                                "Team Technik Jakobs",
                                                "Team Technik Ruland",
                                                "Team Technik Wirtz",
                                                ""
                                            };

	// *********************************************************************************
	//
	//  Class global variables
    //
	// *********************************************************************************
    
    //Speichern von Row Numbern, wenn Location gewechselt wird. Wird beim Aufrufen von DME Ausgeben (bt_handingover) genutzt und geleert.
    private ArrayList<Integer> dmeAusgabeListe = new ArrayList<Integer>();
    private String dmeLocationPuffer;
    
    private DefaultListModel<String> dmeAusgabeListModel = new DefaultListModel<String>();
    
    private DataBeanList customRowList = new DataBeanList();
    
	// *********************************************************************************
	//
	//	Methods
    //
	// *********************************************************************************


    public GUI(String path){
        this.path = path;
    }


    public void create(){
        mainPanel           = new JPanel();
        dmeContentPanel     = new JPanel();
        dmeMainButtonPanel  = new JPanel();
        dmeButtonPanel      = new JPanel();
        dmeContainerPanel   = new JPanel();
        dmeAusgabeListePanel= new JPanel();
        
        mainPanel.setLayout(        new FlowLayout());
        dmeContentPanel.setLayout(  new GridLayout(0,2));
        dmeMainButtonPanel.setLayout(   new BorderLayout());
        dmeButtonPanel.setLayout(   new GridLayout(0,3));
        dmeContainerPanel.setLayout(new BorderLayout());
        dmeAusgabeListePanel.setLayout(new BorderLayout());


        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        createGUIElements();


        Main.mainWindow.setContentPane(mainPanel);
    }

    public void loadWindow(){
        Main.mainWindow.pack();
        Main.mainWindow.setVisible(true);
    }

    private void createGUIElements(){


        bt_save                	= new JButton(  "Speichern");
        bt_repair				= new JButton(  "Reparatur");
        bt_handingover         	= new JButton(  "DME Ausgeben");
        bt_customRow			= new JButton(	"Reihe +");	

        lb_scanner             	= new JLabel(   "Scanner Input:");
        lb_beschaffungsdatum   	= new JLabel(   "Beschaffungsdatum:");
        lb_beschaffer          	= new JLabel(   "Beschaffer:");
        lb_preis               	= new JLabel(   "Preis:");
        lb_melderTyp           	= new JLabel(   "MelderTyp:");
        lb_barcode             	= new JLabel(   "Barcode:");
        lb_seriennummer        	= new JLabel(   "Seriennummer:");
        lb_datum               	= new JLabel(   "Datum:");
        lb_bemerkung           	= new JLabel(   "Bemerkung:");
        lb_location            	= new JLabel(   "Standort:");
        lb_dmeAusgabeListe		= new JLabel(	"DME Ausgabe Liste");	

        tf_scannerInput        	= new JTextField(15);
        tf_beschaffungsdatum   	= new JTextField(15);
        tf_beschaffer          	= new JTextField(15);
        tf_preis               	= new JTextField(15);

        tf_barcode             	= new JTextField(15);
        tf_seriennummer        	= new JTextField(15);
        tf_datum               	= new JTextField(15);
        tf_bemerkung           	= new JTextField(15);
        
        li_dmeAusgabeListe 		= new JList<String>();
        li_dmeAusgabeListe.setLayoutOrientation(JList.VERTICAL);
        sp_dmeListScroller = new JScrollPane(li_dmeAusgabeListe);
        sp_dmeListScroller.setPreferredSize(new Dimension(450, 350));

        cb_melderTyp           	= new JComboBox<String>(cb_melderTyp_content);
        cb_location            	= new JComboBox<String>(cb_location_content);

        dmeContentPanel.add(lb_scanner);
        dmeContentPanel.add(tf_scannerInput);
        //2x, da Grid Layout (0,2)
        dmeContentPanel.add(Box.createHorizontalStrut(10));
        dmeContentPanel.add(Box.createHorizontalStrut(10));
        dmeContentPanel.add(lb_beschaffungsdatum);
        dmeContentPanel.add(tf_beschaffungsdatum);
        dmeContentPanel.add(lb_beschaffer);
        dmeContentPanel.add(tf_beschaffer);
        dmeContentPanel.add(lb_preis);
        dmeContentPanel.add(tf_preis);
        dmeContentPanel.add(lb_melderTyp);
        dmeContentPanel.add(cb_melderTyp);
        dmeContentPanel.add(lb_barcode);
        dmeContentPanel.add(tf_barcode);
        dmeContentPanel.add(lb_seriennummer);
        dmeContentPanel.add(tf_seriennummer);
        dmeContentPanel.add(lb_datum);
        dmeContentPanel.add(tf_datum);
        dmeContentPanel.add(lb_bemerkung);
        dmeContentPanel.add(tf_bemerkung);
        dmeContentPanel.add(lb_location);
        dmeContentPanel.add(cb_location);
        dmeContentPanel.add(Box.createHorizontalStrut(10));
        dmeContentPanel.add(Box.createHorizontalStrut(10));
  
        dmeMainButtonPanel.add(bt_save,							BorderLayout.NORTH);
        dmeMainButtonPanel.add(Box.createHorizontalStrut(10),	BorderLayout.CENTER);

        
        dmeButtonPanel.add(bt_repair);
        dmeButtonPanel.add(bt_handingover);
        dmeButtonPanel.add(bt_customRow);
        
        
        
        dmeContainerPanel.add(dmeContentPanel,      BorderLayout.NORTH);
        dmeContainerPanel.add(dmeMainButtonPanel,   BorderLayout.CENTER);
        dmeContainerPanel.add(dmeButtonPanel,       BorderLayout.SOUTH);
        
        dmeAusgabeListePanel.add(lb_dmeAusgabeListe, BorderLayout.NORTH);
        dmeAusgabeListePanel.add(sp_dmeListScroller, BorderLayout.CENTER);
        
        mainPanel.add(dmeContainerPanel);
        mainPanel.add(dmeAusgabeListePanel);


    }

    
	// *********************************************************************************
	//
	//  Action Listener
    //
	// *********************************************************************************

    public void createListener(){
        // ********************************
    	//  Fenster Listener
    	// ********************************
        Main.mainWindow.addWindowListener(new Listener_Window());

        // ********************************
    	//  Textfeld Listener
    	// ********************************
        tf_scannerInput.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent e) { excelOutput(); }

            @Override
            public void insertUpdate(DocumentEvent e) { excelOutput(); }

            @Override
            public void removeUpdate(DocumentEvent e) { excelOutput(); }

        });
        
        // ********************************
    	//  Button Listener
    	// ********************************
        bt_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tf_scannerInput.getText() == null || tf_scannerInput.getText().length()<13 )
                    return;
                
                WriteExcelFile excelFile = new WriteExcelFile(path, mainPanel);
                int rowNumber = excelFile.searchSerialNumber(tf_scannerInput.getText());
                //Zeile 0/1 sind Überschrift + Zellen bezeichnung
                if( rowNumber == 0 || rowNumber == 1){
                    System.out.println("Überschrift/Zeilenbeschriftung");
                    return;
                }
                
                //Prüfen ob SN Feld ausreichend gefüllt, sonst aus Scanner input ziehen
                if(tf_seriennummer.getText().length()!=13) tf_seriennummer.setText(tf_scannerInput.getText().substring(0, 13));
                
                /*
                 * Wenn die Location geändert wurde nachdem die Reihe in die Textfelder geladen wurde
                 * und dann auf Speichern gedrückt wird, wird die Reihe zur dmeAusgabeListe hinzugefügt
                 */
                if(!dmeLocationPuffer.equals(cb_location.getSelectedItem().toString())){
                	//Wenn die Reihennummer(=Seriennummer) schon in der Liste ist, alten Wert löschen und neuen Wert einfügen. 
                	for(int i = 0; i<dmeAusgabeListe.size(); i++)
                		if(dmeAusgabeListe.get(i) == rowNumber) dmeAusgabeListe.remove(i);
                	
                	dmeAusgabeListe.add(rowNumber);
                	//Nach einfügen der rowNumber in die AusgabeListe den Location Puffer auf Aktuellen Wert setzen, da sonst eine Änderung auf den Ursprünglichen Wert nicht mehr erkannt wird.
                	dmeLocationPuffer = cb_location.getSelectedItem().toString();
                	
                	/*
                	 * Die dmeAusgabeModelList wird ebenso befüllt, wie die DME Ausgabeliste und dient als deren Visualisierer.
                	 * Neben der rowNumber, wird auch der Location Name und Seriennummer zur Identifizierung geschrieben.
                	 * Über die RowNumber wird Identifiziert, welches Element bspw. bei einem Rechtsklick wieder gelöscht werden soll.
                	 */
                	//Zuerst prüfen ob das Element bereits enthalten ist, falls dann löschen.
                	String[] elementDuplicationCheck;
                	Boolean dmeElementIsIncluded = false;
                	for(int i = 0; i < dmeAusgabeListModel.getSize(); i++) {
                		elementDuplicationCheck = dmeAusgabeListModel.get(i).toString().split("[#]"); //Index 1 ist die RowNumber
                		if(Integer.valueOf(elementDuplicationCheck[1]) == rowNumber) {
                			dmeAusgabeListModel.remove(i);
                		}	
                	}
                	addDmeAusgabeListModel(cb_location.getSelectedItem().toString() + " - "+ cb_melderTyp.getSelectedItem().toString() + " - "+ tf_seriennummer.getText() + " - #" +rowNumber);
                }
                
                
                
                excelFile.writeCell(rowNumber, 0, tf_beschaffungsdatum.getText());
                excelFile.writeCell(rowNumber, 1, tf_beschaffer.getText());
                excelFile.writeCell(rowNumber, 2, tf_preis.getText());
                excelFile.writeCell(rowNumber, 3, cb_melderTyp.getSelectedItem().toString());
                excelFile.writeCell(rowNumber, 4, tf_barcode.getText());
                excelFile.writeCell(rowNumber, 5, tf_seriennummer.getText());
                excelFile.writeCell(rowNumber, 6, cb_location.getSelectedItem().toString());
                excelFile.writeCell(rowNumber, 7, tf_datum.getText());
                excelFile.writeCell(rowNumber, 8, tf_bemerkung.getText());

                excelFile.closeFISFOS();
                
                
                focusOnScannerInput();
            }
        });
        
        bt_repair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintJasper pj = new PrintJasper(mainPanel);
				ReadExcelFile re = new ReadExcelFile(path, mainPanel);
				WriteExcelFile we = new WriteExcelFile(path, mainPanel);
				DataBeanList dbl= new DataBeanList();
				ArrayList<Integer> rowList = re.searchRowsRepair();
							
				//Sucht die ZellenWerte der zur Reparatur gehenden Melder raus
				//und leitet sie an JasperReports weiter.
				for(int i = 0; i < rowList.size(); i++) {
					addDataBean(re, dbl, rowList.get(i));
				}
				//Fügt die Listen Elemente dem zu Druckenden DataBeanList-Objekt an
				if(customRowList != null) {
					dbl.add(customRowList);
					customRowList.getDataBeanArrayList().clear();
				}
				printOptions(dbl);
				if(dbl.size() < 1) {
					JOptionPane.showInternalMessageDialog(mainPanel, 	"Kein Datensatz zum Drucken vorhanden."
																		+ "\n\n- Kein Location wechsel stattgefunden"
																		+ "\n- Keine Benutzerdefinierten Reihen erstellt"
																		+ "\n- Keine leeren Spalten erstellt"
																		, "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				pj.printReparaturSchein(dbl);
				Desktop desk = Desktop.getDesktop();
				try {
					desk.open(new File(pj.getPdfExportReparatur()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
							
				//Nachdem die Liste Gedruckt wurde, werden die custom Rows gelöscht 
				//und bei den Reparaturaufträgen in Bearbeitung reingeschrieben:
				if(customRowList != null ) customRowList.getDataBeanArrayList().clear();
				for(int i = 0; i< rowList.size(); i++) {
					//Schreibt in die Exceltabelle den Status Reparatur - In Bearbeitung
					we.writeCell(rowList.get(i), 6, "Reparatur - in Bearbeitung");
				}
				
				re.closeFIS();
				we.closeFISFOS();
				
				excelOutput();
				focusOnScannerInput();
			}
        	
        });
        
        bt_handingover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintJasper pj = new PrintJasper(mainPanel);
				ReadExcelFile re = new ReadExcelFile(path, mainPanel);
				DataBeanList dbl = new DataBeanList();
				
				//Befüllen der globalen Variable dmeAusgabeListe mit zu druckenden Reihennummern
				// falls dme Liste null oder leer, anlegen und mit aktueller Auswahl füllen.
				if(dmeAusgabeListe == null) { dmeAusgabeListe = new ArrayList<Integer>(); }
				if(dmeAusgabeListe.size() == 0) {
					int rowNumber = re.searchSerialNumber(tf_scannerInput.getText());
					//Wenn SN nicht gefunden gibt re.searchSerialnumber einen Error Dialog aus und wird hier beendet
					if(rowNumber > 0) {
						dmeAusgabeListe.add(rowNumber);
					}
				}
				//die Reihen der dmeAusgabeListe in DataBean packen
				if(dmeAusgabeListe != null && dmeAusgabeListe.size() > 0) {
					for(int i=0; i<dmeAusgabeListe.size(); i++){
						addDataBean(re, dbl, dmeAusgabeListe.get(i));
					}
				}
				
				//Fügt die Listen Elemente dem zu Druckenden DataBeanList-Objekt an
				if(customRowList != null) {
					dbl.add(customRowList);
					customRowList.getDataBeanArrayList().clear();
				}
				
				printOptions(dbl);
				
				if(dbl.size() < 1) {
					JOptionPane.showInternalMessageDialog(mainPanel, 	"Kein Datensatz zum Drucken vorhanden."
																		+ "\n\n- Kein Location wechsel stattgefunden"
																		+ "\n- Keine Benutzerdefinierten Reihen erstellt"
																		+ "\n- Keine leeren Spalten erstellt"
																		, "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				pj.printDmeUebergabeSchein(dbl);
				dmeAusgabeListe.clear();
				
				//Wenn der Button Gedrückt wurde, wird die li_dmeAusgabeListe geleert. Dazu das ListModel leeren und UI updaten
				dmeAusgabeListModel.clear();
				li_dmeAusgabeListe.updateUI();
				
				
				Desktop desk = Desktop.getDesktop();
				try {
					desk.open(new File(pj.getPdfExportUebergabe()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				focusOnScannerInput();
			}
        });
        
        bt_customRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomRows customRowDialog = new CustomRows(mainPanel, customRowList);
				customRowDialog.displayGUI();
				
				
				//Letztes (das neue) Element der CustomRow List in dmeAusgabeListModel packen und UI Updaten
				DataBean fill = customRowList.get(customRowList.size()-1);
				addDmeAusgabeListModel(fill.getLocation() + " - " + fill.getMelderTyp() + " - " + fill.getSeriennummer());
			}        	
        });
        
     
        
    }
    // *********************************************************************************
  	//
  	//  Public Helpers
     //
  	// *********************************************************************************
   
    
    // *********************************************************************************
  	//
  	//  Private Helpers
     //
  	// *********************************************************************************



    private String dateFormat(String s){

        if(!s.contains("/")) return s;
        // 11/1/21      1/11/21
        String[] parts = s.split("\\/");
        if( parts[0].length() < 2 ){ parts[0]= "0" + parts[0]; }
        if( parts[1].length() < 2 ){ parts[1]= "0" + parts[1]; }
        parts[2] = "20" + parts[2];

        return parts[1] + "." + parts[0] + "." + parts[2];
    }
    
    private void addDataBean(ReadExcelFile re, DataBeanList dataBeanList, Integer rowNumber ) {
			dataBeanList.add(	"1x",
								re.cellValue(rowNumber, 0),
								re.cellValue(rowNumber, 1),
								re.cellValue(rowNumber, 2),
								re.cellValue(rowNumber, 3),
								re.cellValue(rowNumber, 4),
								re.cellValue(rowNumber, 5),
								re.cellValue(rowNumber, 6),
								re.cellValue(rowNumber, 7),
								re.cellValue(rowNumber, 8));
    }
    
    //erzeugen von Leeren reihen
    private void emptyDataBeanRow(DataBeanList dataBeanList, Integer times) {
    	for(int i = 0; i < times; i++) {
    		dataBeanList.add("","","","","","","","","","");
    	}
    }
    
    private void focusOnScannerInput() {
    	tf_scannerInput.requestFocus();
    	tf_scannerInput.selectAll();

    }
    
    private void clearFields(){
        tf_beschaffungsdatum.setText("");
        tf_beschaffer.setText("");
        tf_preis.setText("");
        cb_melderTyp.setSelectedItem("");
        tf_preis.setText("");
        tf_seriennummer.setText("");
        cb_location.setSelectedItem("");
        tf_datum.setText("");
        tf_bemerkung.setText("");
    }
    
    //Befüllt die Textfelder aus der ExcelListe
    private void excelOutput(){
        if(tf_scannerInput.getText() == null || tf_scannerInput.getText().length()<13 ){ 
             clearFields();
            return;
        }


        ReadExcelFile excelFile = new ReadExcelFile(path,mainPanel);
        int rowNumber = excelFile.searchSerialNumber(tf_scannerInput.getText());

        if(rowNumber == -1){
            clearFields();
            return;
        }
        
        tf_beschaffungsdatum.setText(   excelFile.cellValue(rowNumber, 0));
        tf_beschaffer.setText(          excelFile.cellValue(rowNumber, 1));
        tf_preis.setText(               excelFile.cellValue(rowNumber, 2));
        cb_melderTyp.setSelectedItem(   excelFile.cellValue(rowNumber, 3));
        tf_barcode.setText(             excelFile.cellValue(rowNumber, 4));
        tf_seriennummer.setText(        excelFile.cellValue(rowNumber, 5));
        cb_location.setSelectedItem(    excelFile.cellValue(rowNumber, 6));
        tf_datum.setText(               dateFormat(excelFile.cellValue(rowNumber, 7)));
        tf_bemerkung.setText(           excelFile.cellValue(rowNumber, 8));
        
        //Zwischenspeichern der Location -> Änderungen zur DME Ausgabe
        dmeLocationPuffer = excelFile.cellValue(rowNumber, 6);


        excelFile.closeFIS();
    }
    
    private void printOptions(DataBeanList dataBeanList) {
    	//Erzeugt Dialog, mit Frage nach Leerzeilen, fängt Abbrechen bzw null Zeilen ab
    	String rows = JOptionPane.showInternalInputDialog(mainPanel, "Sollen Leerzeilen erzeugt werden?\n\nAnzahl: ");
    	if(rows == null || rows.equals("")) return;
    	emptyDataBeanRow(dataBeanList, Integer.parseInt(rows));
    }
    
    private void addDmeAusgabeListModel(String String) {
    	dmeAusgabeListModel.addElement(String);
    	sortDmeAusgabeListModel();
    	li_dmeAusgabeListe.setModel(dmeAusgabeListModel);
    	li_dmeAusgabeListe.updateUI();
    }
    
    private void sortDmeAusgabeListModel() {
    	String[] sarray = new String[dmeAusgabeListModel.size()];
    	for(int i = 0; i < sarray.length; i++) {
    		sarray[i] = dmeAusgabeListModel.get(i);
    	}
    	Arrays.sort(sarray);
    	dmeAusgabeListModel.clear();
    	for(int i = 0; i < sarray.length; i++) {
    		dmeAusgabeListModel.addElement(sarray[i]);
    	}
    }
}