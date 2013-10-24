import java.util.*;

/**
 * All the text problems will be answered in this class
 * @author Sean
 *
 */
public class TextProjects {

	private static List<String> games; // Keeps track of all the games
	private static List<Character> vowels;
	/**
	 * The command center for all of the files
	 */
	public static void main(String[] args) {
		games = new ArrayList<String>();
		games.add("'Q': to quit");
		games.add("Reverse String");
		games.add("Recursive Reverse String");
		games.add("Pig Latin");
		games.add("Vowel Counter");
		
		vowels = new ArrayList<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		Scanner console = new Scanner(System.in);
		printInfo();
		String game = console.next().toLowerCase();
		while (!game.equals("q")) {
			System.out.print("Please enter a word: ");
			String word = console.next().toLowerCase();
			
			if (game.equals("1")) {
				reverseString(word);
			} else if (game.equals("2")) {
				recursiveReverse(word);
			} else if(game.equals("3")) {
				pigLatin(word);
			} else if(game.equals("4")) {
				vowelCounter(word);
			}
			
			System.out.println();
			printInfo();
			game = console.next();
		}
	}
	
	/**
	 * Prints all the games the user has to choose from
	 */
	public static void printInfo() {
		System.out.println(games.get(0));
		for (int i = 1; i < games.size(); i++) {
			System.out.println("\'" + i + "\': " + games.get(i));
		}
		System.out.print("What game do you want to play? (enter number) ");
	}
	
	/**
	 * Prints the string backwards
	 * @param line string to be reversed
	 */
	public static void reverseString(String line) {
		System.out.println("Word is:  " + line);
		System.out.print("Reversed: ");
		for (int i = line.length()-1; i >= 0; i--) {
			System.out.print(line.charAt(i));
		}
		System.out.println();
	}
	
	/**
	 * Reverses the string recursively
	 * @param line string to be reversed
	 */
	public static void recursiveReverse(String line) {
		if (line.length() <= 1) {
			System.out.println(line);
		} else {
			System.out.print(line.charAt(line.length()-1));
			recursiveReverse(line.substring(0, line.length()-1));
		}
	}
	
	/**
	 * Print the Pig Latin of a word
	 * @param word - word being changed
	 */
	public static void pigLatin(String word) {
		System.out.println("Word is: " + word);
		System.out.print("Result:  ");
		String ending = getConsonants(word);
		String newWord = word.substring(ending.length());
		if (ending.length() == 0) {
			ending += "w";
		}
		System.out.println(newWord + ending + "ay");
	}
	
	/**
	 * @param word - word being used
	 * @return the beginning consonants of a word
	 */
	private static String getConsonants(String word) {
		vowels.add('y');
		String consonants = "";
		if (word.charAt(0) == 'y') {
			consonants = "y";
			word = word.substring(1);
		}
		
		while (word.length() > 0 && !vowels.contains(word.charAt(0))) {
			consonants += word.charAt(0); 
			word = word.substring(1);
		}
		vowels.remove('y');
		return consonants;
	}
	
	/**
	 * Counts all the vowels in a word and the number of characters hit
	 * @param word - word that vowels will be counted
	 */
	public static void vowelCounter(String word) {
		Map<Character, Integer> vowelCount = new TreeMap<Character, Integer>();
		int count = 0;
		
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			if (vowels.contains(character)) {
				count++;
				if (vowelCount.containsKey(character)) {
					vowelCount.put(character, vowelCount.get(character) + 1);
				} else {
					vowelCount.put(character, 1);
				}
			}
		}
		
		System.out.println(count + " vowels");
		for (Character c : vowelCount.keySet()) {
			System.out.println(c + " appeared " + vowelCount.get(c) + " times");
		}
	}

}
