package practice.lamdas;

import java.util.Comparator;

public class Lambdas_Comarator_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Legacy Way:
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		System.out.println("Comparator 1 --> "+comparator.compare(3, 2));
		
		//Lamda Way:
		Comparator<Integer> comparator2 = (Integer a, Integer b) -> {
			return a.compareTo(b);
		};
		System.out.println("Comparator 2 --> "+comparator2.compare(3, 2));
		
		
		//Lamda Way:
		Comparator<Integer> comparator3 = (a, b) -> {return a.compareTo(b);};
		
		System.out.println("Comparator 3 --> "+comparator3.compare(3, 2));
		
		
		
		
		
		
	}

}
