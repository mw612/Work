import java.util.ArrayList;

public class DataBeanList {
	private ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

	
	private DataBean produce(String MelderTyp, String Seriennummer, String Bemerkung) {
		DataBean dataBean = new DataBean();
		dataBean.setMelderTyp(MelderTyp);
		dataBean.setSeriennummer(Seriennummer);
		dataBean.setBemerkung(Bemerkung);

		return dataBean;
	}
	
	public void add(String MelderTyp, String Seriennummer, String Bemerkung) {
		dataBeanList.add(produce(MelderTyp, Seriennummer, Bemerkung));
	}
	
	public ArrayList<DataBean> getDataBeanArrayList() {
		return dataBeanList;
	}
	
	
}
