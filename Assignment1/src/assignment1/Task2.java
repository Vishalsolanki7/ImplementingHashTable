/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author Vishal
 */
import java.util.*;
public class Task2 {

    /**
     * @param args the command line arguments
     */
  
static void add(Hashtable<Integer,String> hm, int l) 
{       int leftLimit = 97; // letter 'a'
	int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
	for(int i=1;i<=l;i++){
            Random random = new Random(); 	
            String generatedString = random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength).collect(StringBuilder::new, 
            StringBuilder::appendCodePoint, 
            StringBuilder::append).toString();   	
            
            hm.put(i,generatedString);
	}
        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue()); 
        }
}
 
static void remove(Hashtable<Integer,String> hm, String r)
{       
        for(Map.Entry m:hm.entrySet())
        {   
                if(Objects.equals(m.getValue(), r)) //finding the string first
                {                           
                hm.remove(m.getKey());// removing using key remove function
            }
        }
        
}

public static void main(String args[]){
 	
	Scanner sc= new Scanner(System.in);

        Hashtable<Integer,String> hm=new Hashtable<Integer,String>();
	long StartTime = System.nanoTime();
        
         add(hm,10);    //generating 10 random strings for further operations
        
             System.out.print("Please enter the number of strings you want to deleted: ");   
            //takes an integer input         
            String[] string = new String [sc.nextInt()];      
            //consuming the <enter> from input above  
            sc.nextLine();   
             StartTime = System.nanoTime();
            for (int i = 0; i < string.length; i++)   
            {  
            string[i] = sc.nextLine();  
            remove(hm, string[i]);
            }  
         
            long TotalTime = System.nanoTime() - StartTime;
            System.out.println("Average time for each removal(milliseconds) " + "is: "
                + (TotalTime)/string.length + "\n");
        
             for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue()); //printing the final Hashtable
        }
        
      }
    
        
  }
