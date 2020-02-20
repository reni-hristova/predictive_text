package predictive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 * Objects of this class are created using a file 
 * location to a dictionary. The dictionary has to 
 * contain a list of words, each separated on a new 
 * line. The words are stored in a HashMap. 
 * The class contains methods for converting 
 * words to signatures and vice versa.
 * 
 * @author Reni Hristova
 * @version 2020-02-15
 */
public class MapDictionary implements Dictionary {
	private Map <String, Set<String>> dictionaryMap = new HashMap<>();
	
	/**
	 * Constructor for the class.
	 * @param dictionaryLocation The path to the dictionary
	 * as a String.
	 */
	public MapDictionary(String dictionaryLocation) {
		try {
			Scanner dictionary = new Scanner(new FileReader(dictionaryLocation));
			while(dictionary.hasNextLine()) {
				String word = dictionary.nextLine().toLowerCase();
				if(PredictivePrototype.isValidWord(word))
					addElement(word, PredictivePrototype.wordToSignature(word));
			}
			dictionary.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("Dictionary not found.");
		}
	}
	
	/**
	 * Check whether a key for the word's signature 
	 * exists. If so, add the word to the existing set. 
	 * Otherwise, create a new entry.
	 * 
	 * @param word The value to be added to the String Set in the
	 * Map as a String.
	 * @param signature The key we are searching for in the Map
	 * as a String.
	 */
	public void addElement(String word, String signature) {
		if(dictionaryMap.get(signature)!= null)
			dictionaryMap.get(signature).add(word);
		else {
			Set<String> newSignature = new TreeSet<>();
			newSignature.add(word);
			dictionaryMap.put(signature, newSignature);
		}
	}
	/** 
	 * @return The hashMap of all signatures (as keys) and 
	 * their respective matching words (as a Set of Strings).
	 */
	public Map<String, Set<String>> getDictionaryMap() {
		return dictionaryMap;
	}
	
	/**
	 * Get all words associated with the given signature.
	 * 
 	 * @param signature The signature, whose possible 
 	 * matching words, we want to return, as a String.
 	 * @return A set of all words, whose signature matches
 	 * the given signature, as a TreeSet. If there are no
 	 * words associated with the signature, the returned 
 	 * TreeSet is empty.
	 */
	public Set<String> signatureToWords(String signature) {
		if(dictionaryMap.containsKey(signature))
			return dictionaryMap.get(signature);
		return new TreeSet<>();
	}		
}
