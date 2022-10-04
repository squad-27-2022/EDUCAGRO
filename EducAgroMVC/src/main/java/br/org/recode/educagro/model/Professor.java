package br.org.recode.educagro.model;

public class Professor {
	// Atributos
		private String email;
		private String senha;
		private String nome;
		private int id_professor;
		// Contrutores
		public Professor() {
		}
		
		public Professor(String email, String senha, String nome, int id_professor) {
			super();
			this.email = email;
			this.senha = senha;
			this.nome = nome;
			this.id_professor = id_professor;
		}

		// Getters e Setters

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

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

		public int getId(){
			return id_professor;
		}
		
		public void setId(int id){
			this.id_professor = id;
		}

		public Object getId_professor() {
			// TODO Auto-generated method stub
			return null;
		}
}
