package programming;

import java.util.Arrays;
import java.util.List;

public class FP01Structured {
	public static void main(String[] args) {
		//printAllNumbersInListStructured(Arrays.asList(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17));
		List<Integer> numbers = Arrays.asList(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17);
		printEvenNumbersInListStructured(numbers);
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		
		for(int number:numbers) {
			System.out.println(number);
		}
		
	}
	
	
    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		
		for(int number:numbers) {
			if(number%2==0)
			    System.out.println(number);
		}
		
	}
}
