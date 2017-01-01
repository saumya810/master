package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class relation{
		int source;
		int destination;
		public relation(int s,int d)
		{
			this.source=s;
			this.destination=d;
		}
	}


public class vasya_party {
	int Max;
	int count;
	
	
public int bs(int start,int end,int i,ArrayList <relation> rel)
{
	if(start==end&&rel.get(start).source!=i)
	return -1;
	
	if(start==end && rel.get(start).source==i)
	 return start;
	int mid=(start+end)/2;
	
	if(rel.get(mid).source<i)
	    return bs(mid+1,end,i,rel);
	 else
	     return bs(start,mid,i,rel);
	     
}
	
	
public 	void dfs1(ArrayList <relation> rep,int i,Set <Integer> visited,int []k,int N,ArrayList <relation> rev)
	{
		
	//System.out.println(i+"         i");
	//System.out.println("r.source  i "+i+" rep size "+rep.size());
		for(relation r :rep.subList(i, rep.size()))
		{
			
			if(r.source!=rep.get(i).source)
			 break;
			 if(!visited.contains(r.destination))
			 {
				// System.out.println(" helllo  ---  "+r.destination);
			 	visited.add(r.destination);
			 	if(k[r.destination]>this.Max)
				{
					this.Max=k[r.destination];
					this.count=1;
				}
				else if(k[r.destination]==this.Max)
				{
					this.count++;
				}
			   int index=this.bs(0,rep.size()-1,r.destination,rep);
			   if(index!=-1){
			   this.dfs1(rep,index,visited,k,N,rev);}
			   index=this.bs(0,rev.size()-1,r.destination,rev);
			   if(index!=-1)
			   this.dfs1(rev,index,visited,k,N,rep);
			 }
		}
		
		
		
		
		/*for(int j=0;j<N;j++)
		{
			if(g[i][j]==1&&(!visited.contains(j)))
			{
				visited.add(j);
				if(k[j]>this.Max)
				{
					this.Max=k[j];
					this.count=1;
				}
				else if(k[j]==this.Max)
				{
					this.count++;
				}
				
			this.dfs1(g,j,visited,k,N);	
			}
		}*/
	}
	
	public void dfs(ArrayList <relation> rel,int i,Set <Integer> visited,int []k,int N,ArrayList <relation> rev)
	{
		//System.out.println(" Newwwwwwww   "+ i);
		this.count=1;
		this.Max = k[i];
		visited.add(i);
		
		if(!rel.isEmpty())
		{
	    int index=this.bs(0,N,i,rel);
	    if(index!=-1)
	    {
	    
	   
	    this.dfs1(rel,index,visited,k,N,rev);
	    }
	    
	     index=this.bs(0,N,i,rev);
	     if(index!=-1){
	    //	 System.out.println(" rev   "+index);
	 	    	
	    this.dfs1(rev,index,visited,k,N,rel);
	    }
	    }
	    
		
	}
	

    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
       // int N = Integer.parseInt(line);
        String s[];
        s=line.split(" ");
        int N=Integer.parseInt(s[0]);
        int M=Integer.parseInt(s[1]);
        ArrayList <relation> rel=new ArrayList<relation>();
        ArrayList <relation> rev=new ArrayList<relation>();
       // relation [] rel=new relation[M];
       // int [][]g=new int[N][N];
       // for(int i=0;i<N;i++)
         // Arrays.fill(g[i],0);
       int []k=new int[N];
        String kn[];
        line = br.readLine();
        kn=line.split(" ");
        for(int i=0;i<N;i++)
        {
        	k[i]=Integer.parseInt(kn[i]);
        }
        
       for (int i = 0; i < M; i++) {
           line = br.readLine();
           String s1[];
           s1=line.split(" ");
           int x1=Integer.parseInt(s1[0]);
           int x2=Integer.parseInt(s1[1]);
           relation r2=new relation(x1-1,x2-1);
           relation r3=new relation(x2-1,x1-1);
           rel.add(r2);
           rev.add(r3);
           
          //g[x1-1][x2-1]=1;
          //g[x2-1][x1-1]=1;
        }
        
        if(!rel.isEmpty())
        {
        	
        
        Collections.sort(rel,new Comparator <relation>()
        {
        	public int compare(relation r1,relation r2)
        	{
        		if(r1.source>r2.source)
        		   return 1;
        		 else if(r1.source==r2.source)
        		 return 0;
        		 else
        		 return -1;
        		 
        	}
        	});
        	
        }
        
        if(!rev.isEmpty())
        {
        	
        
        Collections.sort(rev,new Comparator <relation>()
        {
        	public int compare(relation r1,relation r2)
        	{
        		if(r1.source>r2.source)
        		   return 1;
        		 else if(r1.source==r2.source)
        		 return 0;
        		 else
        		 return -1;
        		 
        	}
        	});
        	
        }
        
       
        
        Set <Integer> visited=new HashSet <Integer>();
        long p=1;
        vasya_party obj=new vasya_party();
        for(int i=0;i<N;i++)
        {
        	if(!visited.contains(i))
        	{
        		obj.dfs(rel,i,visited,k,rel.size()-1,rev);
        	//System.out.println(obj.count);
        		p=(p*obj.count)%1000000007;
        		
        	}
        }
        System.out.println(p);
       

       
    }
}
