package programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


public class FP03Functional2 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,12,25,4,6,2,6,4,7,13,19,21,55,17);	
		
		//Supplier is the situation when we don't have any input but want to return anything.		
		Supplier<Integer> randomNumSupplier = () -> {
			//return 2; // here in this method, return statement is compulsory
			Random random = new Random();
			return random.nextInt(100);
			
		};
		
		System.out.println(randomNumSupplier.get());
		
		
		//Unary operator takes one input and returns an output.
		UnaryOperator<Integer> unaryOperator = (x) -> 3 *x;
		System.out.println(unaryOperator.apply(10));
		
		
		// Bipredicate Takes 2 inputs and returns one output of type boolean.
		BiPredicate<Integer, String> bipredicate = (number, str) ->  {
			return (number<10 && str.length()>5);
		};
		
		System.out.println(bipredicate.test(10, "Aeroplane"));
	
		//Takes 2 input and returns an output of a specific type, we have to give the 3rd type as well.
		BiFunction<Integer, String, String> biFunction = (number, str) -> {
			return number + " "+ str;		
		};	
		
		System.out.println(biFunction.apply(15, "in29minutes"));
		
		//Takes 2 inputs and doesn't return anything.
		BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};
		
		biConsumer.accept(1, "in28minutes"); // no SOPL as its not returning anything
		
		
        BinaryOperator<Integer> sumBinaryOperator2 = (x, y) -> x + y;
		
        //This below one is good for primitives operation.
        //We should use these below operators when we need to work with primitives.
		IntBinaryOperator intBinaryOperator = (x,y) -> x + y;
		
		
		//IntBinaryOperator
		//IntConsumer
		//IntFunction
		//IntPredicate
		//IntSupplier
		//IntToDoubleFunction
		//IntToLongFunction
		//IntUnaryOperator
		
		//Long, Double, Int
		

		//numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(sysoutConsumer);

		//int sum = numbers.stream().reduce(0, sumBinaryOperator);
		
		
	}
		
	
	
}

