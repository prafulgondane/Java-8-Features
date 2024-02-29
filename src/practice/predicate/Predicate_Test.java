package practice.predicate;

import java.util.List;
import java.util.function.Predicate;

import practice.consumer.Consumer_Test;
import practice.data.Student;
import practice.data.StudentDataBase;

public class Predicate_Test {
	

	static Predicate<Integer> p1 = (i) -> i%2 == 0;
	static Predicate<Integer> p2 = (i) -> i%5 == 0;
	
	public static Predicate<Student> gradePredicate = (student) -> student.getGradeLevel() >= 3;
	
	public static void main(String a[]) {
		Predicate<Integer> p = (i) -> {
			return i%2 == 0;
		};
		
		System.out.println("Predicate for Even Num : " + p.test(4));
		
		predicateAND();
		predicateOR();
		
		printNameGpaAndActivitiesUsingPredicateCondition();
		
	}
	
	public static void predicateAND() {
		System.out.println("Predicate for AND : " + p1.and(p2).test(10));
	}
	
	public static void predicateOR() {
		System.out.println("Predicate for AND : " + p1.or(p2).test(10));
	}
	
	public static void printNameGpaAndActivitiesUsingPredicateCondition() {
		System.out.println();
		System.out.println("###### printNameGpaAndActivitiesUsingCondition() ######");
		//Print All printNameGpaAndActivities
		
		List<Student> students = StudentDataBase.getAllStudents();
		
		students.forEach(student ->{
			
			if(gradePredicate.test(student)) {
				Consumer_Test.c2.andThen(Consumer_Test.c3).accept(student);
			}
			
		});  //Consumer Chaining
	}

}
