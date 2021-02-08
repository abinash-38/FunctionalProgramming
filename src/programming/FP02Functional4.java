package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class FP02Functional4 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		
		//List<Integer> squareNumbers = squareList(numbers);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		
	//	List<Integer> evenNumbers = evenList(numbers);
		
		List<Integer> lengths = coursesLengths(courses);
		
		System.out.println(lengths);
		
//		Instant start = Instant.now();
//		Instant end = Instant.now();
//		
//		long timetaken = Duration.between(start, end).toMillis();
//		System.out.println("Time taken : "+timetaken);
		
	}
	
	

	private static List<Integer> coursesLengths(List<String> courses) {
		return courses.stream()
					   .map(course -> course.length())
					   .collect(Collectors.toList());
	}

	/*********************************************************************************/
	
//	private static List<Integer> evenList(List<Integer> numbers) {
//		return numbers.stream()
//						.filter(number -> number%2 ==0) // filter even numbers and pass them forward
//						.collect(Collectors.toList());  // make a collection from above numbers and pass them
//	}
//	
	
	/*********************************************************************************/
	
	
//	
//	private static List<Integer> squareList(List<Integer> numbers)
//	{
//		// we need to collect each numbers square into a list.
//		return numbers.stream()  // stream
//						.map(number -> number * number) // map each number into its square 
//						.collect(Collectors.toList()); // collect all above results into a list.
//	}
	
	
	
}

