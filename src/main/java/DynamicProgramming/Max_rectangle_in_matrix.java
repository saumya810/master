package DynamicProgramming;
import java.util.*;

public class Max_rectangle_in_matrix {

	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		ListIterator<ArrayList<Integer>> iter = a.listIterator();
		ListIterator<Integer> iter1;
		ArrayList<Integer> b;
		int n=a.size();
		int n1=a.get(0).size();
		int [][]A=new int[n][n1];
		
		for(int i=0; iter.hasNext();i++)
		{
			iter1=iter.next().listIterator();
			for(int j=0;iter1.hasNext();j++)
			{
				A[i][j]=iter1.next();
			}
		}
		int [][][]A1=new int[n][n1][3];
		int max=0;
		if(A[0][0]==1)
		{
			A1[0][0][0]=1;
			A1[0][0][1]=1;
			A1[0][0][2]=1;
		}
		for(int i=1;i<n1;i++)
		{
			if(A[0][i]!=0)
			{
				A1[0][i][0]=A1[0][i-1][0]+1;
				A1[0][i][1]=1;
				A1[i][0][0]=1;
				A1[i][0][1]=A1[i-1][0][1]+1;
				//if(A[i][j])
			}
			
		}
		int x=0,y=0,temp=0;
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<n1;j++)
			{
				//System.out.print(A[i][j]+" ");
				
				if(A[i][j]==0)
				{
					A1[i][j][0]=0;
					A1[i][j][1]=0;
					
				}
				else
				{
					A1[i][j][0]=A1[i][j-1][0]+1;
					A1[i][j][1]=A1[i-1][j][1]+1;
					x=Math.min(A1[i-1][j][0],A1[i][j][0]);
					y=Math.min(A1[i][j-1][1],A1[i][j][1]);
					temp=Math.max(x*y,A1[i][j][0]);
					temp=Math.max(temp,A1[i][j][0]);
				if(temp>max)
				{
					System.out.println("i "+i+" j "+j);
					System.out.println("y "+y+" x "+x);
					
				}
					max=Math.max(max,temp);
					
				}
				
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n1;j++)
			{
				//System.out.print(A1[i][j][0]
				System.out.print(A1[i][j][0]+" ---- "+ A1[i][j][1] + "          ");
			}
			System.out.println();
			}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]B={
				  {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
				  {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				  {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
				  {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
				  {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
				  {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
				  {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
				  {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}
				};
		ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<B.length;i++)
		{
			ArrayList<Integer> b=new ArrayList<Integer>();
			for(int j=0;j<B[0].length;j++)
			{
				b.add(B[i][j]);
			}
			l.add(b);
		}
		
		Max_rectangle_in_matrix ob1=new Max_rectangle_in_matrix();
		
		System.out.println(ob1.maximalRectangle(l));
	}

}
