import java.io.File; 
import java.util.*;
import org.apache.commons.io.FilenameUtils;

public class Maintest
{ 
    static Map<String, Integer> map = new HashMap<String, Integer>();
     static void RecursivePrint(File[] arr,int index,int level)  
     { 
         if(index == arr.length){
             return; 
         }
           
         if(arr[index].isFile())
         {
            String extension = FilenameUtils.getExtension(arr[index].getName());
             System.out.println(arr[index].getName());
             if(map.get(extension) == null){
                map.put(extension,1);
             }
             else{
                int num = map.get(extension);
                map.put(extension, num+1);
             }
         }

           
         else if(arr[index].isDirectory()) 
         { 
             System.out.println("[" + arr[index].getName() + "]"); 
               
             RecursivePrint(arr[index].listFiles(), 0, level + 1); 
         } 
            
         RecursivePrint(arr,++index, level);
    } 
      
    public static void main(String[] args) 
    { 
        String maindirpath = "/Users/cb-dhiraj/Task/src/week2"; 
                  
        File maindir = new File(maindirpath); 
           
        if(maindir.exists() && maindir.isDirectory()) 
        { 
            File arr[] = maindir.listFiles(); 
              
            RecursivePrint(arr,0,0);  
       }
       System.out.println(map);
    } 
} 