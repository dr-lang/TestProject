package driverPackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import objectsPackage.Student;
import objectsPackage.University;

public class TestDriver {
	
	

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Student> myStudents = new ArrayList<Student>();
		ArrayList<University> myUniversities = new ArrayList<University>();
		
		myStudents = getStudentData(keyboard);
		myUniversities = getUniversityData(keyboard);
		printArrayList(myStudents);
		printArrayList(myUniversities);
		writeReportToFile(myUniversities, myStudents);
		writeUniversityObjectsToAFile(myUniversities);
		writeStudentObjectsToAFile(myStudents);
		

	}

	

	

	private static void writeStudentObjectsToAFile(ArrayList<Student> myStudents) {
		String fileName = "StudentObjectFile.objf";
		FileOutputStream outputFile = null;
		ObjectOutputStream objectWriter = null;
		try
		{
			outputFile = new FileOutputStream(fileName, false);
			objectWriter = new ObjectOutputStream(outputFile);
			for(Student curStudent: myStudents)
			    objectWriter.writeObject(curStudent);
			objectWriter.close();	
			
		}
		catch(FileNotFoundException fileError)
		{
			System.out.println(fileError.getMessage());
			System.exit(0);
		}
		catch(IOException ioError)
		{
			System.out.println(ioError.getMessage());
			System.exit(0);
		}
	}





	private static void writeReportToFile(ArrayList<University> pUniversities, ArrayList<Student> pStudents)
	{
		FileOutputStream outputStream = null;
		PrintWriter fileWriter = null;
		String fileName = "ReportFile.txt";
		try 
		{
		outputStream = new FileOutputStream(fileName, false);
		fileWriter = new PrintWriter(outputStream);
		}
		catch(FileNotFoundException fileError)
		{
			System.out.println(fileError.getMessage());
			System.exit(0);
		}
		for(University curUniversity: pUniversities)
		{
			writeUniversityHeaderToFile(curUniversity, fileWriter);
			for(Student curStudent: pStudents)
            {
            	if(curStudent.getUniversity().equals(curUniversity.getUniversityName()))
            	{
            		curStudent.calculateCosts(curUniversity);
            		curUniversity.updateTotals(curStudent);
            		curUniversity.updateTotalTuition(curStudent.getTuition());
            		writeStudentReportToFile(curStudent,fileWriter);
            		
            	}
            }
            writeUniversityTotalsToFile(curUniversity, fileWriter);
		}
		
	}

	private static void writeUniversityObjectsToAFile(ArrayList<University> myUniversities) 
	{
		String fileName = "UniversityObjectFile.objf";
		FileOutputStream outputFile = null;
		ObjectOutputStream objectWriter = null;
		try
		{
			outputFile = new FileOutputStream(fileName, false);
			objectWriter = new ObjectOutputStream(outputFile);
			for(University curUniversity: myUniversities)
				objectWriter.writeObject(curUniversity);
			objectWriter.close();
		}
		catch(FileNotFoundException fileError)
		{
			System.out.println(fileError.getMessage());
			System.exit(0);
		}
		catch(IOException ioError)
		{
			System.out.println(ioError.getMessage());
			System.exit(0);
		}
	
		
	}

	

	private static ArrayList<University> getUniversityData(Scanner keyboard2)
	{
		String universityName = null;
		String streetAddress = null;
		String cityAddress = null;
		String stateAddress = null;
		int ZIPAddress = 0;
		String phoneNumber = null;
		double instateTuition_1_To_11 = 0.0;
		double instateTuition_12_To_18 = 0.0;
		double instateTuitionOver18 = 0.0;
		double outOfStateTuition_1_To_11 = 0.0;
		double outOfStateTuition_12_To_18 = 0.0;
		double outOfStateTuitionOver18 = 0.0;
		double studentCostMealPlanA = 0.0;
		double studentCostMealPlanB = 0.0;
		double studentCostMealPlanC = 0.0;
		double healthCare_1_To_10 = 0.0;
		double healthCare_11_To_15 = 0.0;
		double healthCareOver15 = 0.0;
		double lateFeeRate = 0.0;
		double incedentalFeeRate = 0.0;
		double incedentalFeeMax = 0.0;
		
		
		ArrayList<University> universityArray = new ArrayList<University>();
		
		String fileName = "Universities9.txt";
		University curUniversity = null;
		File filePath = null;
		Scanner fileInputStream = null;
		{
		filePath = new File(fileName);
		
		try
		{
			fileInputStream = new Scanner(filePath);
			fileInputStream.useDelimiter("[,\n\r]+");
		}
		catch(FileNotFoundException e1)
		{
			System.out.println(e1.getMessage());
			System.out.println("Error opening file: " + fileName);
			System.exit(0);
		}
		fileInputStream.nextLine();
		while(fileInputStream.hasNextLine())
		{
			universityName = fileInputStream.next();
			streetAddress = fileInputStream.next();
			cityAddress = fileInputStream.next();
			stateAddress = fileInputStream.next();
			ZIPAddress = fileInputStream.nextInt();
			phoneNumber = fileInputStream.next();
			instateTuition_1_To_11 = fileInputStream.nextDouble();
			instateTuition_12_To_18 = fileInputStream.nextDouble();
			instateTuitionOver18 = fileInputStream.nextDouble();
			outOfStateTuition_1_To_11 = fileInputStream.nextDouble();
			outOfStateTuition_12_To_18 = fileInputStream.nextDouble();
			outOfStateTuitionOver18 = fileInputStream.nextDouble();
			studentCostMealPlanA = fileInputStream.nextDouble();
			studentCostMealPlanB = fileInputStream.nextDouble();
			studentCostMealPlanC = fileInputStream.nextDouble();
			healthCare_1_To_10 = fileInputStream.nextDouble();
			healthCare_11_To_15 = fileInputStream.nextDouble();
			healthCareOver15 = fileInputStream.nextDouble();
			lateFeeRate = fileInputStream.nextDouble();
			incedentalFeeRate = fileInputStream.nextDouble();
			incedentalFeeMax = fileInputStream.nextDouble();
			
			fileInputStream.nextLine();
			curUniversity = new University(universityName,streetAddress,cityAddress,stateAddress,
					ZIPAddress,phoneNumber,instateTuition_1_To_11,instateTuition_12_To_18,instateTuitionOver18,
					outOfStateTuition_1_To_11,outOfStateTuition_12_To_18,outOfStateTuitionOver18,studentCostMealPlanA,
					studentCostMealPlanB,studentCostMealPlanC,healthCare_1_To_10,healthCare_11_To_15,healthCareOver15,
					lateFeeRate,incedentalFeeRate,incedentalFeeMax);
			universityArray.add(curUniversity);
			
			
		}
		fileInputStream.close();
		bubbleSortArrayList(universityArray);
		removeDuplicates(universityArray);
		
		return universityArray;
		}
	}

	private static ArrayList<Student> getStudentData(Scanner keyboard2) 
	{
		String firstName = null;
		String middleName = null;
		String lastName = null;
		int age = 0;
		char gender = ' ';
		String streetAddress = null;
		String city = null;
		String state = null;
		int zip = 0;
		String phone = null;
		String university = null;
		String studentId = null;
		int credits = ' ';
		char instate = ' ';
		char healthPlan = ' ';
		char foodPlan = ' ';
		char lateFees = ' ';
		
		ArrayList<Student> studentArray = new ArrayList<Student>();
		
		String fileName = "StudentFile.txt";
		Student curStudent = null;
		File filePath = null;
		Scanner fileInputStream = null;
		{
			filePath = new File(fileName);

		try
		{
			fileInputStream = new Scanner(filePath);
			fileInputStream.useDelimiter("[,\n\r]+");
		}
		catch(FileNotFoundException e1)
		{
			System.out.println(e1.getMessage());
			System.out.println("Error opening file: " + fileName);
			System.exit(0);
			
			
		}
		fileInputStream.nextLine();
		while (fileInputStream.hasNextLine())
		{
			firstName = fileInputStream.next();
			middleName = fileInputStream.next();
			lastName = fileInputStream.next();
			age = fileInputStream.nextInt();
			gender = fileInputStream.next().charAt(0);
			streetAddress = fileInputStream.next();
			city = fileInputStream.next();
			state = fileInputStream.next();
			zip = fileInputStream.nextInt();
			phone = fileInputStream.next();
			university = fileInputStream.next();
			studentId = fileInputStream.next();
			credits = fileInputStream.nextInt();
			instate = fileInputStream.next().charAt(0);
			healthPlan = fileInputStream.next().charAt(0);
			foodPlan = fileInputStream.next().charAt(0);
			lateFees = fileInputStream.next().charAt(0);
			
			fileInputStream.nextLine();
			curStudent = new Student(firstName, middleName, lastName, age, gender,
					streetAddress, city, state, zip, phone, university, studentId,
					credits, instate, healthPlan, foodPlan, lateFees);
			
			studentArray.add(curStudent);
			
			
		}
		    fileInputStream.close();
		    bubbleSortArrayList(studentArray);
			removeDuplicates(studentArray);
			
			return studentArray;
		}
	}
			


	private static <T> void bubbleSortArrayList(ArrayList<T> pArray) {
		T tempValue = null;
		T valueTwo = null;
		int length = pArray.size();
		for (int pass = length -1; length >= 0; length--)
		{
			for(int index = 0; index < pass; index++)
			{
				tempValue = pArray.get(index);
				valueTwo = pArray.get(index + 1);
				if(((Comparable<T>)tempValue).compareTo(valueTwo) > 0);
				{
					pArray.set(index, valueTwo);
					pArray.set(index + 1, tempValue);
					                                                                                                                                
				}
			}
		}
	}
	private static <T> void printArrayList(ArrayList<T> pArray)
	{
		for(T curElement: pArray) 
		{
			System.out.println(curElement.toString());
			
		}
	}
	
	
	
	private static <T> void removeDuplicates(ArrayList<T> pArray)
	{
		int length = pArray.size();
		T curElement = null;
		T nextElement = null;
		for (int index = length - 1; index > 0; index--)
		{
			curElement = pArray.get(index);
			nextElement = pArray.get(index - 1);
			if(curElement.equals(nextElement))
				pArray.remove(index);
			
		
		}
	}
	
	private static void writeUniversityTotalsToFile(University pUniversity, PrintWriter pFileWriter)
	{
		String spaces30 = "                              ";
		String curLine = "";
		curLine = String.format("%s%s TOTALS", spaces30, pUniversity);
		pFileWriter.println(curLine);
		curLine = String.format("%s%3d", OutPut.buildStringLeft(18, "NUMBER OF STUDENTS"), pUniversity.getTotalStudents());
		pFileWriter.println(curLine);
		curLine = String.format("%s%3d", OutPut.buildStringLeft(18, "INSTATE"), pUniversity.getTotalInstate());
		pFileWriter.println(curLine);
		curLine = String.format("%s%3d", OutPut.buildStringLeft(18, "OUT OF STATE"), pUniversity.getTotalStudents());
		pFileWriter.println(curLine);
		curLine = String.format("%s%s%3d       $%,10.2f", OutPut.buildStringLeft(18, "MEAL PLAN"), OutPut.buildStringLeft(24, "3 Meals a day"), pUniversity.getTotalMealsA(), pUniversity.getTotalCostOfMealA());
		pFileWriter.println(curLine);
		curLine = String.format("%s%s%3d       $%,10.2f", OutPut.buildStringLeft(18, ""), OutPut.buildStringLeft(24, "2 Meals a day"), pUniversity.getTotalMealsB(), pUniversity.getTotalCostOfMealsB());
		pFileWriter.println(curLine);
		curLine = String.format("%s%s%3d       $%,10.2f", OutPut.buildStringLeft(18, ""), OutPut.buildStringLeft(24, "1 Meal a day"), pUniversity.getTotalMealsC(), pUniversity.getTotalCostOfMealsC());
		pFileWriter.println(curLine);
		curLine = String.format("%s%3s       $%,10.2f", OutPut.buildStringLeft(18, ""), OutPut.buildStringLeft(24, "FOOD SUB TOTAL"),pUniversity.getTotalCostOfAllMeals());
		pFileWriter.println(curLine);
		curLine = String.format("%s$%,10.2f", OutPut.buildStringLeft(18, "TUITION"), pUniversity.getTotalTuition());
		pFileWriter.println(curLine);
		curLine = String.format("%s$%,10.2f", OutPut.buildStringLeft(18, "LATE FEE"), pUniversity.getTotalLateFees());
		pFileWriter.println(curLine);
		curLine = String.format("%s$%,10.2f", OutPut.buildStringLeft(18, "INCEDENTAL"), pUniversity.getTotalIncedentalFees());
		pFileWriter.println(curLine);
		curLine = String.format("%s$%,10.2f            TOTAL $%,10.2f", OutPut.buildStringLeft(18, "Health Care"), pUniversity.getTotalHealthCare(), pUniversity.getTotalCosts());
		pFileWriter.println(curLine);
		pFileWriter.println();
	}
	
	private static void writeUniversityHeaderToFile(University pUniversity, PrintWriter pFileWriter)
	{
		String spaces30 = "                              ";
		String curLine = "";
		String shortString = "";
		curLine = String.format("%s%s", spaces30, pUniversity.getUniversityName().toUpperCase());
		pFileWriter.println(curLine);
		curLine = String.format("%s%s", spaces30, pUniversity.getStreetAddress());
		pFileWriter.println(curLine);
		curLine = String.format("%s%s, %s %05d", spaces30, pUniversity.getCityAddress(), pUniversity.getStateAddress(), pUniversity.getZip());
		pFileWriter.println(curLine);
		shortString = pUniversity.getPhoneNumber();
		curLine = String.format("%s(%s)%s-%s", spaces30, shortString.substring(0,3), shortString.substring(3,6), shortString.substring(6, 9));
		pFileWriter.println(curLine);
		pFileWriter.println();
		
		
	}
	private static void writeStudentReportToFile(Student pStudent, PrintWriter pFileWriter)
	{
		String curLine = "";
		curLine = String.format("%s%s%s%3d", OutPut.buildStringLeft(12, "NAME"), OutPut.buildStringLeft(40, pStudent.getFullName()), OutPut.buildStringLeft(15, "CREDITS"), pStudent.getCredits());
		pFileWriter.println(curLine);
		curLine = String.format("%s%s", OutPut.buildStringLeft(12, "ADDRESS"), OutPut.buildStringLeft(40, pStudent.getAddress()));
		pFileWriter.println(curLine);
		curLine = String.format("%s%s", OutPut.buildStringLeft(12, "PHONE"), OutPut.buildStringLeft(40, pStudent.getFormattedPhoneNumber()));
		pFileWriter.println(curLine);
		curLine = String.format("%s%s", OutPut.buildStringLeft(12, "TUITION"), OutPut.buildStringLeft(40, String.format("$%,9.2f", pStudent.getTuition())));
		pFileWriter.println(curLine);
		curLine = String.format("%s%s", OutPut.buildStringLeft(12, "LATE FEE"), OutPut.buildStringLeft(40, String.format("$%,9.2f", pStudent.getLateFee())));
		pFileWriter.println(curLine);
		curLine = String.format("%s%s", OutPut.buildStringLeft(12, "INCEDENTAL"), OutPut.buildStringLeft(40, String.format("$%9.2f", pStudent.getIncidentalFees())));
		pFileWriter.println(curLine);
		curLine = String.format("%s%s", OutPut.buildStringLeft(12, "HEALTH CARE"), OutPut.buildStringLeft(40, String.format("$%9.2f", pStudent.getHealthCare())));
		pFileWriter.println(curLine);
		curLine = String.format("%s%s  %s  %s", OutPut.buildStringLeft(12, "MEALPLAN"), OutPut.buildStringLeft(40, String.format("$%9.2f", pStudent.getFoodCost())), OutPut.buildStringLeft(15, "TOTAL"), String.format("$%9.2f", pStudent.getTotalCosts()));
		pFileWriter.println(curLine);
		pFileWriter.println();
	}
	
}


