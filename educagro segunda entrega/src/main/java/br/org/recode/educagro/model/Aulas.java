package br.org.recode.educagro.model;

public class Aulas {
	
	private int id_aulas;
	private String nomeMateria;
	private String nomeProfessor;
	private String nomeVoluntario;

	public Aulas() {

	}

	public Aulas(String nomeMateria, String nomeProfessor, String nomeVoluntario) {
		super();
		this.nomeMateria = nomeMateria;
		this.nomeProfessor = nomeProfessor;
		this.nomeVoluntario = nomeVoluntario;
	}

	public Aulas(int id_aulas, String nomeMateria, String nomeProfessor, String nomeVoluntario) {
		super();
		this.id_aulas = id_aulas;
		this.nomeMateria = nomeMateria;
		this.nomeProfessor = nomeProfessor;
		this.nomeVoluntario = nomeVoluntario;
	}

	public int getId_aulas() {
		return id_aulas;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public String getNomeVoluntario() {
		return nomeVoluntario;
	}

	public void setId_aulas(int id_aulas) {
		this.id_aulas = id_aulas;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public void setNomeVoluntario(String nomeVoluntario) {
		this.nomeVoluntario = nomeVoluntario;
	}

    public Object getMaterias() {
        // TODO Auto-generated method stub
        return null;
    }




}
