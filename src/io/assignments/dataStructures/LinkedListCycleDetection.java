package io.assignments.dataStructures;

public class LinkedListCycleDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(8);
		ListNode n4 = new ListNode(10);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null; // cycle

		boolean res = cycleDetection(n1);
		if(res)
			System.out.println("Cycle exists!");
		else
			System.out.println("Cycle does not exists!");

	}

	private static boolean cycleDetection(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	

}

class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
	ListNode(int val){
		this.val = val;
	}
}
