package io.assignments.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Program to find the word frequency count from a sentence using streams. Case insensitive
public class WordCountInASentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = "Java is great. JaVa, JAVA! Java?";
		
		WordCountInASentence obj = new WordCountInASentence();
		Map<String, Long> res = obj.frequencyCount(sentence);
		System.out.println(res);

	}
	
	public Map<String, Long> frequencyCount(String sentence) {
		if(sentence.isEmpty() || sentence == null)
			return null;
		
	    String cleaned = sentence.replaceAll("[^a-zA-Z\\s]", "");
	    String[] words = cleaned.trim().split("\\s+");

	    return Arrays.stream(words)
	            .collect(Collectors.groupingBy(
	                    Function.identity(),
	                    Collectors.counting()
	            ));
	}

}
