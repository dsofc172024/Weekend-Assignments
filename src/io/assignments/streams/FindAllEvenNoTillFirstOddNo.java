package io.assignments.streams;

import java.util.List;
import java.util.stream.Collectors;

//Program to find even numbers in an array using streams but condition is till
// first odd number is encountered

public class FindAllEvenNoTillFirstOddNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FindAllEvenNoTillFirstOddNo obj = new FindAllEvenNoTillFirstOddNo();
		List<Integer> list = List.of(2, 4, 6, 8, 9, 10, 12);
		System.out.println(obj.filterEvenTillOddReached(list) + "\n");

	}

	public List<Integer> filterEvenTillOddReached(List<Integer> list) {
		List<Integer> res = list.stream().takeWhile(n -> n % 2 == 0).collect(Collectors.toList());
		return res;
	}

}
