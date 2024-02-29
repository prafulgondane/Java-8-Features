package practice.consumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import practice.data.Student;
import practice.data.StudentDataBase;

public class Consumer_Test {
	

	public static Consumer<Student> c2 = (s) -> System.out.print(s.getName() + " ");
	public static Consumer<Student> c3 = (s) -> System.out.print(s.getGpa()+ " ");
	static Consumer<Student> c4 = (s) -> System.out.println(s.getActivities());

	public static void main(String a[]) {
		// TODO Auto-generated method stub
		
		//Consumer Example:
		Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());
		consumer.accept("Java 8 Consumer");
		
		printStudents();
		printNameGpaAndActivities();
		printNameGpaAndActivitiesUsingPredicateCondition();
		
		//Biconsumers
		printNameAndActivitiesUsingBiConsumers();
	}
	
	public static void printStudents() {
		System.out.println();
		System.out.println("###### printStudents() ######");
		//Print All Students
		Consumer<Student> c1 = (s) -> System.out.println(s);
		List<Student> students = StudentDataBase.getAllStudents();
		students.forEach(c1);
	}
	
	public static void printNameGpaAndActivities() {
		System.out.println();
		System.out.println("###### printNameGpaAndActivities() ######");
		//Print All printNameGpaAndActivities
		Consumer<Student> c2 = (s) -> System.out.print(s.getName() + " ");
		Consumer<Student> c3 = (s) -> System.out.print(s.getGpa()+ " ");
		Consumer<Student> c4 = (s) -> System.out.println(s.getActivities());
		
		List<Student> students = StudentDataBase.getAllStudents();
		
		students.forEach(c2.andThen(c3).andThen(c4));  //Consumer Chaining
	}
	
	public static void printNameGpaAndActivitiesUsingPredicateCondition() {
		System.out.println();
		System.out.println("###### printNameGpaAndActivitiesUsingCondition() ######");
		//Print All printNameGpaAndActivities
		
		List<Student> students = StudentDataBase.getAllStudents();
		
		students.forEach(student ->{
			
			if(student.getGradeLevel() >=3) {
				c2.andThen(c3).andThen(c4).accept(student);
			}
			
		});  //Consumer Chaining
	}
	
	public static void printNameAndActivitiesUsingBiConsumers() {
		System.out.println();
		System.out.println("###### printNameAndActivitiesUsingBiConsumers() ######");
		
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name +" : " + activities);
		List<Student> students = StudentDataBase.getAllStudents();
		students.forEach(student ->{
			biConsumer.accept(student.getName(), student.getActivities());
		});
		
	}
	
}

