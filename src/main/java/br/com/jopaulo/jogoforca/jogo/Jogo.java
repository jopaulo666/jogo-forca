package br.com.jopaulo.jogoforca.jogo;

import java.util.HashSet;
import java.util.Set;

import br.com.jopaulo.jogoforca.nucleo.Config;
import br.com.jopaulo.jogoforca.nucleo.Dicionario;
import br.com.jopaulo.jogoforca.nucleo.LetraInvalidaException;
import br.com.jopaulo.jogoforca.nucleo.Palavra;
import br.com.jopaulo.jogoforca.ui.UI;

public class Jogo {

	public void comecar() {
		UI.escrever("Bem vindo ao jogo da forca");
		
		Dicionario dicionario = Dicionario.getInstance();
		UI.escrever("Dicionário usado: " + dicionario.getNome());
		
		Palavra palavra = dicionario.proximaPalavra();
		
		UI.escrever("A palavra tem " + palavra.tamanho() + " letras");
		
		Set<Character> letraUsada = new HashSet<>();
		int erroCont = 0;
		
		int errosMax = Integer.parseInt(Config.get("errosMax"));
		UI.escrever("Número de chances: " + errosMax);
		
		while (true) {
			UI.escrever(palavra);
			UI.escreverNovaLinha();
			
			char c;
			try {
				c = UI.lerLetra("Digite uma letra: ");
				
				if (letraUsada.contains(c)) {
					throw new LetraInvalidaException("Esta letra já foi usada");
				}
				
				letraUsada.add(c);
				
				if (palavra.encontroLetra(c)) {
					UI.escrever("Você acertou uma letra!");
				} else {
					erroCont++;
					
					if (erroCont <= errosMax) {
						UI.escrever("Errou! Você ainda tem " + (errosMax - erroCont) + " chances");
					}
				}				
				
				UI.escreverNovaLinha();
				
				if (palavra.mostrar()) {
					UI.escrever("Parabéns, você acertou a palavra " + palavra.getPalavraOriginal());
					UI.escrever("Fim de jogo");
					break;
				}
				
				if (erroCont == errosMax) {
					UI.escrever("Infelizmente, você não acertou a palavra correta: " + palavra.getPalavraOriginal());
					UI.escrever("Fim de jogo");
					break;
				}
				
				
			} catch (LetraInvalidaException e) {
				UI.escrever("Erro: " + e.getMessage());
				UI.escreverNovaLinha();
			}
		}
	}
}
