package predictive;

import java.util.Set;

/**
 * Interface class for all dictionary objects. 
 * 
 * @author Reni Hristova
 * @version 2020-02-07
 */
public interface Dictionary {
	
	/**
	 * The method creates a set of possible words,
	 * which correspond to a given numeric signature.
	 * 
 	 * @param signature The signature, whose possible 
 	 * matching words, we want to return, as a String.
 	 * @return A set of all words, whose signature matches
 	 * the given signature, as a Set.
	 */
	public  Set<String> signatureToWords(String signature);
}