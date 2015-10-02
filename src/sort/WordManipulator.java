package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WordManipulator {
	
	/*
	 * Sorting each letter of a word in the list alphabetically.
	 */
	public static ArrayList<String> SortAlphabetically(List<String> words) {
		char[] chars = null;
		ArrayList<String> sortedWords = new ArrayList<String>();
		for (int i=0; i<words.size(); i++) {
			chars = words.get(i).toCharArray();
			Arrays.sort(chars);
			sortedWords.add(new String(chars));
		}
		return sortedWords;
	}
	/*
	 * Find any anagrams using the sorted words and return a list with all anagram words.
	 */
	public static ArrayList<String> FindAnagrams(List<String> words, ArrayList<String> sortedWords) {
		
		/* 
		 * Using a hashmap to get performance ~O(n) instead of brute force search which is O(n^2).
		 * Creating a list containing indexes for each word and possible duplicate entries.
		 */
		HashMap<String, ArrayList<Integer>> indexes = new HashMap<String, ArrayList<Integer>>();
		
		for (int i=0; i<sortedWords.size(); i++) {
			ArrayList<Integer> hashedIndexes = indexes.get(sortedWords.get(i));
			/*
			 * When its a new entry.
			 */
			if (hashedIndexes == null) {
				ArrayList<Integer> index = new ArrayList<Integer>();
				index.add(i);
				indexes.put(sortedWords.get(i), index);
				continue;
			}
			hashedIndexes.add(i);
			indexes.put(sortedWords.get(i), hashedIndexes);
		}
		
		/*
		 * Traverse the map using all keys, adding only entries with more
		 * than one index (an anagram). 
		 */
		ArrayList<String> keys = new ArrayList<String>();
		keys.addAll(indexes.keySet());
		ArrayList<String> anagrams = new ArrayList<String>();
		for (int i=0; i<keys.size(); i++) {
			String tmp = "";
			ArrayList<Integer> anagramIndexes = indexes.get(keys.get(i));
			if (anagramIndexes.size() < 2)
				continue;
			for (int j=0; j<anagramIndexes.size(); j++) {
				tmp = tmp + words.get(anagramIndexes.get(j)) + " ";
			}
			anagrams.add(tmp);
		}
		Collections.sort(anagrams);
		return anagrams;
	}
}
