package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UseriDAO;
import entitati.Useri;

public class UseriDAOImpl implements UseriDAO{

	public void saveUser(Useri u, Connection con) throws SQLException {

		PreparedStatement ps=con.prepareStatement("insert into useri(nume_prenume, parola, email, telefon, adresa, tip) values(?,?,?,?,?,?)");
		ps.setString(1,u.getNume_prenume()); 
		ps.setString(2,u.getParola()); 
		ps.setString(3,u.getEmail()); 
		ps.setString(4,u.getTelefon()); 
		ps.setString(5,u.getAdresa()); 
		ps.setString(6,u.getTip()); 
		
		ps.executeUpdate();
	}
	public Useri findUser(String email,String password, Connection con) throws SQLException {
		PreparedStatement ps=con.prepareStatement("select * from useri where email=? and parola=?");
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		Useri user = null;
		if(rs.next())
		{
			user = new Useri(rs.getString("nume_prenume"),rs.getString("parola"),
					rs.getString("email"),rs.getString("telefon"),
					rs.getString("adresa"),rs.getString("tip"));
			user.setId_user(rs.getInt("id_user"));
		}
		return user;
	}

	public int logging(Useri user, String userName, String password) {
		if(password.charAt(0)=='-' && password.charAt(1)=='1')
			return 1;
		return 0;
	}
	
	public void updateUser(Useri u,int iduser, Connection con) throws SQLException {
		
		PreparedStatement ps=con.prepareStatement("update useri set nume_prenume=?, parola=?, email=?, telefon=?, adresa=? where id_user=?");
		
		ps.setString(1,u.getNume_prenume()); 
		ps.setString(2,u.getParola()); 
		ps.setString(3,u.getEmail()); 
		ps.setString(4,u.getTelefon()); 
		ps.setString(5,u.getAdresa());
		ps.setInt(6, iduser);
			
		ps.executeUpdate();
	}

	public void blockUser(int iduser, Connection con) throws SQLException {
		PreparedStatement ps1=con.prepareStatement("select parola from useri where id_user="+iduser);
		ResultSet rs1=ps1.executeQuery(); 
		
		if(rs1.next())	
		{
			String parola=rs1.getString("parola");
			if(!(parola.charAt(0)=='-' && parola.charAt(1)=='1'))
			{
				PreparedStatement ps=con.prepareStatement("update useri set parola=concat('-1',parola) where id_user=?");
				ps.setInt(1, iduser);
				ps.executeUpdate();	
			}
		}
	}
	
	public void unblockUser(int iduser, Connection con) throws SQLException {
		PreparedStatement ps1=con.prepareStatement("select parola from useri where id_user="+iduser);
		ResultSet rs1=ps1.executeQuery(); 
		
		if(rs1.next())	
		{
			String parola=rs1.getString("parola");
			if(parola.charAt(0)=='-' && parola.charAt(1)=='1')
			{
				PreparedStatement ps=con.prepareStatement("update useri set parola=substr(parola,3) where id_user=?");
				ps.setInt(1, iduser);
				ps.executeUpdate();	
			}
		}
	}
 
	public List<Useri> printUsers(Connection con) throws SQLException {
		
		List<Useri> listaUseri = new ArrayList<Useri>();

		PreparedStatement ps = con.prepareStatement("select * from useri");
        ResultSet rs;
        rs = ps.executeQuery();
        while(rs.next()){
        	Useri user=new Useri();
        	user.setId_user(rs.getInt("id_user"));
        	user.setParola(rs.getString("parola"));
        	user.setNume_prenume(rs.getString("nume_prenume"));
        	user.setEmail(rs.getString("email"));
        	user.setTelefon(rs.getString("telefon"));
        	user.setAdresa(rs.getString("adresa"));
        	user.setTip(rs.getString("tip"));
        	
            listaUseri.add(user);
        	}
        return listaUseri;
	}

}
