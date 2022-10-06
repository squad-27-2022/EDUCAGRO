package br.org.recode.educagro.model;

public class Materias {
	 private int id_materia;
	    private String nome;

	    // Contrutores
	    public Materias() {
	    }

	    public Materias(int id_materia, String nome) {
	        super();
	        this.id_materia = id_materia;
	        this.nome = nome;
	    }

	    // Getters e Setters

	    public Materias(String nome2) {
			this.nome = nome2;
		}

		public Materias(String nome2, int id) {
			this.nome = nome2;
			this.id_materia = id;
		}

		public int getId_materia() {
	        return id_materia;

	    }

	    public void setId_materia(int id_materia) {
	        this.id_materia = id_materia;

	    }

	    public String getNome() {
	        return nome;
	    }

	    public  void setNome(String nome) {
	        this.nome = nome;
	    }
}
