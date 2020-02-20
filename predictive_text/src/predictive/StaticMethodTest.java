package predictive;

import java.util.Set;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/** 
 * @author Reni Hristova
 * @version 2020-02-09
 */
class StaticMethodTest {
	
	@Test
	public void wordToSignatureTest1() {
		String word 	= "levanter";
		String expected = "53826837";
		String actual 	= PredictivePrototype.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature prototype method.");
	}
	
	@Test
	public void wordToSignatureTest2() {
		String word 	= "Picture";
		String expected = "7428873";
		String actual 	= PredictivePrototype.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature prototype method.");
	}
	
	@Test
	public void wordToSignatureTest3() {
		String word 	= "Sleepless Tomato dusk lost";
		String expected = "753375377 866286 3875 5678";
		String actual 	= PredictivePrototype.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature prototype method.");
	}
	
	@Test
	public void wordToSignatureTest4() {
		String word 	= "soldier brain beautiful pain LEGACY 44-2+one";
		String expected = "7653437 27246 232884385 7246 534229      663";
		String actual 	= PredictivePrototype.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature prototype method.");
	}
	
	@Test
	public void wordToSignatureTest5() {
		String word 	= "";
		String expected = "";
		String actual 	= PredictivePrototype.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature prototype method.");
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
		String actual 	= PredictivePrototype.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature prototype method.");
	}
	
	@Test
	public void wordToSignatureTest7() {
		String word 	= "123456";
		String expected = "      ";
		String actual 	= PredictivePrototype.wordToSignature(word); 
		assertEquals(expected, actual, "Error in wordToSignature ListDictionary method.");
	}
	
	@Test
	public void signatureToWordsTest1() {
		String signature 	 = "";
		Set<String> expected = new TreeSet<String>();
		Set<String> actual 	 = PredictivePrototype.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords prototype method.");
	}
	
	@Test
	public void signatureToWordsTest2() {
		String signature 	 = "534229";
		Set<String> expected = new TreeSet<String>();
		expected.add("legacy");
		Set<String> actual 	 = PredictivePrototype.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords prototype method.");
	}
	
	@Test
	public void signatureToWordsTest3() {
		String signature 	 = "232884385";
		Set<String> expected = new TreeSet<String>();
		expected.add("beautiful");
		Set<String> actual 	 = PredictivePrototype.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords prototype method.");
	}
	
	@Test
	public void signatureToWordsTest4() {
		String signature 		= "7246";
		String[] expectedArray	= {"pain", "rago", "rain", "saho", "sain"};
		Set<String> expected 	= new TreeSet<String>();
		for(int i = 0; i < expectedArray.length ;i++)
			expected.add(expectedArray[i]);
		Set<String> actual 	= PredictivePrototype.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords prototype method.");
	}
	
	@Test
	public void signatureToWordsTest5() {
		String signature 		= "27246";
		String[] expectedArray 	= {"brain", "crain"};
		Set<String> expected 	= new TreeSet<String>();
		for(int i = 0; i < expectedArray.length ;i++)
			expected.add(expectedArray[i]);
		Set<String> actual 	= PredictivePrototype.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords prototype method.");
	}
	
	@Test
	public void signatureToWordsTest6() {
		String signature 	 = "753375377";
		Set<String> expected = new TreeSet<String>();
		Set<String> actual 	 = PredictivePrototype.signatureToWords(signature); 
		assertEquals(expected, actual, "Error in signatureToWords prototype method.");
	}
	
	@Test
	public void isValidWordTest1() {
		assertTrue(PredictivePrototype.isValidWord("artistry"), "Error in isValidWord method.");
		assertTrue(PredictivePrototype.isValidWord("fountain"), "Error in isValidWord method.");
		assertTrue(PredictivePrototype.isValidWord("mosquito"), "Error in isValidWord method.");
		assertTrue(PredictivePrototype.isValidWord(""), 		"Error in isValidWord method.");
	}
	
	@Test
	public void isValidWordTest2() {
		assertFalse(PredictivePrototype.isValidWord("3D"), 			"Error in isValidWord method.");
		assertFalse(PredictivePrototype.isValidWord("MAX"), 		"Error in isValidWord method.");
		assertFalse(PredictivePrototype.isValidWord("Predicate"), 	"Error in isValidWord method.");
		assertFalse(PredictivePrototype.isValidWord("new star"), 	"Error in isValidWord method.");
		assertFalse(PredictivePrototype.isValidWord("birthDay"), 	"Error in isValidWord method.");
		assertFalse(PredictivePrototype.isValidWord("$s*^&f"), 	 	"Error in isValidWord method.");
		assertFalse(PredictivePrototype.isValidWord("co-operation"), "Error in isValidWord method.");
	}
}