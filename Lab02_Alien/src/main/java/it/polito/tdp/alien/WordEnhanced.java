package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	List<String> translations;
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
		translations = new LinkedList<String>();
	}
	
	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public List<String> getTranslations() {
		return translations;
	}

	public void setTranslations(List<String> translations) {
		this.translations = translations;
	}

	public void addWord(String translation) {
	
		for(String s : translations) {
			if(s.equals(translation)) {
				return ;
			}
		}
		
		translations.add(translation);
		
	}
	
	public String toString() {
		
		String risultato = "";
		
		for(String s : translations) {
			if(risultato.equals("")) {
				risultato += s;
			}
			else {
			risultato += ", " +s;
			}
		}
		
		return risultato;
	}

}
