package io.assignments.dataStructures;

import java.util.Stack;

public class QueueUsingTwoStacks {
	
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingTwoStacks q = new QueueUsingTwoStacks();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Removed element:: " + q.dequeue());

        q.display();

        System.out.println("Is queue empty:: " + q.isEmpty());
	}
	
	//push operation
	public void enqueue(int element) {
		
		//copy stack1 to stack2
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		
		//push element into primary stack
		stack1.push(element);
		
		// copy s2 to s1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
		
	}
	
	public boolean isEmpty() {
		return stack1.isEmpty();
	}
	

    // Pop operation (Dequeue)
    public int dequeue() {

        // s1.pop(top)
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return stack1.pop();
    }

    public void display() {
    	System.out.println("Displaying queue elements:: "+stack1);
    }
    
}
