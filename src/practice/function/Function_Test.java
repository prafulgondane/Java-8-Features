package practice.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import practice.data.Student;
import practice.data.StudentDataBase;
import practice.predicate.Predicate_Test;

public class Function_Test {
	
	static Function<String, String> function1 = (name) -> name.toUpperCase();
	
	static Function<String, String> function2 = (name) -> name.toUpperCase().concat("default");
	

	static Function<List<Student>, Map<String, Double>> func = (students) -> {
		
		Map map = new HashMap<>();
		students.forEach((student ->{
			if(Predicate_Test.gradePredicate.test(student)) {
				map.put(student.getName(), student.getGradeLevel());
			}
		}));
		
		
		return map;
		
	};
	
	static BiFunction< List<Student>, Predicate<Student>, Map<String, Double>> biFunc = (students, predicate) -> {
		
		Map m = new HashMap();
		
		students.forEach(student -> {
			if(predicate.test(student)) {
				m.put(student.getName(), student.getGradeLevel());
			}
		});
		
		return m;
		
	};
	
	public static void main(String a[]) {
		
		System.out.println("Function 1 --> " + function1.apply("java 8"));
		
		System.out.println("Function 2 andThen--> " + function1.andThen(function2).apply("java 8"));
		
		System.out.println("Function 2 compose--> " + function1.compose(function2).apply("java 8"));
		
		System.out.println("Func --> " + func.apply(StudentDataBase.getAllStudents()));
		
		System.out.println("biFunc --> " + biFunc.apply(StudentDataBase.getAllStudents(), Predicate_Test.gradePredicate));
	}

}
