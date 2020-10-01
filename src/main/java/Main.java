package main.java;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static final int MIN_RANGE = 1;
	public static final int MAX_RANGE = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--- START ---");
		
		Integer[] computerNumbers = generateComputerNumbers();
		
		// To use test values provided in the example pdf, uncomment lines bellow :
		// computerNumbers[0] = 2;
		// computerNumbers[1] = 7;
		// computerNumbers[2] = 10;
		
		System.out.println("Computer number : " + computerNumbers[0] + " - " + computerNumbers[1] + " - " + computerNumbers[2]);
		
		boolean success = false;
		
		while(!success) {
			System.out.println("Enter a guess :");
			int validMultiples = 0;
			
			try
			{
				int userInput = sc.nextInt();
				
				for(int i : computerNumbers) {
					if(userInput % i == 0)
						validMultiples++;
				}
			}
			catch(Exception e) {
				continue;
			}
			
			System.out.println("Multiples Found : " + validMultiples);
			
			if(validMultiples == 3)
				success = true;
		}
		
		System.out.println("You win !");
	}
	
	public static Integer[] generateComputerNumbers()
	{
		Set<Integer> generatedNumbers = new HashSet<Integer>();
		Random rnd = new Random();
		
		while(generatedNumbers.size() < 3) {
			var randomNumber = rnd.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
			
			try {
				generatedNumbers.add(randomNumber);
			} catch (Exception e) {
				continue;
			}
		}
		
		return generatedNumbers.toArray(new Integer[generatedNumbers.size()]);
	}

}
