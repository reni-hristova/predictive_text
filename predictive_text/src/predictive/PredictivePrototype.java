package predictive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * The class contains methods for converting words to 
 * signatures and vice versa.
 * A signature of a word in this class corresponds to 
 * the numbers one would type in a phone keypad similar
 * to the following:
 * 
 * 		1		|	2(abc)	|	3(def)
 * 		4(ghi)	|	5(jkl)	|	6(mno)
 * 		7(pqrs)	|	8(tuv)	|	9(wxyz)
 * 
 * where the each of the letters in bracket is typed 
 * using the number in front of the brackets once.
 * 
 * @author Reni Hristova
 * @version 2020-02-07
 */
public class PredictivePrototype {
	
	/**
	 * Convert a word to its corresponding numeric signature.
	 * 
	 * Using a StringBuffer here is significantly
	 * more efficient than using a String object
	 * as the '+' function of a String creates a new 
	 * StringBuffer object, uses the append method,
	 * then converts the result to String. The StringBuffer
	 * is in this manner more efficient in terms of 
	 * both time and space complexity.
	 * 
	 * @param word The word, whose signature we want to 
	 * return, as a String.
	 * @return The signature of the word, where each 
	 * letter is replaces with the corresponding number
	 * as a String.
	 */
 	public static String wordToSignature(String word) {
 		StringBuffer signature = new StringBuffer();
 		for(int i = 0; i < word.length(); i++) {
 			switch(word.toLowerCase().charAt(i)) {
 				case 'a': case 'b': case 'c': signature.append('2'); break;
	 			case 'd': case 'e': case 'f': signature.append('3'); break;
	 			case 'g': case 'h': case 'i': signature.append('4'); break;
	 			case 'j': case 'k': case 'l': signature.append('5'); break;
	 			case 'm': case 'n': case 'o': signature.append('6'); break;
	 			case 'p': case 'q': case 'r': case 's': signature.append('7'); break;
	 			case 't': case 'u': case 'v': signature.append('8'); break;
	 			case 'w': case 'x': case 'y': case 'z': signature.append('9'); break;
	 			default:  signature.append(' '); break;
 			}
 		}
 		return signature.toString();
 	}
 	
	/**
	 * Create a list of possible words, corresponding 
	 * to a given numeric signature.
	 * 
	 * The method reads each line from a file, then 
	 * converts the line to lower case and compares
	 * the given signature to the signature of each word 
	 * in the dictionary.
	 *
	 * This implementation of the dictionary is not 
	 * efficient as it requires for the method to read 
	 * every entry in the dictionary file and compare
	 * it to the given signature. As the method needs to
	 * be executed for each given signature independently
	 * the time complexity of the method is exponential 
	 * in the worst cases. 
	 *
 	 * @param signature The signature, whose possible 
 	 * matching words, we want to return, as a String.
 	 * @return A set of all words, whose signature matches
 	 * the given signature, as a TreeSet.
 	 */
	public static Set<String> signatureToWords(String signature){
		Set<String> words 	 = new TreeSet<>();
		String 	fileLocation = "DICTIONARY_LOCATION.txt";				// Replace with the location of the dictionary.
		try {
			Scanner dictionary = new Scanner(new FileReader(fileLocation));
			while(dictionary.hasNextLine()) {
				String word = dictionary.nextLine().toLowerCase();
				if(signature.equals(wordToSignature(word)))
					words.add(word);
			}
			dictionary.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("Dictionary not found.");
		}
		return words;
	}
	
	/**
	 * Check if a given word is 'valid' a.k.a
	 * contains only lower case letters from the English 
	 * alphabet. 
	 * 
	 * @param word A String we want to check.
	 * @return true If the String contains only 
	 * lower case letters from the English alphabet.
	 * @return false If the String does not contain
	 * only lower case letters from the English 
	 * alphabet.
	 */
	public static boolean isValidWord(String word) {
		return word.matches("[a-z]*");
	}
}