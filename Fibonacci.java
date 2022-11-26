package com.deAnza.discreteMath;

import java.util.Objects;
import java.util.Scanner;

public class Fibonacci {
	/*Methods:
	 *Generate nth Fibonacci term 
	 *Return n for given Fibonacci term
	 *Take any natural number and return a unique sum of Fibonacci numbers
	 */
	
	public static void main(String[] args) {
		System.out.println("Enter nth 'int' for the nth term of the Fibonacci series");
		System.out.println("Enter nVal 'int' for the n value for a term in the Fibonacci series");
		System.out.println("Enter fibSum 'int' to write a natural number as a unique sum of Fibonacci numbers");
		System.out.println("Enter quit to terminate the program");
		System.out.println("Please enter a command: ");
		Scanner myObj = new Scanner(System.in);
		String input = myObj.nextLine();
		while (!input.equals("quit")) {
			
			String[] separatedInput = input.split(" ");
			if (Objects.equals(separatedInput[0], "nth")) {
				nthTerm(Integer.valueOf(separatedInput[1]));
			}
			if (Objects.equals(separatedInput[0], "nVal")) {
				nVal(Integer.valueOf(separatedInput[1]));
			}
			if (Objects.equals(separatedInput[0], "fibSum")) {
				nToSum(Integer.valueOf(separatedInput[1]));
			}
			System.out.printf("Please enter a command: ");
			input = myObj.nextLine();
		}
			
	}
	
	public static int nthTerm(int n) {
		int nforN = n;
		int nthTerm = 1;
		int[] previousTerms = new int[100000];
		previousTerms[0] = 1;
		previousTerms[1] = 1;
		int i = 1;
		while(n > 2) {				
			nthTerm += previousTerms[i-1];
			previousTerms[i+1] = nthTerm;
			//System.out.println("previousTerms "+ (i+1) + ": " + previousTerms[i+1]);
			i++;
			n--;
		}
		System.out.println(nforN + "th Fibonacci Number: " + nthTerm);
		return nthTerm;
	}
	
	public static int nVal(int n) {
		int nthTerm = 1;
		int[] previousTerms = new int[100000];
		previousTerms[0] = 1;
		previousTerms[1] = 1;
		int i = 1;
		while(n > nthTerm) {				
			nthTerm += previousTerms[i-1];
			previousTerms[i+1] = nthTerm;
			//System.out.println("previousTerms "+ (i+1) + ": " + previousTerms[i+1]);
			i++;
		}
		if(n == nthTerm) {
			System.out.println(n + " is the " + (i+1) + "th Fibonacci Number");
			return i+1;			
		}
		else {
			System.out.println(n + " is not a Fibonacci Number");
		}
		return 0;		
	}
	
	public static int largestFibUpto(int n) {
		int nthTerm = 1;
		int[] previousTerms = new int[100000];
		previousTerms[0] = 1;
		previousTerms[1] = 1;
		int i = 1;
		while(n >= nthTerm) {				
			nthTerm += previousTerms[i-1];
			previousTerms[i+1] = nthTerm;
			//System.out.println("previousTerms "+ (i+1) + ": " + previousTerms[i+1]);
			i++;
		}
		//System.out.println(previousTerms[i-1]);
		return previousTerms[i-1];
	}
	
	public static int[] nToSum(int n) {
		int[] sum = new int[10000];
		String sumToPrint = "";
		int i = 0;
		while(n > 0) {
			sum[i] = largestFibUpto(n);
			n = n - sum[i];
			i++;
		}
		for(int j = 0; j < i - 1; j++) {
			sumToPrint += sum[j] + " + ";
		}
		sumToPrint += sum[i-1];
		System.out.println(sumToPrint);
		return sum;
		
	}
}
