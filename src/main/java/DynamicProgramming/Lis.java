//package DynamicProgramming;
import java.util.*;
import java.io.*;

public class Lis {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter String");
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String s=br.readLine();
		String []str;
		str=s.split(" ");
		int []A=new int[str.length];
		for(int i=0;i<str.length;i++)
		{
		  A[i]=Integer.parseInt(str[i]);
		}
		NavigableSet <Integer> s1=new TreeSet <Integer>();
		NavigableSet <Integer> s2=new TreeSet <Integer>();
		for(int i=0;i<str.length;i++)
		{
			s1.add(A[i]);
			if(!s1.tailSet(A[i],false).isEmpty())
		    {
				s1.remove(s1.tailSet(A[i],false).first());
		    }
			else
			{
				if(!s1.headSet(A[i],false).isEmpty())
					s2.add(s1.headSet(A[i],false).last());
			}
				
				
		}
		if(s1.last()>s2.last())
			s2.add(s1.last());
		System.out.println(s1.size());
		Iterator iterator = s2.iterator(); 
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			
		}
		
	}

}
