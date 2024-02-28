package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 2;
		System.out.println("Deleting student id " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 5;
		Student mystudent = studentDAO.findById(id);
		System.out.println(mystudent);
		mystudent.setLastName("kolusuKumar");
		studentDAO.update(mystudent);
		System.out.println(mystudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> thestudent = studentDAO.findByLastName("kumar");

		// display list of students
		for (Student tempStudent: thestudent) {

			System.out.println(tempStudent);

		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		
		//display list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDao){

		//create a student object
		System.out.println("Creating a student object...");
		Student tempStudent = new Student("praveen", "kumar", "praveen@luve2code.com");

		//save the student
		studentDao.save(tempStudent);

		//read a student by using id

		System.out.println("Reading a student by using id...");
		Student myStudent = studentDao.findById(tempStudent.getId());
		System.out.println("Found the student..." + myStudent);


	}
	private void createMultipleStudents(StudentDAO studentDAO){
		// create multiple student objects
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 =new Student("John", "Doe", "John@luve2code.com");
		Student tempStudent2 =new Student("Mary", "Doe", "Mary@luve2code.com");
		Student tempStudent3 =new Student("Bonita", "Doe", "Bonita@luve2code.com");

		// save the students objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	private void createStudent(StudentDAO studentDAO){

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent =new Student("paul", "Doe", "paul@luve2code.com");

		//sve the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student. Generated id: " + tempStudent.getId() );

	}
}