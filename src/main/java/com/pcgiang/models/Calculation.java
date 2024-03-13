package com.pcgiang.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Calculation {
	public int firstNum;
	public int secondNum;
	public String operator;
	public int correctAns;
	
	private static HashSet<int[]> previousPairs = new HashSet<>();
	
	public Calculation() {
		previousPairs.clear(); // clear previous pairs set at the beginning
		int[] pair = generatePairs();
		this.firstNum = pair[0];
		this.secondNum = pair[1];
		this.operator = "x";
		this.correctAns = calculate(firstNum, secondNum, operator);
	}
	
	public Calculation(String op) {
		int[] pair = generatePairs();
		this.firstNum = pair[0];
		this.secondNum = pair[1];
		this.operator = op;
		this.correctAns = calculate(firstNum, secondNum, this.operator);
	}
	
	public Calculation(int first, int second, String op) {
		this.firstNum = first;
		this.secondNum = second;
		this.operator = op;
		this.correctAns = calculate(this.firstNum, this.secondNum, this.operator);
	}
	
	// Generate a pair of integers and check against the previously generated pairs
	public int[] generatePairs() {
		int firstInt = generateInt();
		int secondInt = generateInt();
		int[] pair = new int[] {firstInt, secondInt};
		while (checkPreviousPairs(pair)) {
			firstInt = generateInt();
			secondInt = generateInt();
			pair[0] = firstInt;
			pair[1] = secondInt;
		}
		previousPairs.add(pair);
		return pair;
	}
	
	// Check against previous pairs, return true if pair exists before
	public boolean checkPreviousPairs(int[] pair) {
        for (int[] arr : previousPairs) {
            if (Arrays.equals(arr, pair)) {
                return true;
            }
        }
        return false;
	}
	
	// Generate random integer between 0 and 12
	public int generateInt() {
        Random random = new Random();
        int randomNumber = random.nextInt(13); 
        return randomNumber;
	}
	
	public int calculate(int first, int second, String op) {
		switch (op) {
			case "+":
				return first + second;
			case "-":
				return first - second;
			case "/":
				return first / second;
			case "x":
				return first * second;
			default:
				return 0;
		}
	}

}
