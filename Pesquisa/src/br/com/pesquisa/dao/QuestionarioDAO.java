package br.com.pesquisa.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.pesquisa.model.Questao;
import br.com.pesquisa.model.Questionario;

public class QuestionarioDAO {
	/**esse metodo fara a inserção ou atualização da questao no banco
	 * ideal criar uma procedure para verificar se ja existe o id da questao no banco
	 * se sim altera se não insere
	 * @param alternativa
	 */
	public void persist(Questionario questionario){
		System.out.println("PERSISTIU: " + questionario.toString());
	}
	
	public void delete(Questionario questionario){
		System.out.println("DELETOU" + questionario.toString());
	}
	
	public Questionario selectById(long id){
		return new Questionario();
	}
	public List<Questionario> selectAll(){
		return new ArrayList<Questionario>();
	}
	public List<Questionario> selectByNome(String nome){
		return new ArrayList<Questionario>();
	}
}
