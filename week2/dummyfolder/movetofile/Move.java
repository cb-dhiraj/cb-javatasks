import java.io.*; 
import java.util.*;
import org.apache.commons.io.FilenameUtils;

public class Move
{ 
    static String directory = "";
    static String finalDirectory = "/Users/cb-dhiraj/Task/src/new/";
    static Map<String, Integer> map = new HashMap<String, Integer>();
     static void RecursivePrint(File[] arr,int index,int level,String mainDirPath)
     { 
        Boolean bool = true, flag = true;
         if(index == arr.length){
             return; 
         }
           
         if(arr[index].isFile())
         {
            String fileName = arr[index].getName();
            String fileNameExtension = "";
            System.out.println(fileName);
            bool = new File(finalDirectory, fileName).exists();
            if(bool)
            {
                int i=0;
                while(flag == true)
                {
                    i++;
                    bool = new File(finalDirectory, fileName+i).exists();
                    if(!bool)
                    {
                        flag=false;
                    }
                }
                fileNameExtension = FilenameUtils.getExtension(fileName);
                fileName = fileName.split("[.]")[0];
                arr[index].renameTo(new File(finalDirectory+(fileName+i+"."+fileNameExtension)));
            }
            arr[index].renameTo(new File(finalDirectory+fileName));
         }
         else if(arr[index].isDirectory()) 
         { 
             directory = arr[index].getName();

             System.out.println("[" + directory + "]");
               
             RecursivePrint(arr[index].listFiles(), 0, level + 1,mainDirPath); 
         } 
            
         RecursivePrint(arr,++index, level,mainDirPath);
    } 
      
    public static void main(String[] args) 
    { 
        String mainDirPath = "/Users/cb-dhiraj/Task/src/week2/dummyfolder"; 
                  
        File maindir = new File(mainDirPath); 
           
        if(maindir.exists() && maindir.isDirectory()) 
        { 
            File arr[] = maindir.listFiles(); 
              
            RecursivePrint(arr,0,0,mainDirPath);
       }
       System.out.println(map);
    } 
} 