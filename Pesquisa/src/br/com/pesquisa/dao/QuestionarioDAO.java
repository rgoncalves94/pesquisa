package br.com.pesquisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pesquisa.model.Questao;
import br.com.pesquisa.model.Questionario;

public class QuestionarioDAO {
	private Connection conn;
	/**esse metodo fara a inserção ou atualização da questao no banco
	 * ideal criar uma procedure para verificar se ja existe o id da questao no banco
	 * se sim altera se não insere
	 * @param alternativa
	 */
	public void persist(Questionario questionario){
		try {
			conn = DBConnection.getConnection();
			
			//String sql = "INSERT INTO PESQUISAS (PESQUISA_ID, PESQUISA_NOME, PESQUISA_ATIVO, USUARIO_ID) VALUES (SEQ_PESQUISAS.nextval, ?, 1, 1); commit;";
			
			String sql = "begin  persistePesquisa(?, ?); end;";
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setLong(1 , questionario.getId());
			stmt.setString(2 , questionario.getDescricao());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Questionario questionario){
		try {
			conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM PESQUISAS WHERE PESQUISA_ID = ?;";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setLong(1 , questionario.getId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Questionario selectById(long id){
		Questionario q = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "SELECT PESQUISA_ID, PESQUISA_NOME, PESQUISA_ATIVO, USUARIO_ID FROM PESQUISAS WHERE PESQUISA_ID = ?;";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setLong(1 , id);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				q = new Questionario();
				q.setId(rs.getLong("PESQUISA_ID"));
				q.setDescricao(rs.getString("PESQUISA_NOME"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return q;
	}
	public List<Questionario> selectAll(){
		List<Questionario> qs = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "SELECT PESQUISA_ID, PESQUISA_NOME, PESQUISA_ATIVO, USUARIO_ID FROM PESQUISAS;";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			
			ResultSet rs = stmt.executeQuery();
			qs = new ArrayList<Questionario>();
			while (rs.next()) {
				Questionario q = new Questionario();
				q.setId(rs.getLong("PESQUISA_ID"));
				q.setDescricao(rs.getString("PESQUISA_NOME"));
				
				qs.add(q);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qs;
	}
	
	public List<Questionario> selectByNome(String nome){
		List<Questionario> qs = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "SELECT PESQUISA_ID, PESQUISA_NOME, PESQUISA_ATIVO, USUARIO_ID FROM PESQUISAS where PESQUISA_NOME like ? ;";
			
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setString(1, "%" + nome + "%");
			
			ResultSet rs = stmt.executeQuery();
			qs = new ArrayList<Questionario>();
			while (rs.next()) {
				Questionario q = new Questionario();
				q.setId(rs.getLong("PESQUISA_ID"));
				q.setDescricao(rs.getString("PESQUISA_NOME"));
				
				qs.add(q);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qs;
	}
}
