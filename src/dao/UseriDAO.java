package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entitati.Useri;

public interface UseriDAO {
	 void saveUser(Useri u, Connection con) throws SQLException;
	 Useri findUser(String email,String password, Connection con) throws SQLException;
	 int logging(Useri user, String userName, String password);
	 void updateUser(Useri u,int iduser, Connection con) throws SQLException;
	 void blockUser(int iduser, Connection con) throws SQLException;
	 void unblockUser(int iduser, Connection con) throws SQLException;
	 List<Useri> printUsers(Connection con) throws SQLException;

}
