package programming;

public class JShell 
{
	//containing the commands to be run in jshell

		/********************
		 * 
		 * 
		 * 
		 * ***************************JSHELL COMMANDS************************
		 * 
		 * | Welcome to JShell -- Version 11.0.9 | For an introduction type: /help intro
		 * 
		 * jshell> List<Integer> numbers =
		 * List.of(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17); numbers ==> [12, 9, 12, 25,
		 * 4, 6, 2, 6, 4, 7, 13, 19, 21, 55, 17]
		 * 
		 * jshell> numbers.stream(); $2 ==>
		 * java.util.stream.ReferencePipeline$Head@1b604f19
		 * 
		 * jshell> Stream.of(12, 9, 12, 25, 4, 6, 2, 6, 4, 7, 13, 19, 21, 55, 17); $3
		 * ==> java.util.stream.ReferencePipeline$Head@8bd1b6a
		 * 
		 * jshell>
		 * 
		 * jshell> Stream.of(12, 9, 12, 25, 4, 6, 2, 6, 4, 7, 13, 19, 21, 55,
		 * 17).count(); $4 ==> 15
		 * 
		 * jshell> Stream.of(12, 9, 12, 25, 4, 6, 2, 6, 4, 7, 13, 19, 21, 55,
		 * 17).reduce(0, Integer::sum) $5 ==> 212
		 * 
		 * //How to create streams with primitive values //Since the values of below
		 * array is primitive, //the functions like max, min, sum etc were possible.
		 * 
		 * jshell> int[] numArray = {12, 9, 12, 25, 4, 6, 2, 6, 4, 7, 13, 19, 21, 55,
		 * 17}; numArray ==> int[15] { 12, 9, 12, 25, 4, 6, 2, 6, 4, 7, 13, 19, 21, 55,
		 * 17 }
		 * 
		 * jshell> Arrays.stream(numArray).sum(); $7 ==> 212
		 * 
		 * jshell>
		 * 
		 * jshell> Arrays.stream(numArray).average(); $8 ==>
		 * OptionalDouble[14.133333333333333]
		 * 
		 * jshell>
		 * 
		 * jshell> Arrays.stream(numArray).min(); $9 ==> OptionalInt[2]
		 * 
		 * jshell>
		 * 
		 * jshell> Arrays.stream(numArray).max(); $10 ==> OptionalInt[55]
		 * 
		 * -------------------------------------
		 * 
		 * jshell> IntStream.iterate(1, e ->
		 * e+2).limit(10).peek(System.out::println).sum() 1 3 5 7 9 11 13 15 17 19 $15
		 * ==> 100
		 * 
		 * jshell> IntStream.iterate(2, e ->
		 * e+2).limit(10).peek(System.out::println).sum() 2 4 6 8 10 12 14 16 18 20 $16
		 * ==> 110
		 * 
		 * jshell> IntStream.iterate(1, e ->
		 * e%2==0).limit(10).peek(System.out::println).sum() | Error: | incompatible
		 * types: bad return type in lambda expression | boolean cannot be converted to
		 * int | IntStream.iterate(1, e ->
		 * e%2==0).limit(10).peek(System.out::println).sum() | ^----^
		 * 
		 * jshell> IntStream.iterate(2, e ->
		 * e*2).limit(10).peek(System.out::println).sum() 2 4 8 16 32 64 128 256 512
		 * 1024 $17 ==> 2046
		 * 
		 * jshell> IntStream.iterate(2, e ->
		 * e*2).limit(10).boxed().collect(Collectors.toList()); $18 ==> [2, 4, 8, 16,
		 * 32, 64, 128, 256, 512, 1024] (boxed is used to allow the stream to collect
		 * into a list.)
		 * 
		 * ----------------------------------------------------------
		 * 
		 * jshell> Long.MAX_VALUE $1 ==> 9223372036854775807
		 * 
		 * jshell> IntStream.rangeClosed(1, 50).reduce(1, (x,y) -> (x*y)) $2 ==> 0
		 * 
		 * jshell>
		 * 
		 * jshell> LongStream.rangeClosed(1, 50).reduce(1, (x,y) -> (x*y)) $3 ==>
		 * -3258495067890909184
		 * 
		 * jshell> LongStream.rangeClosed(1, 10).reduce(1, (x,y) -> (x*y)) $4 ==>
		 * 3628800
		 * 
		 * jshell> LongStream.rangeClosed(1, 20).reduce(1, (x,y) -> (x*y)) $5 ==>
		 * 2432902008176640000
		 * 
		 * jshell> LongStream.rangeClosed(1,
		 * 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,
		 * BigInteger::multiply) $6 ==>
		 * 30414093201713378043612608166064768844377641568960512000000000000
		 * 
		 * jshell> jshell> LongStream.rangeClosed(1,
		 * 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,
		 * BigInteger::multiply) $7 ==>
		 * 30414093201713378043612608166064768844377641568960512000000000000
		 * 
		 * 
		 * Map each course with other ------------------------------- List<String>
		 * courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS",
		 * "PCF","Azure", "Docker", "Kubernetes");
		 * 
		 * List<String> courses2 = List.of("Spring", "Spring Boot", "API" ,
		 * "Microservices"," AWS", "PCF","Azure", "Docker", "Kubernetes");
		 * 
		 * jshell> courses.stream().flatMap(course -> courses2.stream().map(course2 ->
		 * List.of(course, course2))).collect(Collectors.toList())
		 * 
		 * $13 ==> [[Spring, Spring], [Spring, Spring Boot], [Spring, API], [Spring,
		 * Microservices], [Spring, AWS], [Spring, PCF], [Spring, Azure], [Spring,
		 * Docker], [Spring, Kubernetes], [Spring Boot, Spring], [Spring Boot, Spring
		 * Boot], [Spring Boot, API], [Spring Boot, Microservices], [Spring Boot, AWS],
		 * [Spring Boot, PCF], [Spring Boot, Azure], [Spring Boot, Docker], [Spring
		 * Boot, Kubernetes], [API, Spring], [API, Spring Boot], [API, API], [API,
		 * Microservices], [API, AWS], [API, PCF], [API, Azure], [API, Docker], [API,
		 * Kubernetes], [Microservices, Spring], [Microservices, Spring Boot],
		 * [Microservices, API], [Microservices, Microservices], [Microservices, AWS],
		 * [Mic ... [Docker, API], [Docker, Microservices], [Docker, AWS], [Docker,
		 * PCF], [Docker, Azure], [Docker, Docker], [Docker, Kubernetes], [Kubernetes,
		 * Spring], [Kubernetes, Spring Boot], [Kubernetes, API], [Kubernetes,
		 * Microservices], [Kubernetes, AWS], [Kubernetes, PCF], [Kubernetes, Azure],
		 * [Kubernetes, Docker], [Kubernetes, Kubernetes]]
		 * 
		 * Removing the tuples where element 1 and 2 are same:
		 * 
		 * jshell> courses.stream().flatMap(course -> courses2.stream().map(course2 ->
		 * List.of(course, course2))).filter(list -> !list.get(0).equals(list.get(1)))
		 * .collect(Collectors.toList())
		 * 
		 * $14 ==> [[Spring, Spring Boot], [Spring, API], [Spring, Microservices],
		 * [Spring, AWS], [Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring,
		 * Kubernetes], [Spring Boot, Spring], [Spring Boot, API], [Spring Boot,
		 * Microservices], [Spring Boot, AWS], [Spring Boot, PCF], [Spring Boot, Azure],
		 * [Spring Boot, Docker], [Spring Boot, Kubernetes], [API, Spring], [API, Spring
		 * Boot], [API, Microservices], [API, AWS], [API, PCF], [API, Azure], [API,
		 * Docker], [API, Kubernetes], [Microservices, Spring], [Microservices, Spring
		 * Boot], [Microservices, API], [Microservices, AWS], [Microservices, PCF],
		 * [Microservices, Azure], [Microservices, Docker], [Microservices, Kuberne ...
		 * s], [Docker, Spring], [Docker, Spring Boot], [Docker, API], [Docker,
		 * Microservices], [Docker, AWS], [Docker, PCF], [Docker, Azure], [Docker,
		 * Kubernetes], [Kubernetes, Spring], [Kubernetes, Spring Boot], [Kubernetes,
		 * API], [Kubernetes, Microservices], [Kubernetes, AWS], [Kubernetes, PCF],
		 * [Kubernetes, Azure], [Kubernetes, Docker]]
		 * 
		 * Tuples having same length course names :
		 * 
		 * jshell> courses.stream().flatMap(course -> courses2.stream().filter(course2
		 * -> course2.length()==course.length()).map(course2 -> List.of(course,
		 * course2))).filter(list -> !list.get(0).equals(li
		 * st.get(1))).collect(Collectors.toList()); $15 ==> [[Spring, Docker], [API,
		 * PCF], [AWS, API], [AWS, PCF], [PCF, API], [Docker, Spring]]
		 * 
		 * 
		 * -------------------LAZY operations-----------------
		 * 
		 * 
		 * jshell> courses.stream().peek(System.out::println).filter(courses ->
		 * courses.length()>11)
		 * .map(String::toUpperCase).peek(System.out::println).findFirst() Spring Spring
		 * Boot API Microservices MICROSERVICES
		 * 
		 * $17 ==> Optional[MICROSERVICES]
		 * 
		 * 
		 * The java compiler only runs the above program when it knows what's the
		 * terminal operation (which is findFirst() here). Then it runs only until a
		 * single item has satisfied the condition. It doesn't check further since only
		 * one element is required, thus saving time. This is called INTERMEDIATE
		 * OPERATIONS ARE LAZY hecne it takes an efficient approach. For ex, if we
		 * remove the terminal operation from above, then it wont even run fully and
		 * hence no output will show.
		 * 
		 * 
		 * 
		 * 
		 * -------------------------------removeIf and replaceAll-------------------------------
		 * 
		 * 
		 * jshell> List<String> modifiableCourses = new ArrayList(courses); 
		 * 
		 * | Warning: | unchecked call to ArrayList(java.util.Collection<? extends E>) as a member of
		 * the raw type java.util.ArrayList | List<String> modifiableCourses = new
		 * ArrayList(courses); | ^--------------------^ | Warning: | unchecked
		 * conversion | required: java.util.List<java.lang.String> | found:
		 * java.util.ArrayList | List<String> modifiableCourses = new
		 * ArrayList(courses); | ^--------------------^ modifiableCourses ==> [Spring,
		 * Spring Boot, API, Microservices, AWS, PCF, Azure, Docker, Kubernetes]
		 * 
		 * jshell> modifiableCourses.replaceAll( str -> str.toUpperCase());
         *
		 * jshell> modifiableCourses 
		 * 
		 * modifiableCourses ==> [SPRING, SPRING BOOT, API, MICROSERVICES, AWS, PCF, AZURE, DOCKER, KUBERNETES]
		 * 
		 * jshell> modifiableCourses.removeIf(course -> course.length()<6) 
		 * 
		 * $24 ==> true
		 * 
		 * jshell> modifiableCourses modifiableCourses ==> [SPRING, SPRING BOOT, MICROSERVICES, DOCKER, KUBERNETES]
		 * 
		 * jshell>
		 * 
		 * 
		 * 
		 * 
		 ****************************************/
}