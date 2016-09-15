package FamousProblems;
import java.util.*;

public class Microsoft_non_repeating_substring {

	void f(String str)
	{
		HashMap <Character,Integer> h=new HashMap<Character,Integer>();
		char[]a;
		a=str.toCharArray();
		int length=0;
		int start=0;
		int clength=0;
		int cstart=0;
		
		for(int i=0;i<str.length();i++)
		{
			if(h.get(a[i])==null||h.get(a[i])<cstart)
			{
				h.put(a[i], i);
				clength++;
			}
			else
			{
				if(h.get(a[i])>=cstart)
				{ 
					
					if(length<clength)
					{
						length=clength;
						start=cstart;
					}
				//	System.out.println(" ****   "+clength+"  i   "+i);
					clength=clength-(h.get(a[i])-cstart);
				//	System.out.println(" **after edit **   "+clength+"  i   "+i);
					cstart= h.get(a[i])+1;
					h.put(a[i], i);
					
					
				}
				
				
			}
				
		}
		

		if(length<clength)
		{
			length=clength;
			start=cstart;
		}
		
		System.out.println(length+" "+start+" "+a.toString());
		
		
		
	}
	
	public static void main(String str[])
	{
		Microsoft_non_repeating_substring o=new Microsoft_non_repeating_substring();
		o.f("abcdefeadenhjukia");
	}
}
