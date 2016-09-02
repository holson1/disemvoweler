import java.util.Scanner;


public class Disemvoweler {
	
	public String entry;
	public char[] devoweled;
	public char[] vowels;
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		Disemvoweler dv = new Disemvoweler();
		int vowelCount = 0;
		
		System.out.println("Please enter a string: ");
		
		//get string
		dv.entry = in.nextLine();
		int strLength = dv.entry.length();
		
		dv.devoweled = new char[strLength];
		dv.vowels = new char[strLength];
		
		//convert entry to char array
		dv.entry.getChars(0, strLength, dv.devoweled, 0);
		
		//search for vowels and remove them
		for(int i=0; i<strLength;) {
			
			//if there is a vowel or space
			if(dv.devoweled[i] == 'a' || dv.devoweled[i] == 'e' || dv.devoweled[i] == 'i' ||
					dv.devoweled[i] == 'o' || dv.devoweled[i] == 'u' || dv.devoweled[i] == ' ') {
				
				//if it's not a space, put it in the vowel array
				if(dv.devoweled[i] != ' ') {
					dv.vowels[vowelCount] = dv.devoweled[i];
					vowelCount++;
				}
				
				//right shift
				for(int j=i; j<strLength-1; j++)
					dv.devoweled[j] = dv.devoweled[j+1];
				
				//update array
				dv.devoweled[strLength-1] = '\0';
				strLength--;
			}
			else
				//only advance to the next elt if there's no swapping
				i++;
		}
		
		//display devoweled string and vowels
		for(int i=0; i<strLength; i++)
			System.out.print(dv.devoweled[i]);
		System.out.println();
		for(int i=0; i<vowelCount; i++)
			System.out.print(dv.vowels[i]);
	}
}
