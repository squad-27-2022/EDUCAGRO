package br.org.recode.educagro.model;

public class Aulas {
	
	private int id_aulas;
	public String materias;
	public String professor;
	public String voluntario;

	public Aulas() {

	}

	public Aulas(String professor, String voluntario,String materias) {
		this.professor = professor;
		this.voluntario = voluntario;
		this.materias = materias;

	}

// Gets e Sets

	public void setProfessor(String professor) {
		this.professor = professor;

	}

	public String getProfessor() {
		return professor;

	}

	public void setVoluntario(String voluntario) {
		this.voluntario = voluntario;
	}

	public String getVoluntario() {
		return voluntario;

	}

	public void setMaterias(String materias) {
		this.materias = materias;

	}

	public String getMaterias() {
		return materias;

	}

	public int getId_aulas() {
		return id_aulas;
	}

	public void setId_aulas(int id_aulas) {
		this.id_aulas = id_aulas;
	}

}
