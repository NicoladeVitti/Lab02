package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	//List<Word> dizionario;
	List<WordEnhanced> dizionario;
	
	public AlienDictionary() {
		//dizionario = new LinkedList<Word>();
		dizionario = new LinkedList<WordEnhanced>();
	}

	public void addWord(String alienWord, String translation) {
		
		/*
		for(Word w : dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				w.setTranslation(translation);
				return ;
			}
		}
		
		Word word = new Word(alienWord, translation);
		dizionario.add(word);
		*/
		
		for(WordEnhanced w : dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				w.addWord(translation);
				return ;
			}
		}
		
		WordEnhanced word = new WordEnhanced(alienWord);
		word.addWord(translation);
		dizionario.add(word);
	}
	
	public String translateWord(String alienWord) {
		
		/*
		for(Word w : dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				return w.getTranslation();
			}
		}
		
		return null;
		*/
		
		for(WordEnhanced w : dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				return w.toString();
			}
		}
		
		return null;
	}
}
