package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;


public class FP02Functional2 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		//List<String> courses = Arrays.asList("Spring","Spring Boot", "Micro services", "AWS", "Azure", "PCF", "JPA", "Hibernate", ".NET", "Docker", "Kubernetes");
		
		Instant start = Instant.now();
		
		int sum = calculate(numbers);
		System.out.println("Sum is : "+sum);
		
		Instant end = Instant.now();
		
		long timetaken = Duration.between(start, end).toMillis();
		System.out.println("Time taken : "+timetaken);
		
	}
	
	
	private static int calculate(List<Integer> numbers)
	{
		
        //		return numbers.stream()      				// program to print the sum of squares of numbers.
		//					  .map(x -> x*x) 				// first calculate squares of each and then map  each x into its square. 
		//					  .reduce(0, Integer::sum); 	// Then print their sums.
		
		 //		return numbers.stream()                  	// program to print the sum of numbers.
		 //					  .map(x -> x*x*x) 				// first calculate cubes of each and then map x into its cube. 
		 //					  .reduce(0, Integer::sum); 	// Then print their sums.
		
		return numbers.stream()
					  .filter(x -> x%2 == 1) // program to print sum of odd numbers
					  .reduce(0, Integer::sum);
	}
	
	
}

