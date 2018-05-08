package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import dao.ProduseDAO;
import dao.impl.ProduseDAOImpl;
import entitati.Produse;

/**
 * Servlet implementation class CautaProdus
 */
@WebServlet("/CautaProdus")
public class CautaProdus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/bd")
    private DataSource dbRes;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CautaProdus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		try{
			con=dbRes.getConnection();
			String cautaProd=request.getParameter("cautareprodus");
			
			List<Produse> produseGasite = new ArrayList<Produse>();
			ProduseDAO produseDao = new ProduseDAOImpl();
			produseGasite = produseDao.searchProdus(cautaProd,con);
			
			
			if(!produseGasite.isEmpty())
			{
				HttpSession session=request.getSession(true);	
				session.setAttribute("gasit", produseGasite);
				response.sendRedirect("index.jsp");	
			}
			else
			{
				
				HttpSession session1=request.getSession();
				session1.removeAttribute("gasit");
				
				String mesaj="Produsul nu a fost gasit";
				HttpSession session=request.getSession(true);	
				session.setAttribute("negasit", mesaj);
				response.sendRedirect("index.jsp");	
			}
		}
		catch (SQLException e){
			System.out.println(e);
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

}
