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

@WebServlet(urlPatterns = { "/voluntario", "/create-voluntario", "/edit=voluntario", "/update-voluntario", "/delet-voluntario" })
public class VoluntarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	RequestDispatcher rd = request.getRequestDispatcher("./views/voluntario/index.jsp");
//		rd.forward(request, response);
//    }

	VoluntarioDAO voluntarioDAO = new VoluntarioDAO();
	Voluntario voluntario = new Voluntario();

	public VoluntarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) 
{
		case "/voluntario":
			read(request, response);
			break;
		case "/create-voluntario":
			create(request, response);
			break;
		case "/edit-voluntario":
			edit(request, response);
			break;
		case "/update-voluntario":
			update(request, response);
			break;
		case "/delet-voluntario":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Voluntario> lista = voluntarioDAO.getVoluntarios();

		request.setAttribute("voluntario", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/voluntarios/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		voluntario.setSenha(request.getParameter("senha")) ;
		voluntario.setNome(request.getParameter("nome"));
		voluntario.setEmail(request.getParameter("email")) ;
		
		voluntarioDAO.save(voluntario);
		response.sendRedirect("voluntario");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		voluntario = voluntarioDAO.getVoluntarioById(id);

		request.setAttribute("id", voluntario.getId_voluntario());
		request.setAttribute("nome", voluntario.getNome());
		request.setAttribute("email", voluntario.getEmail());
		request.setAttribute("senha", voluntario.getSenha());

		RequestDispatcher rd = request.getRequestDispatcher("./views/voluntario/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("id", voluntario.getId_voluntario());
		request.setAttribute("nome", voluntario.getNome());
		request.setAttribute("email", voluntario.getEmail());
		request.setAttribute("senha", voluntario.getSenha());
		
		voluntarioDAO.update(voluntario);
		response.sendRedirect("voluntario");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		voluntarioDAO.deleteById(id);
		response.sendRedirect("voluntario");
	}

}

