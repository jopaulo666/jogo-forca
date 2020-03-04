package br.com.jopaulo.jogoforca.nucleo;

import java.lang.reflect.Constructor;

public abstract class Dicionario {

	private static Dicionario instance;
	
	public static Dicionario getInstance() {
		if (instance == null) {
			try {
				String nomeDaClasseDeDicionario = Config.get("nomeDaClasseDeDicionario");
				Class<?> class1 = Class.forName(nomeDaClasseDeDicionario);
				Constructor<?> constructor = class1.getConstructor();
				instance = (Dicionario) constructor.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}			
		}
		return instance;
	}
	
	public abstract Palavra proximaPalavra();
	
	public abstract String getNome();
	
	
}
