/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Vishal
 */
public class Task1 {
    

    /**
     * @param args the command line arguments
     */
  
static void add(Hashtable<Integer,String> hm, int l) //insert hash function 
{ 
         int leftLimit = 97; // letter 'a'
	 int rightLimit = 122; // letter 'z'
  	 int targetStringLength = 10; //length of string
          
         for(int i=1;i<=l;i++){
            Random random = new Random();
   	
            String generatedString = random.ints(leftLimit, rightLimit + 1)
     		 .limit(targetStringLength).collect(StringBuilder::new, 
                 StringBuilder::appendCodePoint, 
                 StringBuilder::append).toString(); 
                //generating random string
            hm.put(i,generatedString);

	}
}

 public static void main(String args[]){
            Scanner sc= new Scanner(System.in);
            int n = sc.nextInt(); 
            Hashtable<Integer,String> hm=new Hashtable<Integer,String>();
            long StartTime = System.nanoTime();//starting timer
            add(hm,n);
            for(Map.Entry m:hm.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue()); //printing the HashTable
            }
            long TotalTime = System.nanoTime() - StartTime;
            System.out.println("Average time for each insertion " + "is: "
                + (TotalTime/n) + "\n");
            //calculating average time for operation 
  }
}
