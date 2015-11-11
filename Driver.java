//Hamza Alsarhan

import java.io.*;
import java.util.Scanner;


public class Driver {

	public static String[] sentence = new String[1500];

	
	public static void main(String[] args) throws Exception{
		
		//Prompts the user for an encoded filename
		Message myMessage = new Message();
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome!");
		System.out.println("Please enter a filename with an encoded message (q to quit) : ");
		String filename = scan.nextLine();
		
		//Prints a goodbye statement if user wants to quit the program
		if (filename.equals("q")){
			System.out.println("Goodbye!");
		}
		else{
			//Reads file line by line and word by word
			File openFile = new File(filename);
			Scanner filereader = new Scanner(openFile);
			
			System.out.println("Reading and decoding message in "+ filename + "...");
			int i = 0;
			while (filereader.hasNext()){
				sentence[i] = filereader.next();
				i++;	
			}
			myMessage.encodedMessage = sentence;
			
			//Fills up the decodedMessage String array, initialized in the Message class, with decoded words
			myMessage.decodedMessage = Decode.decoder(myMessage.encodedMessage);
			
			
			
			/*
			 * Creates a new text file and writes the decoded message into it.
			 */
			String outfile = filename.replaceAll("encoded", "decoded");
			BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
			System.out.println("Decoded message printed to " + outfile);
			System.out.println("Message: ");
			int j = 0;
			while(j< myMessage.decodedMessage.length && myMessage.decodedMessage[j] !=null){
				System.out.print(myMessage.decodedMessage[j] + " ");
				out.write(myMessage.decodedMessage[j] + " ");
				j++;
			}
			out.close();
	
		}
	}
	
	
}

	
/*
 * This is the comment that indicates what each of the encoded files is:
 * 
 * encoded1 -> Declaration of Independence
 * encoded2 -> Alice's Adventures in Wonderland
 * encoded3 -> The Adventures of Sherlock Holmes
 * encoded4 -> The Adventures of Hucklebury Finn
 * encoded5 -> Pride and Prejudice  
 */
	
	

