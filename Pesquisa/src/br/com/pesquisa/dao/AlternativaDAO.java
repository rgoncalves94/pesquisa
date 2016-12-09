package br.com.pesquisa.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.pesquisa.model.Alternativa;

public class AlternativaDAO {
	
	/**esse metodo fara a inser��o ou atualiza��o da alternativa no banco
	 * ideal criar uma procedure para verificar se ja existe o id da alternativa no banco
	 * se sim altera se n�o insere
	 * @param alternativa
	 */
	public void persist(Alternativa alternativa){
		System.out.println("PERSISTIU: " + alternativa.toString());
	}
	
	public void delete(Alternativa alternativa){
		System.out.println("DELETOU" + alternativa.toString());
	}
	
	public Alternativa selectById(long id){
		return new Alternativa();
	}
	public List<Alternativa> selectAll(){
		return new ArrayList<Alternativa>();
	}
	public List<Alternativa> selectByNome(String nome){
		return new ArrayList<Alternativa>();
	}
}
