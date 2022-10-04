package br.org.recode.educagro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recode.educagro.model.*;
import br.org.recode.educagro.dao.*;


@WebServlet(urlPatterns = { "/materias", "/create-materias", "/edit-materias", "/update-materias", "/delet-materias" })
public class MateriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	RequestDispatcher rd = request.getRequestDispatcher("./views/materias/index.jsp");
//		rd.forward(request, response);
//    }

	MateriasDAO materiasDAO = new MateriasDAO();
	Materias materias = new Materias();

	public MateriasServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) 
{
		case "/materias":
			read(request, response);
			break;
		case "/create-materias":
			create(request, response);
			break;
		case "/edit-materias":
			edit(request, response);
			break;
		case "/update-materias":
			update(request, response);
			break;
		case "/delet-materias":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Materias> lista = materiasDAO.getMaterias();

		request.setAttribute("materias", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/materias/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		materias.setNome(request.getParameter("materias"));
		
		materiasDAO.save(materias);
		response.sendRedirect("materias");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		materias = materiasDAO.getMateriaById(id);

		request.setAttribute("id", materias.getId_materia());
		request.setAttribute("materia", materias.getNome());
		

		RequestDispatcher rd = request.getRequestDispatcher("./views/materias/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("id", materias.getId_materia());
		request.setAttribute("materia", materias.getNome());
		
		materiasDAO.update(materias);
		response.sendRedirect("materias");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		materiasDAO.deleteById(id);
		response.sendRedirect("materias");
	}

}
