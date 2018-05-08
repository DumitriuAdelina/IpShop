package entitati;

public class Produse {
	
	private int id_produs;
	private String nume_produs;
	private int stoc;
	private int pret;
	private int id_categorie;
	
	public Produse(){
		
	}
	
	public Produse(String nume_produs, int pret) {

		this.nume_produs = nume_produs;
		this.pret = pret;
	}
	
	public Produse(String nume_produs, int stoc, int pret, int id_categorie) {

		this.nume_produs = nume_produs;
		this.stoc = stoc;
		this.pret = pret;
		this.id_categorie = id_categorie;
	}
	
	@Override
	public String toString() {
		return "Produse [nume_produs=" + nume_produs + ", stoc=" + stoc + ", pret=" + pret + "]";
	}
	
	public int getId_produs() {
		return id_produs;
	}
	public void setId_produs(int id_produs) {
		this.id_produs = id_produs;
	}
	
	public String getNume_produs() {
		return nume_produs;
	}
	public void setNume_produs(String nume_produs) {
		this.nume_produs = nume_produs;
	}
	
	public int getStoc() {
		return stoc;
	}
	public void setStoc(int stoc) {
		this.stoc = stoc;
	}
	
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	
}
