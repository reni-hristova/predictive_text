package predictive;

import java.util.Set;

/**
 * This class contains a command line program, which takes 
 * a list of given signatures and prints all matching 
 * words for that signature on a new line, using
 * the PredictivePrototype class.
 * 
 * @author Reni Hristova
 * @version 2020-02-08
 *
 */
public class Sigs2WordsProto {
	public static void main(String[] args) {
		for(String element: args) {
			Set<String> words = PredictivePrototype.signatureToWords(element);
			System.out.print(element + " :");
			
			if(words.isEmpty())
				System.out.println(" No words in this dictionary "
									+ "correspond to this signature.");
			else{ 
				for(String word: words)
					if(PredictivePrototype.isValidWord(word))
						System.out.print(" " + word);
				System.out.println();
			}
		}
	}
}