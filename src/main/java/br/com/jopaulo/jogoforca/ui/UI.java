package br.com.jopaulo.jogoforca.ui;

import java.util.Scanner;

import br.com.jopaulo.jogoforca.nucleo.LetraInvalidaException;

public class UI {

	public static void escrever(Object texto) {
		System.out.println(texto);
	}
	
	public static void escreverNovaLinha() {
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	public static char lerLetra(String text) throws LetraInvalidaException {
		System.out.println(text + " ");
		
		Scanner scanner = new Scanner(System.in);
		String linha = scanner.nextLine();
		
		if (linha.trim().isEmpty()) {
			throw new LetraInvalidaException("Digite uma letra");
		}
		
		if (linha.length() > 1) {
			throw new LetraInvalidaException("Digite apenas uma letra");
		}
		
		char c = linha.charAt(0);
		
		if (!Character.isLetter(c)) {
			throw new LetraInvalidaException("Apenas letras devem ser digitadas");
		}
		
		return c;
	}
}
