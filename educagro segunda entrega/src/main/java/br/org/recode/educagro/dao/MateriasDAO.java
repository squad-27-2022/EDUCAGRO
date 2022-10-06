package br.org.recode.educagro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recode.educagro.connection.*;
import br.org.recode.educagro.model.*;

public class MateriasDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Materias materia) {
		String sql = "insert into materia(nome) values(?)";

		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, materia.getNome());
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
	public List<Materias> getMaterias() {
		
		String sql = "select * from materia;";

		List<Materias> materia = new ArrayList<Materias>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Materias materias = new Materias();
				materias.setId_materia(rset.getInt("id_materia"));
				materias.setNome(rset.getString("nome"));
				materia.add(materias);
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
		return materia;
	}
	// Metodo pra atualizar

	public void update(Materias materia) {
		String sql = "UPDATE Materia set nome = ? where id_materia = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

		
			pstm.setString(1, materia.getNome());
			
			pstm.setInt(2, materia.getId_materia());

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
		String sql = "DELETE FROM materia WHERE id_materia = ?";

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

	public Materias getMateriaById(int id) {
		String sql = "SELECT * FROM Materia WHERE id_materia = ?;";

		Materias materia = new Materias();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			materia.setNome(rset.getString("nome"));
			materia.setId_materia(Integer.parseInt(rset.getString("id_materia")));

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

		return materia;
	}
}
