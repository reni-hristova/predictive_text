package predictive;

import java.util.Set;

/**
 * This class contains a command line program, which 
 * takes a list of given signatures from and prints all 
 * matching words for that signature on a new line, using
 * the MapDictionary class.
 * 
 * @author Reni Hristova
 * @version 2020-02-15
 */
public class Sigs2WordsMap {
	public static void main(String[] args) {
		MapDictionary dictionary = new MapDictionary("DICTIONARY_LOCATION.txt");		// Replace with the location of the dictionary.
		for(String element: args) {
			Set<String> words = dictionary.signatureToWords(element);
			System.out.print(element + " :");
			if(words.isEmpty())
				System.out.println(" No words in this dictionary "
									+ "correspond to this signature.");
			else {
				for(String word: words)
					System.out.print(" " + word);
				System.out.println();
			}
		}
	}
}