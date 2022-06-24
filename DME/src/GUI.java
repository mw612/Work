
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class GUI {
    private String path;

    private String title;
    private JFrame mainWindow;
    private JPanel mainPanel;
    private JPanel dmeButtonPanel;
    private JPanel dmeContentPanel;
    private JPanel dmeContainerPanel;

    private JButton     bt_save;
    private JButton 	bt_repair;
    private JButton     bt_handingover;

    private JLabel      lb_DME_Panel_Title;
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

    private JTextField  tf_scannerInput;
    private JTextField  tf_beschaffungsdatum;
    private JTextField  tf_beschaffer;
    private JTextField  tf_preis;

    private JTextField  tf_barcode;
    private JTextField  tf_seriennummer;
    private JTextField  tf_datum;
    private JTextField  tf_bemerkung;

    private JComboBox<String>   cb_melderTyp;
    private String cb_melderTyp_content[] = {"BOSS 910", "BOSS 915", "BOSS 915V", "BOSS 925", "BOSS 925V", ""};

    private JComboBox<String>   cb_location;
    private String cb_location_content[] =  {   "Reparatur - Ausgang",
    											"Reparatur - in Bearbeitung",
                                                "Lager",
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
                                                "Team Technik Wirtz",
                                                ""
                                            };




    public GUI(String title, String path){
        this.title = title;
        this.path = path;
    }


    public void create(){
        mainWindow          = new JFrame(title);
        mainPanel           = new JPanel();
        dmeContentPanel     = new JPanel();
        dmeButtonPanel      = new JPanel();
        dmeContainerPanel   = new JPanel();

        mainPanel.setLayout(        new FlowLayout());
        dmeContentPanel.setLayout(  new GridLayout(0,2));
        dmeButtonPanel.setLayout(   new GridLayout(0,2));
        dmeContainerPanel.setLayout(new BorderLayout());



        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        createGUIElements();


        mainWindow.setContentPane(mainPanel);
    }

    public void loadWindow(){
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    private void createGUIElements(){


        bt_save                	= new JButton(   "Speichern");
        bt_repair				= new JButton(   "Reparatur");
        bt_handingover         	= new JButton(   "DME Ausgeben");

        lb_DME_Panel_Title     	= new JLabel(    "DME Inventur");
        lb_scanner             	= new JLabel(    "Scanner Input:");
        lb_beschaffungsdatum   	= new JLabel(    "Beschaffungsdatum:");
        lb_beschaffer          	= new JLabel(    "Beschaffer:");
        lb_preis               	= new JLabel(    "Preis:");
        lb_melderTyp           	= new JLabel(    "MelderTyp:");
        lb_barcode             	= new JLabel(    "Barcode:");
        lb_seriennummer        	= new JLabel(    "Seriennummer:");
        lb_datum               	= new JLabel(    "Datum:");
        lb_bemerkung           	= new JLabel(    "Bemerkung:");
        lb_location            	= new JLabel(    "Standort:");

        tf_scannerInput        	= new JTextField(15);
        tf_beschaffungsdatum   	= new JTextField(15);
        tf_beschaffer          	= new JTextField(15);
        tf_preis               	= new JTextField(15);

        tf_barcode             	= new JTextField(15);
        tf_seriennummer        	= new JTextField(15);
        tf_datum               	= new JTextField(15);
        tf_bemerkung           	= new JTextField(15);


        cb_melderTyp           	= new JComboBox<String>(cb_melderTyp_content);
        cb_location            	= new JComboBox<String>(cb_location_content);

        dmeContentPanel.add(lb_scanner);
        dmeContentPanel.add(tf_scannerInput);
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

        dmeButtonPanel.add(bt_save);
        dmeButtonPanel.add(bt_repair);
        dmeButtonPanel.add(bt_handingover);
        
        
        

        dmeContainerPanel.add(lb_DME_Panel_Title,   BorderLayout.NORTH);
        dmeContainerPanel.add(dmeContentPanel,      BorderLayout.CENTER);
        dmeContainerPanel.add(dmeButtonPanel,       BorderLayout.SOUTH);


        mainPanel.add(dmeContainerPanel);


    }


    public void createListener(){
        //Programm beenden
        mainWindow.addWindowListener(new Listener_Window());


        //Document Listener, Scanner input
        tf_scannerInput.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent e) {
                excelOutput();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                excelOutput();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                excelOutput();

            }


            private void excelOutput(){
                if(tf_scannerInput.getText() == null || tf_scannerInput.getText().length()<13 ){ 
                     clearFields();
                    return;
                }


                ReadExcelFile excelFile = new ReadExcelFile(path);
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
                
                excelFile.closeFIS();
            }
        });

        bt_save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tf_scannerInput.getText() == null || tf_scannerInput.getText().length()<13 )
                    return;

                WriteExcelFile excelFile = new WriteExcelFile(path);
                int rowNumber = excelFile.searchSerialNumber(tf_scannerInput.getText());
                System.out.println(rowNumber);
                //Zeile 0/1 sind Überschrift + Zellen bezeichnung
                if( rowNumber == 0 || rowNumber == 1){
                    System.out.println("Überschrift/Zeilenbeschriftung");
                    return;
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
            }
        });
        
        bt_repair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrintJasper pj = new PrintJasper();
				pj.reparaturSchein();	
				
			}
        	
        });
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


    private String dateFormat(String s){

        if(!s.contains("/")) return s;
        // 11/1/21      1/11/21
        String[] parts = s.split("\\/");
        if( parts[0].length() < 2 ){ parts[0]= "0" + parts[0]; }
        if( parts[1].length() < 2 ){ parts[1]= "0" + parts[1]; }
        parts[2] = "20" + parts[2];

        return parts[1] + "." + parts[0] + "." + parts[2];
    }
}




