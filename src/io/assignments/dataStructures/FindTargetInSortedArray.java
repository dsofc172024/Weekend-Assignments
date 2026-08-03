package io.assignments.dataStructures;

//Program to find the target in sorted array based on order & return the index.

public class FindTargetInSortedArray {

	public static void main(String[] args) {
		
		FindTargetInSortedArray obj = new FindTargetInSortedArray();

        int[] arr1 = {2, 4, 6, 8, 10, 12, 14};
        int[] arr2 = {13, 11, 10, 9, 7, 5, 3, 1, 0};

        System.out.println("Ascending:: "+obj.findTarget(null, 10));   
        System.out.println("Descending:: "+obj.findTarget(arr2, 10)); 

	}

	public int findTarget(int[] arr, int target) {
		// validation
		if (arr == null)
			return -1;
		if (arr.length == 1 && target == arr[0])
			return 0;
		if(arr.length == 1 && target != arr[0]) 
			return -1;
		
		
		//asc or desc check
		if(arr[0] < arr[arr.length - 1]) {
			return binarySearch(arr, target, "asc");
		}
		else {
			return binarySearch(arr, target, "desc");
		}
		
	}
	
	public int binarySearch(int[] arr, int target, String order) {
		int left = 0;
		int right = arr.length-1;
		
		 while (left <= right) {
	            int mid = left + (right - left) / 2;

	            if (arr[mid] == target) {
	                return mid;
	            }

	            //ascending check
	            if (order.equals("asc")) {

	                if (target < arr[mid]) {
	                    right = mid - 1;
	                } else {
	                    left = mid + 1;
	                }

	            } else { // descending check

	                if (target < arr[mid]) {
	                    left = mid + 1;
	                } else {
	                    right = mid - 1;
	                }
	            }
	        }

	        return -1;
	}

}
