package practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_Test {

	public static void main(String[] args) {

		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8);
		List numSqr = (List) numList.stream().map(x->(x * x)).collect(Collectors.toList());
		numSqr.stream().forEach(System.out::println);
		System.out.println();
		
		//Print elements in reverse order
		System.out.println();
		System.out.println("Print elements in reverse order");
		
		numList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


		//Second Larget Element in list.
		System.out.println();
		System.out.println("Second Larget Element in list.");

		Integer secLarge = numList.stream()
				.sorted((a,b) -> b.compareTo(a))
				.skip(1)
				.findFirst()
				.orElse(-1);
		
		System.out.println(secLarge);
		
		//First Char of string in reverse order.
		System.out.println();
		System.out.println("First Char of string in reverse order.");
		List<String> strs = Arrays.asList("CODE", "MAKES", "YOUR", "LIFE", "EASY");
													// . map(x -> Stream.of(x.charAt(0))) // will print hashcodes
		strs.stream().sorted(Comparator.reverseOrder()).flatMap(x -> Stream.of(x.charAt(0))).collect(Collectors.toSet()).forEach(System.out::println);
		
	}

}
