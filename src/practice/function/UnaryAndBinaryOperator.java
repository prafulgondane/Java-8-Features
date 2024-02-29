package practice.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperator {
  
	public static void main(String[] args) {
		
		UnaryOperator<String> unary = (s) -> s.concat("Default");
		
		System.out.println("Unary : " + unary.apply("Java 8"));
		
		BinaryOperator<Integer> binary = (a,b) -> a*b;
		
		System.out.println("Binary : " + binary.apply(2, 3));
		

		Comparator<Integer> comp = (a, b) -> a.compareTo(b);
		
		BinaryOperator<Integer> binMaxBy = BinaryOperator.maxBy(comp);
		
		System.out.println("Binary MaxBy: " + binMaxBy.apply(2, 3));
    }
}
