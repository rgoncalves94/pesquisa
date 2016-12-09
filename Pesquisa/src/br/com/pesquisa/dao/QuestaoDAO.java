package br.com.pesquisa.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.pesquisa.model.Alternativa;
import br.com.pesquisa.model.Questao;

public class QuestaoDAO {
	/**esse metodo fara a inserção ou atualização da questao no banco
	 * ideal criar uma procedure para verificar se ja existe o id da questao no banco
	 * se sim altera se não insere
	 * @param alternativa
	 */
	public void persist(Questao questao){
		System.out.println("PERSISTIU: " + questao.toString());
	}
	
	public void delete(Questao questao){
		System.out.println("DELETOU" + questao.toString());
	}
	
	public Questao selectById(long id){
		return new Questao();
	}
	public List<Questao> selectAll(){
		return new ArrayList<Questao>();
	}
	public List<Questao> selectByNome(String nome){
		return new ArrayList<Questao>();
	}
}
