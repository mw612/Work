import java.util.ArrayList;

public class DataBeanList {
	public ArrayList<DataBean> getDataBeanList(){
		ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();
		dataBeanList.add(produce("BOSS915V", "C201409.12345", "Displayriss" ));
		dataBeanList.add(produce("BOSS910", "C201409.15234", "Kein Ton" ));
		dataBeanList.add(produce("BOSS915V", "C201409.54123", "Kaputt" ));
		dataBeanList.add(produce("BOSS920V", "C201409.11111", "Gehäuse defekt" ));

		return dataBeanList;
	}
	
	private DataBean produce(String MelderTyp, String Seriennummer, String Bemerkung) {
		DataBean dataBean = new DataBean();
		dataBean.setMelderTyp(MelderTyp);
		dataBean.setSeriennummer(Seriennummer);
		dataBean.setBemerkung(Bemerkung);

		return dataBean;
	}
}
