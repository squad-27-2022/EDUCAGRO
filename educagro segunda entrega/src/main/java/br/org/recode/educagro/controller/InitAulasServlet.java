package br.org.recode.educagro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recode.educagro.dao.MateriasDAO;
import br.org.recode.educagro.dao.ProfessorDAO;
import br.org.recode.educagro.dao.VoluntarioDAO;
import br.org.recode.educagro.model.Materias;
import br.org.recode.educagro.model.Professor;
import br.org.recode.educagro.model.Voluntario;

@WebServlet("/initAulas")
public class InitAulasServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Materias> materias = new MateriasDAO().getMaterias();
		List<Professor> professores = new ProfessorDAO().getProfessores();
		List<Voluntario> voluntarios = new VoluntarioDAO().getVoluntarios();
		req.setAttribute("professores", professores);
		req.setAttribute("materias", materias);
		req.setAttribute("voluntarios", voluntarios);
		req.getRequestDispatcher("./views/aulas/create.jsp").forward(req, resp);
	}
	
	
	


		
		

	
	

}
