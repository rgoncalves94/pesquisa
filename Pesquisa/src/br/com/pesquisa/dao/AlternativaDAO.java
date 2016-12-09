package br.com.pesquisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pesquisa.model.Alternativa;

public class AlternativaDAO {
	
	private Connection conn;
	/**esse metodo fara a inserção ou atualização da questao no banco
	 * ideal criar uma procedure para verificar se ja existe o id da questao no banco
	 * se sim altera se não insere
	 * @param alternativa
	 */
	public void persist(Alternativa Alternativa, int pergunta){
		try {
			conn = DBConnection.getConnection();
			
			//String sql = "INSERT INTO PESQUISAS (PESQUISA_ID, PESQUISA_NOME, PESQUISA_ATIVO, USUARIO_ID) VALUES (SEQ_PESQUISAS.nextval, ?, 1, 1); commit;";
			
			String sql = "begin  PERSISTEALTERNATIVA(?, ?, ?); end;";
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setLong(1 , Alternativa.getId());
			stmt.setString(2 , Alternativa.getAfirmacao());
			stmt.setInt(3 , pergunta);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Alternativa Alternativa){
		try {
			conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM OPCOES_RESPOSTA WHERE OPCAO_RESPOSTA_ID = ?;";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setLong(1 , Alternativa.getId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Alternativa selectById(long id){
		Alternativa q = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "select OPCAO_RESPOSTA_ID, OPCAO_RESPOSTA_DESCRICAO, OPCAO_RESPOSTA_VALOR_PADRAO, TIPO_CAMPO_ID, PERGUNTA_ID from opcoes_resposta where opcao_resposta_id = ?;";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setLong(1 , id);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				q = new Alternativa();
				q.setId(rs.getLong("OPCAO_RESPOSTA_ID"));
				q.setAfirmacao(rs.getString("OPCAO_RESPOSTA_DESCRICAO"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return q;
	}
	public List<Alternativa> selectAll(){
		List<Alternativa> qs = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "select OPCAO_RESPOSTA_ID, OPCAO_RESPOSTA_DESCRICAO, OPCAO_RESPOSTA_VALOR_PADRAO, TIPO_CAMPO_ID, PERGUNTA_ID from opcoes_resposta;";
		
		
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			
			ResultSet rs = stmt.executeQuery();
			qs = new ArrayList<Alternativa>();
			while (rs.next()) {
				Alternativa q = new Alternativa();
				q.setId(rs.getLong("OPCAO_RESPOSTA_ID"));
				q.setAfirmacao(rs.getString("OPCAO_RESPOSTA_DESCRICAO"));
				
				qs.add(q);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qs;
	}
	
	public List<Alternativa> selectByNome(String nome){
		List<Alternativa> qs = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "select OPCAO_RESPOSTA_ID, OPCAO_RESPOSTA_DESCRICAO, PERGUNTA_ID from opcoes_resposta where OPCAO_RESPOSTA_DESCRICAO like ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setString(1, "%" + nome + "%");
			
			ResultSet rs = stmt.executeQuery();
			qs = new ArrayList<Alternativa>();
			while (rs.next()) {
				Alternativa q = new Alternativa();
				q.setId(rs.getLong("OPCAO_RESPOSTA_ID"));
				q.setAfirmacao(rs.getString("OPCAO_RESPOSTA_DESCRICAO"));
				
				qs.add(q);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qs;
	}
}
