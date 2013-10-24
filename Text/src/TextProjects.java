/**
 * All the text problems will be answered in this class
 * @author Sean
 *
 */
public class TextProjects {

	/**
	 * The command center for all of the files
	 */
	public static void main(String[] args) {
		reverseString("Hello World!");
		System.out.println();
		
		reverseString("0123456789");
		System.out.println();
		
		System.out.println("Word is:  0123456789");
		System.out.print("Reversed: ");
		recursiveReverse("0123456789");
		System.out.println();
		
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
			System.out.print(line);
		} else {
			System.out.print(line.charAt(line.length()-1));
			recursiveReverse(line.substring(0, line.length()-1));
		}
	}

}
