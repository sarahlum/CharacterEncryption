//2D Character Array Encryption Program

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class TwoDimensionalCharacterArray {
		
		public static void main(String[] args) throws IOException{ 
			//1 open file for reading
	
			FileInputStream fileByteStream = new FileInputStream("input.in");
			Scanner inFS = new Scanner(fileByteStream);

			//2 declare 2D array to store tabular data 
			char[][] letters = new char[5][7];
			
			//3 arraylist to read and manipulate data
			ArrayList<Character> charList = new ArrayList<Character>();
			
			//4 while there's data to read, read from file and store to arraylist charList
			while(inFS.hasNext()) {
				
				String word = inFS.next(); //store next file word in String word
				
				for(int a = 0; a < word.length(); a++) { //iterate through each word to add each character to charList
					char letter = word.charAt(a); 		// a is the index of the letter in each word
					charList.add(letter);				//store each character of word in arraylist charList
				} 
				//add space after each word unless it's the last word
				if(inFS.hasNext()) {
					charList.add(' ');
				}
			}
		
			//5 close file
			fileByteStream.close();
			inFS.close();
			
			//6a. If arrayList is too short
			//fill charList arraylist to size of 2DArray if it's too short i.e. if it's not equal to 2DArray row * column (total size, not indices)
			if(charList.size() < (((letters.length) * (letters[0].length)))) {
				for(int b = charList.size(); b < (((letters.length) * (letters[0].length))); b++) { //indices should still be one less than 2D row * column since it's referring to index, not size
					charList.add('*');
				}
			}		
			
			//6b. if arrayList is too long
			//remove characters from arraylist charList to meet twoDArray length until words is equal to twoDArray total cells
			int c = (charList.size())-1; //c is the index being removed, starting from the last index	
			while((charList.size()) > ((letters.length * letters[0].length))) {
				charList.remove(c);
				c--;
			}	
				
			//7 convert arraylist words to an array
			char[] lettersArray = new char[charList.size()];
			
			for(int d = 0; d < charList.size(); d++) {
    			lettersArray[d] = charList.get(d);
			}
			 
			//8 copying lettersArray to letters(2D) as indicated (forward on even rows, backward on odd rows)
			int e = 0; //c to access indices of lettersArray. initializing outside loop so it doesn't reset each time
			for(int m = 0; m < letters.length; m++) {	
				//even rows
				if(m % 2 == 0) {
					//n to access column indices
					for(int n = 0; n < letters[m].length; n++ ) {
						letters[m][n] = lettersArray[e];
						e++;
					} 
				} else { //odd rows, print right to left
					//n to access column indices backwards
					for(int n = letters[m].length-1; n >= 0; n-- ) {
						letters[m][n] = lettersArray[e];
							e++;								
					} 		
				}
			} 
			
			//9 Extract characters from 2D letters into a new string
			//pull in column-major order
			String code = "";
			
			//add letters(2D) into String code
			//f is the column indices.
			for(int f = 0; f < (letters[0].length); f++) {
				//g is the row indices. 
				for(int g = 0; (g < letters.length); g++) {
					code += (letters[g][f]);
				}
			} 
			//10 output as String
			System.out.println(code);

	} //end main

} //end class




		