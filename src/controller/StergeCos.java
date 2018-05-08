package controller;

import java.io.IOException;
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
import entitati.Produse;

/**
 * Servlet implementation class StergeCos
 */
@WebServlet("/StergeCos")
public class StergeCos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/bd")
    private DataSource dbRes;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StergeCos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
					
			HttpSession session = request.getSession();
			List<Cos> listaCos = (ArrayList<Cos>)session.getAttribute("listaCos");
			
			int idSters=-1; 
			if(request.getParameter("produsSters")!=null)
				idSters=Integer.parseInt(request.getParameter("produsSters"));
			if(idSters!=-1)
			{
				int ok=0;
				for(int i =0;i<listaCos.size() && ok==0;i++)
					if(listaCos.get(i).getP().getId_produs()==idSters)
					{
						if(listaCos.get(i).getCantitate()>1)
						{
							listaCos.get(i).setCantitate(listaCos.get(i).getCantitate()-1);
						}
						else
						{
							listaCos.remove(i);
						}
						ok=1;
					}
			}	

			request.getRequestDispatcher("cosCurent.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
