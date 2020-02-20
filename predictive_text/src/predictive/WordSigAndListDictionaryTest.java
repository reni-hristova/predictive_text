package predictive;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Reni Hristova
 * @version 2020-02-10
 */
class WordSigAndListDictionaryTest {
	private String dictionaryLocation;
	private ListDictionary dictionary;
	
	@BeforeEach
	public void initial() {
		dictionaryLocation =  "DICTIONARY_LOCATION.txt";			// Replace with the location of the dictionary.
		dictionary = new ListDictionary(dictionaryLocation);
	}
	// Tes the WordSig class.
	@Test
	public void WordSigTest1() {
		WordSig object 		= new WordSig("levanter", "53826837");
		String expectedWord = "levanter";
		String actualWord	= object.getWords();
		String expectedSignature = "53826837";
		String actualSignature 	 = object.getSignature();
		assertEquals(expectedWord, actualWord, "Error in WordSig constructor.");
		assertEquals(expectedSignature, actualSignature, "Error in WordSig constructor.");	
	}
	
	@Test
	public void WordSigTest2() {
		WordSig object 		= new WordSig("", "");
		String expectedWord = "";
		String actualWord	= object.getWords();
		String expectedSignature = "";
		String actualSignature 	 = object.getSignature();
		assertEquals(expectedWord, actualWord, "Error in WordSig constructor.");
		assertEquals(expectedSignature, actualSignature, "Error in WordSig constructor.");
	}
	
	@Test
	public void WordSigTest3() {
		WordSig empty 	 = new WordSig("", "");
		WordSig levanter = new WordSig("levanter", "53826837");
		WordSig saint 	 = new WordSig("saint", "72468");
		WordSig sain 	 = new WordSig("sain", "7246");
		WordSig rain 	 = new WordSig("rain", "7246");
		WordSig pain 	 = new WordSig("pain", "7246");
		assertTrue(empty.compareTo(levanter) < 0, 	"Error in WordSig compareTo method.");
		assertTrue(sain.compareTo(saint) < 0, 		"Error in WordSig compareTo method.");
		assertTrue(rain.compareTo(sain) == 0, 		"Error in WordSig compareTo method.");
		assertTrue(pain.compareTo(rain) == 0, 		"Error in WordSig compareTo method.");
		assertTrue(pain.compareTo(levanter) > 0,	"Error in WordSig compareTo method.");
		assertTrue(saint.compareTo(rain) > 0, 		"Error in WordSig compareTo method.");
		
	}
	
	// The following set of tests tests the ListDictionary class.
	@Test
	public void wordToSignatureTest1() {
		String word 	= "levanter";
		String expected = "53826837";
		String actual 	= ListDictionary.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature ListDictionary method.");
	}
	
	@Test
	public void wordToSignatureTest2() {
		String word 	= "Picture";
		String expected = "7428873";
		String actual 	= ListDictionary.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature ListDictionary method.");
	}
	
	@Test
	public void wordToSignatureTest3() {
		String word 	= "Sleepless Tomato dusk lost";
		String expected = "753375377 866286 3875 5678";
		String actual 	= ListDictionary.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature ListDictionary method.");
	}
	
	@Test
	public void wordToSignatureTest4() {
		String word 	= "soldier brain beautiful pain LEGACY 44-2+one";
		String expected = "7653437 27246 232884385 7246 534229      663";
		String actual 	= ListDictionary.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature ListDictionary method.");
	}
	
	@Test
	public void wordToSignatureTest5() {
		String word 	= "";
		String expected = "";
		String actual 	= ListDictionary.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature ListDictionary method.");
	}
	
	@Test
	public void wordToSignatureTest6() {
		String word 	= "legacy brain soldier always spectacular beautiful glee "
							+ "glamour dusk dust hello bee you tomato picture Levanter "
							+ "Lost Lilly saho sain saint paiN life-long rago crain rain "
							+ "artistry";
		String expected = "534229 27246 7653437 259297 77328228527 232884385 4533 "
							+ "4526687 3875 3878 43556 233 968 866286 7428873 53826837 "
							+ "5678 54559 7246 7246 72468 7246 5433 5664 7246 27246 7246 "
							+ "27847879";
		String actual 	= ListDictionary.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature prototype method.");
	}
	
	@Test
	public void wordToSignatureTest7() {
		String word 	= "123456";
		String expected = "      ";
		String actual 	= ListDictionary.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature ListDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest1() {
		String signature	 = "";
		Set<String> expected = new TreeSet<String>();
		Set<String> actual 	 = dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords ListDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest2() {
		String signature 	 = "534229";
		Set<String> expected = new TreeSet<String>();
		expected.add("legacy");
		Set<String> actual 	= dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords ListDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest3() {
		String signature 	 = "232884385";
		Set<String> expected = new TreeSet<String>();
		expected.add("beautiful");
		Set<String> actual 	= dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords ListDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest4() {
		String signature 		= "7246";
		String[] expectedArray	= {"pain", "rago", "rain", "saho", "sain"};
		Set<String> expected 	= new TreeSet<String>();
		for(String element: expectedArray)
			expected.add(element);
		Set<String> actual 	= dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords ListDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest5() {
		String signature 		= "27246";
		String[] expectedArray 	= {"brain", "crain"};
		Set<String> expected 	= new TreeSet<String>();
		for(String element: expectedArray)
			expected.add(element);
		Set<String> actual 	= dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords ListDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest6() {
		String signature 	 = "753375377";
		Set<String> expected = new TreeSet<String>();
		Set<String> actual 	 = dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords ListDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest7() {
		String signature 	 = "5433 5664";
		Set<String> expected = new TreeSet<String>();
		Set<String> actual 	 = dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords ListDictionary method.");
	}
}