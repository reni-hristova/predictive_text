package predictive;

/**
 * This class is a blueprint for creating objects,
 * containing a pair of Strings representing a word
 * and its corresponding numeric signature.
 * 
 * @author Reni Hristova
 * @version 2020-02-07
 *
 */
public class WordSig implements Comparable<WordSig>{
	private String words;
	private String signature;
	
	/**
	 * Constructor 
	 */
	public WordSig (String words, String signature) {
		this.words 		= words;
		this.signature 	= signature;
	}
	
	/**
	 * @return the word of the pair as a String.
	 */
	public String getWords() {
		return words;
	}
	
	/**
	 * @return the signature of the pair as a String.
	 */
	public String getSignature() {
		return signature;
	}
	
	
	/**
	 * Compare elements based on their signature. 
	 * @param ws The object to which the this object 
	 * will be compared to as an object of type WordSig.
	 */
	public int compareTo(WordSig ws) {
		return this.signature.compareTo(ws.signature);
	}
}	
