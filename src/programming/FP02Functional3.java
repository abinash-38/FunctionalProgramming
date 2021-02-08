package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;


public class FP02Functional3 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		Instant start = Instant.now();
		
		//calculate(numbers);
		calculatecourses(courses);
		
		
		Instant end = Instant.now();
		
		long timetaken = Duration.between(start, end).toMillis();
		System.out.println("Time taken : "+timetaken);
		
	}
	
	
	private static void calculate(List<Integer> numbers)
	{
			// numbers.stream().distinct().forEach(System.out::println);
		 numbers.stream().distinct().sorted().forEach(System.out::println);
	}
	
	private static void calculatecourses(List<String> courses)
	{
			// numbers.stream().distinct().forEach(System.out::println);
		 courses.stream().distinct().sorted().forEach(System.out::println);
	}
	
}

