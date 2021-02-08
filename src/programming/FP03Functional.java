package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;


public class FP03Functional {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17);
		//List<String> courses = Arrays.asList("Spring","Spring Boot", "Micro services", "AWS", "Azure", "PCF", "JPA", "Hibernate", ".NET", "Docker", "Kubernetes");
	
		int sum = addFunctional(numbers);
		System.out.println("Sum is : "+sum);
	}

	
	private static int addFunctional(List<Integer> numbers)
	{
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			/*
			 * BinaryOperator is used to apply some functionality where 2 variables are
			 * used, like addition, squares etc.
			 */
			@Override
			public Integer apply(Integer a, Integer b) {
				return a+b;
			}
		};
		
		return numbers.stream()
				.reduce(0, sumBinaryOperator2);
	}
	
	
}

