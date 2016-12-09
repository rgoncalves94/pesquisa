package br.com.pesquisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pesquisa.model.Alternativa;
import br.com.pesquisa.model.Questao;
import br.com.pesquisa.model.Questionario;

public class QuestaoDAO {
	private Connection conn;
	/**esse metodo fara a inserção ou atualização da questao no banco
	 * ideal criar uma procedure para verificar se ja existe o id da questao no banco
	 * se sim altera se não insere
	 * @param alternativa
	 */
	public void persist(Questao q, long questionario){
		try {
			conn = DBConnection.getConnection();
			
			//String sql = "INSERT INTO PERGUNTAS (PERGUNTA_ID, PERGUNTA_DESCRICAO, PESQUISA_ID) VALUES (SEQ_PERGUNTAS.nextval, ?, ?);";
			
			String sql = "begin  persistePergunta(?, ?, ?); end;";
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setLong(1, q.getId());
			stmt.setString(2 , q.getPergunta());
			stmt.setLong(3 , questionario);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Questao q){
		try {
			conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM PERGUNTAS WHERE PERGUNTA_ID = ?;";
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setLong(1 , q.getId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Questao selectById(long id){
		Questao q = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "SELECT PERGUNTA_ID, PERGUNTA_DESCRICAO, PESQUISA_ID FROM PERGUNTAS WHERE PERGUNTA_ID = ?;";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setLong(1 , id);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				q = new Questao();
				q.setId(rs.getLong("PERGUNTA_ID"));
				q.setPergunta(rs.getString("PERGUNTA_DESCRICAO"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return q;
	}
	public List<Questao> selectAll(){
		List<Questao> q = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "SELECT PERGUNTA_ID, PERGUNTA_DESCRICAO, PESQUISA_ID FROM PERGUNTAS";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			q = new ArrayList<Questao>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Questao qx = new Questao();
				qx.setId(rs.getLong("PERGUNTA_ID"));
				qx.setPergunta(rs.getString("PERGUNTA_DESCRICAO"));
				
				q.add(qx);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return q;
	}
	public List<Questao> selectByNome(String nome){
		List<Questao> q = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "SELECT PERGUNTA_ID, PERGUNTA_DESCRICAO, PESQUISA_ID FROM PERGUNTAS WHERE PERGUNTA_DESCRICAO LIKE ?";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, "%" + nome + "%");
				
			q = new ArrayList<Questao>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Questao qx = new Questao();
				qx.setId(rs.getLong("PERGUNTA_ID"));
				qx.setPergunta(rs.getString("PERGUNTA_DESCRICAO"));
				
				q.add(qx);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return q;
	}
}
