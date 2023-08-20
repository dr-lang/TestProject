package codeProgramming2;

import java.util.ArrayList;

public class CSC222_Exam_Practice {



public static void main(String[] args) {

	//int intArray[] = new int[] {1,2,3,4,5,100,7,8,9,10};
	//System.out.print(findLargest(intArray));
	//System.out.print(secondWord("hello how are you"));
	System.out.print(oddIndexedChar("HelloSir"));
	//System.out.print(split("onetwo"));
	//System.out.print(reverseEvenIndexedChar("Hello"));
}
	

public static int findLargest(int[] pArray)
{
 int largest = pArray[0];
 for(int index = pArray.length - 1; index > 0; index--)
   if(pArray[index] > largest)
     largest = pArray[index];
 return largest;
}
private static String secondWord(String pString)
{
  int index1 = pString.indexOf(' ');
  index1++;
  int index2 = pString.indexOf(' ', index1);
  return pString.substring(index1, index2);
}
public static String oddIndexedChar(String pMyString)
{
  String newString = "";
  for(int index = 1; index <= pMyString.length() - 1; index += 2)
    newString += pMyString.charAt(index);
  return newString;
}
public static String split(String pString)
{
  int halfWay = pString.length() / 2;
  return pString.substring(halfWay) + pString.substring(0,halfWay);
}
public static String reverseEvenIndexedChar(String pMyString)
{
  String newString = "";
  for(int index = 0; index <= pMyString.length() - 1; index += 2)
    newString += pMyString.charAt(index);
  return newString;
}
}
