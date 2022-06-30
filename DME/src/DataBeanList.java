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
	
	public ArrayList<DataBean> getDataBeanArrayList() {
		return dataBeanList;
	}
	
	
}
