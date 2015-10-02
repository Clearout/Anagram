package main;

import java.util.ArrayList;
import java.util.List;
import sort.WordManipulator;
import file.FileLoader;

public class Anagram {

	public static void main(String[] args) {
		List<String> words = FileLoader.loadOrdbok();
		ArrayList<String> sortedWords = WordManipulator.SortAlphabetically(words);
		ArrayList<String> anagrams = WordManipulator.FindAnagrams(words, sortedWords);
		for (int i=0; i<anagrams.size(); i++) {
			System.out.println(anagrams.get(i));
		}		
	}
}
