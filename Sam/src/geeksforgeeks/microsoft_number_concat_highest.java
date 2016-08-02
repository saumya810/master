package geeksforgeeks;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class microsoft_number_concat_highest {

public static void main(String[] str) throws Exception
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String s[];
    s=line.split(" ");
    ArrayList <String> a = new ArrayList <String>();
    for(int i=0;i<s.length;i++)
    a.add(s[i]);
    
    
    
    
    Collections.sort(a,new Comparator <String>()
    {
      public int compare(String str2, String str1)
      {
      
      char current=str1.charAt(0);
      int i=0;
      while(i<Math.min(str1.length(),str2.length()))
      {

       if(str1.charAt(i)>str2.charAt(i))
       {
         return 1;
       }
       else if(str1.charAt(i)<str2.charAt(i))
       return -1;
       i++;
      }
      if(str1.length()>str2.length())
      {
        if(str1.charAt(i)>current)
          return 1;
         else
          return -1;
      }
      else if(str1.length()<str2.length())
      {
          if(str2.charAt(i)>current)
          return -1;
          else
          return 1;
      }
      return 1;


    }
    } );

    for(String s1:a)
    {
    	System.out.println(s1);
    }
}
	
	
	
}
