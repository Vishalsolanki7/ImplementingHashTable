package assignment1;


public class HashImplementationAndAnalysis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
// TODO Auto-generated method stub

		new HashImplementationAndAnalysis().runAndAnalyseHashImplementations();
	}
	
	public void runAndAnalyseHashImplementations()
	{
		long Start=System.currentTimeMillis();
               
		long result=CuckooHashingOperations.executeCuckooHashing(4);
		System.out.println("Cuckoo hashing : ");
		
                long endTime = System.currentTimeMillis();
                System.out.println("Time taken in Milli Secs " + (endTime - Start));
                
                result=0L;
                
                Start = System.currentTimeMillis();
		result=new QuadraticProbingOperations().operateOnHashingFunctions(4);
		System.out.println("Quadratic Probing  : ");
               endTime = System.currentTimeMillis();
               System.out.println("Time taken in Milli Secs " + (endTime - Start));
	    
            
            
                Start=System.currentTimeMillis();
                result=new SeperateChainingOperations().operateOnHashingFunctions(4);
                System.out.println("Seperate Chaining  : ");
                result=0L;
		endTime=System.currentTimeMillis();
		System.out.println("Time taken in Milli Secs "+(endTime-Start));
               
		
	}

}