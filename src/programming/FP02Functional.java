package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;


public class FP02Functional {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17);
		//List<String> courses = Arrays.asList("Spring","Spring Boot", "Micro services", "AWS", "Azure", "PCF", "JPA", "Hibernate", ".NET", "Docker", "Kubernetes");
		
		Instant start = Instant.now();
		
		int sum = addFunctional(numbers);
		System.out.println("Sum is : "+sum);
		
		Instant end = Instant.now();
		
		long timetaken = Duration.between(start, end).toMillis();
		System.out.println("Time taken : "+timetaken);
		
	}
	
	private static int sum(int a, int b) {
		return a+b;
	}
	
	private static int addFunctional(List<Integer> numbers)
	{
		
		return numbers.stream()
			//  .reduce(0, FP02Functional::sum);		//Instead of this, we can do below :
			//	.reduce(0, (x,y) -> (x + y));
				.reduce(0, Integer::sum);
	}
	
	
}

