import java.net.URL;
import java.util.Scanner;

public class MovieTitleGen
{
	public static void main(String[] args) throws Exception
	{

		String[] adjectives = arrayFromUrl("https://cs.leanderisd.org/txt/adjectives.txt");
		String[] nouns      = arrayFromUrl("https://cs.leanderisd.org/txt/nouns.txt");

		System.out.println("Myxyllplyk's Random Movie Title Generator\n");

		System.out.print("Choosing randomly from " + adjectives.length + " adjectives ");
		System.out.println("and " + nouns.length + " nouns (" + (adjectives.length*nouns.length) + " combinations).");

		int adj   = 0 + (int)(Math.random()* adjectives.length); // random num gen of length of adjectives array
		int n  = 0 + (int)(Math.random()* nouns.length); // random num gen of length of nouns array
		String adjective= adjectives[adj]; // obtains the adjective at the random location chosen
		String noun= nouns[n]; // obtains the noun at the random location chosen

		System.out.println( "Your movie title is: " + adjective.substring(0, 1).toUpperCase() +adjective.substring(1) + " " + noun.substring(0,1).toUpperCase() + noun.substring(1) ); //prints the randomly generated movie title
	}

	/**
	*	@param url - the URL to read words from
	*	@return An array of words, initialized from the given URL
	*/	
	public static String[] arrayFromUrl( String url ) throws Exception
	{
		Scanner fin = new Scanner((new URL(url)).openStream());
		int count = fin.nextInt();

		String[] words = new String[count];

		for ( int i=0; i<words.length; i++ )
		{
			words[i] = fin.next();
		}
		fin.close();

		return words;
	}

}