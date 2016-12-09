package br.com.pesquisa.model;

import java.util.List;

public class Questao {
	private long id;
	private String pergunta;
	private List<Alternativa> alternativas;
	
	public Questao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questao(long id, String pergunta, List<Alternativa> alternativas) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.alternativas = alternativas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	@Override
	public String toString() {
		return "Questao [id=" + id + ", pergunta=" + pergunta + ", alternativas=" + alternativas + "]";
	}
	
	
	
}
