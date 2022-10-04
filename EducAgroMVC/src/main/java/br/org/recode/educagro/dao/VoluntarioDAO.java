package br.org.recode.educagro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recode.educagro.connection.*;
import br.org.recode.educagro.model.*;

public class VoluntarioDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Voluntario voluntario) {
		String sql = "INSERT INTO Voluntario (senha, nome, email, id_voluntario) values(?, ?, ?, ?)";

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, voluntario.getSenha());

			pstm.setString(2, voluntario.getNome());
			pstm.setString(3, voluntario.getEmail());
			pstm.setInt(4, voluntario.getId_voluntario());
			// Executar a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo para Ler
	public List<Voluntario> getVoluntarios() {
		String sql = "select * from Professor;";

		List<Voluntario> voluntarios = new ArrayList<Voluntario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Voluntario voluntario = new Voluntario();

				voluntario.setSenha(rset.getString("senha"));

				voluntario.setNome(rset.getString("nome"));
				
				voluntario.setEmail(rset.getString("email"));
				
				voluntario.setId_voluntario(rset.getInt("id_voluntario"));

				voluntarios.add(voluntario);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return voluntarios;
	}
	// Metodo pra atualizar

	public void update(Voluntario voluntario) {
		String sql = "UPDATE Voluntario set senha = ?, nome = ?, email = ? where id_voluntario = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, voluntario.getSenha());

			pstm.setString(2, voluntario.getNome());
			
			pstm.setString(3, voluntario.getEmail());
			
			pstm.setInt(4, voluntario.getId_voluntario());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM Voluntario WHERE id_voluntario = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Voluntario getVoluntarioById(int id) {
		String sql = "SELECT * FROM Voluntario WHERE id_voluntario = ?;";

		Voluntario voluntario = new Voluntario();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			voluntario.setSenha(rset.getString("senha"));

			voluntario.setNome(rset.getString("nome"));
			
			voluntario.setEmail(rset.getString("email"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return voluntario;
	}
}
