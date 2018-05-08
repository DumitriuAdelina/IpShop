package entitati;

public class Useri {
	
	private int id_user;
	private String nume_prenume;
	private String parola;
	private String email;
	private String telefon;
	private String adresa;
	private String tip;
	
	public Useri(){
		
	}
	
	public Useri(String nume_prenume, String parola, String email, String telefon, String adresa, String tip){
		this.nume_prenume=nume_prenume;
		this.parola=parola;
		this.email=email;
		this.telefon=telefon;
		this.adresa=adresa;
		this.tip=tip;
	}
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	public String getNume_prenume() {
		return nume_prenume;
	}
	public void setNume_prenume(String nume_prenume) {
		this.nume_prenume = nume_prenume;
	}
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
}
