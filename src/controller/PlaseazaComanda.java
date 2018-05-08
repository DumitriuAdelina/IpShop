package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import entitati.Cos;

/**
 * Servlet implementation class PlaseazaComanda
 */
@WebServlet("/PlaseazaComanda")
public class PlaseazaComanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/bd")
    private DataSource dbRes;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaseazaComanda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		try {
			con = dbRes.getConnection();
			HttpSession session = request.getSession();
			List<Cos> listaCos = (ArrayList<Cos>)session.getAttribute("listaCos");
			if(listaCos!=null)
	           {
					for(int i=0;i<listaCos.size();i++)	
					{
						PreparedStatement ps=con.prepareStatement("update produse set stoc=stoc-? where id_produs="+listaCos.get(i).getP().getId_produs());
						ps.setInt(1,listaCos.get(i).getCantitate());
						int affectedRows = ps.executeUpdate();
				        if (affectedRows == 0) {
				            throw new SQLException("plaseaza comanda failed");
				        }
					}
					listaCos.clear();
	           }
			else
				request.getRequestDispatcher("index.jsp").include(request, response);
			String mesaj="Comanda a fost plasata cu succes";
			response.sendRedirect("index.jsp?mesaj="+URLEncoder.encode(mesaj,"UTF-8"));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(con!=null)
				try {
					con.close();
				} 
				catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}