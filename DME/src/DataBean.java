public class DataBean {
	/*
	 * Namenskonvention für Jasper sehr wichtig!
	 * Sowohl Felder im Report als auch Varaiablen müssen mit Lowercase beginnen.
	 * 
	 * Databean ist ein Objekt, dass Informationen an Jasper als Liste übergibt.
	 */
	
	private String anzahl;
	private String beschaffungsDatum;
	private String beschaffer;
	private String preis;
	private String melderTyp;
	private String barcode;
	private String seriennummer;
	private String location;
	private String datum;
	private String bemerkung;
	
	public String getAnzahl() { return anzahl; }
	public void setAnzahl(String anzahl) { this.anzahl = anzahl; }
	
	public String getBeschaffungsDatum() { return beschaffungsDatum; }
	public void setBeschaffungsDatum(String beschaffungsDatum) { this.beschaffungsDatum = beschaffungsDatum; }
	
	public String getBeschaffer() { return beschaffer; }
	public void setBeschaffer(String beschaffer) { this.beschaffer = beschaffer; }
	
	public String getPreis() { return preis; }
	public void setPreis(String preis) { this.preis = preis; }

	public String getMelderTyp() { return melderTyp; }
	public void setMelderTyp(String MelderTyp) { this.melderTyp = MelderTyp; }
	
	public String getBarcode() { return barcode; }
	public void setBarcode(String barcode) { this.barcode = barcode; }
	
	public String getSeriennummer() { return seriennummer; }
	public void setSeriennummer(String Seriennummer) { this.seriennummer = Seriennummer; }

	public String getLocation() { return location; }
	public void setLocation(String Location) { this.location = Location; }
	
	public String getDatum() { return datum; }
	public void setDatum(String datum) { this.datum = datum; }
	
	public String getBemerkung() { return bemerkung; }
	public void setBemerkung(String bemerkung) { this.bemerkung = bemerkung; }
	
}
