package driverPackage;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


import objectsPackage.Student;
import objectsPackage.University;


public class ReadObjectFiles {

	public static void main(String[] args) {
		String studentObjectsFileName = "StudentObjectFile.objf";
		String universityObjectsFileName = "UniversityObjectFile.objf";
		String studentArrayObjectFileName = "StudentArrayObjectFile.objf";
		String universityArrayObjectFileName = "UniversityArrayObjectFile.objf";
		ArrayList<Student> studentObjectsFromFile = new ArrayList<Student>();
		ArrayList<University> universityObjectsFromFile = new ArrayList<University>();
		ArrayList<Student> studentArrayObjectFromFile = null;
		ArrayList<University> universityArrayObjectFromFile = null;
		FileInputStream inputFile = null;
		ObjectInputStream objectReader = null;
		//Student array added from file
		System.out.println("Display Student Objects from an ArrayList read in from a file.");
		try
		{
			inputFile = new FileInputStream(studentArrayObjectFileName);
			objectReader = new ObjectInputStream(inputFile);
			studentArrayObjectFromFile = (ArrayList<Student>)objectReader.readObject();
			displayStudentArrayList(studentArrayObjectFromFile);
			objectReader.close();

		}
		catch(FileNotFoundException fileError)
		{
			System.out.println(fileError);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//students added to array one object at a time from file
		System.out.println("Display Student Objects from an ArrayList filled with Student Objects read in from a file.");
		try
		{
			inputFile = new FileInputStream(studentObjectsFileName);
			objectReader = new ObjectInputStream(inputFile);
			try
			{
				while(true)
					studentObjectsFromFile.add((Student)objectReader.readObject());

			}catch (IOException e) {
				System.out.println("End of file");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			objectReader.close();
			displayStudentArrayList(studentObjectsFromFile);

		}
		catch(FileNotFoundException fileError)
		{
			System.out.println(fileError);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	//University array added from file
	System.out.println("Display University Objects from an ArrayList read in from a file.");
	try
	{
		inputFile = new FileInputStream(universityArrayObjectFileName);
		objectReader = new ObjectInputStream(inputFile);

		universityArrayObjectFromFile = (ArrayList<University>)objectReader.readObject();

		displayUniversityArrayList(universityArrayObjectFromFile);
		objectReader.close();

	}
	catch(FileNotFoundException fileError)
	{
		System.out.println(fileError);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//universities added to array one object at a time from file
	System.out.println("Display University Objects from an ArrayList filled with University Objects read in from a file.");
	try
	{
		inputFile = new FileInputStream(universityObjectsFileName);
		objectReader = new ObjectInputStream(inputFile);
		try
		{
			while(true)
				universityObjectsFromFile.add((University)objectReader.readObject());

		}catch (IOException e) {
			System.out.println("End of file");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectReader.close();
		displayUniversityArrayList(universityObjectsFromFile);

	}
	catch(FileNotFoundException fileError)
	{
		System.out.println(fileError);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}

	private static void displayUniversityArrayList(ArrayList<University> pUniversityArraye) {
		for(University curUniversity: pUniversityArraye)
			System.out.println(curUniversity.getUniversityName());
		System.out.println();
		
	}

	private static void displayStudentArrayList(ArrayList<Student> pStudentArray) {
		for(Student curStudent: pStudentArray)
			System.out.println(curStudent.getFullName());
		System.out.println();
		
	}

}
