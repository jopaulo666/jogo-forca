package br.com.jopaulo.jogoforca.nucleo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.jopaulo.jogoforca.jogo.JogoException;
import br.com.jopaulo.jogoforca.utils.RandomUtils;

public class ArquivoDicionario extends Dicionario {

	private static final String NOME_ARQUIVO = "dicionario.txt";
	private List<String> palavras = new ArrayList<>();
	
	public ArquivoDicionario() {
		carregar();
	}

	private void carregar() {		
		try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + NOME_ARQUIVO))){
			
			while (scanner.hasNextLine()) {
				String palavra  = scanner.nextLine().trim();
				palavras.add(palavra);
			}
			
			if (palavras.size() == 0) {
				throw new JogoException("A lista de paçavras não pode ser vazia");
			}
		}		
	}
	
	@Override
	public Palavra proximaPalavra() {
		int pos = RandomUtils.novoRandomNumero(0, palavras.size());
		return new Palavra(palavras.get(pos));
	}

	@Override
	public String getNome() {
		return "Arquivo " + NOME_ARQUIVO;
	}
}
