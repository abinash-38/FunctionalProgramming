package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class FP02Functional5 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		Instant start = Instant.now();
		
		
		calculatecourses(courses);
		
		
		Instant end = Instant.now();
		
		long timetaken = Duration.between(start, end).toMillis();
		System.out.println("Time taken : "+timetaken);
		
	}
	
	
	
	private static void calculatecourses(List<String> courses)
	{
		/*SORT BY REVERSE, BY NATURAL ORDER AND BY USER DEFINED WAY USING COMPARING, learn to use DISTINCT*/
		
		//courses.stream().distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		// courses.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		courses.stream().distinct().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}
	
}

