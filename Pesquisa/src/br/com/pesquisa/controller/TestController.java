package br.com.pesquisa.controller;

import br.com.pesquisa.dao.QuestionarioDAO;
import br.com.pesquisa.model.Questionario;

public class TestController {
	
	public static void main(String[] args) {
		QuestionarioDAO dao = new QuestionarioDAO();
		
		Questionario q = new Questionario();
		
		q.setDescricao("Minha pergunta teste");
		
		dao.persist(q);
	}
}
