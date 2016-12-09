package br.com.pesquisa.model;

import java.util.List;

public class Questionario {
	private long id;
	private String nome;
	private String descricao;
	private List<Questao> questoes;
	
	
	public Questionario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questionario(long id, String nome, String descricao, List<Questao> questoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.questoes = questoes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	@Override
	public String toString() {
		return "Questionario [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", questoes=" + questoes
				+ "]";
	}
	
	

}
