package assignment1;
import java.lang.Math;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * Class for executing Cuckoo Hashing operations
 */
public class CuckooHashingOperations {
    public static void main(String[] args) {
        long Start = System.currentTimeMillis();
        int n=0;
        System.out.println("Output: " + executeCuckooHashing(1048576));
        long endTime = System.currentTimeMillis();
        System.out.println("Time in Milli Secs " + (endTime - Start));
    }

    public static Long executeCuckooHashing(int l) {
        
        Long findFailureCount = 0L;
        String sOperation = "";
        CuckooHashing cuckooHashing = new CuckooHashing(new StringHashMethods(3));
        int n=0,i=0,leftLimit = 97; // letter 'a'
	int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        String generatedString ="";
        //a = Math.random()*(max-min+1)+min; 
        
       
        
            for (int iCount = 0; iCount<l; iCount++){
                Random random = new Random();
              generatedString = random.ints(leftLimit, rightLimit + 1)
     		 .limit(targetStringLength).collect(StringBuilder::new, 
              StringBuilder::appendCodePoint, 
  		StringBuilder::append).toString();
               	
            cuckooHashing.insert(generatedString);
            
            
            
        }
        /*try {
            Scanner fileScanner = new Scanner(infile);
            while (fileScanner.hasNext()) {
                if (!(Character.isDigit((sOperation = fileScanner.next()).charAt(0)))) {
                    if (sOperation.compareTo("Insert") == 0) {
                        cuckooHashing.insert(fileScanner.next());
                    } else if (sOperation.compareTo("Find") == 0) {
                        if (!cuckooHashing.find(String.valueOf(fileScanner.nextLong()))) {
                            findFailureCount++;
                        }
                    } else if (sOperation.compareTo("Remove") == 0) {
                        cuckooHashing.remove(String.valueOf(fileScanner.nextLong()));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
*/
        return findFailureCount;
    }
}