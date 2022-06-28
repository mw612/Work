import java.util.ArrayList;

public class DataBeanList {
	private ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

	
	private DataBean produce(String MelderTyp, String Seriennummer, String Location, String Bemerkung) {
		DataBean dataBean = new DataBean();
		dataBean.setMelderTyp(MelderTyp);
		dataBean.setSeriennummer(Seriennummer);
		dataBean.setBemerkung(Bemerkung);
		dataBean.setLocation(Location);

		return dataBean;
	}
	
	public void add(String MelderTyp, String Seriennummer, String Location, String Bemerkung) {
		dataBeanList.add(produce(MelderTyp, Seriennummer, Location, Bemerkung));
	}
	
	public ArrayList<DataBean> getDataBeanArrayList() {
		return dataBeanList;
	}
	
	
}
