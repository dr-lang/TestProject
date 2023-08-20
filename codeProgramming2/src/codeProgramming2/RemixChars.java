package codeProgramming2;

public class RemixChars {
	 public static void remix(String rmn, String chsn) {
	      if (rmn.isEmpty()) { 
	         System.out.println(chsn + rmn); 
	      } 
	      else { 
	          for (int i = 0; i < rmn.length(); ++i) { 
	            remix((rmn.substring(0, i) + rmn.substring(i + 1, rmn.length())), (chsn + rmn.charAt(i))); 
	         } 
	      } 
	   }        
	public static void main(String[] args) {
		remix("yz", ""); 

	}

}
