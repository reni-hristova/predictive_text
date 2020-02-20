package predictive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Objects of this class are created using a file 
 * location to a dictionary. The dictionary has to 
 * contain a list of words, each separated on a new 
 * line. The words are stored in a Tree, where each
 * node can have up to 8 children. Each child 
 * corresponds to a number on the phone keyboard
 * (e.g. The first child of the root node corresponds 
 * to '2' and all words that begin with 'a', 'b' or 'c' 
 * are stored in that subtree). Each node contains a set
 * of all words that match the signature so far. The root
 * node stores all words in the dictionary. Each tree
 * also has a variable associated with the depth of the 
 * root node of the tree. 
 * 
 * @author Reni Hristova
 * @version 2020-02-17
 */
public class TreeDictionary implements Dictionary {
    private final int 			depth;
    private TreeSet<String> 	values;
    private TreeDictionary[] 	subTrees;
    
	/**
	 * Constructor - This constructor is only used for the initial creation of
	 * the root node and subtrees, hence it's depth is always 1. 
	 * All subtrees are created with the second constructor.
	 *  
	 * @param dictionaryLocation The path to the dictionary
	 * as a String.
	 */
    public TreeDictionary(String dictionaryLocation) {
    	depth 		= 0;
    	values 		= new TreeSet<>(); 
    	subTrees 	= new TreeDictionary[8];
    	for (int i = 0; i < 8; i++)
    		subTrees[i] = new TreeDictionary(depth + 1);	
    	
    	try {
			Scanner dictionary = new Scanner(new FileReader(dictionaryLocation));
			while(dictionary.hasNextLine()) {
				// Convert to lowecase
				String word = dictionary.nextLine().toLowerCase();
				// Add the word to the dictionary if it is valid
				if(PredictivePrototype.isValidWord(word))
					addElement(word, depth);
			}
			dictionary.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("Dictionary not found.");
		}
    }
    
    /**
     * Constructor for the class, which creates a new subTree 
     * with a given depth of the root node.
     * 
     * @param depth The depth of the current subtree's root as 
     * an integer.
     */
    public TreeDictionary(int depth) {
    	values 		= new TreeSet<>();
    	this.depth  = depth;
    	subTrees 	= new TreeDictionary[8];
    }

    /**	
	 * Add a new element to the dictionary tree.
	 *
     * @param word The value to be added to the String Set in the
	 * Map as a String.
     * @param depth The depth of the current subtree's root as 
     * an integer.
     */
    public void addElement(String word, int depth) {
    	// Add the value to the root
    	if(depth > 0)
    		values.add(word);
    	
    	// Add it to the corresponding subtree
		if(word.length() > depth) {
			String 	signature 	= PredictivePrototype.wordToSignature(word);
			int 	index 		= (Character.getNumericValue(signature.charAt(depth))) - 2;
			if(subTrees[index] == null)
				subTrees[index] = new TreeDictionary(depth + 1);
			subTrees[index].addElement(word, depth + 1);
    	}
    }

    /**
     * @return The depth of the current subtree's root as 
     * an integer.
     */
    public int getDepth() {
    	return depth;
    }
    
	/**
	 * @return The words associated with this node as 
	 * a TreeSet of type String. 
	 */
	public TreeSet<String> getValues() {
		return values;
	}

	/**
	 * @return The children of the current tree as objects
	 * of type TreeDictionary.
	 */
	public TreeDictionary[] getSubTrees() {
		return subTrees;
	}
	
	/**
	 * The method recursively traverses the tree to find the
	 * node, which corresponds to the given signature. After 
	 * finding the node, the method returns all words stored
	 * at that node.
	 * If the node corresponding to that signature does not 
	 * contain any values (or hasn't been created) the method 
	 * returns an empty TreeSet.
	 * 
 	 * @param signature The signature, whose possible 
 	 * matching words, we want to return, as a String.
 	 * @return A set of all words, whose signature matches
 	 * the given signature, as a TreeSet. If there are no
 	 * words associated with the signature, the returned 
 	 * TreeSet is empty.
	 */
    public Set<String> signatureToWords(String signature) {
    	int length = signature.length();
    	if(depth == length) {
    		Set<String> words = new TreeSet<>();
    		getValues().forEach((String word) -> 
    				{ words.add(word.substring(0, length)); });
    		return words;
    	}

    	int index 	= Character.getNumericValue(signature.charAt(depth)) - 2;
    	return (subTrees[index] == null)? new TreeSet<String>() : subTrees[index].signatureToWords(signature);
	}
}