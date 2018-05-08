package controller;

import java.io.IOException;
import java.sql.Connection;
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
import dao.UseriDAO;
import dao.impl.ProduseDAOImpl;
import dao.impl.UseriDAOImpl;
import entitati.Cos;
import entitati.Produse;
import entitati.Useri;
import recommender.Recommender;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/bd")
    private DataSource dbRes;
	private static final UseriDAO useriDAO = new UseriDAOImpl();
    private static final ProduseDAO produseDAO = new ProduseDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
		Connection con = null;
		try {
			con = dbRes.getConnection();
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Useri user = null;
			user = useriDAO.findUser(username, password, con);
			if (user == null) {
				String mesaj = "Username/parola incorecte";
				HttpSession session = request.getSession(true);
				session.setAttribute("eroare", mesaj);
				response.sendRedirect("login.jsp");
			}
			if (useriDAO.logging(user, username, password) == 1) {
				String mesaj = "Contul este blocat.";
				HttpSession session = request.getSession(true);
				session.setAttribute("eroare", mesaj);
				response.sendRedirect("login.jsp");
			} if(user != null){
				HttpSession session = request.getSession(true);
				session.setAttribute("iduser", user.getId_user());
				session.setAttribute("userCurent", user);
				session.setAttribute("welcome", user.getNume_prenume());
				session.setAttribute("tipUser", user.getTip());
				session.setAttribute("listaCos", new ArrayList<Cos>());
				Recommender recommender = new Recommender();
				List<Long> listaRec = recommender.recommendTraining();
				List<Produse> listaProdRec = produseDAO.searchProdusRecommender(listaRec, con);
				/*for( Produse i : listaProdRec)
				{
					System.out.println(i.getNume_produs());
				}*/
				session.setAttribute("listaProdRec",listaProdRec);
				response.sendRedirect("index.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
