package br.org.recode.educagro.model;

public class Voluntario {
	private String senha;
	private String nome;
    private String email;
	private int id_voluntario;
	// Contrutores
	public Voluntario() {
	}
	
	public Voluntario(String senha, String nome, String email, int id_voluntario) {
		super();
		this.senha = senha;
		this.nome = nome;
        this.email = email;
		this.id_voluntario = id_voluntario;
	}

	// Getters e Setters

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public int getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(int id_voluntario) {
        this.id_voluntario = id_voluntario;
    }
}
