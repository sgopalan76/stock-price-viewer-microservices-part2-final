package com.techprimers.stock.stockservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class TestLambda {

	// Traditional approach
	private static boolean isPrime(int number) {
		if (number < 2)
			return false;
		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	// Declarative approach
	private static boolean isPrime2(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}

	public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream()
					  .filter(TestLambda::isOdd) // Predicate is functional interface and
				      .filter(TestLambda::isGreaterThan3) // we are using lambdas to initialize it
				      .filter(TestLambda::isLessThan11) // rather than anonymous inner classes
				      .max(Comparator.naturalOrder()).map(i -> i * i)
				      .get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}

	public static boolean isGreaterThan3(int i) {
		return i > 3;
	}

	public static boolean isLessThan11(int i) {
		return i < 11;
	}

	// operation is implemented using lambda expressions
	interface FuncInter1 {
		int operation(int a, int b);
	}

	// sayMessage() is implemented using lambda expressions
	// above
	interface FuncInter2 {
		void sayMessage(String message);
	}

	// Performs FuncInter1's operation on 'a' and 'b'
	private static int operate(int a, int b, FuncInter1 fobj) {
		return fobj.operation(a, b);
	}
	
	
	List<Integer> list = Arrays.asList(12,5,45,66,78,34);
	
	/*findNumbers(list, new BiPredicate<Integer, Integer>() {
		public boolean test(Integer i1, Integer i2) {
			return Numbers.isMorethanFifty(i1, i2);
		}
	});
	
	findNumbers(list, Numbers::isMorethanFifty)*/

	public static void main(String args[]) {
		int myInt = 1;
		int myInt1 = 15;
		int myInt2 = 92;
		int myInt3 = 50;
		int myInt4 = 70;
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(myInt));
		list.add(new Integer(myInt1));
		list.add(new Integer(myInt2));
		list.add(new Integer(myInt3));
		list.add(new Integer(myInt4));

		System.out.println(TestLambda.isPrime(47));
		System.out.println(TestLambda.isPrime2(13));

		// Using lambda expression to print all elements
		// of arrL
		list.forEach(x -> {
			if (x % 5 == 0)
				System.out.println(x);
		});
		
		list.forEach(System.out::println);

		// System.out.println(TestLambda.findSquareOfMaxOdd(list));

		// lambda expression for addition for two parameters
		// data type for x and y is optional.
		// This expression implements 'FuncInter1' interface
		FuncInter1 add = (int x, int y) -> x + y;

		// lambda expression multiplication for two parameters
		// This expression also implements 'FuncInter1' interface
		FuncInter1 multiply = (int x, int y) -> x * y;
		
		// lambda expression divide for two parameters
		// This expression also implements 'FuncInter1' interface
		FuncInter1 divide = (int x, int y) -> x / y;
		
		// lambda expression subtract for two parameters
		// This expression also implements 'FuncInter1' interface
		FuncInter1 subtract = (int x, int y) -> x - y;
		

		// Add two numbers using lambda expression
		System.out.println("Addition is " + TestLambda.operate(6, 3, add));

		// Multiply two numbers using lambda expression
		System.out.println("Multiplication is " + TestLambda.operate(6, 3, multiply));
		
		// Divide two numbers using lambda expression
		System.out.println("Division is " + TestLambda.operate(6, 3, divide));
		
		// Subtract two numbers using lambda expression
		System.out.println("Subtract is " + TestLambda.operate(987, 689, subtract));
		

		// lambda expression for single parameter
		// This expression implements 'FuncInter2' interface
		FuncInter2 fobj = msg -> System.out.println("Hello " + msg);
		fobj.sayMessage("Venki");
		
		String str = null;
		Optional<String> opt = Optional.ofNullable(str);
		System.out.println("value of str is: "+opt);
		
	}

}
