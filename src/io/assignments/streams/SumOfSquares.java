package io.assignments.streams;

import java.util.Scanner;
import java.util.stream.Stream;

//Program to generate numbers till 'n' take from input and find sum of squares.
public class SumOfSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		SumOfSquares obj = new SumOfSquares();

        try {
            System.out.print("Enter a positive number: ");

            long n = scanner.nextLong();

            long result = obj.sumOfSquares(n);

            System.out.println("Sum of squares = " + result);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");

        } finally {
            scanner.close();
        }
	}
	
	 public static long sumOfSquares(long n) {
	        if (n < 1) {
	            throw new IllegalArgumentException("Enter a positive number!");
	        }

	        return Stream.iterate(1L, i -> i + 1)
	                .limit(n)
	                .mapToLong(i -> i * i)
	                .sum();
	    }

}
