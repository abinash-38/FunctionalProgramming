package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}

public class FP04CustomClass_Practice {

	public static void main(String[] args) {
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));
		
		/***********************************************************************************************/
		// allMatch, noneMatch, anyMatch
		Predicate<Course> reviewMoreThan90 = course -> course.getReviewScore() > 90;
		Predicate<Course> reviewMoreThan95 = course -> course.getReviewScore() > 95;
		Predicate<Course> reviewLessThan90 = course -> course.getReviewScore() < 90;
		
		// All should match to predicate then true
		System.out.println("reviewLessThan90, all match -> "+courses.stream().allMatch(reviewLessThan90));
		System.out.println("reviewMoreThan95, all match -> "+courses.stream().allMatch(reviewMoreThan95));
		System.out.println("reviewMoreThan90, all match -> "+courses.stream().allMatch(reviewMoreThan90));
		
		//None should match to predicate, then true
		System.out.println("reviewLessThan90, none match -> "+courses.stream().noneMatch(reviewLessThan90));
		System.out.println("reviewMoreThan90, none match -> "+courses.stream().noneMatch(reviewMoreThan95));
		System.out.println("reviewMoreThan90, none match -> "+courses.stream().noneMatch(reviewMoreThan90));
		
		//atleast one element matches to the predicate, then true
		System.out.println("reviewLessThan90, any match -> "+courses.stream().anyMatch(reviewLessThan90));
		System.out.println("reviewMoreThan90, any match -> " + courses.stream().anyMatch(reviewMoreThan95));
		System.out.println("reviewMoreThan90, any match -> "+courses.stream().anyMatch(reviewMoreThan90));
	
		/***********************************************************************************************/
		
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
		
		System.out.println("Comparing by no of students, increasing -> "
				+ courses
				 .stream()
				 .sorted(comparingByNoOfStudentsIncreasing)
				 .collect(Collectors.toList()));
		
		Comparator<Course> comparingNoOfStudentsByDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
		System.out.println("Comparing by no of students, decreasing -> "
				+ courses
				 .stream()
				 .sorted(comparingNoOfStudentsByDecreasing)
				 .collect(Collectors.toList()));
		
		Comparator<Course> comparingNoOfStudentsAndNoOfReviews = Comparator.comparing(Course::getNoOfStudents)
																	.thenComparing(Course::getReviewScore).reversed();
		
		System.out.println("Comparing by no of students, and then, no of reviews in decreasing order -> "
				+ courses
				 .stream()
				// .sorted(comparingNoOfStudentsAndNoOfReviews.reversed()) // this also works to reverse the comparator
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .collect(Collectors.toList()));
		//result = [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
		
		/*********************************************************************************************************/
		
		//limit , skip, takewhile, dropwhile 
		
		//limit
		System.out.println("Comparing by no of students, and then, no of reviews in decreasing order , limit = 5 -> "
				+ courses
				 .stream()
				// .sorted(comparingNoOfStudentsAndNoOfReviews.reversed()) // this also works to reverse the comparator
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .limit(5) // result = [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]
				 .collect(Collectors.toList()));
		
		//skip
		System.out.println("Comparing by no of students, and then, no of reviews in decreasing order , skip = 3 -> "
				+ courses
				 .stream()
				// .sorted(comparingNoOfStudentsAndNoOfReviews.reversed()) // this also works to reverse the comparator
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .skip(3) // result = [AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
				 .collect(Collectors.toList()));
		
		// skip AND limit
		System.out.println("Comparing by no of students, and then, no of reviews in decreasing order , skip = 3 , limit = 5 -> "
				+ courses
				 .stream()
				// .sorted(comparingNoOfStudentsAndNoOfReviews.reversed()) // this also works to reverse the comparator
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .skip(3)// result =  [AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
				 .limit(4) // now result = [AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91]
				 .collect(Collectors.toList()));
		
		System.out.println("Comparing by no of students, and then, no of reviews in decreasing order , limit = 5 , skip = 3  -> "
				+ courses
				 .stream()
				// .sorted(comparingNoOfStudentsAndNoOfReviews.reversed()) // this also works to reverse the comparator
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .limit(5) // result = [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]
				 .skip(3) // now result = [AWS:21000:92, Spring:20000:98]
				 .collect(Collectors.toList()));
		
		System.out.println("All courses printed -> "+courses); 
		//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
		
		//takeWhile
		System.out.println("Displaying all courses, as long as all are having review score >= 95. IF one fails to match, this will stop ->" 
				           +courses
				 	 	   .stream()
				           .takeWhile(course -> course.getReviewScore() >= 95)
				           .collect(Collectors.toList()));
		
		//DropWhile
		System.out.println("Skipping/dropping all courses, as long as all are having review score >= 95. IF one fails to match, this will stop and rest will be printed ->" 
		           +courses
		 	 	   .stream()
		           .dropWhile(course -> course.getReviewScore() >= 95)
		           .collect(Collectors.toList()));
		
		/***********************************************************************************************/
		
		
		
		System.out.println("MAX, with predicate comparingNoOfStudentsAndNoOfReviews -> "
				+ courses
				 .stream()
				 .max(comparingNoOfStudentsAndNoOfReviews)); // result =  Optional[FullStack:14000:91]
		
		System.out.println("min, with predicate comparingNoOfStudentsAndNoOfReviews -> "
				+ courses
				 .stream()
				 .min(comparingNoOfStudentsAndNoOfReviews)); // result =  Optional[Microservices:25000:96]
		
		
		System.out.println("min, with predicate reviewLessThan90 and comparingNoOfStudentsAndNoOfReviews, with OrELSE -> "	+	
				courses.stream()
		        .filter(reviewLessThan90)
		        .min(comparingNoOfStudentsAndNoOfReviews) // until here, it returns empty result. So, in output, it returns : Optional.empty
				.orElse(new Course("Kubernetes", "Cloud", 91, 20000))); //result  Kubernetes:20000:91
		
		
		System.out.println("findfirst with reviewMoreThan95 predicate-> "	+	
				courses.stream()
		        .filter(reviewMoreThan95)
		        .findFirst()); //result = Optional[Spring:20000:98]
		   
		
		System.out.println("findAny with reviewMoreThan95 predicate-> "	+	
				courses.stream()
		        .filter(reviewMoreThan95)
		        .findAny()); //result = any result from the stream => Optional[Spring:20000:98]
		
		System.out.println("Sum of students with reviewMoreThan95 predicate-> "	+	
				courses.stream()
		        .filter(reviewMoreThan95)
		        .mapToInt(Course::getNoOfStudents) // maptoint is a primitive method, doesnt involve any boxing or unboxing
		        .sum()); // result = 88000 students
		
		System.out.println("Average of students with reviewMoreThan95 predicate-> "	+	
				courses.stream()
		        .filter(reviewMoreThan95)
		        .mapToInt(Course::getNoOfStudents) // maptoint is a primitive method, doesnt involve any boxing or unboxing
		        .average()); // result = OptionalDouble[22000.0]
		
		System.out.println("Count of students with reviewMoreThan95 predicate-> "	+	
				courses.stream()
		        .filter(reviewMoreThan95)
		        .mapToInt(Course::getNoOfStudents) // maptoint is a primitive method, doesnt involve any boxing or unboxing
		        .count()); // result = 4 (as there are 4 courses matching the criteria)
		
		
		System.out.println("The courses, grouped by Category:: "+
					    	courses.stream()
						    .collect(Collectors.groupingBy(Course::getCategory)));
		//result = The courses, grouped by Category:: {Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], 
		//FullStack=[FullStack:14000:91], Microservices=[API:22000:97, Microservices:25000:96], Framework=[Spring:20000:98, Spring Boot:18000:95]}

		System.out.println("The count of courses, in each category:: "+
		    	courses.stream()
			    .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//result = The count of courses, in each category:: {Cloud=4, FullStack=1, Microservices=2, Framework=2}
	
		System.out.println("The course, with maximum review score, in each category:: "+
		    	courses.stream()
			    .collect(Collectors.groupingBy(Course::getCategory, 
			    		Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		//result = The course, with maximum review score, in each category:: {Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

		
		System.out.println("The courses names only, grouped by Category:: "+
		    	courses.stream()
			    .collect(Collectors.groupingBy(Course::getCategory, 
			    		Collectors.mapping(Course::getName, Collectors.toList()))));
		//result - The courses names only, grouped by Category:: 
		//{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], 
		//Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}

		//--------------------------------Higher Order Functions--------------------------------------------------
		
		int cutOffReviewScore = 95;
		

		Predicate<Course> reviewMoreThan90Predicate2 = createPredicateWithCutoffReviewScore(90);
		Predicate<Course> reviewMoreThan95Predicate2 = createPredicateWithCutoffReviewScore(95);
		
   	}

		/**
		 * This methods below are higher order functions, as they return another function/logic 
		 * 
		 * */	
		private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutOffReviewScore) {
			return course -> course.getReviewScore() > cutOffReviewScore;
		}
}