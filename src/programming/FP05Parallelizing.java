package programming;


import java.util.stream.LongStream;

public class FP05Parallelizing {
	
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		
		//869 1893 1912 1887 1851
		//System.out.println(LongStream.range(0,1000000000).sum());//499999999500000000
		
		//601 706 587 582 667
		System.out.println(LongStream.range(0,1000000000).parallel().sum());
		
		System.out.println(System.currentTimeMillis() - time);
	}

}