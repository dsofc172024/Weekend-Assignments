package io.assignments.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAssignment {

	public static void main(String[] args) {
		StreamAssignment obj = new StreamAssignment();
		String sentence = "Java is great. JaVa, JAVA! Java?";
		String word = "Java";

		long res = obj.frequencyCount(word, sentence);
		System.out.println("Word:: " + word + " has a count of:: " + res + "\n");

		List<List<Integer>> listOfList = List.of(List.of(5, 2, 8), List.of(3, 1, 2), List.of(9, 8, 7),
				List.of(4, 6, 5));

		System.out.println("List of list response:: " + obj.mergeLists(listOfList) + "\n");

		List<Integer> list = List.of(2, 4, 6, 8, 9, 10, 12);

		System.out.println(obj.filterEvenTillOddReached(list) + "\n");

		System.out.println("Sum of squares::" + obj.sumOfSquares(5) + "\n");

	}

	// Program to find the word frequency count from a sentence using streams.
	public long frequencyCount(String word, String sentence) {
		String cleaned = sentence.replaceAll("[^a-zA-Z\\s]", "");
		String[] words = cleaned.trim().split("\\s+");

		long count = Arrays.stream(words).filter(e -> e.equals(word)).collect(Collectors.counting());
		return count;
	}

	// Program to merge all List<List<Integer>> into sorted, distinct List<Integer>
	public List<Integer> mergeLists(List<List<Integer>> listOfList) {
		List<Integer> res = listOfList.stream().flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
		return res;
	}

	// Program to find even numbers in an array using streams but condition is till
	// first odd number is encountered
	public List<Integer> filterEvenTillOddReached(List<Integer> list) {
		List<Integer> res = list.stream().takeWhile(n -> n % 2 == 0).collect(Collectors.toList());
		return res;
	}

	// Program to generate numbers till 'n' take from input and find sum of squares.
	public long sumOfSquares(long n) {
		long sum = Stream.iterate(1, e -> e + 1).limit(n).mapToLong(e -> e * e).sum();
		return sum;
	}

}
