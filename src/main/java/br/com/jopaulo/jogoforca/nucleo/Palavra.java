package br.com.jopaulo.jogoforca.nucleo;

import java.util.HashSet;
import java.util.Set;

public class Palavra {

	private static  final char LETRA_SECRETA = '_';	
	private String palavraOriginal;
	private Set<Character> letrasEncontradas = new HashSet<>();
	private Set<Character> letrasSemDuplicidade = new HashSet<>();

	public Palavra(String palavraOriginal) {
		this.palavraOriginal = palavraOriginal.toUpperCase();
		
		char[] letras = this.palavraOriginal.toCharArray();
		for (char c : letras) {
			letrasSemDuplicidade.add(c);
		}
	}
	
	public int tamanho() {
		return palavraOriginal.length();
	}
	
	public boolean encontroLetra(char c) {
		c = Character.toUpperCase(c);
		
		if (palavraOriginal.indexOf(c) > -1) {
			letrasEncontradas.add(c);
			return true;			
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); // monta uma string em várias partes
		
		char[] letrasArray = palavraOriginal.toCharArray();
		
		for (int i = 0; i < letrasArray.length; i++) {
			char c = letrasArray[i];
			
			if (letrasEncontradas.contains(c)) {
				builder.append(c);
			} else {
				builder.append(LETRA_SECRETA);
			}
			builder.append(" ");
		}
		return builder.toString();
	}
	
	public boolean mostrar() {
		return letrasEncontradas.equals(letrasSemDuplicidade);
	}
	
	public String getPalavraOriginal() {
		return palavraOriginal;
	}
}
