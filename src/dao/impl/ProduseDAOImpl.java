package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import dao.ProduseDAO;
import entitati.Produse;

public class ProduseDAOImpl implements ProduseDAO {

	@Override
	public List<Produse> printProduse(int id_categ, Connection con) throws SQLException {
		
		List<Produse> listaProduse = new ArrayList<Produse>();
		
		PreparedStatement ps = con.prepareStatement("select * from produse where id_categorie="+id_categ);

        ResultSet rs;
        rs = ps.executeQuery();
        while(rs.next()){
        	Produse produs=new Produse();
        	produs.setId_produs(rs.getInt("id_produs"));
            produs.setNume_produs(rs.getString("nume_produs"));
            produs.setStoc(rs.getInt("stoc"));
            produs.setPret(rs.getInt("pret"));
            produs.setId_categorie(rs.getInt("id_categorie"));
            listaProduse.add(produs);
        	}
        return listaProduse;
	}

	@Override
	public void addProdus(Produse p, Connection con) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into produse(nume_produs, stoc, pret, id_categorie) values(?,?,?,?)");
		ps.setString(1,p.getNume_produs()); 
		ps.setInt(2,p.getStoc()); 
		ps.setInt(3,p.getPret()); 
		ps.setInt(4,p.getId_categorie());
		
		ps.executeUpdate();		
	}

	@Override
	public List<Produse> searchProdus(String cautaProd, Connection con) throws SQLException {
		List<Produse> produseGasite = new ArrayList<Produse>();
		
		PreparedStatement ps=con.prepareStatement("select * from produse where lower(nume_produs) like lower('%"+cautaProd+"%')");
		
		ResultSet rs=ps.executeQuery();  
		while( rs.next())
		{
			
			Produse produs=new Produse();
			produs.setId_produs(rs.getInt("id_produs"));
            produs.setNume_produs(rs.getString("nume_produs"));
            produs.setStoc(rs.getInt("stoc"));
            produs.setPret(rs.getInt("pret"));
            produs.setId_categorie(rs.getInt("id_categorie"));

            produseGasite.add(produs);
		}
		return produseGasite;
	}

}
