package io.assignments.dataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list1 = List.of(12, 9, 8, 3, 1);
		List<Integer> list2 = List.of(11, 10, 8, 7, 2, 0);

		MergeTwoSortedLists merge = new MergeTwoSortedLists();
		System.out.println("Merged list:: " + merge.mergeTwoLists(list1, list2));
		System.out.println("Merged list using streams:: " + merge.mergeTwoListsUsingStream(list1, list2));
	}

	public List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
		//determining the sorted order
		boolean ascending = list1.get(0) <= list1.get(list1.size() - 1);
		
		List<Integer> res = new ArrayList<>(list1.size() + list2.size());
		int i = 0;
		int j = 0;

		while (i < list1.size() && j < list2.size()) {

			if (ascending) {
				if (list1.get(i) <= list2.get(j)) {
					res.add(list1.get(i++));
				} else {
					res.add(list2.get(j++));
				}
			} else {
				if (list1.get(i) >= list2.get(j)) {
					res.add(list1.get(i++));
				} else {
					res.add(list2.get(j++));
				}
			}
		}
		System.out.println("Res:: " + res);
		
		//adding remaining elements from both lists
		if (i < list1.size()) {
			while (i < list1.size()) {
				res.add(list1.get(i));
				i++;
			}
			System.out.println("Res  : " + res);
		} else {
			while (j < list2.size()) {
				res.add(list2.get(j));
				j++;
			}

		}

		return res;
	}

	//approach 2 
	public List<Integer> mergeTwoListsUsingStream(List<Integer> list1, List<Integer> list2) {
		boolean ascending = list1.get(0) <= list1.get(list1.size() - 1); 
		
		if(ascending)
			return Stream.concat(list1.stream(), list2.stream()).sorted().toList();
		else
			return Stream.concat(list1.stream(), list2.stream()).sorted(Comparator.reverseOrder()).toList();
	}

}
