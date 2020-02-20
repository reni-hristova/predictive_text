package predictive;

/**
 * This class contains a command line program, which 
 * takes a list of Strings and prints pairs of the 
 * words and their corresponding signatures 
 * using the PredictivePrototype class.
 * 
 * @author Reni Hristova
 * @version 2020-02-08
 *
 */
public class Words2SigProto {	
	public static void main(String[] args) {
		for(String element: args)
				System.out.println(element + " : " + PredictivePrototype.wordToSignature(element));	
	}	
}