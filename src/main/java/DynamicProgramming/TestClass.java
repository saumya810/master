package DynamicProgramming;
/* IMPORTANT: Multiple classes and nested static classes are supported */
// hacker earth taxi prob


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



class P implements Comparable <P>{
	
	int incomingt;
	int travelt;
	public int compareTo(P other)
	{
		if(this.equals(other))
			return 0;
		else if(this.incomingt>other.incomingt)
			return 1;
		else
			return -1;
	}
}

class TestClass implements Comparator <P> {
	ArrayList <P> p2=new ArrayList <P>();
	
		
	public int compare(P e1,P e2)
	{
		if(e1.incomingt>=e2.incomingt)
		{
			return 1;
		}
		else
			return -1;
	}
		
    public static void main(String args[] ) throws Exception {
        
        // * Read input from stdin and provide input before running
    	TestClass a=new TestClass();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String [] str1=new String[2];
        str1=line.split(" ");
        int N = Integer.parseInt(str1[0]);
        int M= Integer.parseInt(str1[1]);
        long [] taxi1=new long[M];
       // ArrayList <P> p2=new ArrayList <P>();
        P p=new P();
        for(int i=0;i<M;i++)
        {
        	taxi1[i]=0;
        }
        for(int i=0;i<N;i++)
        {
        	line = br.readLine();
        	str1=line.split(" ");
        	
        	p=new P();
        	p.incomingt=Integer.parseInt(str1[0]);
        	p.travelt=Integer.parseInt(str1[1]);
        	a.p2.add(p);
        	
        	
        }
        
        Collections.sort(a.p2,a);
        
        for(P p3:a.p2)
        {
        	int i;
        	for( i=0;i<M;i++)
        	{
        		if(taxi1[i]<=p3.incomingt)
        		{
        			System.out.print(i+1+" ");
        			taxi1[i]=p3.incomingt+p3.travelt;
        			break;
        		}
        		
        	}
        	if(i==M)
        		System.out.print("-1 ");
        	//
        }
        
    }
}
