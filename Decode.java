//Hamza Alsarhan

import java.io.*;

public class Decode {
	
	/*
	 * Initializing global variables that will be used in the program.
	 */
	public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public static char[] stdFreq = {'e','t','a','o','i','n','s','h','r','d','l','u','c','m','f','w','y','p','v','b','g','k','q','j','x','z'};
	public static int[] freq = new int[26];
	public static char[] mapping = new char[26];
	public static int mapIndex;
	public static String[] decodedMessage = new String[1500];
	
	
	/*
	 * Goes through the files and counts the frequency of each letters in the file
	*/
	public static int[] countFreq(String[] message){
		
		int j = 0;
		while (j<message.length && message[j] !=null){
			char[] letters = message[j].toCharArray();
			//increments the value at the index of the letter in the freq array when it finds a letter
			for(int i=0; i<letters.length; i++){
				if (Character.isLetter(letters[i])){
				freq[alphabet.indexOf(letters[i])] ++;
			
				}	
			}
		j++;

		}
		return freq;
	}
	

	/*
	 * uses the freq of letters in the file to sort them in descending order in terms of frequencies
	 * and maps the letters in this new array to the ones from the alphabet
	 */
	public static char[] mapping(int[] freq){
		//creates an alphabet character array
		char[] alphabetC = alphabet.toCharArray();
		
		for (mapIndex = 0; mapIndex< freq.length; mapIndex++){
			int max = 0;
			int maxIndex = -1;
			
			for (int j = 0; j<freq.length; j++){
				if (freq[j] >= max){
					max = freq[j];
					maxIndex = j;	
				}
			}
			mapping[mapIndex] = alphabetC[maxIndex];
			//set index = -1, so the loop doesn't go back to the letter again
			freq[maxIndex] = -1;
		}
		return mapping;
	}
	
	/*
	 * Uses the mapping character array to decode the message inputted as a parameter
	 */
	public static String[] decoder(String[] message){
		
		char[] alphabetC = alphabet.toCharArray();
		String words = new String(mapping(countFreq(message)));
		
		int i = 0;
		while (i< message.length && message[i] != null){
			char[] letters = message[i].toCharArray();
			char[] word = new char[letters.length];
			
			//checks what letters from the mapping array match letters from the stdFreq and replaces them
			for(int j=0; j<letters.length; j++){
				if (Character.isLetter(letters[j])){
					word[j] = stdFreq[words.indexOf(letters[j])];
			}
				else{
					word[j] = letters[j];
				}		
		}
			String finalDecoding = new String(word);
			decodedMessage[i] = finalDecoding;
			i++;	
	}
	return decodedMessage;
	}
	
}