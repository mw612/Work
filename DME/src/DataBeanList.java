import java.util.ArrayList;

public class DataBeanList {
	private ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

	
	private DataBean produce(	String Anzahl,
								String BeschaffungsDatum,
								String Beschaffer,
								String Preis,
								String MelderTyp, 
								String Barcode, 
								String Seriennummer, 
								String Location, 
								String Datum, 
								String Bemerkung) {
		DataBean dataBean = new DataBean();
		dataBean.setAnzahl(				Anzahl);
		dataBean.setBeschaffungsDatum(	BeschaffungsDatum);
		dataBean.setBeschaffer(			Beschaffer);
		dataBean.setPreis(				Preis);
		dataBean.setMelderTyp(			MelderTyp);
		dataBean.setSeriennummer(		Seriennummer);
		dataBean.setBarcode(			Barcode);
		dataBean.setLocation(			Location);
		dataBean.setDatum(				Datum);
		dataBean.setBemerkung(			Bemerkung);

		return dataBean;
	}
	
	//Hinzufügen von DataBeanObjekten zur Liste über Strings
	public void add(	String Anzahl,
						String BeschaffungsDatum,
						String Beschaffer,
						String Preis,
						String MelderTyp, 
						String Barcode, 
						String Seriennummer, 
						String Location, 
						String Datum, 
						String Bemerkung) {
		
		dataBeanList.add( produce(	Anzahl,
									BeschaffungsDatum,
									Beschaffer, 
									Preis,
									MelderTyp, 
									Barcode, 
									Seriennummer, 
									Location, 
									Datum, 
									Bemerkung 
								  )	
						);
	}
	
	//Funktion add mit DataBeanListObjekt überladen
	public ArrayList<DataBean> add(DataBeanList dbl) {
		ArrayList<DataBean> adbl = dbl.getDataBeanArrayList();
		if(adbl == null) return null;
		for(int i = 0; i< adbl.size(); i++) {
			dataBeanList.add(adbl.get(i));
		}
		return dataBeanList;
	}
	
	public ArrayList<DataBean> getDataBeanArrayList() {
		return dataBeanList;
	}
	
	public void sort() {
	}
	
	
}
