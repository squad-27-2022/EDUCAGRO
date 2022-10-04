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

@WebServlet(urlPatterns = { "/professor", "/create-professor", "/edit=professor", "/update-professor", "/delet-professor" })
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	RequestDispatcher rd = request.getRequestDispatcher("./views/professor/index.jsp");
//		rd.forward(request, response);
//    }

	ProfessorDAO ProfessorDAO = new ProfessorDAO();
	Professor professor = new Professor();

	public ProfessorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) 
{
		case "/professor":
			read(request, response);
			break;
		case "/create-professor":
			create(request, response);
			break;
		case "/edit-professor":
			edit(request, response);
			break;
		case "/update-professor":
			update(request, response);
			break;
		case "/delet-professor":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Professor> lista = ProfessorDAO.getProfessores();

		request.setAttribute("professor", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/professores/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		professor.setEmail(request.getParameter("email")) ;
		professor.setSenha(request.getParameter("senha")) ;
		professor.setNome(request.getParameter("nome"));
		ProfessorDAO.save(professor);
		response.sendRedirect("professor");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		professor = ProfessorDAO.getProfessorById(id);

		request.setAttribute("id", professor.getId_professor());
		request.setAttribute("nome", professor.getNome());
		request.setAttribute("email", professor.getEmail());
		request.setAttribute("senha", professor.getSenha());

		RequestDispatcher rd = request.getRequestDispatcher("./views/professor/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("id", professor.getId_professor());
		request.setAttribute("nome", professor.getNome());
		request.setAttribute("email", professor.getEmail());
		request.setAttribute("senha", professor.getSenha());
		
		ProfessorDAO.update(professor);
		response.sendRedirect("professor");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProfessorDAO.deleteById(id);
		response.sendRedirect("professor");
	}

}

