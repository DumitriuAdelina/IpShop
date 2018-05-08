package entitati;

public class Cos {
	private Produse p;
	private int cantitate;
	public Produse getP() {
		return p;
	}
	public void setP(Produse p) {
		this.p = p;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	public Cos(Produse p, int cantitate) {
		super();
		this.p = p;
		this.cantitate = cantitate;
	}
	public Cos(){
		
	}
	
}
