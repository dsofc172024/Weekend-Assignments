package io.assignments.dataStructures;

//Program to show palindromic string using two pointers.?
public class PalindromeUsingTwoPointers {

	public static void main(String[] args) {
		String input = "";
		PalindromeUsingTwoPointers obj = new PalindromeUsingTwoPointers();
		
		System.out.println("Result:: "+obj.palindromeCheck(input));
				
	}

	public boolean palindromeCheck(String input) {
		
		if(input == null || input.isEmpty())
			return false;
		else if(input.length() == 1)
			return true;
		
		input = input.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
			
		int right = input.length()-1;
		
		for(int left=0; left<input.length()/2; left++) {
			if(input.charAt(left) != input.charAt(right)) {
				return false;
			}
			right--;
		}
		return true;
	}
}
