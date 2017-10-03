//package trial_hw3;

public class ClientCode {
		

	public static void main(String[] args) {
		HashTable hashtable = new HashTable();
		hashtable.add(123, "One");
		hashtable.add(3, "Two");
		hashtable.add(5, "Three");
		hashtable.add(0, "Four");
		hashtable.add(9, "Five");
		hashtable.add(97, "Six");
		hashtable.add(569, "Seven");
		hashtable.add(56, "Eight");
		hashtable.add(84, "Nine");
		hashtable.add(45, "Ten");
		
		hashtable.add(477, "Eleven");
     	hashtable.add(688, "Twelve");


		hashtable.add(688, "Bangalore");
		System.out.println(hashtable.toString());
		
		hashtable.update(0, "Calcutta");
		System.out.println(hashtable.toString());
		
		hashtable.remove(0);
		System.out.println(hashtable.toString());
//		
//		hashtable.getAssociation(123);
//		System.out.println(hashtable.printAssociation(123));
//		hashtable.findNextSize();*/


	}

}

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.Set;
//
//public class ClientCode {
//	
//	// Path to desired thesaurus file to read
//	public final static String THESAURUS_FILE = "simple_thesaurus.txt";
//	
//	public static void main(String[] args) throws IOException {
//		File file = new File(THESAURUS_FILE);
//		
//		// Create new empty TextAssociator
//		TextAssociator sc = new TextAssociator();
//		BufferedReader reader = new BufferedReader(new FileReader(file));
//		String text = null;
//		
//		while ((text = reader.readLine()) != null) {
//			String[] words = text.split(",");
//			String currWord = words[0].trim();
//			sc.addNewWord(currWord);
//			//System.out.println("adding words");
//			//sc.prettyPrint();
//			
//			for (int i = 1; i < words.length; i++) {
//				sc.addAssociation(currWord, words[i].trim());
//			}
//			//System.out.println("addAssociation");
//			//sc.prettyPrint();
//			
//			//sc.addNewWord("hard");
//			//sc.getAssociations("happy")
//			//sc.prettyPrint();
//			
////			sc.remove("hard");
////			System.out.println("removing");
////			sc.prettyPrint();
//		}
//		sc.addNewWord("mahima");
//		sc.addNewWord("alan");
//		sc.addNewWord("reshma");
//		sc.prettyPrint();
//		
//			}
//}

