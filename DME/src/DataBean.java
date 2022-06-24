public class DataBean {
	/*
	 * Namenskonvention für Jasper sehr wichtig!
	 * Sowohl Felder im Report als auch Varaiablen müssen mit Lowercase beginnen.
	 * 
	 * Databean ist ein Objekt, dass Informationen an Jasper als Liste übergibt.
	 */
	
	private String melderTyp;
	private String seriennummer;
	private String bemerkung;
	
	public String getMelderTyp() { return melderTyp; }
	public void setMelderTyp(String MelderTyp) { this.melderTyp = MelderTyp; }
	
	public String getSeriennummer() { return seriennummer; }
	public void setSeriennummer(String Seriennummer) { this.seriennummer = Seriennummer; }
	
	public String getBemerkung() { return bemerkung; }
	public void setBemerkung(String Bemerkung) { this.bemerkung = Bemerkung; }
}
