package br.org.recode.educagro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recode.educagro.dao.*;
import br.org.recode.educagro.model.*;

@WebServlet(urlPatterns = { "/aulas", "/create", "/edit", "/update", "/delet" })
public class AulasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	RequestDispatcher rd = request.getRequestDispatcher("./views/aulas/index.jsp");
//		rd.forward(request, response);
//    }

	AulasDAO aulasDAO = new AulasDAO();
	Aulas aulas = new Aulas();

	public AulasServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) 
{
		case "/aulas":
			read(request, response);
			break;
		case "/create":
			create(request, response);
			break;
		case "/edit":
			edit(request, response);
			break;
		case "/update":
			update(request, response);
			break;
		case "/delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Aulas> lista = aulasDAO.getAulas();

		request.setAttribute("aulas", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/aulas/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		aulas.setMaterias(request.getParameter("materias"));
		aulas.setProfessor(request.getParameter("professor"));
		aulas.setVoluntario(request.getParameter("voluntario"));
		aulasDAO.save(aulas);
		response.sendRedirect("aulas");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		aulas = aulasDAO.getaulaById(id);

		request.setAttribute("id", aulas.getId_aulas());
		request.setAttribute("materia", aulas.getMaterias());
		request.setAttribute("professor", aulas.getProfessor());
		request.setAttribute("voluntario", aulas.getVoluntario());

		RequestDispatcher rd = request.getRequestDispatcher("./views/aulas/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("id", aulas.getId_aulas());
		request.setAttribute("materia", aulas.getMaterias());
		request.setAttribute("professor", aulas.getProfessor());
		request.setAttribute("voluntario", aulas.getVoluntario());

		aulasDAO.update(aulas);
		response.sendRedirect("aulas");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		aulasDAO.deleteById(id);
		response.sendRedirect("aulas");
	}

}