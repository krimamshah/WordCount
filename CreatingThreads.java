
package creatingthreads;

//importing the required libraries
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CreatingThreads {

    
    public static void main(String[] args) throws Exception{
        
        try{
        
       FileReader fr = new FileReader ("M:\\Customer1.txt"); //Reads the input file       
       BufferedReader br = new BufferedReader (fr);
       String line = br.readLine();                      //Reads the first line of the document
       HashMap<String,Integer> outputMap = new HashMap(); //Creating a HashMap object
       Thread myThread = new WordThread();                //Creating a object of class Thread
       
       while (line != null) {
        String []words = line.split(" ");              //Split the line into words and store them in an array
         myThread = new WordThread(words,outputMap);
         myThread.start();                              //Create a thread and do the computstion
         myThread.join();                              //Join the threads in order to consolidate the hashmap
         line = br.readLine(); 
          }
       // consolidate and display output
       displayOutput(outputMap);
        }catch(Exception e){
            System.out.printf("Excption: "+ e.getMessage());
        }
       }
    
     public static void displayOutput(HashMap<String,Integer> outputMap){
         //initialising Iterator object
              Iterator<Map.Entry<String, Integer>> i = outputMap.entrySet().iterator(); 
                while(i.hasNext()){
                   String key = i.next().getKey();
                   System.out.println(key+", "+outputMap.get(key));
                }
    }
}
        
        
    
    
   
    

    

