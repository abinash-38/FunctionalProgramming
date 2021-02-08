package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FP03BehaviourParameterization2 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17);
		//We pass the behaviour of the method, this is behaviour parameterization
		
		
		//Predicate<Integer> evenPredicate = x -> x%2 ==0; // refactor and extract into a variable
		//filterAndPrint(numbers, evenPredicate); //below is the inline, shortened one
		
		//filterAndPrint(numbers, x -> x%2 ==0);
		
		
		//Predicate<Integer> evenPredicate = x -> x%2 !=0; // refactor and extract into a variable
		//filterAndPrint(numbers, evenPredicate); // below is the inline, shortened one
		
		//filterAndPrint(numbers, x -> x%2 !=0);
		
		
		List<Integer> sqNum = createNewList(numbers, x -> x*x);
		System.out.println("The squared numbers are: "+sqNum);

		List<Integer> doubleNum = createNewList(numbers, x -> x + x);
		System.out.println("The doubled numbers are: "+doubleNum);
		
	}

	private static List<Integer> createNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
		return numbers.stream().map(mappingFunction)
								.collect(Collectors.toList());
	}


}

