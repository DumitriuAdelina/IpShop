package entitati;

public class Categorii {

	private int id_categorie;
	private String nume_categorie;
	
	public Categorii(int id_categorie, String nume_categorie) {
		this.id_categorie = id_categorie;
		this.nume_categorie = nume_categorie;
	}
	
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	
	public String getNume_categorie() {
		return nume_categorie;
	}
	public void setNume_categorie(String nume_categorie) {
		this.nume_categorie = nume_categorie;
	}
	
	
}
