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

import entitati.Cos;
import entitati.Produse;

/**
 * Servlet implementation class AdaugareInCos
 */
@WebServlet("/AdaugareInCos")
public class AdaugareInCos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/bd")
    private DataSource dbRes;   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdaugareInCos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con=null;
		HttpSession session = request.getSession();

		try{
			con=dbRes.getConnection();
			int id = Integer.parseInt(request.getParameter("produsAdaugat"));
			List<Cos> listaCos = (ArrayList<Cos>)session.getAttribute("listaCos");
			
			if(id>0)
			{
				PreparedStatement ps=con.prepareStatement("select * from produse where id_produs="+id);  
				ResultSet rs=ps.executeQuery();  
				while( rs.next())
				{			
					Produse produs=new Produse();
					produs.setId_produs(rs.getInt("id_produs"));
		            produs.setNume_produs(rs.getString("nume_produs"));
		            produs.setStoc(rs.getInt("stoc"));
		            produs.setPret(rs.getInt("pret"));
		            produs.setId_categorie(rs.getInt("id_categorie"));
		             
		            if(!listaCos.isEmpty())
		            {
		            	int ok=0;
						for(int i =0;i<listaCos.size() && ok==0;i++)
							if(listaCos.get(i).getP().getId_produs()==produs.getId_produs())
							{	
								if(listaCos.get(i).getCantitate()+1<=listaCos.get(i).getP().getStoc())
								{
									listaCos.get(i).setCantitate(listaCos.get(i).getCantitate()+1);
									ok=1;
								}
								else ok=-1;
							}
						if(ok==0 && produs.getStoc()>0)
						{
							Cos ob=new Cos();
				            int cantitate=1;
				            ob.setP(produs);//System.out.println(ob.getP());
				            ob.setCantitate(cantitate);//System.out.println(ob.getCantitate());
				            listaCos.add(ob);
						}
		            }
		            else if(produs.getStoc()>0){
			            Cos ob=new Cos();
			            int cantitate=1;
			            ob.setP(produs);//System.out.println(ob.getP());
			            ob.setCantitate(cantitate);//System.out.println(ob.getCantitate());
			            listaCos.add(ob);
		            }
				}
				request.getSession().setAttribute("listaCos",listaCos);
				
				request.getRequestDispatcher("cosCurent.jsp").include(request, response);

			}
			else
				request.getRequestDispatcher("cosCurent.jsp").include(request, response);
			
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
