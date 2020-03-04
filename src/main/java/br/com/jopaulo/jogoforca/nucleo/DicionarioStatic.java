package br.com.jopaulo.jogoforca.nucleo;

import java.util.List;

public class DicionarioStatic extends Dicionario {
	
	private List<String> palavras = List.of("casa", "carro", "gato", "cachorro");
	private int indexAtual = -1;

	@Override
	public Palavra proximaPalavra() {
		indexAtual = (indexAtual + 1) % palavras.size();
		return new Palavra(palavras.get(indexAtual));
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Estático";
	}

}
