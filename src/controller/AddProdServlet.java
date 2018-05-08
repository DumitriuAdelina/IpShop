package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ProduseDAO;
import dao.impl.ProduseDAOImpl;
import entitati.Produse;

/**
 * Servlet implementation class AddProdServlet
 */
@WebServlet("/AddProdServlet")
public class AddProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/bd")
    private DataSource dbRes;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		try {
			con = dbRes.getConnection();
			Produse p=new Produse(request.getParameter("nume_produs"),Integer.parseInt(request.getParameter("stoc")),Integer.parseInt(request.getParameter("pret")),Integer.parseInt(request.getParameter("id_categorie")));
			
			ProduseDAO produseDao = new ProduseDAOImpl();
			produseDao.addProdus(p, con);

			
			response.sendRedirect("index.jsp");		
		}
		catch (SQLException e) {
			System.out.println(e);
		}
	}

}
