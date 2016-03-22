
package creatingthreads;
import java.util.HashMap;

public class WordThread extends Thread{
    
   private String[] threadWords;
   private HashMap<String,Integer> wordMap = new HashMap();
    
   //default constructor
   public WordThread(){
       
   }
    //Creating a constructor and initialising the value to the array
    public WordThread(String[] words,HashMap<String,Integer> wordMap){
       threadWords = new String[words.length];
        for(int i=0;i<words.length;i++){
            threadWords[i] = words[i];
           this.wordMap = wordMap;
        }
    }
    
    //getter-setter for HashMap Object
     public  HashMap<String,Integer> getHashmap() {
        return wordMap;
    }

    public void setHashmap( HashMap<String,Integer> wordMap) {
        this.wordMap = wordMap;
    }
   
    //An override method of class Thread used to find word frequency in a thread.
    @Override
    public void run(){
    
     
     for(int i=0;i<threadWords.length;i++){
         if(!this.wordMap.containsKey(threadWords[i]))  //compare wordMap to the threadWord array
         {
           this.wordMap.put(threadWords[i], new Integer("1")); //adding a word and setting its count to 1
         }
             else
             {
               this.wordMap.put(threadWords[i], this.wordMap.get(threadWords[i]) + 1); // adding the word and incrementing the count by 1
              }
     }
    }
    
}
  
     





    



        