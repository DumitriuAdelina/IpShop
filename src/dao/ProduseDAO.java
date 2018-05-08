package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entitati.Produse;


public interface ProduseDAO {
	
	List<Produse> printProduse(int id_categ,Connection con)throws SQLException;
	void addProdus(Produse p, Connection con) throws SQLException;
	List<Produse> searchProdus(String cautaProd,Connection con)throws SQLException;

}
