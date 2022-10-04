package br.org.recode.educagro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recode.educagro.connection.*;
import br.org.recode.educagro.model.Aulas;
import br.org.recode.educagro.model.*;

public class AulasDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Aulas aula) {
		String sql = "INSERT INTO aulas () values(?, ?)";

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, aula.getMaterias());
			pstm.setString(2, aula.getProfessor());
			pstm.setString(3, aula.getVoluntario());
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

	// TODO rever método getAulas(GILSON)
	// Metodo para Ler
	public List<Aulas> getAulas() {
		String sql = "select * from aulas;";

		List<Aulas> aulas = new ArrayList<Aulas>();
		List<Materias> materias = new ArrayList<Materias>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Aulas aula = new Aulas();

				aula.setId_aulas(rset.getInt("id_aula"));

				((Materias) materias).setNome(rset.getString("nome_aula"));
				
		

				aulas.add(aula);

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

		return aulas;
	}
	
	// TODO rever método updateAulas(GILSON)
	// Metodo pra atualizar
	public void update(Aulas aula) {
		String sql = "UPDATE aulas set id_professor = ?, id_voluntario = ?, id_materia = ? where id_aula = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setObject(1, aula.getProfessor());

			pstm.setObject(2, aula.getVoluntario());
			
			pstm.setObject(2, aula.getMaterias());

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
	
	// TODO rever método deleteById(GILSON)
	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM aulas WHERE id_aula = ?";

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

	//TODO rever método getaulaById(GILSON)
	public Aulas getaulaById(int id) {
		String sql = "SELECT * FROM aulas WHERE id_aula = ?;";

		Aulas aula = new Aulas();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			aula.setId_aulas(rset.getInt("id_aula"));

			aula.setMaterias(rset.getString("nome_aula"));

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

		return aula;
	}
}
