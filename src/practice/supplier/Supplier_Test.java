package practice.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import practice.data.Student;
import practice.data.StudentDataBase;

public class Supplier_Test {

	public static void main(String[] args) {
		Supplier<Student> studentSupplier = () ->{
			return new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));
		};
		
		System.out.println("StudentSupplier : " + studentSupplier.get());
		
		Supplier<List<Student>> studentList = () -> StudentDataBase.getAllStudents();
		System.out.println("StudentList : " + studentList.get());
		
	}
}
