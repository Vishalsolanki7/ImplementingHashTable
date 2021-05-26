package assignment1;


import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Dany
 *
 */
public class QuadraticProbingOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long Start=System.currentTimeMillis();
                int n=0;
		long result=new QuadraticProbingOperations().operateOnHashingFunctions(1048576);
		System.out.println("Total Operations : "+result);
		long endTime=System.currentTimeMillis();
		System.out.println("Time in Milli Secs "+(endTime-Start));

	}
	
	public long operateOnHashingFunctions(int l)
	{

		
		Long nTotalOperationResult= 0L;
		String sOperation="";
		Long nFind=0L;
        //SplayTree sTree = new SplayTree();
        String generatedString="";
        QuadraticProbingHashTable sHashing = new QuadraticProbingHashTable();
         int leftLimit = 97; // letter 'a'
	int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
       
        
            for (int iCount = 0; iCount<l; iCount++){
                Random random = new Random();
              generatedString = random.ints(leftLimit, rightLimit + 1)
     		 .limit(targetStringLength).collect(StringBuilder::new, 
              StringBuilder::appendCodePoint, 
  		StringBuilder::append).toString();
               	
             
            sHashing.insert(generatedString);
            
        }
        
        
		/*try{
			Scanner fileScanner=new Scanner(infile);
			while(fileScanner.hasNext())
			{
				if(!(Character.isDigit((sOperation=fileScanner.next()).charAt(0))))
				{
				//System.out.println(sOperation);
				if(sOperation.compareTo("Insert")==0)
				sHashing.insert(fileScanner.nextLong(), fileScanner.nextLong());
				else if(sOperation.compareTo("Find")==0)
				{
				nFind = sHashing.find(fileScanner.nextLong());
				if(nFind==null)
				{
				nTotalOperationResult++;
				}
				}
				else if(sOperation.compareTo("Remove")==0)
				sHashing.remove(fileScanner.nextLong());
				}
			}
			
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		*/

		return nTotalOperationResult;
	
	}


}