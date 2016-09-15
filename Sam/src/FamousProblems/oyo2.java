package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;




public class oyo2 {

	class Node{
		int num;
		Node next;
		
		public Node(int num)
		{
			this.num=num;
			this.next=null;
		}
	}
	public static void main(String arg [])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Node dummy=new Node(0);
        Node start=null;
        Node node=dummy;
        for(int i=0;i<N;i++)
        {
        	node.next=new Node(i+1);
        	node=node.next;
        	
        }
        start=dummy.next;
        node.next=start;
        line = br.readLine();
        int j=0;
        while(node.next!=node)
        {
        	if(j==(line.length()))
        	{
        		j=0;
        	}
        	if(line.charAt(j)=='a')
        	{
        		node=node.next;
        		//System.out.println(node.num+"  "+);
        	}
        	else if(line.charAt(j)=='b')
        	{
        		node.next=node.next.next;
        	}
        	j++;
        }
        
        System.out.println(node.num);
        
        
        
	}
}
