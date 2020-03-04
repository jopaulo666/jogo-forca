package br.com.jopaulo.jogoforca.utils;

import java.util.Random;

public class RandomUtils {
	
	private static Random random = new Random();

	public static int novoRandomNumero(int min, int max) {
		return random.nextInt(max - min) + min;
	}
}
