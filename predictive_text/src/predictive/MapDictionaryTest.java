package predictive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Reni Hristova
 * @version 2020-02-17
 */
class MapDictionaryTest {
	private String dictionaryLocation;
	private MapDictionary dictionary;
	
	@BeforeEach
	public void initial() {
		dictionaryLocation = "DICTIONARY_LOCATION.txt";		// Replace with the location of the dictionary.
		dictionary = new MapDictionary(dictionaryLocation);		
	}
	
	@Test
	public void signatureToWordsTest1() {
		String signature	 = "";
		Set<String> expected = new TreeSet<String>();
		Set<String> actual 	 = dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords MapDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest2() {
		String signature 	 = "534229";
		Set<String> expected = new TreeSet<String>();
		expected.add("legacy");
		Set<String> actual 	= dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords MapDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest3() {
		String signature 	 = "232884385";
		Set<String> expected = new TreeSet<String>();
		expected.add("beautiful");
		Set<String> actual 	= dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords MapDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest4() {
		String signature 		= "7246";
		String[] expectedArray	= {"pain", "rago", "rain", "saho", "sain"};
		Set<String> expected 	= new TreeSet<String>();
		for(String element: expectedArray)
			expected.add(element);
		Set<String> actual 	= dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords MapDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest5() {
		String signature 		= "27246";
		String[] expectedArray 	= {"brain", "crain"};
		Set<String> expected 	= new TreeSet<String>();
		for(String element: expectedArray)
			expected.add(element);
		Set<String> actual 	= dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords MapDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest6() {
		String signature 	 = "753375377";
		Set<String> expected = new TreeSet<String>();
		Set<String> actual 	 = dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords MapDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest7() {
		String signature 	 = "5433 5664";
		Set<String> expected = new TreeSet<String>();
		Set<String> actual 	 = dictionary.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords MapDictionary method.");
	}
}