package spoj;
/* IMPORTANT: Multiple classes and nested static classes are supported */



import java.io.BufferedReader;
import java.io.InputStreamReader;


class milly_and_chocolate {
	
	public int binarysearch(int start,int end ,int i,int []sc)
	{
		if(i<=sc[start])
		  return start;
	   int	mid=(start+end)/2;
		if(i<=sc[mid]){
			return binarysearch(start,mid,i,sc);}
		else
		    return binarysearch(mid+1,end,i,sc);
		
		  
	}
    public static void main(String args[] ) throws Exception {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        int []c=new int[N];
        int []sc=new int[N];
        String str[];
        int sum=0;
        str=line.split(" ");
        for (int i = 0; i < N; i++) {
            c[i]=Integer.parseInt(str[i]);
            sc[i]=sum+c[i];
            sum=sc[i];
        }
        
      
       line = br.readLine();
       int Q = Integer.parseInt(line);
       milly_and_chocolate ob1=new milly_and_chocolate();
       for(int i=0;i<Q;i++)
       {
       	 line = br.readLine();
       	System.out.println(ob1.binarysearch(0,N-1,Integer.parseInt(line),sc)+1);
       }
        
    }
}
