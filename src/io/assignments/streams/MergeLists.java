package io.assignments.streams;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

//Program to merge all List<List<Integer>> into sorted, distinct List<Integer>

public class MergeLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeLists obj = new MergeLists();
		List<List<Integer>> listOfList = List.of(List.of(5, 2, 8), List.of(3, 1, 2), List.of(9, 8, 7),
				List.of(4, 6, 5));

		System.out.println("List of list response:: " + obj.mergeLists(listOfList));

	}

	public Set<Integer> mergeLists(List<List<Integer>> listOfList) {
		//List<Integer> res = listOfList.stream().flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
		
		//improvement
		Set<Integer> res = listOfList.stream()
		        .flatMap(List::stream)
		        .collect(Collectors.toCollection(TreeSet::new));
		return res;
	}

}
