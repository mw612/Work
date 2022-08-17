import java.util.ArrayList;
import java.util.Arrays;

public class DataBeanList {
	private ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

	
	private DataBean produce(	String Anzahl,				//0
								String BeschaffungsDatum,	//1
								String Beschaffer,			//2
								String Preis,				//3
								String MelderTyp, 			//4
								String Barcode, 			//5
								String Seriennummer, 		//6
								String Location, 			//7
								String Datum, 				//8
								String Bemerkung) {			//9
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
		/*  Die Übergebene DataBeanList wird an eine ArrayList übergeben, 
		 *  geprüft ob diese null ist
		 *  Die ArrayList der Klasse wird befüllt, und zurückgegeben.
		 */
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
	
	public int size() {
		int size = dataBeanList.size();
		return size;
	}
	
	public void sortByLocation() {
		DataBean tmp;
		int compare;
		for(int i = 0; i < dataBeanList.size()-1; i++) {
			for(int j = 0; j < dataBeanList.size() - 2; j++  ) {
				compare = dataBeanList.get(j).getLocation().compareTo(dataBeanList.get(j+1).getLocation());
				if(compare > 0) {
					tmp = dataBeanList.get(j+1);
					dataBeanList.set(j+1, dataBeanList.get(j));
					dataBeanList.set(j, tmp);
				}
			}
		}
	}
	
	//Returns the DataBean Object at the specific Index
	public DataBean get(int Index) {
		return dataBeanList.get(Index);
	}
	
	
}
