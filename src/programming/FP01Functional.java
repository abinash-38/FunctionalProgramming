package programming;

import java.util.Arrays;
import java.util.List;


public class FP01Functional {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17);
		List<String> courses = Arrays.asList("Spring","Spring Boot", "Micro services", "AWS", "Azure", "PCF", "JPA", "Hibernate", ".NET", "Docker", "Kubernetes");
		
		//      courses.stream()
		//		       .forEach(System.out::println); // All courses are printed
		
       //		courses.stream()
	   //		.filter(course -> course.contains("Spring")) // only the ones containing "spring" are filtered.
	   //		.forEach(System.out::println);
		
		//				courses.stream()
		//						.filter(course -> course.length() >= 4) // only print the courses having more than 4 letters
		//						.forEach(System.out::println);
		//		
		
		//printAllNumbersInListFunctional(numbers);
		//printEvenNumbersInListFunctional(numbers);
		//printOddNumbersInListFunctional(numbers);
		//printSquareOfEvenNumbersInListFunctional(numbers);
		//printCubeOfOddNumbersInListFunctional(numbers);
		  printLengthOfCourseFunctional(courses);
		
		
		
	}
	
//	private static void print(int num) {
//		System.out.println(num);
//	}
	
	//Below line commented and replaced by 'Lambda'
//	private static boolean isEven(int number) {
//		return number%2==0;
//	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		//convert list of numbers into sequence of elements ->> stream()
		numbers.stream() // stream is nthing but a seq.. of characters
		       //.forEach(FP01Functional::print); // means for each element, the print method will be called		
			   // instead of above line along with print method, we can use below single line: 
			   .forEach(System.out::println);	
	}
	
	
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		// What to do ? 
    	
    	numbers.stream() //First convert the list into stream.
    			//.filter(FP01Functional::isEven) // Filter - For each single number, Only allow even numbers
    			//Above line commented and below line with similar functionality added.
    	 		.filter(number -> number%2==0 ) //This is Lambda
    	        .forEach(System.out::println); //print each sinlge one (which are filtered from above)
		
	}
	
	
    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		// What to do ? 
    	
    	numbers.stream() //First convert the list into stream.
    			//.filter(FP01Functional::isEven) // Filter - For each single number, Only allow even numbers
    			//Above line commented and below line with similar functionality added.
    	 		.filter(number -> number%2!=0 ) //This is Lambda
    	        .forEach(System.out::println); //print each sinlge one (which are filtered from above)	
	}	
    
    private static void printSquareOfEvenNumbersInListFunctional(List<Integer> numbers) {
		// What to do ? 
    	
    	 numbers.stream() //First convert the list into stream.   			
    	 	    .filter(number -> number %2 == 0 ) //This is Lambda
    	 	    .map(number -> number * number)
    	        .forEach(System.out::println); //print each sinlge one (which are filtered from above and mapped)	
	}	
    
    private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {
		// What to do ? 
    	
    	numbers.stream()
    		   .filter(number -> number%2 == 1)
    		   .map(number -> number * number * number)
    		   .forEach(System.out::println);
	}	
    
    private static void printLengthOfCourseFunctional(List<String> courses) {
		// What to do ? 
    	
    	courses.stream()
    		   .map(course -> course  + " " +course.length())
    		   .forEach(System.out::println);
	}
}

