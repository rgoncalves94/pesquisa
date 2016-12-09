package br.com.pesquisa.model;

public class Alternativa {
	private long id;
	private String afirmacao;
	private boolean estaCorreta;
	private boolean escolhida;
	
	public Alternativa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alternativa(long id, String afirmacao, boolean estaCorreta, boolean escolhida) {
		super();
		this.id = id;
		this.afirmacao = afirmacao;
		this.estaCorreta = estaCorreta;
		this.escolhida = escolhida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAfirmacao() {
		return afirmacao;
	}

	public void setAfirmacao(String afirmacao) {
		this.afirmacao = afirmacao;
	}

	public boolean isEstaCorreta() {
		return estaCorreta;
	}

	public void setEstaCorreta(boolean estaCorreta) {
		this.estaCorreta = estaCorreta;
	}

	public boolean isEscolhida() {
		return escolhida;
	}

	public void setEscolhida(boolean escolhida) {
		this.escolhida = escolhida;
	}

	@Override
	public String toString() {
		return "Alternativa [id=" + id + ", afirmacao=" + afirmacao + ", estaCorreta=" + estaCorreta + ", escolhida="
				+ escolhida + "]";
	}
	
	

}
