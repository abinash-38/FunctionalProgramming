package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;


public class FP03BehaviourParameterization {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17);
		//We pass the behaviour of the method, this is behaviour parameterization
		
		
		//Predicate<Integer> evenPredicate = x -> x%2 ==0; // refactor and extract into a variable
		//filterAndPrint(numbers, evenPredicate); //below is the inline, shortened one
		
		filterAndPrint(numbers, x -> x%2 ==0);
		
		
		//Predicate<Integer> evenPredicate = x -> x%2 !=0; // refactor and extract into a variable
		//filterAndPrint(numbers, evenPredicate); // below is the inline, shortened one
		
		filterAndPrint(numbers, x -> x%2 !=0);
		filterAndPrint(numbers, x -> x%3 ==0);

		
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
	
}

