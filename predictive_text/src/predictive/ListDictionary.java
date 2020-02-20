package predictive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Objects of this class are created using a file 
 * location to a dictionary. The dictionary has to 
 * contain a list of words, each separated on a new 
 * line. The words are stored in a sorted ArrrayList.
 * The class contains methods for converting 
 * words to signatures and vice versa.
 * 
 * @author Reni Hristova
 * @version 2020-02-08
 */
public class ListDictionary implements Dictionary {
	private ArrayList<WordSig> dictionaryArray = new ArrayList<>();
	
	/**
	 * Constructor for the class. Copies all entries, which contain 
	 * only letters of the English alphabet into an ArrayList after 
	 * converting each word to lower case and creating a WordSig 
	 * object with it and its corresponding signature.
	 * 
	 * @param dictionaryLocation The path to the dictionary
	 * as a String.
	 */	
	public ListDictionary(String dictionaryLocation) {
		try {
			Scanner dictionary = new Scanner(new FileReader(dictionaryLocation));
			while(dictionary.hasNextLine()) {
				String word = dictionary.nextLine().toLowerCase();
				if(PredictivePrototype.isValidWord(word))
					dictionaryArray.add(new WordSig(word, PredictivePrototype.wordToSignature(word)));
			}
			dictionary.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("Dictionary not found.");
		}
		// Sort the array
		Collections.sort(dictionaryArray);
	}
	
	/**
	 * Convert a given word to its corresponding signature.
	 * 
	 * @param word The word, whose signature we want to 
	 * return, as a String.
	 * @return The signature of the word, where each 
	 * letter is replaces with the corresponding number
	 * as a String.
	 */
	public static String wordToSignature(String word) {
		return PredictivePrototype.wordToSignature(word);
	}
	
	/**
	 * TCreate a set of possible words, which correspond 
	 * to a given numeric signature.
	 * 
	 * The method uses the sorted ArrayList of type 
	 * WordSig and performs a binary search to find the 
	 * first matching word. Then, it searches around it 
	 * for other possible matches.
	 * 
 	 * @param signature The signature, whose possible 
 	 * matching words, we want to return, as a String.
 	 * @return A set of all words, whose signature matches
 	 * the given signature, as a TreeSet.
 	 */
	public Set<String> signatureToWords(String signature) {
		Set<String> words 		 = new TreeSet<>();
		WordSig 	signatureObj = new WordSig("", signature);
		int 		firstIndex 	 = Collections.binarySearch(dictionaryArray, signatureObj);
		
		if(firstIndex < 0)
			return new TreeSet<>();
		words.add(dictionaryArray.get(firstIndex).getWords());
		
		int cursorUp 	= firstIndex + 1,			// the cursor is used to scan elements above the first match
			cursorDown 	= firstIndex - 1,			// the cursor is used to scan elements below the first match
			check1 		= 0,
			check2 		= 0;
		
		while(check1 == 0 || check2 == 0) {
			check1 = (cursorUp >= dictionaryArray.size())? -1 : dictionaryArray.get(cursorUp).compareTo(signatureObj);
			check2 = (cursorDown < 0)? -1 : dictionaryArray.get(cursorDown).compareTo(signatureObj);
			
			if(check1 == 0){
				words.add(dictionaryArray.get(cursorUp).getWords());
				cursorUp++;
			}
			if(check2 == 0){
				words.add(dictionaryArray.get(cursorDown).getWords());
				cursorDown--;
			}
		}
		return words;
	}
}